package br.com.davesmartins.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.davesmartins.model.Entrega;


public interface Entregas extends JpaRepository<Entrega, Long> {
	
	List<Entrega> findByEntregaAbertaTrue();

	List<Entrega> findByEntregaAbertaFalse();
	

}
