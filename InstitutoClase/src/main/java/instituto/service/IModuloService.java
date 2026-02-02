package instituto.service;

import java.util.ArrayList;

import instituto.model.Modulo;

public interface IModuloService {

	  Modulo registrar (Modulo modulo);
	  Modulo modificar (Modulo modulo);
	  ArrayList<Modulo> listar();
	  Modulo obtener (Integer id);
	  void eliminar (Integer id);
}
