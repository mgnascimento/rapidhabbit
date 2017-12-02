package br.com.davesmartins.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entrega implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -932618142482401931L;
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	@ManyToOne
	@JoinColumn(name = "codigo_origem")
	private PontoReferencia origem;
	@ManyToOne
	@JoinColumn(name = "codigo_destino")
	private PontoReferencia destino;
	@ManyToOne
	@JoinColumn(name = "codigo_cliente")
	private Usuario cliente;
	@ManyToOne
	@JoinColumn(name = "codigo_motorista")
	private Usuario motorista;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "entrega_ponto", joinColumns = @JoinColumn(name = "codigo_entrega")
		, inverseJoinColumns = @JoinColumn(name = "codigo_ponto"))
	private List<PontoReferencia> pontos;
	@ManyToOne
	@JoinColumn(name = "codigo_produto")
	private Produto produto;
	private double valor;
	private double kmPercorrido;
	private boolean entregaAberta;
	public Entrega() {
		super();
	}
	public Entrega(Long id, Date cadastro, PontoReferencia origem, PontoReferencia destino, Usuario cliente,
			Usuario motorista, List<PontoReferencia> pontos, Produto produto, double valor, double kmPercorrido,
			boolean entregaAberta) {
		super();
		this.id = id;
		this.cadastro = cadastro;
		this.origem = origem;
		this.destino = destino;
		this.cliente = cliente;
		this.motorista = motorista;
		this.pontos = pontos;
		this.produto = produto;
		this.valor = valor;
		this.kmPercorrido = kmPercorrido;
		this.entregaAberta = entregaAberta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCadastro() {
		return cadastro;
	}
	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}
	public PontoReferencia getOrigem() {
		return origem;
	}
	public void setOrigem(PontoReferencia origem) {
		this.origem = origem;
	}
	public PontoReferencia getDestino() {
		return destino;
	}
	public void setDestino(PontoReferencia destino) {
		this.destino = destino;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Usuario getMotorista() {
		return motorista;
	}
	public void setMotorista(Usuario motorista) {
		this.motorista = motorista;
	}
	public List<PontoReferencia> getPontos() {
		return pontos;
	}
	public void setPontos(List<PontoReferencia> pontos) {
		this.pontos = pontos;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getKmPercorrido() {
		return kmPercorrido;
	}
	public void setKmPercorrido(double kmPercorrido) {
		this.kmPercorrido = kmPercorrido;
	}
	public boolean isEntregaAberta() {
		return entregaAberta;
	}
	public void setEntregaAberta(boolean entregaAberta) {
		this.entregaAberta = entregaAberta;
	}
	
	
	

}
