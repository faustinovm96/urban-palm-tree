package com.formularios.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequeridoValidator implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		//reemplazar la condicion if y dara el mismo resultado value == null || value.isEmpty() || value.isBlank()
		if (value == null || !StringUtils.hasText(value)) {
			return false;
		}
		return true;
	}

}
