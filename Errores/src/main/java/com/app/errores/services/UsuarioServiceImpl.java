package com.app.errores.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.errores.model.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> usuarios;
	
	public UsuarioServiceImpl() {
		usuarios = Arrays.asList(new Usuario(1, "Faustino", "Villasboa"),
									new Usuario(2, "Viviana", "Ojete"),
									new Usuario(3, "Liz", "Marecos"),
									new Usuario(4, "Claudio", "Cañales"),
									new Usuario(5, "Rosa", "Meltrozo"),
									new Usuario(6, "Hector", "Miers"));
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarios;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		
		for (Usuario usuario : usuarios) {
			if (usuario.getId().equals(id)) {
				resultado = usuario;
				break;
			}
		}
		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		
		return Optional.ofNullable(usuario);
	}

}
