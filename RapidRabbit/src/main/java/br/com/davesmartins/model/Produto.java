package br.com.davesmartins.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2806138982332939052L;
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private double peso;
	public Produto(Long id, String descricao, double peso) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.peso = peso;
	}
	public Produto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
