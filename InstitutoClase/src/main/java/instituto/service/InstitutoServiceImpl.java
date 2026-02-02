/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instituto.service;

import instituto.model.Instituto;
import instituto.repository.IInstitutoRepository;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guille
 */
@Service
public class InstitutoServiceImpl implements IInstitutoService {

    @Autowired 
    IInstitutoRepository institutoRepository;
    
    @Override
    public Instituto registrar(Instituto instituto) {
        return institutoRepository.save(instituto);
    }

    @Override
    public Instituto modificar(Instituto instituto) {
        return institutoRepository.save(instituto);
    }

    @Override
    public ArrayList<Instituto> listar() {
        return (ArrayList<Instituto>) institutoRepository.findAll();
    }

    @Override
    public Instituto obtener(Integer id) {
        Optional<Instituto> op = institutoRepository.findById(id);
        return op.isPresent()?op.get():new Instituto();
    }

    @Override
    public void eliminar(Integer id) {
        institutoRepository.deleteById(id);
    }
    
    @Override
    public ArrayList<Instituto> listarPorLocalidad(String localidad) {
        return (ArrayList<Instituto>) institutoRepository.findByLocalidad(localidad);
    }

    @Override
    public ArrayList<Instituto> listarPorPrefijo(String prefijo) {
        return (ArrayList<Instituto>) institutoRepository.listarPorPrefijoTelefono(prefijo);
    }
    
}
