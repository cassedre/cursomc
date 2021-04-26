package com.henriquedemetrio.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquedemetrio.cursomc.domain.Cliente;
import com.henriquedemetrio.cursomc.repositories.ClienteRepository;
import com.henriquedemetrio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	
	
	@Autowired //instanciada o objeto abaixo nomeado de repo ,pelo spring boot
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) { //um ID como parametro // recebe um id e retorna um cliente referente a esse id ,caso nao exista lanca um erro
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado! Id: "+id + "Tipo: " + Cliente.class.getName())); //metodo de excessao lanca um exception caso o id nao exista.
			
		}

		
	
}
