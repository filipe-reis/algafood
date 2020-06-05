package com.algworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algworks.algafood.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
