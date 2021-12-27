package com.formularios.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.formularios.models.domain.Empleado;
import com.formularios.validations.EmpleadoValidador;

@Controller
@SessionAttributes("empleado")
public class FormController {
	
	@Autowired
	private EmpleadoValidador validador;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setValidator(validador); //Reemplaza el validador por defecto
		binder.addValidators(validador); //añade el validador a la cola
	}
	
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
		//validador.validate(empleado, result);
		
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
