package com.renta.peliculas;

public class Catalogo {
	protected String nombre;
	
	public Catalogo(String pNombre){
		this.nombre = pNombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
}
