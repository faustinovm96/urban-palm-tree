package com.formularios.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.formularios.models.domain.Empleado;

@Controller
@SessionAttributes("empleado")
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		Empleado empleado = new Empleado();
		/*persona.setDireccion("HOLA");
		persona.setCedula("1.111.111");*/
		model.addAttribute("titulo", "Formulario de Empleado");
		model.addAttribute("empleado", empleado);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Empleado empleado, BindingResult result, 
			Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Empleado");
			//System.out.println("Hola Mundo");
			return "form";
		}
		
		model.addAttribute("titulo", "Resultados del Método POST");
		model.addAttribute("empleado", empleado);
		status.setComplete();
		return "resultado";
	}
	
}
