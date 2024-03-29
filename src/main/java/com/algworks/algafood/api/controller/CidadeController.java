package com.algworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

import com.algworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algworks.algafood.domain.model.Cidade;
import com.algworks.algafood.domain.repository.CidadeRepository;
import com.algworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {


	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CadastroCidadeService cadastroCidade;
	
	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId){
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		
		if(cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade){
		try {
			cidade = cadastroCidade.adicionar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(cidade);
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PutMapping
	@RequestMapping("/{cidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, 
			@RequestBody Cidade cidade){
		try {
			Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
			
			if(cidadeAtual.isPresent()) {
				BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
				
				Cidade cidadeSalva = cadastroCidade.adicionar(cidadeAtual.get());
				return ResponseEntity.ok(cidadeSalva);
			}	
			
			return ResponseEntity.notFound().build();
			
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}


	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId){
		Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
		
		if(cidade.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroCidade.remover(cidadeId);
		return ResponseEntity.noContent().build();
	}
	
}
