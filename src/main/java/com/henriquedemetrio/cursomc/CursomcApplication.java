package com.henriquedemetrio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.henriquedemetrio.cursomc.domain.Categoria;
import com.henriquedemetrio.cursomc.domain.Cidade;
import com.henriquedemetrio.cursomc.domain.Estado;
import com.henriquedemetrio.cursomc.domain.Produto;
import com.henriquedemetrio.cursomc.repositories.CategoriaRepository;
import com.henriquedemetrio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { //ele permite implementar um metodo auxiliar para executar alguma acao quando a aplicao iniciar

	@Autowired
	private CategoriaRepository categoriaRepository; // Objeto responsavel por salvar dados no BAANCO DE DADOS
	
	@Autowired
	private ProdutoRepository produtoRepository; //criar automaticamente o objeto no banco de dados
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override //Quais objetos eu irei instanciar?
	public void run(String... args) throws Exception {
	
	Categoria cat1 = new Categoria (null, "Informatica"); //instanciar e salvar
	Categoria cat2 = new Categoria (null, "Escritorio");
	// salvar os objetos no banco de dados. Quem e responsavel por acessar o banco de dados e salvar, categoria repository
	
	
	Produto p1 = new Produto (null, "Computador", 2000.00);
	Produto p2 = new Produto (null, "Impressora", 800.00);
	Produto p3 = new Produto (null, "Mouse", 80.00);
	
	cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	cat2.getProdutos().addAll(Arrays.asList(p2)); //quais produtos que estao associados com o categoria 2
	
	p1.getCategorias().addAll(Arrays.asList(cat1));   //o produto p1 e da categoria 1
	p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	p3.getCategorias().addAll(Arrays.asList(cat1));
	
	 Estado est1 = new Estado (null, "Minas Gerais");
	 Estado est2 = new Estado (null, "Sao Paulo");
	 
	 Cidade c1 = new Cidade(null, "Uberlandia", est1);
	 Cidade c2 = new Cidade (null, "Sao paulo", est2);
	 Cidade c3 = new Cidade (null, "Campinas", est2);
	
	 
	 est1.getCidades().addAll(Arrays.asList(c1)); //acesso o objeto estado , chamo o metodo pra pegar a cidade e salvo essa cidade do estado em uma lista do tipo Array
	 est2.getCidades().addAll(Arrays.asList(c2,c3));
	 
	categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); // metodo saveAll , depois uma lista automatica Arrays.asList (cat1,cat2)
	produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
