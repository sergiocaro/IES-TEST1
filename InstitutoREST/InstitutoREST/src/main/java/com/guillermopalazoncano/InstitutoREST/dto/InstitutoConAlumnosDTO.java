/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.dto;

import com.guillermopalazoncano.InstitutoREST.model.Alumno;
import com.guillermopalazoncano.InstitutoREST.model.Instituto;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 *
 * @author guille
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class InstitutoConAlumnosDTO {
    private Integer id;
    private String nombre;
    private String direccion;
    private String localidad;
    private String telefono;
    private List<AlumnosSinInstitutoDTO> alumnoList = new ArrayList<AlumnosSinInstitutoDTO>();
    
    public InstitutoConAlumnosDTO (Instituto instituto){
        this.id = instituto.getId();
        this.nombre = instituto.getNombre();
        this.direccion = instituto.getDireccion();
        this.localidad = instituto.getLocalidad();
        this.telefono = instituto.getTelefono();   
        
        List<Alumno> alumnosInstituto = instituto.getAlumnoList();
        for (Alumno al: alumnosInstituto){
            AlumnosSinInstitutoDTO alsin = new AlumnosSinInstitutoDTO(al);
            alumnoList.add(alsin);
        }        
    }
}
