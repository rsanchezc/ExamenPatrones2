package com.renta.peliculas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.renta.peliculas.Disco;
import com.renta.peliculas.Pelicula;

public class DiscoTest {

	
	@Test
	public void testGetNumeroSerie() {
		Pelicula pelicula = new Pelicula("Nombre",1000);
		Disco disco = new Disco("D101",pelicula);
		
		assertEquals("D101", disco.getNumeroSerie());
	}
}
