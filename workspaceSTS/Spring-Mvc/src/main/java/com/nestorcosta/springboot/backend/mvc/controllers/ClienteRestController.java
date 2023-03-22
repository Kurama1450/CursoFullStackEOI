package com.nestorcosta.springboot.backend.mvc.controllers;

import java.time.LocalDate;
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

import com.nestorcosta.springboot.backend.mvc.models.entity.Cliente;
import com.nestorcosta.springboot.backend.mvc.models.services.IclienteService;

@CrossOrigin(origins= {"*"})//Todas las aplicaciones pueden acceder a los servicios web.
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IclienteService clienteService;
	
	@GetMapping("/clientes")//Muestra todos los clientes
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")//Muestra un solo cliente
	public Cliente show(@PathVariable Long id){
		return clienteService.findById(id);
	}
	
	@DeleteMapping("/clientes/{id}")//Borra un solo cliente
	public void delete(@PathVariable Long id){
		clienteService.delete(id);
	}
	
	@PostMapping("/clientes")//Inserccion de un cliente
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente){
		cliente.setCreateAt(LocalDate.now());//Le pongo como fecha de creacion la de hoy
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")//Actualiza un cliente
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActualizar = clienteService.findById(id);//Buscamos el elemento a cambiar
		clienteActualizar.setNombre(cliente.getNombre());//cambiamos los datos
		clienteActualizar.setApellido(cliente.getApellido());
		clienteActualizar.setEmail(cliente.getEmail());
		return clienteService.save(clienteActualizar);//Guardo la nueva informacion
	}
}
