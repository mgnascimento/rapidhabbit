package br.com.davesmartins.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.davesmartins.model.Usuario;
import br.com.davesmartins.model.E.ETipoUsuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	public Usuario findByLoginAndSenha(String login, String senha);
	
	public ETipoUsuario findById(Long id);
	
	

}
