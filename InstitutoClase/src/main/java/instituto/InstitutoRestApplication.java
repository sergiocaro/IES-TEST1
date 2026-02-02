package instituto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import instituto.model.Alumno;
import instituto.model.InformeCurso;
import instituto.model.Instituto;
import instituto.model.Modulo;
import instituto.repository.IAlumnoRepository;
import instituto.repository.IInstitutoRepository;
import instituto.repository.IModuloRepository;
import instituto.service.AlumnoServiceImpl;
import instituto.service.InstitutoServiceImpl;
import instituto.service.ModuloServiceImpl;


@SpringBootApplication
public class InstitutoRestApplication implements CommandLineRunner {
    
	@Autowired
	AlumnoServiceImpl alumnoServiceImp;
	@Autowired
	InstitutoServiceImpl institutoServiceImp;
	@Autowired
	ModuloServiceImpl moduloServiceImp;
	
	
    public static void main(String[] args) {
            SpringApplication.run(InstitutoRestApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

		Instituto inst1 = new Instituto("Jose martinez palomo", "Alquerias", "Murcia", "846929462");
		//institutoServiceImp.registrar(inst1);
		Modulo mod1 = new Modulo("Entornos","DAM");
		//moduloServiceImp.registrar(mod1);
		Alumno alum1 = new Alumno("Pepe",LocalDate.of(2005, 5, 20),"C/ciego","pepe@gmail","8546565");
		//alumnoServiceImp.registrar(alum1);
		
		List<Alumno>alumnoList = new ArrayList<Alumno>();
		alumnoList.add(alum1);
		
		inst1.setAlumnoList(alumnoList);
		institutoServiceImp.registrar(inst1);
		
		alum1.setInstitutoId(inst1);
		alumnoServiceImp.registrar(alum1);

		List<InformeCurso>informeCursoList = new ArrayList<InformeCurso>();
		InformeCurso inf1 = new InformeCurso(alum1,mod1);
		
		informeCursoList.add(inf1);
		
		mod1.setInformeCursoList(informeCursoList);
		alum1.setInformeCursoList(informeCursoList);
		
		institutoServiceImp.registrar(inst1);
		moduloServiceImp.registrar(mod1);
		alumnoServiceImp.registrar(alum1);
		
		
		institutoServiceImp.listarPorLocalidad("Murcia").forEach(x -> System.out.println(x.toString()));
		institutoServiceImp.listarPorPrefijo("846").forEach(x -> System.out.println(x.toString()));
		System.out.println(inf1.toString());
		alumnoServiceImp.listar().forEach(x -> System.out.println(x.toString()));
		institutoServiceImp.listar().forEach(x -> System.out.println(x.toString()));
		moduloServiceImp.listar().forEach(x -> System.out.println(x.toString()));
	}    
}
