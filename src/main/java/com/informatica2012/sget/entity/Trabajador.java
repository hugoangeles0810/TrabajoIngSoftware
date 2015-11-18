/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name = "trabajador")
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")})
public class Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @JoinColumn(name = "personaid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;
    @JoinColumn(name = "estacionid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstacionTrabajo estacionTrabajo;
    @JoinColumn(name = "cargoid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cargo cargo;
    @OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY)
    private List<EstacionTrabajo> estacionTrabajoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajador", fetch = FetchType.LAZY)
    private List<PersonalViaje> personalViajeList;

    public Trabajador() {
    }

    public Trabajador(Integer id) {
        this.id = id;
    }

    public Trabajador(Integer id, Date fechaingreso) {
        this.id = id;
        this.fechaingreso = fechaingreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public EstacionTrabajo getEstacionTrabajo() {
        return estacionTrabajo;
    }

    public void setEstacionTrabajo(EstacionTrabajo estacionTrabajo) {
        this.estacionTrabajo = estacionTrabajo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<EstacionTrabajo> getEstacionTrabajoList() {
        return estacionTrabajoList;
    }

    public void setEstacionTrabajoList(List<EstacionTrabajo> estacionTrabajoList) {
        this.estacionTrabajoList = estacionTrabajoList;
    }

    public List<PersonalViaje> getPersonalViajeList() {
        return personalViajeList;
    }

    public void setPersonalViajeList(List<PersonalViaje> personalViajeList) {
        this.personalViajeList = personalViajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informatica2012.sget.entity.Trabajador[ id=" + id + " ]";
    }
    
}
