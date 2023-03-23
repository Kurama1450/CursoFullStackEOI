package com.nestorcosta.springboot.backend.eventos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.nestorcosta.springboot.backend.eventos.models.entity.Evento;

public interface IeventoDao extends CrudRepository<Evento, Integer> {

	
	
}
