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

import br.com.davesmartins.model.Entrega;
import br.com.davesmartins.model.PontoReferencia;
import br.com.davesmartins.model.Usuario;
import br.com.davesmartins.model.dto.UsuarioLoginDTO;
import br.com.davesmartins.repositorio.Entregas;
import br.com.davesmartins.util.CustomErrorType;

//import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas")
public class EntregasResource {

	public static final Logger logger = LoggerFactory.getLogger(EntregasResource.class);

	@Autowired
	private Entregas entregas;//

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		logger.info("call buscar {}", id);
		Entrega e = entregas.findOne(id);
		if (e == null) {
			logger.error("Entrega {} não encontrado.", id);
			return new ResponseEntity(new CustomErrorType("Entrega " + id + " não encontrado."), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(e, HttpStatus.OK);
	}

	@GetMapping("/{id}/fechar")
	public ResponseEntity<?> fechar(@PathVariable Long id) {
		logger.info("call fechar {}", id);
		Entrega e = entregas.findOne(id);
		if (e == null) {
			logger.error("Entrega {} não encontrado.", id);
			return new ResponseEntity(new CustomErrorType("Entrega " + id + " não encontrado."), HttpStatus.NOT_FOUND);
		}
		e.setEntregaAberta(false);
		return new ResponseEntity(e, HttpStatus.OK);
	}

	@GetMapping("/{id}/pontos")
	public ResponseEntity<List<?>> pontos(@PathVariable Long id) {
		logger.info("call pontos {}", id);
		Entrega e = entregas.findOne(id);
		if (e == null) {
			logger.error("Entrega {} não encontrado.", id);
			return new ResponseEntity(new CustomErrorType("Entrega " + id + " não encontrado."), HttpStatus.NOT_FOUND);
		}
		List<PontoReferencia> pr = e.getPontos();
		pr.add(0, e.getOrigem());
		pr.add(e.getDestino());
		return new ResponseEntity(pr, HttpStatus.OK);
	}

	  @PostMapping("/{id}/pontos/add")
	  public ResponseEntity<?> addPontos(@PathVariable Long id, @RequestBody PontoReferencia pr) {
	    logger.info("addPontos");	    

		Entrega e = entregas.findOne(id);
		e.getPontos().add(pr);
		e = entregas.save(e);
		  if (e == null) {
	        	logger.error("Erro addPontos");
	            return new ResponseEntity(new CustomErrorType("Erro addPontos.") , HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity(e, HttpStatus.OK);
	  }
	  
	@GetMapping("/abertas")
	public ResponseEntity<List<Entrega>> allEntregasAbertas() {
		logger.info("call allEntregasAbertas");
		List<Entrega> ents = entregas.findByEntregaAbertaTrue();
		if (ents.isEmpty()) {
			logger.error("Entregas Abertas não encontradas.");
			return new ResponseEntity(new CustomErrorType("Entregas Abertas não encontradas."), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(ents, HttpStatus.OK);
	}

	@GetMapping("/fechadas")
	public ResponseEntity<List<Entrega>> allEntregasFechadas() {
		logger.info("call allEntregasFechadas");
		List<Entrega> ents = entregas.findByEntregaAbertaFalse();
		if (ents.isEmpty()) {
			logger.error("Entregas Fechadas não encontradas.");
			return new ResponseEntity(new CustomErrorType("Entregas Fechadas não encontradas."), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(ents, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Entrega>> allEntregas() {
		logger.info("call allEntregas");
		List<Entrega> ents = entregas.findAll();
		if (ents.isEmpty()) {
			logger.error("Entregas não encontradas.");
			return new ResponseEntity(new CustomErrorType("Entregas não encontradas."), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(ents, HttpStatus.OK);
	}

	@PostMapping
	public Entrega salvar(@RequestBody Entrega entrega) {
		return entregas.save(entrega);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		entregas.delete(id);
	}

}
