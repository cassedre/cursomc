package com.henriquedemetrio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.henriquedemetrio.cursomc.domain.Categoria;
import com.henriquedemetrio.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository; // Objeto responsavel por salvar dados no BAANCO DE DADOS
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override //Quais objetos eu irei instanciar?
	public void run(String... args) throws Exception {
	
	Categoria cat1 = new Categoria (null, "Informatica"); //instanciar e salvar
	Categoria cat2 = new Categoria (null, "Escritorio");
	// salvar os objetos no banco de dados. Quem e responsavel por acessar o banco de dados e salvar, categoria repository
	
	categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); // metodo saveAll , depois uma lista automatica Arrays.asList (cat1,cat2)
	
		
	}

}
