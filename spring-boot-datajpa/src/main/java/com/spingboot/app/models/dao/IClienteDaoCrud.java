package com.spingboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.spingboot.app.models.domain.Cliente;

public interface IClienteDaoCrud extends CrudRepository<Cliente, Long>{

}
