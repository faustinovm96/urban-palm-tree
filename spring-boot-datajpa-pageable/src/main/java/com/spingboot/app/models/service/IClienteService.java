package com.spingboot.app.models.service;

import java.util.List;

import com.spingboot.app.models.domain.Cliente;

public interface IClienteService {
	public List<Cliente> listarClientes();
	public void guardarCliente(Cliente cliente);
	public Cliente findOne(Long id);
	public void eliminar(Long id);
}
