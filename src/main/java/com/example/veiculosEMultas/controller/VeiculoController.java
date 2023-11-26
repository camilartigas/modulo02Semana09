package com.example.veiculosEMultas.controller;

import com.example.veiculosEMultas.model.Multa;
import com.example.veiculosEMultas.model.Veiculo;
import com.example.veiculosEMultas.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        List<Veiculo> veiculos = veiculoService.getAllVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculoByPlaca(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.getVeiculoByPlaca(placa);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    @PostMapping("/{placa}/multas")
    public ResponseEntity<Multa> cadastrarMulta(@PathVariable String placa, @RequestBody Multa multa) {
        Multa novaMulta = veiculoService.cadastrarMulta(placa, multa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMulta);
    }
}
