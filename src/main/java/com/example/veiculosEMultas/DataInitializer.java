package com.example.veiculosEMultas;

import com.example.veiculosEMultas.model.*;
import com.example.veiculosEMultas.repository.UsuarioRepository;
import com.example.veiculosEMultas.repository.VeiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final VeiculoRepository veiculoRepository;

    public DataInitializer(UsuarioRepository usuarioRepository, VeiculoRepository veiculoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public void run(String... args) {
        // Carga inicial de Usuários
        Usuario usuario1 = new Usuario("Usuário 1", "usuario1@example.com", "senha123", Role.USUARIO);
        Usuario usuario2 = new Usuario("Usuário 2", "usuario2@example.com", "senha456", Role.ADMIN);

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

        // Carga inicial de Veículos
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setPlaca("ABC1234");
        veiculo1.setTipo(TipoVeiculo.AUTOMOVEL);
        veiculo1.setNome("Carro 1");
        veiculo1.setAnoFabricacao(2020);
        veiculo1.setCor("Preto");

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setPlaca("DEF5678");
        veiculo2.setTipo(TipoVeiculo.CAMIONETA);
        veiculo2.setNome("Carro 2");
        veiculo2.setAnoFabricacao(2022);
        veiculo2.setCor("Branco");

        veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2));

        // Carga inicial de Multas
        Multa multa1 = new Multa();
        multa1.setLocal("Avenida Principal");
        multa1.setMotivo("Excesso de velocidade");
        multa1.setValor(150.0f);

        Multa multa2 = new Multa();
        multa2.setLocal("Rua Secundária");
        multa2.setMotivo("Estacionamento irregular");
        multa2.setValor(100.0f);

        Veiculo veiculoComMultas = veiculoRepository.findById("ABC1234").orElse(null);
        if (veiculoComMultas != null) {
            multa1.setVeiculo(veiculoComMultas);
            veiculoComMultas.setMultas(Arrays.asList(multa1));
            veiculoRepository.save(veiculoComMultas);
        }

        Veiculo outroVeiculoComMultas = veiculoRepository.findById("DEF5678").orElse(null);
        if (outroVeiculoComMultas != null) {
            multa2.setVeiculo(outroVeiculoComMultas);
            outroVeiculoComMultas.setMultas(Arrays.asList(multa2));
            veiculoRepository.save(outroVeiculoComMultas);
        }
    }
}
