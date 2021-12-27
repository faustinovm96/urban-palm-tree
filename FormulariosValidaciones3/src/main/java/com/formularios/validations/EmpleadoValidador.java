package com.formularios.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formularios.models.domain.Empleado;

@Component
public class EmpleadoValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Empleado.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Empleado empleado = (Empleado)target;
		
		//ValidationUtils.rejectIfEmpty(errors, "nombre", "NotEmpty.empleado.nombre");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.empleado.nombre");
		
		if(!empleado.getCedula().matches("[0-9]{1}[.][\\d]{3}[.][\\d]{3}") == false) {
			errors.rejectValue("cedula", "pattern.empleado.cedula");
		}
	}

}
