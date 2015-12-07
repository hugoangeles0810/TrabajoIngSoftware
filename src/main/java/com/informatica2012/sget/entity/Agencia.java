/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name = "agencia")
@NamedQueries({
    @NamedQuery(name = "Agencia.findAll", query = "SELECT a FROM Agencia a")})
public class Agencia implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencia")
    private List<Bus> busList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aforo")
    private int aforo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidadbus")
    private int capacidadbus;
    @JoinColumn(name = "estacionid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstacionTrabajo estacionTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private List<Viaje> viajeDestinoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origen")
    private List<Viaje> viajeOrigenList;

    public Agencia() {
    }

    public Agencia(Integer id) {
        this.id = id;
    }

    public Agencia(Integer id, int aforo, int capacidadbus) {
        this.id = id;
        this.aforo = aforo;
        this.capacidadbus = capacidadbus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public int getCapacidadbus() {
        return capacidadbus;
    }

    public void setCapacidadbus(int capacidadbus) {
        this.capacidadbus = capacidadbus;
    }

    public EstacionTrabajo getEstacionTrabajo() {
        return estacionTrabajo;
    }

    public void setEstacionTrabajo(EstacionTrabajo estacionTrabajo) {
        this.estacionTrabajo = estacionTrabajo;
    }

    public List<Viaje> getViajeDestinoList() {
        return viajeDestinoList;
    }

    public void setViajeDestinoList(List<Viaje> viajeDestinoList) {
        this.viajeDestinoList = viajeDestinoList;
    }

    public List<Viaje> getViajeOrigenList() {
        return viajeOrigenList;
    }

    public void setViajeOrigenList(List<Viaje> viajeOrigenList) {
        this.viajeOrigenList = viajeOrigenList;
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
        if (!(object instanceof Agencia)) {
            return false;
        }
        Agencia other = (Agencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informatica2012.sget.entity.Agencia[ id=" + id + " ]";
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }
    
}
