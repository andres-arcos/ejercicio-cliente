package com.ejercicio.app.test.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejercicio.app.entity.Cliente;
import com.ejercicio.app.repository.ClienteRepository;

@SpringBootTest
public class ClienteEntityTest {
	
	@Mock
	ClienteRepository clienteRepository;
	
	private Cliente cliente;
	
	@BeforeEach
	void setUp() {
		cliente = new Cliente();
		cliente.setNombres("Carlos Alvarado");
		cliente.setDireccion("Calle A - 321");
	}

	@Test
	void crearInstanciaClienteTest() {
		assertNotNull(cliente);
		assertEquals("Carlos Alvarado", cliente.getNombres());
		assertEquals("Calle A - 321", cliente.getDireccion());
	}
	
	@Test
	void guardarClienteTest() {
		when(clienteRepository.save(cliente)).thenReturn(cliente);
		
		Cliente clienteguardado = clienteRepository.save(cliente);
		
		assertNotNull(clienteguardado);
		assertEquals("Carlos Alvarado", clienteguardado.getNombres());
		assertEquals("Calle A - 321", clienteguardado.getDireccion());
	}
}
