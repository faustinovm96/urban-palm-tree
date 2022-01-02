package com.app.errores.services;

import java.util.List;
import java.util.Optional;

import com.app.errores.model.domain.Usuario;

public interface UsuarioService {
	public List<Usuario> listarUsuarios();
	public Usuario obtenerPorId(Integer id);
	public Optional<Usuario> obtenerPorIdOptional(Integer id);
}
