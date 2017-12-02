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

import br.com.davesmartins.model.PontoReferencia;
import br.com.davesmartins.repositorio.PontosReferencias;
import br.com.davesmartins.util.CustomErrorType;



@RestController
@RequestMapping("/referencia")
public class PontoReferenciaResource {
	
	public static final Logger logger = LoggerFactory.getLogger(PontoReferenciaResource.class);

	@Autowired
	  private PontosReferencias pontos;//
	 
	  @GetMapping("/{id}")
	  public ResponseEntity<?> buscar(@PathVariable Long id) {
		  logger.info("call buscar {}",id);
		  PontoReferencia p = pontos.findOne(id);
		  if (p == null) {
	        	logger.error("Ponto {} não encontrado.",id);
	            return new ResponseEntity(new CustomErrorType("Ponto "+id+" não encontrado.") , HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity(p, HttpStatus.OK);
	  }
	  
			  
	  @GetMapping
	  public ResponseEntity<List<PontoReferencia>> allPontos() {
		  logger.info("call allPontos");
	    List<PontoReferencia> points = pontos.findAll();
        if (points.isEmpty()) {
        	logger.error("Pontos não encontrados.");
            return new ResponseEntity(new CustomErrorType("Pontos não encontrados."), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(points, HttpStatus.OK);
	  }
		
	  @PostMapping
	  public PontoReferencia salvar(@RequestBody PontoReferencia point) {
	    return pontos.save(point);
	  }
	 
	  @DeleteMapping("/{id}")
	  public void deletar(@PathVariable Long id) {
	    pontos.delete(id);
	  }
	
}
	