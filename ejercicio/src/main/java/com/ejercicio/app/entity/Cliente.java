package com.ejercicio.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity()
@Table(name="cliente",schema = "seguridad")
public class Cliente extends Persona {
	
	public Cliente() {
		
	}
	
	public Cliente(String contraseña, String estado) {
		super();
		this.contraseña = contraseña;
		this.estado = estado;
	}
	private String contraseña;
	private String estado;
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


}
