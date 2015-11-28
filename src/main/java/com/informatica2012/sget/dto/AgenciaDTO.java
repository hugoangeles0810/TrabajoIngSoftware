/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.Agencia;
import com.informatica2012.sget.entity.EstacionTrabajo;
import java.io.Serializable;

/**
 *
 * @author Hugo
 */
public class AgenciaDTO implements Serializable {
    
    private Integer id;
    private Integer estacion;
    private String estacionNombre;
    private Integer aforo;
    private Integer capacidadbus;

    public AgenciaDTO() {
    }
    
    public AgenciaDTO(Agencia agencia) {
        this.id = agencia.getId();
        this.estacion = agencia.getEstacionTrabajo().getId();
        this.estacionNombre = agencia.getEstacionTrabajo().getNombre();
        this.aforo = agencia.getAforo();
        this.capacidadbus = agencia.getCapacidadbus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstacion() {
        return estacion;
    }

    public void setEstacion(Integer estacion) {
        this.estacion = estacion;
    }

    public String getEstacionNombre() {
        return estacionNombre;
    }

    public void setEstacionNombre(String estacionNombre) {
        this.estacionNombre = estacionNombre;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public Integer getCapacidadbus() {
        return capacidadbus;
    }

    public void setCapacidadbus(Integer capacidadbus) {
        this.capacidadbus = capacidadbus;
    }
    
    public Agencia getAgencia(){
        Agencia agencia = new Agencia();
        agencia.setEstacionTrabajo(new EstacionTrabajo(estacion));
        agencia.setAforo(aforo);
        agencia.setCapacidadbus(capacidadbus);
        return agencia;
    }
    
    public void passValues(Agencia agencia){
        agencia.setAforo(aforo);
        agencia.setCapacidadbus(capacidadbus);
    }
    
}
