package instituto.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instituto.model.Modulo;
import instituto.repository.IModuloRepository;

@Service
public class ModuloServiceImpl implements IModuloService {
	
	@Autowired
	IModuloRepository moduloRepository;

	@Override
	public Modulo registrar(Modulo modulo) {
		return moduloRepository.save(modulo);
	}

	@Override
	public Modulo modificar(Modulo modulo) {
		return moduloRepository.save(modulo);
	}

	@Override
	public ArrayList<Modulo> listar() {
		return (ArrayList<Modulo>) moduloRepository.findAll();
	}

	@Override
	public Modulo obtener(Integer id) {
		  Optional<Modulo> op = moduloRepository.findById(id);
	      return op.isPresent()?op.get():new Modulo();
	}

	@Override
	public void eliminar(Integer id) {
		moduloRepository.deleteById(id);
	}
	
	
}
