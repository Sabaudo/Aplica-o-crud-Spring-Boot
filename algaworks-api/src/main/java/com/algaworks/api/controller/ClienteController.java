package com.algaworks.api.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.api.domain.model.Cliente;
import com.algaworks.api.domain.repository.ClienteRepository;
import com.algaworks.api.domain.service.CadastroClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	//Lista todos os clientes
	@GetMapping
	public List<Cliente> listar() {
		return cr.findAll();
		
		//return cr.findByNome("");
		//return cr.findByNomeContaining("");
	}
	
	//Busca um cliente específico a partir do id
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = cr.findById(clienteId);
		
		//Checa se o id existe, retorna 200 OK
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		//Senão, retorna 404
		return ResponseEntity.notFound().build();
	}
	
	//Registra um novo cliente
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente registrar(@Valid @RequestBody Cliente cliente) {
		return cadastroCliente.salvar(cliente);
	}
	
	//Atualiza as infos de um cliente
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, 
			@RequestBody Cliente cliente){
		
		if(!cr.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		cadastroCliente.salvar(cliente);
		return ResponseEntity.ok(cliente);
		
	}
	
	//Remove um cliente
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		if(!cr.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cadastroCliente.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
}
