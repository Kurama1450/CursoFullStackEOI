package com.nestorcosta.springboot.backend.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nestorcosta.springboot.backend.eventos.models.entity.Evento;
import com.nestorcosta.springboot.backend.eventos.models.services.IeventoService;

@CrossOrigin(origins= {"*"})  // Todas las aplicaciones pueden acceder a los servicios web
@RestController
@RequestMapping("/eventos")
public class EventoRestController {
	
	@Autowired
	private IeventoService eventoService;
	
	@GetMapping("")
	public List<Evento> index(){
		return eventoService.findAll();
	}
	
	@GetMapping("/{id}")  // Muestra un solo evento
	public Evento show(@PathVariable int id){
		return eventoService.findById(id);
	}
	
	@DeleteMapping("/{id}")  // Borra un evento
	public void delete(@PathVariable int id){
		eventoService.delete(id);
	}
	
	@PostMapping("")   // Inserta un evento
	@ResponseStatus(HttpStatus.CREATED)
	public Evento create(@RequestBody Evento evento) {
		return eventoService.save(evento);
	}
	
	@PutMapping("/{id}")  // actualiza un cliente
	@ResponseStatus(HttpStatus.CREATED)
	public Evento update(@RequestBody Evento evento,@PathVariable int id) {
		Evento objetoActualizar = eventoService.findById(id);  // Buscamos el elemento a cambiar
		objetoActualizar.setNombre(evento.getNombre());		// cambiamos los datos
		objetoActualizar.setDescripcion(evento.getDescripcion());
		objetoActualizar.setPrecio(evento.getPrecio());
		objetoActualizar.setFecha(evento.getFecha());
		return eventoService.save(objetoActualizar); // Guardo la nueva información
	}
}
