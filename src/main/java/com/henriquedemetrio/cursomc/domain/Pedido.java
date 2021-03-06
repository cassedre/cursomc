package com.henriquedemetrio.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
private Integer id;
private Date instante ;

//associacoes
@OneToOne (cascade=CascadeType.ALL, mappedBy="pedido") //            <------------------------- nao inserido 1x1
private Pagamento pagamento;

@ManyToOne
@JoinColumn(name="cliente_number") // foreign key
private Cliente cliente;

@ManyToOne
@JoinColumn(name="endereco_entrega_id")
private Endereco enderecoEntrega;


@OneToMany (mappedBy="id.pedido") //associacao inversa. id e um objeto auxiliar
private Set<ItemPedido> itens = new HashSet<>(); // mapeando a classe itempedido 

public Pedido() {
	
	
	
}
public Pedido(Integer id, Date instante,Cliente cliente, Endereco enderecoEntrega) {
	super();
	this.id = id;
	this.instante = instante;
	this.cliente = cliente;
	this.enderecoEntrega= enderecoEntrega;
	
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getInstante() {
	return instante;
}
public void setInstante(Date instante) {
	this.instante = instante;
}
public Pagamento getPagamento() {
	return pagamento;
}
public void setPagamento(Pagamento pagamento) {
	this.pagamento = pagamento;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public Endereco getEnderecoEntrega() {
	return enderecoEntrega;
}
public void setEnderecoEntrega(Endereco enderecoEntrega) {
	this.enderecoEntrega = enderecoEntrega;
}
public Set<ItemPedido> getItens() {
	return itens;
}
public void setItens(Set<ItemPedido> itens) {
	this.itens = itens;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Pedido other = (Pedido) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
