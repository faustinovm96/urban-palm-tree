package com.spingboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spingboot.app.models.domain.Cliente;
import com.spingboot.app.models.service.IClienteService;
import com.spingboot.app.util.paginator.PageRender;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteServiceJPA")
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name ="page", defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4);
		
		Page<Cliente> clientes = clienteService.listarClientes(pageRequest);
		
		PageRender<Cliente> pageRender = new PageRender<Cliente>("/clientes/listar", clientes);
		model.addAttribute("titulo", "Listar de CLientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
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
	public String crearCliente(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Clientes");
			return "form";
		}
		clienteService.guardarCliente(cliente);
		flash.addFlashAttribute("success", "Cliente Creado con éxito");
		return "redirect:/clientes/listar";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteService.findOne(id);
			if(cliente == null) {
				flash.addFlashAttribute("error", "El id del cliente no existe en la DB");
			}
		}else {
			flash.addFlashAttribute("error", "ID NO ENCONTRADO");
			return "redirect:/clientes/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if(id > 0) {
			clienteService.eliminar(id);
			flash.addFlashAttribute("success", "Cliente Eliminado con éxito");
		}
		return "redirect:/clientes/listar";
	}
	
}
