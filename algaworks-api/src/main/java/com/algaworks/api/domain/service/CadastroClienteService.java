package com.algaworks.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.api.domain.exception.NegocioException;
import com.algaworks.api.domain.model.Cliente;
import com.algaworks.api.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository cr;
	
	public Cliente salvar(Cliente c) {
		Cliente clienteExistente = cr.findByEmail(c.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(c)) {
			throw new NegocioException("Este email não pode ser cadastrado pois já existe.");
		}
		
		return cr.save(c);
	}
	
	public void excluir(Long id) {
		cr.deleteById(id);
	}
	
}
