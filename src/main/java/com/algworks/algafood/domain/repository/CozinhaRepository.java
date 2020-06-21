package com.algworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	Optional<Cozinha> findByNome(String nome);

	List<Cozinha> findTodasByNomeContaining(String nome);

	boolean existsByNome(String nome);
}
