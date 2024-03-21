package com.ejercicio.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.app.entity.Cliente;
import com.ejercicio.app.service.ClienteService;

@RestController
@RequestMapping(path = "api/v1/clientes")
public class ClienteController {

	private final ClienteService service;

	public ClienteController(ClienteService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(this.service.guardarDatosCliente(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(this.service.guardarDatosCliente(cliente), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obtenerCliente(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = service.obtenerClientePorId(id);
		if (cliente.isPresent()) {
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> obtenerClientes() {
		List<Cliente> clientes = service.obtenerClientes();
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarCliente(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = service.obtenerClientePorId(id);
		if (cliente.isPresent()) {
			service.eliminarCliente(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
}
