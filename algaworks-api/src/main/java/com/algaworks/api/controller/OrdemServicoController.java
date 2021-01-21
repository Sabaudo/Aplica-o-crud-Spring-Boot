package com.algaworks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.api.domain.model.OrdemServico;
import com.algaworks.api.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private GestaoOrdemServicoService gestaoOrdemSS;
	
	@PostMapping
	@ResponseStatus
	public OrdemServico criar(@RequestBody OrdemServico os) {
		
		return gestaoOrdemSS.criar(os);
		
	}
	
	
}
