/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author yurankali
 */
public class Interrupcao implements Serializable {
    private static final long seriaVescionuID = 1l;


    private String tipoServico;
    private String zonaAfetada;

    private String motivo;

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getZonaAfetada() {
        return zonaAfetada;
    }

    public void setZonaAfetada(String zonaAfetada) {
        this.zonaAfetada = zonaAfetada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Interrupcao(String tipoServico, String zonaAfetada, String motivo, String estado) {
        this.tipoServico = tipoServico;
        this.zonaAfetada = zonaAfetada;
        this.motivo = motivo;
        this.estado = estado;
    }

    private String estado;
}
