package model;

import java.io.Serializable;

public class Despesa implements Serializable {
    private static final long seriaVescionuID = 1l;
    
    private String descricao;
    private String categoria;
    private double valor;
    private String responsavel;
    private String benificiario;
    private String apartamento;


    public Despesa(String descricao, String categoria, double valor, String responsavel, String benificiario, String apartamento) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.responsavel = responsavel;
        this.benificiario = benificiario;
        this.apartamento = apartamento;
    }

    public Despesa() {
}
  

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getBenificiario() {
        return benificiario;
    }

    public void setBenificiario(String benificiario) {
        this.benificiario = benificiario;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

   
}
