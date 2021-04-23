package com.henriquedemetrio.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquedemetrio.cursomc.domain.Categoria;
import com.henriquedemetrio.cursomc.repositories.CategoriaRepository;
import com.henriquedemetrio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	
	
	@Autowired //instanciada o objeto abaixo nomeado de repo ,pelo spring boot
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) { //um ID como parametro
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado! Id: "+id + "Tipo: " + Categoria.class.getName())); //metodo de excessao lanca um exception caso o id nao exista.
			
		}

		
	
}
