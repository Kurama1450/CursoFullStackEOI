package com.nestorcosta.ejemplo1.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class RequestParamController {

	@GetMapping({"/index","/","","/home"}) // http://localhost:8080/params/index, http://localhost:8080/app/
	public String index(Map<String,Object> map) {
		map.put("titulo", "Ejemplo Param");
		map.put("contenidoh1", "Contenido del H1 en param");
		return "/params/index";
	}
	
	@GetMapping({"/string"}) // http://localhost:8080/params/string
	public String ver(@RequestParam(name="texto",required=false,defaultValue="texto por defecto") String texto,
			Map<String,Object> map) {
		map.put("titulo", "Ejemplo Param");
		map.put("contenidoh1", "El texto por parametro es : " +texto);
		return "/params/ver";
	}
	
	@GetMapping("/dosparametros") // http://localhost:8080/params/dosparametros?param1=hola&param2=5
	public String dosp(@RequestParam String param1, @RequestParam Integer param2, Map<String,Object> map) {
		map.put("titulo", "Ejemplo Param");
		map.put("contenidoh1", "El texto del primer parámetro es : " + param1 + " y el del segundo + 1 es: " + (param2+1));
		return "/params/dosp";
	}
}
