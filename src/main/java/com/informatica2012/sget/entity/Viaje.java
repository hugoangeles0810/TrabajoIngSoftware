/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "viaje")
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")})
public class Viaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "origen")
    private int origen;
    @Basic(optional = false)
    @Column(name = "destino")
    private int destino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date partida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "busid")
    private int busid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaje", fetch = FetchType.LAZY)
    private List<Boleto> boletoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaje", fetch = FetchType.LAZY)
    private List<PersonalViaje> personalViajeList;

    public Viaje() {
    }

    public Viaje(Integer id) {
        this.id = id;
    }

    public Viaje(Integer id, int origen, int destino, Date partida, BigDecimal precio, int busid) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.partida = partida;
        this.precio = precio;
        this.busid = busid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public Date getPartida() {
        return partida;
    }

    public void setPartida(Date partida) {
        this.partida = partida;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getBusid() {
        return busid;
    }

    public void setBusid(int busid) {
        this.busid = busid;
    }

    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
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
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informatica2012.sget.entity.Viaje[ id=" + id + " ]";
    }
    
}
