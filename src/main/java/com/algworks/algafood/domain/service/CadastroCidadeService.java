package com.algworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algworks.algafood.domain.model.Cidade;
import com.algworks.algafood.domain.model.Estado;
import com.algworks.algafood.domain.repository.CidadeRepository;
import com.algworks.algafood.domain.repository.EstadoRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade adicionar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException
						(String.format("Estado não existe para o id %d", estadoId)));
		
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
		
	}
	
	public void remover(Long cidadeId) {
		cidadeRepository.deleteById(cidadeId);
	}
}
