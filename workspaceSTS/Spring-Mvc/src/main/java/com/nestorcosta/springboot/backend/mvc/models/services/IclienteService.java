package com.nestorcosta.springboot.backend.mvc.models.services;

import java.util.List;

import com.nestorcosta.springboot.backend.mvc.models.entity.Cliente;

public interface IclienteService {

	public List<Cliente> findAll();//Get buscar todos
	
	public Cliente findById(Long id);//Get buscar uno
	
	public void delete(Long id);//Dlete (Borrado)
	
	public Cliente save(Cliente cliente);//Vale para post y put (Insercion y Actualizacion)
	
	
}
