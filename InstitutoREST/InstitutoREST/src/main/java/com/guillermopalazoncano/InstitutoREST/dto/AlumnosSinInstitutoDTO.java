/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.dto;

import com.guillermopalazoncano.InstitutoREST.model.Alumno;
import lombok.*;

/**
 *
 * @author guille
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AlumnosSinInstitutoDTO {    
    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    
    public AlumnosSinInstitutoDTO(Alumno al){
        this.nombre = al.getNombre();
        this.direccion = al.getDireccion();
        this.correo = al.getCorreo();
        this.telefono = al.getTelefono();        
    }
}


