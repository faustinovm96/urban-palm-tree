package com.app.errores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.errores.errors.UsuarioNoEncontradoException;
import com.app.errores.model.domain.Usuario;
import com.app.errores.services.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index() {
		Integer p = Integer.parseInt("NASDF");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		/*Usuario usuario = usuarioService.obtenerPorId(id);
		
		if (usuario == null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}*/
		
		Usuario usuario = usuarioService.obtenerPorIdOptional(id).
				orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle Usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
