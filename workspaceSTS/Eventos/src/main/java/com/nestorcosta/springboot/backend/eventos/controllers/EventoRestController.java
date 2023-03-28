package com.nestorcosta.springboot.backend.eventos.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nestorcosta.springboot.backend.eventos.models.dto.EventoDto;
import com.nestorcosta.springboot.backend.eventos.models.entity.Evento;
import com.nestorcosta.springboot.backend.eventos.models.services.IeventoService;

@CrossOrigin(origins= {"*"})  // Todas las aplicaciones pueden acceder a los servicios web
@RestController
@RequestMapping("/eventos")
public class EventoRestController {
	
	@Autowired
	private IeventoService eventoService;
	/*
	@GetMapping("")
	public List<Evento> index(){
		return eventoService.findAll();
	}*/
	
	@GetMapping("/dto")
	public List<EventoDto> indexDto(){
		List<EventoDto> listaDto = new  ArrayList<>();
		eventoService.findAll().forEach(evento->{
			listaDto.add(new EventoDto(evento.getId(),evento.getNombre(),evento.getDescripcion(),evento.getUsuarios()));
		});		
		return listaDto;
	}
	
	
	@GetMapping("")
	public ResponseEntity<?> index(){
		
		List<Evento> respuesta = new ArrayList<Evento>();
		Map<String,Object> response = new HashMap<>();
		
		try {
			respuesta = eventoService.findAll()
					.stream()
					.map(e->{  // construimos una nueva lista con el campo imagen con la ruta completa
						Evento evento = new Evento(e);
						if(evento.getImagen()!=null) {  // Para devolverle al front la ruta completa de la imagen
							evento.setImagen(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + evento.getImagen());
						}
						return evento;						
					})
					.collect(Collectors.toList());
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Evento>>(respuesta,HttpStatus.OK);
	}
	

	/*
	@GetMapping("/{id}")  // Muestra un solo evento
	public Evento show(@PathVariable int id){
		return eventoService.findById(id);
	}*/
	
	@GetMapping("/{id}")  
	public ResponseEntity<?> show(@PathVariable int id){
		
		Evento evento = null;
		Map<String,Object> response = new HashMap<>();
		try {
			evento = eventoService.findById(id);
		} catch (DataAccessException e) {  // fallo en la petición a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(evento==null) {  // no existe el id de cliente
			response.put("mensaje", "El evento con ID: ".concat(id+"").concat(" no existe"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		if(evento.getImagen()!=null)
			evento.setImagen(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + evento.getImagen());	
		// ha encontrado el cliente
		return new ResponseEntity<Evento>(evento,HttpStatus.OK);		
	}
	
	/*
	@DeleteMapping("/{id}")  // Borra un evento
	public void delete(@PathVariable int id){
		eventoService.delete(id);
	}*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		Map<String,Object> response = new HashMap<>();
		try {
			eventoService.delete(id);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al eliminar el id");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El evento se ha borrado correctamente");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	/*
	@PostMapping("")   // Inserta un evento
	@ResponseStatus(HttpStatus.CREATED)
	public Evento create(@RequestBody Evento evento) {
		return eventoService.save(evento);
	}*/
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Evento evento){
		
		Evento nuevo = null;
		Map<String,Object> response = new HashMap<>();
					
		try {
			nuevo = eventoService.save(evento);
			if(evento.getImagen()!=null) {  // Para devolverle al front la ruta completa de la imagen
				nuevo.setImagen(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + nuevo.getImagen());
			}
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El evento se ha insertado correctamente");
		response.put("evento", nuevo);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	/*
	@PutMapping("/{id}")  // actualiza un cliente
	@ResponseStatus(HttpStatus.CREATED)
	public Evento update(@RequestBody Evento evento,@PathVariable int id) {
		Evento objetoActualizar = eventoService.findById(id);  // Buscamos el elemento a cambiar
		objetoActualizar.setNombre(evento.getNombre());		// cambiamos los datos
		objetoActualizar.setDescripcion(evento.getDescripcion());
		objetoActualizar.setPrecio(evento.getPrecio());
		objetoActualizar.setFecha(evento.getFecha());
		return eventoService.save(objetoActualizar); // Guardo la nueva información
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Evento evento, @PathVariable int id){
		
		Evento eventoActual = null;
		Evento eventoUpdated = null;
		Map<String,Object> response = new HashMap<>();
			
		try {
			eventoActual = eventoService.findById(id); // El cliente puede existir o no
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(eventoActual==null) { // No existe en la base de datos
			response.put("mensaje", "El evento con ID: ".concat(id+"").concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		// Si llegamos aquí es que el cliente que queremos modificar SI existe
		try {
			eventoActual.setNombre(evento.getNombre());
			eventoActual.setDescripcion(evento.getDescripcion());
			eventoActual.setPrecio(evento.getPrecio());
			eventoActual.setFecha(evento.getFecha());
			if(evento.getImagen()!=null)  // Me la guarda en bbdd si existe
				eventoActual.setImagen(evento.getImagen());
			else
				eventoActual.setImagen(null);
			eventoUpdated = eventoService.save(eventoActual);
			if(evento.getImagen()!=null) {  // Para devolverle al front la ruta completa de la imagen
				eventoUpdated.setImagen(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + eventoUpdated.getImagen());
			}
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El evento se ha modificado correctamente");
		response.put("evento", eventoUpdated);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	}
}
