package com.formularios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.formularios.models.domain.Role;

@Component
public class RoleServiceImpl implements RoleService {

	private List<Role> roles;
	
	public RoleServiceImpl() {
		roles = new ArrayList<>();
		roles.add(new Role(1, "ROLE_ADMIN", "Administrador"));
		roles.add(new Role(2, "ROLE_USER", "Usuario"));
		roles.add(new Role(3, "ROLE_MODERATOR", "Moderador"));
	}
	
	@Override
	public List<Role> listarRoles() {
		return roles;
	}

	@Override
	public Role obtenerRolPorId(Integer id) {
		Role resultado = null;
		
		for (Role role : roles) {
			if (id == role.getId()) {
				resultado = role;
				break;
			}
		}
		return resultado;
	}

}
