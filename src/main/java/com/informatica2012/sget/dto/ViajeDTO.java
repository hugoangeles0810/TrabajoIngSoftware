/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.Agencia;
import com.informatica2012.sget.entity.Bus;
import com.informatica2012.sget.entity.Viaje;
import com.informatica2012.sget.util.Helper;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Hugo
 */
public class ViajeDTO implements Serializable {
    
    private Integer id;
    private Integer origenId;
    private String origenNombre;
    private Integer destinoId;
    private String destinoNombre;
    private Double precio;
    private String fecha;
    private String hora;
    private Integer busId;
    private String busPlaca;

    public ViajeDTO() {
    }
    
    public ViajeDTO(Viaje viaje) {
        this.id = viaje.getId();
        this.origenId = viaje.getOrigen().getId();
        this.origenNombre = viaje.getOrigen().getEstacionTrabajo().getNombre();
        this.destinoId = viaje.getDestino().getId();
        this.destinoNombre = viaje.getDestino().getEstacionTrabajo().getNombre();
        this.precio = viaje.getPrecio().doubleValue();
        this.fecha = Helper.formatDate(viaje.getPartida());
        this.hora = Helper.formatHour(viaje.getPartida());
        this.busId = viaje.getBus().getId();
        this.busPlaca = viaje.getBus().getPlaca();
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrigenId() {
        return origenId;
    }

    public void setOrigenId(Integer origenId) {
        this.origenId = origenId;
    }

    public String getOrigenNombre() {
        return origenNombre;
    }

    public void setOrigenNombre(String origenNombre) {
        this.origenNombre = origenNombre;
    }

    public Integer getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Integer destinoId) {
        this.destinoId = destinoId;
    }

    public String getDestinoNombre() {
        return destinoNombre;
    }

    public void setDestinoNombre(String destinoNombre) {
        this.destinoNombre = destinoNombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getBusPlaca() {
        return busPlaca;
    }

    public void setBusPlaca(String busPlaca) {
        this.busPlaca = busPlaca;
    }
    
    public Viaje getViaje() {
        Viaje viaje = new Viaje();
        viaje.setOrigen(new Agencia(origenId));
        viaje.setDestino(new Agencia(destinoId));
        viaje.setPrecio(BigDecimal.valueOf(precio));
        viaje.setPartida(Helper.parseDateAndHour(fecha + " " + hora));
        viaje.setBus(new Bus(busId));
        return viaje;
    }
    
}
