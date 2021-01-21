package com.algaworks.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.api.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	//Metodo de pesquisa por nome
	List<Cliente> findByNome(String nome);

	//Metodo de pesquisa por letra ou trecho de nome
	List<Cliente> findByNomeContaining(String n);
	
	//Metodo de pesquisa por email
	Cliente findByEmail(String email);
}
