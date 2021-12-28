package com.formularios.services;

import java.util.List;

import com.formularios.models.domain.Pais;

public interface PaisService {
	public List<Pais> listarPaises();
	public Pais buscarPorId(Integer id);
}
