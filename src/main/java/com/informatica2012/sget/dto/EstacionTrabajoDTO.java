/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.EstacionTrabajo;
import java.io.Serializable;

/**
 *
 * @author Hugo
 */
public class EstacionTrabajoDTO implements Serializable{
    
    private Integer id;
    private String nombre;
    private String direccion;
    private LugarDTO lugar;

    public EstacionTrabajoDTO() {
    }

    public EstacionTrabajoDTO(String nombre, String direccion, LugarDTO lugar) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.lugar = lugar;
    }
    
    public EstacionTrabajoDTO(EstacionTrabajo estacion) {
        this.id = estacion.getId();
        this.nombre = estacion.getNombre();
        this.direccion = estacion.getDireccion();
        this.lugar = new LugarDTO(estacion.getLugar());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LugarDTO getLugar() {
        return lugar;
    }

    public void setLugar(LugarDTO lugar) {
        this.lugar = lugar;
    }
    
    
    
}
