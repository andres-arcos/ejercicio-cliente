package com.ejercicio.app.test.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ejercicio.app.entity.Cliente;
import com.ejercicio.app.repository.ClienteRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClienteIntegrationTest {

	@LocalServerPort
	private int port;

	@MockBean
	private ClienteRepository clienteRepository;

	@Autowired
	TestRestTemplate testRestTemplate;

	HttpHeaders headers = new HttpHeaders();

	@Test
	void crearClienteTest() {
		Cliente cliente = new Cliente();
		cliente.setNombres("Test 1");

		ResponseEntity<Cliente> response = testRestTemplate.exchange("http://localhost:" + port + "/api/v1/clientes",
				HttpMethod.POST, new HttpEntity<Cliente>(cliente), Cliente.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	}

}
