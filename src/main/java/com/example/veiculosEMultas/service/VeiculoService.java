package com.example.veiculosEMultas.service;

import com.example.veiculosEMultas.model.Multa;
import com.example.veiculosEMultas.model.Veiculo;
import com.example.veiculosEMultas.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
        private final VeiculoRepository veiculoRepository;

        public VeiculoService(VeiculoRepository veiculoRepository) {
            this.veiculoRepository = veiculoRepository;
        }

        public List<Veiculo> getAllVeiculos() {
            return veiculoRepository.findAll();
        }

        public Veiculo getVeiculoByPlaca(String placa) {
            return veiculoRepository.findById(placa)
                    .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        }

        public Veiculo cadastrarVeiculo(Veiculo veiculo) {
            return veiculoRepository.save(veiculo);
        }

        public Multa cadastrarMulta(String placa, Multa multa) {
            Veiculo veiculo = getVeiculoByPlaca(placa);
            multa.setVeiculo(veiculo);
            veiculo.getMultas().add(multa);
            veiculoRepository.save(veiculo);
            return multa;
        }

}
