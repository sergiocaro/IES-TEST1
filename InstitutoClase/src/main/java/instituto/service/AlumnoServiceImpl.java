package instituto.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instituto.model.Alumno;
import instituto.repository.IAlumnoRepository;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	IAlumnoRepository alumnoRepository;
	
	@Override
	public Alumno registrar(Alumno alumno) {
		
		return alumnoRepository.save(alumno);
	}

	@Override
	public Alumno modificar(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public ArrayList<Alumno> listar() {
		return (ArrayList<Alumno>) alumnoRepository.findAll();
	}

	@Override
	public Alumno obtener(Integer id) {
        Optional<Alumno> op = alumnoRepository.findById(id);
        return op.isPresent()?op.get():new Alumno();
	}

	@Override
	public void eliminar(Integer id) {
		alumnoRepository.deleteById(id);
	}

}
