package com.algaworks.api.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.api.domain.model.OrdemServico;
import com.algaworks.api.domain.model.StatusOrdemServico;
import com.algaworks.api.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository osr;
	
	public OrdemServico criar(OrdemServico os) {
		os.setStatus(StatusOrdemServico.ABERTA);
		os.setDataAbertura(LocalDateTime.now());
		return osr.save(os);
		
	}
	
}
