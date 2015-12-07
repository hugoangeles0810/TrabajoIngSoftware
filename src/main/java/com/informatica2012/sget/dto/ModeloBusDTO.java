/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.ModeloBus;
import java.math.BigDecimal;

/**
 *
 * @author Hugo
 */
public class ModeloBusDTO {
    
    private Integer id;
    private String nombre;
    private boolean compartimientoComida;
    private Double capacidadBodega;

    public ModeloBusDTO() {
    }

    public ModeloBusDTO(ModeloBus modeloBus) {
        this.id = modeloBus.getId();
        this.nombre = modeloBus.getNombre();
        this.compartimientoComida = modeloBus.getCompartimientocomida();
        this.capacidadBodega = modeloBus.getCapacidadbodega().doubleValue();
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

    public boolean isCompartimientoComida() {
        return compartimientoComida;
    }

    public void setCompartimientoComida(boolean compartimientoComida) {
        this.compartimientoComida = compartimientoComida;
    }

    public Double getCapacidadBodega() {
        return capacidadBodega;
    }

    public void setCapacidadbodega(Double capacidadbodega) {
        this.capacidadBodega = capacidadbodega;
    }
    
    public ModeloBus getModeloBus() {
        ModeloBus modeloBus = new ModeloBus();
        modeloBus.setId(id);
        modeloBus.setNombre(nombre);
        modeloBus.setCompartimientocomida(compartimientoComida);
        modeloBus.setCapacidadbodega(BigDecimal.valueOf(capacidadBodega));
        return  modeloBus;
    }
    
}
