package com.algworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algworks.algafood.domain.model.Cozinha;
import com.algworks.algafood.domain.repository.CozinhaRepository;
import com.algworks.algafood.domain.service.CadastroCozinhaService;

@SpringBootTest
class CadastroCozinhaIntegrationTest {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Test
	public void devePreencherCozinhaId_QuandorCadastrarCozinhaComDadosCorretos() {
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		//validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoCadastroCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);
		
		Assertions.assertThrows(ConstraintViolationException.class, () -> {
			cadastroCozinha.salvar(novaCozinha);
		});
	}

	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
		Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
			cadastroCozinha.excluir(1l); 
		});
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
		Assertions.assertThrows(EntidadeNaoEncontradaException.class, () -> {
			cadastroCozinha.excluir(13l);
		});
	}
	
	@Test
	public void deveExcluirCozinhaId_QuandoExcluirCozinha() {
		
		cadastroCozinha.excluir(5l);
		Optional<Cozinha> cozinhaExcluida = cozinhaRepository.findById(5l);
		
		assertThat(cozinhaExcluida).isEmpty();
	}
}
