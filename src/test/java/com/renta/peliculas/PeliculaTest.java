package com.renta.peliculas;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class PeliculaTest {

	@Test
	public void testGet() {
		HashMap<String, Pelicula> Peliculas = new HashMap<String, Pelicula>();
				
		Pelicula peliculaTest = new Pelicula("Nombre1",1000);
		Peliculas.put("Nombre1", peliculaTest);
						
		assertEquals(peliculaTest, Peliculas.get("Nombre1"));		
	}
	
	@Test
	public void testGetCodigoPrecio() {
		HashMap<String, Pelicula> Peliculas = new HashMap<String, Pelicula>();			
		
		Pelicula peliculaTest = new Pelicula("Nombre1",1000);
		Peliculas.put("Nombre1", peliculaTest);
						
		assertEquals(1000, Peliculas.get("Nombre1").getCodigoPrecio());
	}
	
	@Test
	public void testGetNombre() {
		HashMap<String, Pelicula> Peliculas = new HashMap<String, Pelicula>();			
		
		Pelicula peliculaTest = new Pelicula("Nombre1",1000);
		Peliculas.put("Nombre1", peliculaTest);
						
		assertEquals("Nombre1", Peliculas.get("Nombre1").getNombre());
	}
	
}
