package model;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private static final long seriaVescionuID = 1l;

    private int id;
    private String nomeCompleto;
    private String bi;
    private String telefone;
    private String cargo;
    private double salario;
    private String dataContratacoa;
    private String estado;
    private String senha;

    public Funcionario() {

    }

    public Funcionario(int id, String nomeCompleto, String bi, String telefone, String cargo, double salario, String dataContratacoa, String estado) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.bi = bi;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacoa = dataContratacoa;
        this.estado = estado;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataContratacoa() {
        return dataContratacoa;
    }

    public void setDataContratacoa(String dataContratacoa) {
        this.dataContratacoa = dataContratacoa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
