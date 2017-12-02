package br.com.davesmartins.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.davesmartins.model.Usuario;
import br.com.davesmartins.model.dto.UsuarioLoginDTO;
import br.com.davesmartins.repositorio.Usuarios;
import br.com.davesmartins.util.CustomErrorType;

//import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
public class UsuariosResource {
	
	public static final Logger logger = LoggerFactory.getLogger(UsuariosResource.class);

	@Autowired
	  private Usuarios usuarios;//
	 
	  @GetMapping("/{id}")
	  public ResponseEntity<?> buscar(@PathVariable Long id) {
		  logger.info("call buscar {}",id);
		  Usuario u = usuarios.findOne(id);
		  if (u == null) {
	        	logger.error("Usuário {} não encontrado.",id);
	            return new ResponseEntity(new CustomErrorType("Usuário "+id+" não encontrado.") , HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity(u, HttpStatus.OK);
	  }
		
	  @PostMapping("/login")
	  public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO user) {
	    logger.info("call login {}, {}",user.getLogin(),user.getSenha());
		  Usuario u = usuarios.findByLoginAndSenha(user.getLogin(),user.getSenha());
		  if (u == null) {
	        	logger.error("Login ou Senha Incorreta. {}, {}",user.getLogin(),user.getSenha());
	            return new ResponseEntity(new CustomErrorType("Login ou Senha Incorreta.") , HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity(u, HttpStatus.OK);
	  }
	  
	  @GetMapping
	  public ResponseEntity<List<Usuario>> allUsuarios() {
		  logger.info("call allUsuarios");
	    List<Usuario> users = usuarios.findAll();
        if (users.isEmpty()) {
        	logger.error("Usuários não encontrado.");
            return new ResponseEntity(new CustomErrorType("Usuários não encontrado."), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(users, HttpStatus.OK);
	  }
		
	  @PostMapping
	  public Usuario salvar(@RequestBody Usuario produto) {
	    return usuarios.save(produto);
	  }
	 
	  @DeleteMapping("/{id}")
	  public void deletar(@PathVariable Long id) {
	    usuarios.delete(id);
	  }
	
}
	