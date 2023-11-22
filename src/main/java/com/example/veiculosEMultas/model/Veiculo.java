package com.example.veiculosEMultas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "veiculos")
public class Veiculo {
    @Id
    private String placa;

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;

    private String nome;
    private Integer anoFabricacao;
    private String cor;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Multa> multas;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }
}
