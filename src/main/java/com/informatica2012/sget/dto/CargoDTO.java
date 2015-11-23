/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.Cargo;

/**
 *
 * @author Hugo
 */
public class CargoDTO {
    
    private Integer id;
    private String nombre;

    public CargoDTO() {
    }

    public CargoDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public CargoDTO(Cargo cargo) {
        this.id = cargo.getId();
        this.nombre = cargo.getNombre();
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
    
}
