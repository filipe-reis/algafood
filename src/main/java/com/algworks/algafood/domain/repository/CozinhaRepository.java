package com.algworks.algafood.domain.repository;

import java.util.List;

import com.algworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();
	List<Cozinha> consultarProNome(String nome);
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Long id);
}
