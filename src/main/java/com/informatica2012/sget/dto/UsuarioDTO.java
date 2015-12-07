/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.dto;

import com.informatica2012.sget.entity.Rol;
import com.informatica2012.sget.entity.Trabajador;
import com.informatica2012.sget.entity.Usuario;
import java.io.Serializable;

/**
 *
 * @author Hugo
 */
public class UsuarioDTO implements Serializable{
    
    private Integer id;
    private Integer trabajador;
    private String trabajadorNombre;
    private Integer rol;
    private String rolNombre;
    private String usuario;
    private String clave;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.trabajador = usuario.getTrabajador().getId();
        this.trabajadorNombre = usuario.getTrabajador().getPersona().getApellidos() + ", " + usuario.getTrabajador().getPersona().getNombre();
        this.rol = usuario.getRol().getId();
        this.rolNombre = usuario.getRol().getNombre();
        this.usuario = usuario.getUsuario();
        this.clave = usuario.getClave();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Integer trabajador) {
        this.trabajador = trabajador;
    }

    public String getTrabajadorNombre() {
        return trabajadorNombre;
    }

    public void setTrabajadorNombre(String trabajadorNombre) {
        this.trabajadorNombre = trabajadorNombre;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public Usuario getUsuarioEntity() {
        Usuario user = new Usuario();
        user.setTrabajador(new Trabajador(trabajador));
        user.setRol(new Rol(rol));
        user.setUsuario(usuario);
        user.setClave(clave);
        return user;
    }
    
}
