/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author guille
 */
@Entity
@Table(name = "tmodulo")
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByCodigoModulo", query = "SELECT m FROM Modulo m WHERE m.codigoModulo = :codigoModulo"),
    @NamedQuery(name = "Modulo.findByNombreModulo", query = "SELECT m FROM Modulo m WHERE m.nombreModulo = :nombreModulo"),
    @NamedQuery(name = "Modulo.findByCicloFormativo", query = "SELECT m FROM Modulo m WHERE m.cicloFormativo = :cicloFormativo")})
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_modulo")
    private Integer codigoModulo;
    @Basic(optional = false)
    @Column(name = "nombre_modulo")
    private String nombreModulo;
    @Basic(optional = false)
    @Column(name = "ciclo_formativo")
    private String cicloFormativo;
    @ManyToMany(mappedBy = "moduloList")
    private List<Alumno> alumnoList;

    public Modulo() {        
    }

    public Modulo(Integer codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public Modulo(Integer codigoModulo, String nombreModulo, String cicloFormativo) {
        this.codigoModulo = codigoModulo;
        this.nombreModulo = nombreModulo;
        this.cicloFormativo = cicloFormativo;
    }

    public Integer getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Integer codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getCicloFormativo() {
        return cicloFormativo;
    }

    public void setCicloFormativo(String cicloFormativo) {
        this.cicloFormativo = cicloFormativo;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoModulo != null ? codigoModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.codigoModulo == null && other.codigoModulo != null) || (this.codigoModulo != null && !this.codigoModulo.equals(other.codigoModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modulo{" + "código=" + codigoModulo + ", nombreModulo=" + nombreModulo + ", cicloFormativo=" + cicloFormativo + ", alumnoList=" + alumnoList + '}';
    }

   
    
}
