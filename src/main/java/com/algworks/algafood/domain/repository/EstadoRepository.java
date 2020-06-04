package com.algworks.algafood.domain.repository;

import java.util.List;

import com.algworks.algafood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado Estado);
	void remover(Long estadoId);
}
