package com.spingboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.spingboot.app.models.domain.Cliente;

@Component("clienteDaoCRUD")
public interface IClienteDaoCrud extends PagingAndSortingRepository<Cliente, Long>{

}
