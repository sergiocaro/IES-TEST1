/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package instituto.service;

import java.util.ArrayList;

import instituto.model.Instituto;

/**
 *
 * @author guille
 */
public interface IInstitutoService {
    Instituto registrar (Instituto instituto);
    Instituto modificar (Instituto instituto);
    ArrayList<Instituto> listar();
    Instituto obtener (Integer id);
    void eliminar (Integer id);
    ArrayList<Instituto> listarPorLocalidad(String localidad);
    ArrayList<Instituto> listarPorPrefijo(String prefijo);
}
