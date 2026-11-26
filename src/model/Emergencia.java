package model;

import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author yurankali
 */
public class Emergencia implements Serializable {

    private static final long seriaVescionuID = 1l;

    private int id;

    private String apartamento;
    private String nomeContacto;
    private String telefone;
    private String parentesco;
    private String contactoAlternativo;

    public Emergencia(String apartamento, String nomeContacto, String telefone, String parentesco, String contactoAlternativo, int id) {

        this.apartamento = apartamento;
        this.nomeContacto = nomeContacto;
        this.telefone = telefone;
        this.parentesco = parentesco;
        this.contactoAlternativo = contactoAlternativo;
        this.id = id;
    }

    public Emergencia() {

    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getNomeContacto() {
        return nomeContacto;
    }

    public void setNomeContacto(String nomeContacto) {
        this.nomeContacto = nomeContacto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getParentesco() {
        return parentesco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getContactoAlternativo() {
        return contactoAlternativo;
    }

    public void setContactoAlternativo(String contactoAlternativo) {
        this.contactoAlternativo = contactoAlternativo;
    }

}
