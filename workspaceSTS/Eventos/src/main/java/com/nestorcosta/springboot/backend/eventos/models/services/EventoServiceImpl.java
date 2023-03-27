package com.nestorcosta.springboot.backend.eventos.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nestorcosta.springboot.backend.eventos.models.dao.IeventoDao;
import com.nestorcosta.springboot.backend.eventos.models.entity.Evento;
import com.nestorcosta.springboot.backend.eventos.utilidades.ImageUtils;

@Service
public class EventoServiceImpl implements IeventoService{
	
	@Autowired
	private IeventoDao eventoDao;

	private final ImageUtils imageUtils = new ImageUtils();

	@Override
	@Transactional(readOnly=true)
	public List<Evento> findAll() {
		return (List<Evento>)eventoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Evento findById(int id) {
		return eventoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(int id) {
		eventoDao.deleteById(id);		
	}

	@Override
	@Transactional
	public Evento save(Evento evento) {
		if(evento.getImagen()!=null) {
			String ruta = imageUtils.saveImageBase64("eventos", evento.getImagen());
	        evento.setImagen(ruta);
		}
		return eventoDao.save(evento);
	}

}
