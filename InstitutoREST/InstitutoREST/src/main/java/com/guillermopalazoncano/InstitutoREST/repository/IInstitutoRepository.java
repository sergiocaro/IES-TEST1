/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.repository;

import com.guillermopalazoncano.InstitutoREST.model.Instituto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author guille
 */
public interface IInstitutoRepository extends JpaRepository<Instituto, Integer> {
    
    public List<Instituto> findByLocalidad(String localidad);
    
    @Query ("FROM Instituto i WHERE LOWER(i.telefono) LIKE :numero%")
    List<Instituto> listarPorPrefijoTelefono(@Param("numero") String numero);
}
