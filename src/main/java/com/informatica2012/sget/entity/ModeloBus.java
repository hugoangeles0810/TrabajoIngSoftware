/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name = "modelobus")
@NamedQueries({
    @NamedQuery(name = "ModeloBus.findAll", query = "SELECT m FROM ModeloBus m")})
public class ModeloBus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compartimientocomida")
    private boolean compartimientocomida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidadbodega")
    private BigDecimal capacidadbodega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloBus", fetch = FetchType.LAZY)
    private List<Bus> busList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloBus", fetch = FetchType.LAZY)
    private List<ModeloBusServicios> modeloBusServiciosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloBus", fetch = FetchType.LAZY)
    private List<ModeloBusPisos> modeloBusPisosList;

    public ModeloBus() {
    }

    public ModeloBus(Integer id) {
        this.id = id;
    }

    public ModeloBus(Integer id, String nombre, boolean compartimientocomida, BigDecimal capacidadbodega) {
        this.id = id;
        this.nombre = nombre;
        this.compartimientocomida = compartimientocomida;
        this.capacidadbodega = capacidadbodega;
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

    public boolean getCompartimientocomida() {
        return compartimientocomida;
    }

    public void setCompartimientocomida(boolean compartimientocomida) {
        this.compartimientocomida = compartimientocomida;
    }

    public BigDecimal getCapacidadbodega() {
        return capacidadbodega;
    }

    public void setCapacidadbodega(BigDecimal capacidadbodega) {
        this.capacidadbodega = capacidadbodega;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public List<ModeloBusServicios> getModeloBusServiciosList() {
        return modeloBusServiciosList;
    }

    public void setModeloBusServiciosList(List<ModeloBusServicios> modeloBusServiciosList) {
        this.modeloBusServiciosList = modeloBusServiciosList;
    }

    public List<ModeloBusPisos> getModeloBusPisosList() {
        return modeloBusPisosList;
    }

    public void setModeloBusPisosList(List<ModeloBusPisos> modeloBusPisosList) {
        this.modeloBusPisosList = modeloBusPisosList;
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
        if (!(object instanceof ModeloBus)) {
            return false;
        }
        ModeloBus other = (ModeloBus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informatica2012.sget.entity.ModeloBus[ id=" + id + " ]";
    }
    
}
