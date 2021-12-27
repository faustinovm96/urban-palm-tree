package com.formularios.services;

import java.util.List;

import com.formularios.models.domain.Role;

public interface RoleService {
	public List<Role> listarRoles();
	public Role obtenerRolPorId(Integer id);
}
