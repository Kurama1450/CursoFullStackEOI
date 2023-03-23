package com.nestorcosta.springboot.backend.eventos.models.services;

import java.util.List;

import com.nestorcosta.springboot.backend.eventos.models.entity.Evento;

public interface IeventoService {

	public List<Evento> findAll();
	public Evento findById(int id);
	public void delete(int id);  // Delete (Borrado)
	public Evento save(Evento evento);  // Vale para POST y para PUT (Inserción y actualización)
	
}
