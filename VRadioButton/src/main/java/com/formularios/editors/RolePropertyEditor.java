package com.formularios.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formularios.services.RoleService;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {
	
	@Autowired
	private RoleService roleService;
	
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(text);
			setValue(roleService.obtenerRolPorId(id));
		} catch (Exception e) {
			setValue(null);
		}
	}
}
