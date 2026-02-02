/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import instituto.model.Modulo;

public interface IModuloRepository extends JpaRepository<Modulo, Integer> {
    
}
