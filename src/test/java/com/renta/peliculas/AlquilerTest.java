package com.renta.peliculas;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlquilerTest {

	@Test
	public void testGetDiasAlquilado() {
		Pelicula pelicula = new Pelicula("Nombre",1000);
		Disco disco = new Disco("S101",pelicula);	
		Alquiler alquiler = new Alquiler(disco,2);
		
		assertEquals(2, alquiler.getDiasAlquilado());
	}
	
}
