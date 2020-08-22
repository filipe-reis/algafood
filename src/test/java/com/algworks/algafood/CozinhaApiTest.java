package com.algworks.algafood;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CozinhaApiTest {
	
	private static final int COZINHA_INDIANA = 2;
	private static final int COZINHA_INEXISTENTE = 100;
	

	@LocalServerPort
	private int port;
	
	
	@BeforeEach
	public void setUp() {
		RestAssured.basePath = "/cozinhas";
		RestAssured.port = port;
	}
	
	@Test
	public void whenListAllCozinhas_thenReturnStatusOK() {
		RestAssured.given()
							.accept(ContentType.JSON)
					.when()
							.get()
					.then()
							.statusCode(HttpStatus.OK.value());
			
	}
	
	
	@Test
	public void whenFindExistentCozinha_thenReturnStatusOK() {
		RestAssured.given()
							.pathParam("cozinhaId", COZINHA_INDIANA)
							.accept(ContentType.JSON)
				   .when()
				   			.get("/{cozinhaId}")
				   	.then()
				   			.statusCode(HttpStatus.OK.value())
				   			.body("nome", equalTo("Indiana"));
	}
	
	
	@Test
	public void whenFindNonExistentCozinha_thenReturnStatusNOTFOUND() {
		RestAssured.given()
							.pathParam("cozinhaId", COZINHA_INEXISTENTE)
							.accept(ContentType.JSON)
				   .when()
				   			.get("/{cozinhaId}")
				   	.then()
				   			.statusCode(HttpStatus.NOT_FOUND.value());
	}
}
