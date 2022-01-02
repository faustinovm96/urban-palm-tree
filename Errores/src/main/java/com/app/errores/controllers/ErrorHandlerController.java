package com.app.errores.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.errores.errors.UsuarioNoEncontradoException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error Aritmetico");
		model.addAttribute("message", "Error en la operacion aritmetica");
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatoError(NumberFormatException ex, Model model) {
		model.addAttribute("error", "Formato de Número Incorrectop");
		model.addAttribute("message", "El formato no se puede convertir");
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/number-format";
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String usuarioNoEncontradoFound(UsuarioNoEncontradoException ex, Model model) {
		model.addAttribute("error", "Usuario No Encontrado");
		model.addAttribute("message", "El usuario no se puede encontrar");
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generics";
	}
}
