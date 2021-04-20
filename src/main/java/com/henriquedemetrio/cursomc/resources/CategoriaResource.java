package com.henriquedemetrio.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias") //end-point
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)//obtendo um dado
	public String listar() {
		return "REST esta funcionando";
		
		
	}
}
