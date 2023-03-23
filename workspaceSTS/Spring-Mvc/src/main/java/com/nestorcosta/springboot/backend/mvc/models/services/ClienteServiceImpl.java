package com.nestorcosta.springboot.backend.mvc.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nestorcosta.springboot.backend.mvc.models.dao.IClienteDao;
import com.nestorcosta.springboot.backend.mvc.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IclienteService {

	
	@Autowired//Para incorporar un componente dentro de otro componente
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)//Autoexiges que dentro del metodo no usarás nada que pueda modificar los datos.
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override

	@Transactional(readOnly=true)

	public Cliente findById(Long id) {

		return clienteDao.findById(id).orElse(null);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

}