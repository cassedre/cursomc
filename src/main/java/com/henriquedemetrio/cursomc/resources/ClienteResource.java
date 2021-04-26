package com.henriquedemetrio.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.henriquedemetrio.cursomc.domain.Cliente;
import com.henriquedemetrio.cursomc.services.ClienteService;
import com.henriquedemetrio.cursomc.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/clientes") //end-point
public class ClienteResource {
	
	@Autowired
	private ClienteService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)//obtendo um dado
	public ResponseEntity<?> find (@PathVariable Integer id ) {	
		
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
			
		
	
		
		
	}
}
