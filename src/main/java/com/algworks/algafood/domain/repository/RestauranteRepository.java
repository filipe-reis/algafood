package com.algworks.algafood.domain.repository;

import java.util.List;

import com.algworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante Restaurante);
	void remover(Restaurante Restaurante);
}
