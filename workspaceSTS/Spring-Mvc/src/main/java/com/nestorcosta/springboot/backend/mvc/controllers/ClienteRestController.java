package com.nestorcosta.springboot.backend.mvc.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

import com.nestorcosta.springboot.backend.mvc.models.entity.Cliente;
import com.nestorcosta.springboot.backend.mvc.models.services.IclienteService;

import jakarta.validation.Valid;

@CrossOrigin(origins= {"*"})//Todas las aplicaciones pueden acceder a los servicios web.
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IclienteService clienteService;
	
	/*
	@GetMapping("/clientes")  // Muestra todos los clientes
	public List<Cliente> index(){
		return clienteService.findAll();
	}*/
	
	@GetMapping("/clientes")
	public ResponseEntity<?> index(){
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Map<String,Object> response = new HashMap<>();
		
		try {
			listaClientes = clienteService.findAll();
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Cliente>>(listaClientes,HttpStatus.OK);
	}
	
	/*
	@GetMapping("/clientes/{id}")  // Muestra un solo cliente
	public Cliente show(@PathVariable Long id){
		return clienteService.findById(id);
	}*/
	
	@GetMapping("/clientes/{id}")  // Muestra un solo cliente
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Cliente cliente = null;
		Map<String,Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id);
		} catch (DataAccessException e) {  // fallo en la petición a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(cliente==null) {  // no existe el id de cliente
			response.put("mensaje", "El cliente con ID: ".concat(id.toString()).concat(" no existe"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		// ha encontrado el cliente
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);		
	}
	
	/*
	@DeleteMapping("/clientes/{id}")  // Borra un cliente
	public void delete(@PathVariable Long id){
		clienteService.delete(id);
	}*/
	
	@DeleteMapping("clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String,Object> response = new HashMap<>();
		try {
			clienteService.delete(id);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al eliminar el id");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El cliente se ha borrado correctamente");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	/*
	@PostMapping("/clientes")   // Inserta un cliente
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		cliente.setCreateAt(LocalDate.now());  // Le pongo como fecha de creación la de hoy
		return clienteService.save(cliente);
	}*/
	
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result){
		
		Cliente clienteNew = null;
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {  // hay algún error en la validación de datos

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			cliente.setCreateAt(LocalDate.now());  // Cambia la fecha a la actual
			clienteNew = clienteService.save(cliente);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente se ha insertado correctamente");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	
	
	/*
	@PutMapping("/clientes/{id}")  // actualiza un cliente
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
		Cliente clienteActualizar = clienteService.findById(id);  // Buscamos el elemento a cambiar
		clienteActualizar.setNombre(cliente.getNombre());		// cambiamos los datos
		clienteActualizar.setApellido(cliente.getApellido());
		clienteActualizar.setEmail(cliente.getEmail());
		return clienteService.save(clienteActualizar); // Guardo la nueva información
	}*/
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, @PathVariable Long id, BindingResult result){
		
		Cliente clienteActual = null;
		Cliente clienteUpdated = null;
		Map<String,Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			clienteActual = clienteService.findById(id); // El cliente puede existir o no
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(clienteActual==null) { // No existe en la base de datos
			response.put("mensaje", "El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		// Si llegamos aquí es que el cliente que queremos modificar SI existe
		try {
			clienteActual.setNombre(cliente.getNombre());
			clienteActual.setApellido(cliente.getApellido());
			clienteActual.setEmail(cliente.getEmail());
			clienteUpdated = clienteService.save(clienteActual);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente se ha modificado correctamente");
		response.put("cliente", clienteUpdated);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);

	}
}
