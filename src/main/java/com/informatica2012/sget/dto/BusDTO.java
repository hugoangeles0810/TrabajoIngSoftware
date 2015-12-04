/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.Agencia;
import com.informatica2012.sget.entity.Bus;
import com.informatica2012.sget.entity.ModeloBus;
import java.io.Serializable;

/**
 *
 * @author Hugo
 */
public class BusDTO implements Serializable {
    
    private Integer id;
    private String placa;
    private String anio;
    private String estado;
    private Integer modelobus;
    private String modelobusNombre;
    private Integer agencia;
    private String agenciaNombre;

    public BusDTO() {
    }

    public BusDTO(Bus bus) {
        this.id = bus.getId();
        this.placa = bus.getPlaca();
        this.anio = bus.getAno() + "";
        this.estado = bus.getEstado() + "";
        this.modelobus = bus.getModeloBus().getId();
        this.modelobusNombre = bus.getModeloBus().getNombre();
        this.agencia = bus.getAgencia().getId();
        this.agenciaNombre = bus.getAgencia().getEstacionTrabajo().getNombre();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getModelobus() {
        return modelobus;
    }

    public void setModelobus(Integer modelobus) {
        this.modelobus = modelobus;
    }

    public String getModelobusNombre() {
        return modelobusNombre;
    }

    public void setModelobusNombre(String modelobusNombre) {
        this.modelobusNombre = modelobusNombre;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getAgenciaNombre() {
        return agenciaNombre;
    }

    public void setAgenciaNombre(String agenciaNombre) {
        this.agenciaNombre = agenciaNombre;
    }
    
    public Bus getBus() {
        Bus bus = new Bus();
        bus.setPlaca(placa);
        bus.setAno(Integer.parseInt(anio));
        bus.setEstado(estado.charAt(0));
        bus.setAgencia(new Agencia(agencia));
        bus.setModeloBus(new ModeloBus(modelobus));
        
        return bus;
    }
    
    public void passValues(Bus bus) {
        bus.setAno(Integer.parseInt(anio));
        bus.setPlaca(placa);
        bus.setEstado(estado.charAt(0));
        bus.setModeloBus(new ModeloBus(modelobus));
        bus.setAgencia(new Agencia(agencia));
    }
    
}
