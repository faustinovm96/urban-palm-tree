package com.formularios.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formularios.models.domain.Persona;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		Persona persona = new Persona();
		model.addAttribute("persona", persona);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Persona persona, BindingResult result,
			Model model/*
						 * , @RequestParam String ruc,
						 * 
						 * @RequestParam String nombre, @RequestParam String direccion,
						 * 
						 * @RequestParam String telefono
						 */) {
		/*
		 * Persona persona = new Persona(); persona.setNombre(nombre);
		 * persona.setRuc(ruc); persona.setDireccion(direccion);
		 * persona.setTelefono(telefono);
		 */

		//1. Forma: Modo Manual
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(),
						"El campo ".concat(err.getField()).concat("  ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);
			return "form";
		}

		model.addAttribute("persona", persona);

		return "resultado";
	}

}
