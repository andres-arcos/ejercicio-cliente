package com.ejercicio.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ejercicio.app.entity.Cliente;
import com.ejercicio.app.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository repository;
	
    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

	@Override
	public Cliente guardarDatosCliente(Cliente cliente) {
		//TODO validaciones por identificacion
		return repository.save(cliente);
	}

	@Override
	public Optional<Cliente> obtenerClientePorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		repository.delete(cliente);
		
	}

	@Override
	public List<Cliente> obtenerClientes() {
		return repository.findAll();
	}

}
