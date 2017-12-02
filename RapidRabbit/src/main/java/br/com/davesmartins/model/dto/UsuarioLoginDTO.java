package br.com.davesmartins.model.dto;

public class UsuarioLoginDTO {

	private String login, senha;

	public UsuarioLoginDTO(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public UsuarioLoginDTO() {
		super();
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
	
	
	
}
