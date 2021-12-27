package com.formularios.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formularios.services.PaisService;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private PaisService service;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {

		if (idString != null && idString.length() > 0) {
			try {
				Integer id = Integer.parseInt(idString);
				setValue(service.buscarPorId(id));

			} catch (NumberFormatException e) {
				System.out.println("ES NULO TRY");
				setValue(null);
			}
		} else {
			setValue(null);
			System.out.println("ES NULO IF");
		}
	}
}
