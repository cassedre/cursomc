package com.henriquedemetrio.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquedemetrio.cursomc.domain.Categoria;
import com.henriquedemetrio.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	
	
	@Autowired //instanciada o objeto abaixo nomeado de repo ,pelo spring boot
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) { //um ID como parametro
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElse(null);
		
	}
}
