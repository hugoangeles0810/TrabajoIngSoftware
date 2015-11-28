/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.Persona;
import com.informatica2012.sget.entity.Trabajador;
import com.informatica2012.sget.util.Helper;
import java.io.Serializable;

/**
 *
 * @author Hugo
 */
public class TrabajadorDTO implements Serializable{
    
    private Integer id;
    private String dni;
    private String apellidos;
    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private Integer cargo;
    private String cargoNombre;
    private Integer estacion;
    private String estacionNombre;
    private String fechaIngreso;

    public TrabajadorDTO() {
    }
    
    public TrabajadorDTO(Trabajador trabajador) {
        this.id = trabajador.getId();
        this.dni = trabajador.getPersona().getDni();
        this.apellidos = trabajador.getPersona().getApellidos();
        this.nombre = trabajador.getPersona().getNombre();
        this.direccion = trabajador.getPersona().getDireccion();
        this.telefono = trabajador.getPersona().getTelefono();
        this.fechaNacimiento = Helper.formatDate(trabajador.getPersona().getFechanacimiento());
        this.cargo = trabajador.getCargo().getId();
        this.cargoNombre = trabajador.getCargo().getNombre();
        this.estacion = trabajador.getEstacionTrabajo().getId();
        this.estacionNombre = trabajador.getEstacionTrabajo().getNombre();
        this.fechaIngreso = Helper.formatDate(trabajador.getFechaingreso());
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public String getCargoNombre() {
        return cargoNombre;
    }

    public void setCargoNombre(String cargoNombre) {
        this.cargoNombre = cargoNombre;
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public Persona getPersona() {
        Persona persona = new Persona();
        persona.setDni(dni);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        persona.setFechanacimiento(Helper.parseDate(fechaNacimiento));
        
        return persona;
    }
    
    public void passValuesForUpdate(Persona persona){
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setFechanacimiento(Helper.parseDate(fechaNacimiento));
        persona.setTelefono(telefono);
        persona.setDireccion(direccion);
    }
}
