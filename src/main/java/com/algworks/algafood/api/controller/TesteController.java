package com.algworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algworks.algafood.domain.model.Cozinha;
import com.algworks.algafood.domain.model.Restaurante;
import com.algworks.algafood.domain.repository.CozinhaRepository;
import com.algworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("cozinhas/unica-por-nome")
	public Optional<Cozinha> cozinhaPorNome(String nome){
		return cozinhaRepository.findByNome(nome);
	}
	
	@GetMapping("cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome){
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("cozinhas/exists")
	public boolean cozinhasExists(String nome){
		return cozinhaRepository.existsByNome(nome);
	}
	
	
	@GetMapping("cozinhas/primeiro")
	public Optional<Cozinha> cozinhaPrimeiro(){
		return cozinhaRepository.buscarPrimeiro();
	}
	
	@GetMapping("restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
		return restauranteRepository.queryByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
	
	@GetMapping("restaurantes/por-nome")
	public List<Restaurante> restaurantesPorNome(String nome, Long cozinhaId){
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}
	
	
	@GetMapping("restaurantes/first-por-nome")
	public Optional<Restaurante> firstRestaurantePorNome(String nome){
		return restauranteRepository.findFirstByNomeContaining(nome);
	}
	
	@GetMapping("restaurantes/top2-por-nome")
	public List<Restaurante> top2RestaurantePorNome(String nome){
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}
	
	@GetMapping("restaurantes/cout-por-cozinha")
	public int countPorCozinha(Long cozinhaId){
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}
	
	@GetMapping("restaurantes/por-nome-e-frete")
	public List<Restaurante> restaurantesPorNomeFrete(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal){
		return restauranteRepository.find(nome, taxaInicial, taxaFinal);
	}
	
	@GetMapping("restaurantes/com-frete-gratis")
	public List<Restaurante> restauranteComFreteGratis(String nome){
		return restauranteRepository.findComFreteGratis(nome);
	}
	
	@GetMapping("restaurantes/primeiro")
	public Optional<Restaurante> restaurantePrimeiro(){
		return restauranteRepository.buscarPrimeiro();
	}
}
