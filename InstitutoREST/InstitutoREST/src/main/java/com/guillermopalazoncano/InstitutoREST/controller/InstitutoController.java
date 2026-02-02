/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.controller;

import com.guillermopalazoncano.InstitutoREST.dto.InstitutoConAlumnosDTO;
import com.guillermopalazoncano.InstitutoREST.model.Instituto;
import com.guillermopalazoncano.InstitutoREST.service.InstitutoServiceImpl;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/api/ies")
public class InstitutoController {
    @Autowired
    InstitutoServiceImpl insServicio;
    
    @GetMapping("/institutos")
    public ResponseEntity<ArrayList<Instituto>> getInstitutos() {
        ArrayList<Instituto> todosInstitutos = insServicio.listar();
        return ResponseEntity.ok(todosInstitutos);
    }
    
    @GetMapping("/institutosalumnos")
    public ResponseEntity<ArrayList<InstitutoConAlumnosDTO>> getInstitutosAlumnos() {
        ArrayList<Instituto> todosInstitutos = insServicio.listar();
        ArrayList<InstitutoConAlumnosDTO> listaInsDevolver = new ArrayList<InstitutoConAlumnosDTO>();
        for (Instituto instituto : todosInstitutos) {
            listaInsDevolver.add(new InstitutoConAlumnosDTO(instituto));
        }        
        return ResponseEntity.ok(listaInsDevolver);
    }
    
    @GetMapping("/institutos/{id}")
    public ResponseEntity<Instituto> getInstitutoPorId(@PathVariable int id) {
        Instituto instituto = insServicio.obtener(id);
        if (instituto.getId()==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(instituto);
    }
    
    @PostMapping("/institutos")
    public ResponseEntity<Instituto> insInstituto(@RequestBody Instituto instituto) {
        
        if (instituto.getId()!=null){
            Instituto institutoYaExiste = insServicio.obtener(instituto.getId());
            if (institutoYaExiste.getId()!=null){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        Instituto insDevolver = insServicio.registrar(instituto);
        return new ResponseEntity<>(insDevolver,HttpStatus.CREATED);
    }
    
    @PutMapping("/institutos/{id}")
    public ResponseEntity<Instituto> actualizaInstituto(@RequestBody Instituto instituto,
            @PathVariable int id) {
        
        Instituto ins = insServicio.obtener(id);
        if (ins.getId()==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (instituto.getId()!=null && instituto.getId()!=id){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } 
        }
        ins.setDireccion(instituto.getDireccion());
        ins.setNombre(instituto.getNombre());
        ins.setLocalidad(instituto.getLocalidad());
        ins.setTelefono(instituto.getTelefono());
        Instituto insDevolver = insServicio.modificar(ins);
        return new ResponseEntity<>(insDevolver,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/institutos/{id}")
    public ResponseEntity<Instituto> deleteInstituto(@PathVariable Integer id) {

        Instituto instituto = insServicio.obtener(id);
        if (instituto.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // Verificar si el id en el body coincide con el id en la ruta
            insServicio.eliminar(id);
        }
        // 204. Para indicarle que no devuelve contenido (JSON o cualquier otro)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
    
    @GetMapping("/institutos/localidad/{localidad}")
    public ResponseEntity<ArrayList<Instituto>> getInstitutosLocalidad(@PathVariable String localidad) {
        ArrayList<Instituto> institutos = insServicio.listarPorLocalidad(localidad);
        return new ResponseEntity<>(institutos, HttpStatus.OK);
    }
    
    @GetMapping("/institutos/prefijo/{numero}")
    public ResponseEntity<ArrayList<Instituto>> getInstitutosPrefijo(@PathVariable String numero) {
        ArrayList<Instituto> institutos = insServicio.listarPorPrefijo(numero);
        return new ResponseEntity<>(institutos, HttpStatus.OK);
    }
}
