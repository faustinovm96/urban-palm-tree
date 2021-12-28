package com.formularios.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formularios.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	private List<Pais> paises;
	
	public PaisServiceImpl() {
		this.paises = Arrays.asList(new Pais(1, "PY", "Paraguay"),
				new Pais(2, "BR", "Brasil"),
				new Pais(3, "ARG", "Argentina"),
				new Pais(4, "COL", "Colombia"));
	}
	
	@Override
	public List<Pais> listarPaises() {
		// TODO Auto-generated method stub
		return paises;
	}

	@Override
	public Pais buscarPorId(Integer id) {
		Pais resultado = null;
		for (Pais pais : paises) {
			if(id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
