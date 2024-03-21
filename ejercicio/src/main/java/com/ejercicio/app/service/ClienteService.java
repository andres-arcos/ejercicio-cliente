package com.ejercicio.app.service;

import java.util.List;
import java.util.Optional;

import com.ejercicio.app.entity.Cliente;

public interface ClienteService {

	Cliente guardarDatosCliente(Cliente cliente);
	
	Optional<Cliente> obtenerClientePorId(Long id);
	
	void eliminarCliente(Cliente cliente);
	
	List<Cliente> obtenerClientes();
	
}
