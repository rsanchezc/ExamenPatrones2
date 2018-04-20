package com.renta.peliculas;

import java.util.HashMap;

public class Registrar {
	private static HashMap<String, Pelicula> Peliculas = new HashMap<String, Pelicula>();
	private static HashMap<String, Cliente> Clientes = new HashMap<String, Cliente>();
	
	public static Catalogo get(String coleccion, String nombre) {
		if ("Peliculas".equals(coleccion)){
			return Peliculas.get(nombre);
		}else {
			return Clientes.get(nombre);
		}
	}

	public static void add(String coleccion, Catalogo pCatalogo) {
		if ("Peliculas".equals(coleccion)){
			Pelicula nuevaPelicula = (Pelicula) pCatalogo;
			Peliculas.put(nuevaPelicula.getNombre(), nuevaPelicula);		
		}
		if ("Clientes".equals(coleccion)){
			Cliente nuevoCliente = (Cliente) pCatalogo;
			Clientes.put(nuevoCliente.getNombre(), nuevoCliente);
		}
	}

}
