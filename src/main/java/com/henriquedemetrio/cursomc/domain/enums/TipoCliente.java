package com.henriquedemetrio.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), // ENUMS COM CODIGO QUE SEMPRE SERA O MESMO VALOR NAO ALTERA. construtor para armazenar string c. codigo
	PESSOAJURIDICA (2, "Pessoa Juridica");
	
	private int cod; //variavel interna para armazenar os valores de enums acima
	private String descricao;
	
	
	private TipoCliente (int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		
		
	}
	
	public int getCod() { //uma vez instanciado o enum, voce nao muda mais(constante). entao so precisamos do get
		return cod;
		
	}
	public String getDescricao() {
		return descricao;
		
	}
	public static TipoCliente toEnum(Integer cod) { //static porque sera possivel usar sem instanciar o objeto
		
		if(cod ==null) { //busca se o teste que for passado for nulo 
			
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) { //todo objeto possivl pessoa fisica ou juridica, se ele for igual ao codigo que foi informado entao ele retorna o objeto pessoa fisica ou juridica, se nao existir ninguem ai eu dou um object invalid
			
			if (cod.equals(x.getCod())) {
				
				return x;
				
			}
		}
		throw new IllegalArgumentException("Id invalid" + cod);
	}
}
