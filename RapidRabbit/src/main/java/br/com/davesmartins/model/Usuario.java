package br.com.davesmartins.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.davesmartins.model.E.ETipoUsuario;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private boolean ativo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;
	@NotNull
	private ETipoUsuario tipo;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String email, String login, String senha, boolean ativo, Date cadastro,
			ETipoUsuario tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
		this.cadastro = cadastro;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public ETipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(ETipoUsuario tipo) {
		this.tipo = tipo;
	}
	
	

}
