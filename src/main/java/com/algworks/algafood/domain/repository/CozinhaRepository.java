package com.algworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.algworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	Optional<Cozinha> findByNome(String nome);

	List<Cozinha> findTodasByNomeContaining(String nome);

	boolean existsByNome(String nome);
}
