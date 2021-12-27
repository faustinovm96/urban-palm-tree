package com.formularios.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CedulaRegexValidator implements ConstraintValidator<CedulaRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(!value.matches("[0-9]{1}[.][\\d]{3}[.][\\d]{3}") == false) {
			return true;
		}
		return false;
	}

}
