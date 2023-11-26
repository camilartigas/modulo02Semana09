package com.example.veiculosEMultas.dto;

import com.example.veiculosEMultas.model.TipoVeiculo;
import lombok.Data;
import java.util.List;

@Data
public class VeiculoResponse {

    private String placa;

    private TipoVeiculo tipo;

    private String nome;

    private Integer anoFabricacao;

    private String cor;

    private List<MultaResponse> multas;

}