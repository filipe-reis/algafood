package com.algworks.algafood.domain.repository;

import java.util.List;

import com.algworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	List<FormaPagamento> listar();
	FormaPagamento buscar(Long id);
	FormaPagamento salvar(FormaPagamento FormaPagamento);
	void remover(FormaPagamento FormaPagamento);
}
