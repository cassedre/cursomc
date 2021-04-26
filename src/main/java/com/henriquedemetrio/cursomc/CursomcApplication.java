package com.henriquedemetrio.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.henriquedemetrio.cursomc.domain.Categoria;
import com.henriquedemetrio.cursomc.domain.Cidade;
import com.henriquedemetrio.cursomc.domain.Cliente;
import com.henriquedemetrio.cursomc.domain.Endereco;
import com.henriquedemetrio.cursomc.domain.Estado;
import com.henriquedemetrio.cursomc.domain.ItemPedido;
import com.henriquedemetrio.cursomc.domain.Pagamento;
import com.henriquedemetrio.cursomc.domain.PagamentoBoleto;
import com.henriquedemetrio.cursomc.domain.PagamentoCartao;
import com.henriquedemetrio.cursomc.domain.Pedido;
import com.henriquedemetrio.cursomc.domain.Produto;
import com.henriquedemetrio.cursomc.domain.enums.EstadoPagamento;
import com.henriquedemetrio.cursomc.domain.enums.TipoCliente;
import com.henriquedemetrio.cursomc.repositories.CategoriaRepository;
import com.henriquedemetrio.cursomc.repositories.CidadeRepository;
import com.henriquedemetrio.cursomc.repositories.ClienteRepository;
import com.henriquedemetrio.cursomc.repositories.EnderecoRepository;
import com.henriquedemetrio.cursomc.repositories.EstadoRepository;
import com.henriquedemetrio.cursomc.repositories.ItemPedidoRepository;
import com.henriquedemetrio.cursomc.repositories.PagamentoRepository;
import com.henriquedemetrio.cursomc.repositories.PedidoRepository;
import com.henriquedemetrio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { //ele permite implementar um metodo auxiliar para executar alguma acao quando a aplicao iniciar

	@Autowired
	private CategoriaRepository categoriaRepository; // Objeto responsavel por salvar dados no BAANCO DE DADOS
	
	@Autowired
	private ProdutoRepository produtoRepository; //criar automaticamente o objeto no banco de dados
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Autowired 
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository; //dependencias instanciacao automaticas
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
	
	 
		// estadoRepository.save(Arrays.asList(est1,est2));
		// cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		 categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); // metodo saveAll , depois uma lista automatica Arrays.asList (cat1,cat2)
		 produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		 
	 Estado est1 = new Estado (null, "Minas Gerais");
	 Estado est2 = new Estado (null, "Sao Paulo");
	 
	 Cidade c1 = new Cidade(null, "Uberlandia", est1);
	 Cidade c2 = new Cidade (null, "Sao paulo", est2);
	 Cidade c3 = new Cidade (null, "Campinas", est2);
	
	 
	 est1.getCidades().addAll(Arrays.asList(c1)); //acesso o objeto estado , chamo o metodo pra pegar a cidade e salvo essa cidade do estado em uma lista do tipo Array
	 est2.getCidades().addAll(Arrays.asList(c2,c3));
	
	 estadoRepository.saveAll(Arrays.asList(est1,est2));
	 cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	 	 
	 
	 //primeiro instanciamos o cliente , depois acessamos sua tabela auxiliar telefone e em seguida a tabela endereco
	 Cliente cli1 = new Cliente (null, "Maria Silva", "maria@gmail.com", "1234566667", TipoCliente.PESSOAFISICA); //null = id gerado automaticamente
	 cli1.getTelefones().addAll(Arrays.asList("123344456","988383838")); //
	 
	 Endereco e1 = new Endereco (null,"Rua Flores","573","Apto 303", "Jardim", "345667", cli1 , c3); //associando o cliente e o endereco
	 Endereco e2 = new Endereco (null,"Rua Flores","573","Apto 303", "Jardim", "345667", cli1 , c2);  //associando o cliente o nome e o endereco com acidade
	 
	 cli1.getEnderecos().addAll(Arrays.asList(e1,e2)); //o cliente tem que conhecer o endereco deele entao vamos isso
	 //ordem quem dos independentes aos dependentes
	 clienteRepository.saveAll(Arrays.asList(cli1)); //para salvar objetos no banco criamos a classe clienteRepository e depois salvamos com o comando saveAll
	 enderecoRepository.saveAll(Arrays.asList(e1,e2));
	 
	 
	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	 
	 Pedido ped1 = new Pedido (null, sdf.parse("30/09/2017 10:32"), cli1, e1); //cliente e endereco
	 Pedido ped2 = new Pedido (null, sdf.parse("10/10/2017 19:35"), cli1, e2);
	 
	 Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6); //ENUM CLASS
	 ped1.setPagamento(pagto1);
	 
	 Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null); // data do pgto null porque ainda nao esta pago
	 ped2.setPagamento(pagto2);
	 
	 cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
	 // salvando os novos objetos acima no banco de dados --->
	 
	 pedidoRepository.saveAll(Arrays.asList(ped1,ped2)); //banco de dados onde sera registrado os pedidos . Primeiro e gerado o pedido pra depois pagar.
	 pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2)); //banco de dados onde sera registrado os pagamento
	//associando todos
	 ItemPedido ip1 = new ItemPedido(ped1,p1, 0.00, 1 , 2000.00);
	 ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 1 , 80.00);
	 ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1 , 800.00); // primeiro instancia o objeto do tipo ItemPedido, verificamos a classe que ele faz referencia, e verificamos o pedido , produto, desconto, quantidade e preco
	 
	 ped1.getItens().addAll(Arrays.asList(ip1,ip2));
	 ped2.getItens().addAll(Arrays.asList(ip3));
	 
	 p1.getItens().addAll(Arrays.asList(ip1));
	 p2.getItens().addAll(Arrays.asList(ip3));
	 p3.getItens().addAll(Arrays.asList(ip2));
	 
	 itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	 
	} 

}
