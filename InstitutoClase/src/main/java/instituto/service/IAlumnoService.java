package instituto.service;

import java.util.ArrayList;

import instituto.model.Alumno;

public interface IAlumnoService {
	
    Alumno registrar (Alumno alumno);
    Alumno modificar (Alumno alumno);
    ArrayList<Alumno> listar();
    Alumno obtener (Integer id);
    void eliminar (Integer id);
}
