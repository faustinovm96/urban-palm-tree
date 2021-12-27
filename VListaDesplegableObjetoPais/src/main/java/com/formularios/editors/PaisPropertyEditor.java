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
	public void setAsText(String id) throws IllegalArgumentException {
		setValue(service.buscarPorId(Integer.parseInt(id)));
	}
}
