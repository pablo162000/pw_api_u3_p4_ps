package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.model.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		List<Materia> lista = this.iMateriaRepository.buscarPorCedulaEstudiante(cedula);

		List<MateriaTO> listaFinal = lista.stream().map(materia -> this.convertir(materia))
				.collect(Collectors.toList());

		return listaFinal;
	}

	private MateriaTO convertir(Materia materia) {

		MateriaTO mate = new MateriaTO();
		mate.setId(materia.getId());
		mate.setCreditos(materia.getCodigo());
		mate.setNombre(materia.getNombre());
		mate.setCodigo(materia.getCodigo());
		return mate;

	}

	@Override
	public List<Materia> bucarTodas() {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.bucarTodas();
	}

	@Override
	public MateriaTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		
		MateriaTO mate = this.convertir(this.iMateriaRepository.buscarPorId(id));
		return mate;
	}

}
