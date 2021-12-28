package com.formularios.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = RequeridoValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Requerido {
	String message() default "Campo Requerido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
