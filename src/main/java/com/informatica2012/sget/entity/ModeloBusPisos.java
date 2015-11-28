/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name = "modelobuspisos")
@NamedQueries({
    @NamedQuery(name = "ModeloBusPisos.findAll", query = "SELECT m FROM ModeloBusPisos m")})
public class ModeloBusPisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piso")
    private int piso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroasientos")
    private int numeroasientos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serviciohigienico")
    private boolean serviciohigienico;
    @JoinColumn(name = "modelobusid", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ModeloBus modeloBus;

    public ModeloBusPisos() {
    }

    public ModeloBusPisos(Integer id) {
        this.id = id;
    }

    public ModeloBusPisos(Integer id, int piso, int numeroasientos, boolean serviciohigienico) {
        this.id = id;
        this.piso = piso;
        this.numeroasientos = numeroasientos;
        this.serviciohigienico = serviciohigienico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumeroasientos() {
        return numeroasientos;
    }

    public void setNumeroasientos(int numeroasientos) {
        this.numeroasientos = numeroasientos;
    }

    public boolean getServiciohigienico() {
        return serviciohigienico;
    }

    public void setServiciohigienico(boolean serviciohigienico) {
        this.serviciohigienico = serviciohigienico;
    }

    public ModeloBus getModeloBus() {
        return modeloBus;
    }

    public void setModeloBus(ModeloBus modeloBus) {
        this.modeloBus = modeloBus;
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
        if (!(object instanceof ModeloBusPisos)) {
            return false;
        }
        ModeloBusPisos other = (ModeloBusPisos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.informatica2012.sget.entity.ModeloBusPisos[ id=" + id + " ]";
    }
    
}
