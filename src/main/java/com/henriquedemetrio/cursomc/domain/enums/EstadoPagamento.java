package com.henriquedemetrio.cursomc.domain.enums;

public enum EstadoPagamento {
PENDENTE (1, "Pendente"),
QUITADO(2, "Quitado"),
CANCELADO(3, "Cancelado");
private int cod ;
private String descricao;
	
	
	private EstadoPagamento (int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
		
		
	}
	
	public int getCod() { //uma vez instanciado o enum, voce nao muda mais(constante). entao so precisamos do get
		return cod;
		
	}
	public String getDescricao() {
		return descricao;
		
	}
	public static EstadoPagamento toEnum(Integer cod) { //static porque sera possivel usar sem instanciar o objeto
		
		if(cod ==null) { //busca se o teste que for passado for nulo 
			
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) { //todo objeto possivl pessoa fisica ou juridica, se ele for igual ao codigo que foi informado entao ele retorna o objeto pessoa fisica ou juridica, se nao existir ninguem ai eu dou um object invalid
			
			if (cod.equals(x.getCod())) {
				
				return x;
				
			}
		}
		throw new IllegalArgumentException("Id invalid" + cod);
	}
}


