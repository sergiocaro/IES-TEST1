/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import instituto.model.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer>  {
    
}
