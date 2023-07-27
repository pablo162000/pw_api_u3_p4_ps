package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	
	@Autowired
	private IEstudianteRepository estudianteService;
	
	@Override
	public Estudiante consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteService.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteService.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteService.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteService.borrar(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteService.buscarTodos();
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteService.buscarPorId(id);
	}

	@Override
	public Estudiante insertar2(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.estudianteService.insertar2(estudiante);
	}

	@Override
	public List<Estudiante> consultarTodos(String provincia) {
		// TODO Auto-generated method stub
		return this.estudianteService.buscarTodosPorProvincia(provincia);
	}

	@Override
	public List<EstudianteTO> buscarTodos1() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteService.buscarTodos();
		List<EstudianteTO> listaTO= lista.stream().map(estudiante->this.convertir(estudiante)).collect(Collectors.toList()); 
		return listaTO;
	}
	
	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO est= new EstudianteTO();
		est.setApellido(estudiante.getApellido());
		est.setId(estudiante.getId());
		est.setCedula(estudiante.getCedula());
		est.setNombre(estudiante.getNombre());
		est.setFechaNacimiento(estudiante.getFechaNacimiento());
		est.setProvincia(estudiante.getProvincia());
		
		return est;
	}
	

}
