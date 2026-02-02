/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author guille
 */
@Entity
@Table(name = "tinstituto")
@NamedQueries({
    @NamedQuery(name = "Instituto.findAll", query = "SELECT i FROM Instituto i"),
    @NamedQuery(name = "Instituto.findById", query = "SELECT i FROM Instituto i WHERE i.id = :id"),
    @NamedQuery(name = "Instituto.findByNombre", query = "SELECT i FROM Instituto i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instituto.findByDireccion", query = "SELECT i FROM Instituto i WHERE i.direccion = :direccion"),
    @NamedQuery(name = "Instituto.findByLocalidad", query = "SELECT i FROM Instituto i WHERE i.localidad = :localidad"),
    @NamedQuery(name = "Instituto.findByTelefono", query = "SELECT i FROM Instituto i WHERE i.telefono = :telefono")})
public class Instituto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "institutoId")
    @JsonIgnore
    private List<Alumno> alumnoList;

    public Instituto() {
    }

    public Instituto(Integer id) {
        this.id = id;
    }

    public Instituto(Integer id, String nombre, String direccion, String localidad, String telefono) {
        this(nombre, direccion, localidad, telefono);
        this.id = id;
    }
    
    public Instituto(String nombre, String direccion, String localidad, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituto)) {
            return false;
        }
        Instituto other = (Instituto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Instituto{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", localidad=" + localidad + ", telefono=" + telefono + "}";
    }

   
}
