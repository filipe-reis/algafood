package com.algworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.algworks.algafood.domain.model.Restaurante;
import com.algworks.algafood.domain.repository.RestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar(){
		return manager.createQuery("from Restaurante", Restaurante.class)
				.getResultList();
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Transactional
	@Override
	public Restaurante salvar(Restaurante Restaurante) {
		return manager.merge(Restaurante);
	}
	
	@Transactional
	@Override
	public void remover(Restaurante Restaurante) {
		Restaurante = buscar(Restaurante.getId());
		manager.remove(Restaurante);
	}

}
