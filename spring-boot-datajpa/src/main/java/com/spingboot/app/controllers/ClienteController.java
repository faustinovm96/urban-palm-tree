package com.spingboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spingboot.app.models.dao.IClienteDao;
import com.spingboot.app.models.domain.Cliente;
import com.spingboot.app.models.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteServiceJPA")
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listar de CLientes");
		model.addAttribute("clientes", clienteService.listarClientes());
		return "listar";
	}
	
	@GetMapping("/form")
	public String formularioCliente(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		
		model.put("titulo", "Formulario de Clientes");
		model.put("cliente", cliente);
		return "form";
	}
	
	@PostMapping("/form")
	public String crearCliente(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Clientes");
			return "form";
		}
		clienteService.guardarCliente(cliente);
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteService.findOne(id);
		}else {
			return "redirect:/clientes/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if(id > 0) {
			clienteService.eliminar(id);
		}
		return "redirect:/clientes/listar";
	}
	
}
