/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.Lugar;
import java.io.Serializable;

/**
 *
 * @author Hugo
 */
public class LugarDTO implements Serializable {
    
    private Integer id;
    private String pais;
    private String estado;
    private String ciudad;
    private String distrito;

    public LugarDTO() {
    }
    
    public LugarDTO(Lugar lugar){
        this.id = lugar.getId();
        this.pais = lugar.getPais();
        this.estado = lugar.getEstado();
        this.ciudad = lugar.getCiudad();
        this.distrito = lugar.getDistrito();
    }

    public LugarDTO(Integer id, String pais, String estado, String ciudad, String distrito) {
        this.id = id;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.distrito = distrito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
     
}
