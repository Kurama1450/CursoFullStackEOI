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
		Evento eventoActual = eventoDao.findById(id).orElse(null);
		if(eventoActual!=null) {
			if(eventoActual.getImagen()!=null) {
				// borrado del fichero de la imagen
				imageUtils.deleteImage("public", eventoActual.getImagen());
			}
			eventoDao.deleteById(id);
		}
	}

	@Override
	@Transactional
	public Evento save(Evento evento) {		
		if(evento.getImagen()!=null) {  // me envían imagen desde el front
			String ruta = imageUtils.saveImageBase64("eventos", evento.getImagen());
			evento.setImagen(ruta);
		} else {  // Le quita la imagen en la base datos si llega con null
			evento.setImagen(null);
		}
		return eventoDao.save(evento);  // actualización sobre la base de datos
	}

}
