package com.nestorcosta.ejemplo1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nestorcosta.ejemplo1.entidades.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	/*
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "programa de prueba");
		model.addAttribute("contenidoh1", "Contenido del H1");
		return "index";
	}*/
	
	@GetMapping({"/index","/","","/home"}) // http://localhost:8080/app/index, http://localhost:8080/app/
	public String index(Map<String,Object> map) {
		map.put("titulo", "programa de prueba");
		map.put("contenidoh1", "Contenido del H1");
		return "/index";
	}
	
	@GetMapping("/index2")   // http://localhost:8080/app/index2
	public String index2(Model model) {
		model.addAttribute("titulo", "Otra prueba");
		model.addAttribute("contenidoh1", "Contenido del H1 en el index2");
		return "/index2";
	}
	
	@GetMapping("/perfil")   // http://localhost:8080/app/index2
	public String perfil(Model model) {
		model.addAttribute("titulo", "Perfil del Usuario");
		//model.addAttribute("usuario",new Usuario("Fran","García","fran@iessanvicente.com"));
		model.addAttribute("usuario",new Usuario("Fran","García"));
		return "/perfil";
	}
	
	@GetMapping("/listar")   // http://localhost:8080/app/index2
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Fran","García","fran@iessanvicente.com"));
		usuarios.add(new Usuario("Dani","García","dani@iessanvicente.com"));
		usuarios.add(new Usuario("Paco","García","paco@iessanvicente.com"));
		
		model.addAttribute("titulo", "Lista de usuarios");
		model.addAttribute("usuarios",usuarios);
		return "/listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Fran","García","fran@iessanvicente.com"));
		usuarios.add(new Usuario("Dani","García","dani@iessanvicente.com"));
		usuarios.add(new Usuario("Paco","García","paco@iessanvicente.com"));
		return usuarios;
	}
}
