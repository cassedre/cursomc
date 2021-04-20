package com.henriquedemetrio.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henriquedemetrio.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias") //end-point
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)//obtendo um dado
	public List<Categoria> listar() {
		
		Categoria cat = new Categoria (1, "Informatica");
		Categoria cat2 = new Categoria (2, "Escritorio");
		
		List<Categoria> lista = new ArrayList<>(); // List e uma interface e nao pode ser importado , logo temos que achar uma classe que implemente a minha classa.
		lista.add(cat);
		lista.add(cat2);
		
		return lista;
		
		
	}
}
