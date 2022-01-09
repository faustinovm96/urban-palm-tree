package com.spingboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spingboot.app.models.domain.Cliente;

public interface IClienteDaoCrud extends PagingAndSortingRepository<Cliente, Long>{

}
