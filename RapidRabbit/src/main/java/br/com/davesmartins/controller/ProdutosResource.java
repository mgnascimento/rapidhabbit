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

import br.com.davesmartins.model.Produto;
import br.com.davesmartins.repositorio.Produtos;
import br.com.davesmartins.util.CustomErrorType;



@RestController
@RequestMapping("/produtos")
public class ProdutosResource {
	
	public static final Logger logger = LoggerFactory.getLogger(ProdutosResource.class);

	@Autowired
	  private Produtos produtos;//
	 
	  @GetMapping("/{id}")
	  public ResponseEntity<?> buscar(@PathVariable Long id) {
		  logger.info("call buscar {}",id);
		  Produto p = produtos.findOne(id);
		  if (p == null) {
	        	logger.error("Produto {} não encontrado.",id);
	            return new ResponseEntity(new CustomErrorType("Produto "+id+" não encontrado.") , HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity(p, HttpStatus.OK);
	  }
	  
			  
	  @GetMapping
	  public ResponseEntity<List<Produto>> allProdutos() {
		  logger.info("call allProdutos");
	    List<Produto> produts = produtos.findAll();
        if (produts.isEmpty()) {
        	logger.error("Produtos não encontrados.");
            return new ResponseEntity(new CustomErrorType("Produtos não encontrados."), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(produts, HttpStatus.OK);
	  }
		
	  @PostMapping
	  public Produto salvar(@RequestBody Produto produto) {
	    return produtos.save(produto);
	  }
	 
	  @DeleteMapping("/{id}")
	  public void deletar(@PathVariable Long id) {
	    produtos.delete(id);
	  }
	
}
	