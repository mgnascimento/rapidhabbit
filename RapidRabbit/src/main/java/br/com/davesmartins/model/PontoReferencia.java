package br.com.davesmartins.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PontoReferencia implements Serializable {	

		/**
	 * 
	 */
	private static final long serialVersionUID = 3145901056098153664L;
		@Id
		@GeneratedValue
		private Long id;
		private String descricao;
		private String detalhe;
		private double kmFaltante;
		private double kmPercorrido;
		@Temporal(TemporalType.TIMESTAMP)
		private Date horrario;
//		@ManyToOne
//		@JoinColumn(name = "codigo_entrega")
//		@JsonIgnore
//		private Entrega entrega;
		
		public PontoReferencia() {
			super();
		}
		public PontoReferencia(Long id, String descricao, String detalhe, double kmFaltante, double kmPercorrido,
				Date horrario) {
			super();
			this.id = id;
			this.descricao = descricao;
			this.detalhe = detalhe;
			this.kmFaltante = kmFaltante;
			this.kmPercorrido = kmPercorrido;
			this.horrario = horrario;
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
		public String getDetalhe() {
			return detalhe;
		}
		public void setDetalhe(String detalhe) {
			this.detalhe = detalhe;
		}
		public double getKmFaltante() {
			return kmFaltante;
		}
		public void setKmFaltante(double kmFaltante) {
			this.kmFaltante = kmFaltante;
		}
		public double getKmPercorrido() {
			return kmPercorrido;
		}
		public void setKmPercorrido(double kmPercorrido) {
			this.kmPercorrido = kmPercorrido;
		}
		public Date getHorrario() {
			return horrario;
		}
		public void setHorrario(Date horrario) {
			this.horrario = horrario;
		}
	
		

}
