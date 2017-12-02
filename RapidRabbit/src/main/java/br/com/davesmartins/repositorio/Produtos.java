package br.com.davesmartins.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.davesmartins.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {
	


}
