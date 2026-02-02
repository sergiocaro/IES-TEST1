/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.guillermopalazoncano.InstitutoREST.repository;

import com.guillermopalazoncano.InstitutoREST.model.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author guillermopalazoncano
 */
public interface IModuloRepository extends JpaRepository<Modulo, Integer> {
    
}
