package com.renta.peliculas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void testGetCliente() {
		HashMap<String, Cliente> Clientes = new HashMap<String, Cliente>();

		Cliente clienteTest = new Cliente("SuNombre");		
		Clientes.put("ID001", clienteTest);
						
		assertEquals(clienteTest, Clientes.get("ID001"));		
	}
	
	@Test
	public void testGetNombre() {
		HashMap<String, Cliente> Clientes = new HashMap<String, Cliente>();

		Cliente clienteTest = new Cliente("SuNombre");		
		Clientes.put("ID001", clienteTest);
						
		assertEquals("SuNombre", Clientes.get("ID001").getNombre());		
	}	
	
	@Test
	public void testStatementConAlquilerTipoNormal() {
				
		ArrayList alquileres = new ArrayList();									
		
		Pelicula pelicula = new Pelicula("NPelicula",0);
		Disco disco = new Disco("S101",pelicula);	
		Alquiler alquilerTest = new Alquiler(disco,2);
		
		alquileres.add(alquilerTest);
						
					
		Cliente clienteTest = new Cliente("SuNombre",alquileres);
		
		String mensaje;
		
		mensaje ="Alquileres de " + "SuNombre" + ":\n";
		mensaje += "\t" +"NPelicula" + "\t" + "2.0" + "\n";
		mensaje +=  "Monto total:  " + "2.0" + "\n";
        mensaje += "Gano " + "1" + " puntos por alquiler frecuente";
        
        assertEquals(mensaje, clienteTest.statement());		
	}
	
	
	@Test
	public void testStatementConAlquilerTipoEstreno() {
				
		ArrayList alquileres = new ArrayList();									
		
		Pelicula pelicula = new Pelicula("NPelicula",1);
		Disco disco = new Disco("S101",pelicula);	
		Alquiler alquilerTest = new Alquiler(disco,2);
		
		alquileres.add(alquilerTest);
						
					
		Cliente clienteTest = new Cliente("SuNombre",alquileres);
		
		String mensaje;
		
		mensaje ="Alquileres de " + "SuNombre" + ":\n";
		mensaje += "\t" +"NPelicula" + "\t" + "6.0" + "\n";
		mensaje +=  "Monto total:  " + "6.0" + "\n";
        mensaje += "Gano " + "2" + " puntos por alquiler frecuente";
        
        assertEquals(mensaje, clienteTest.statement());		
	}
	
	@Test
	public void testStatementConAlquilerTipoInfantil() {
				
		ArrayList alquileres = new ArrayList();									
		
		Pelicula pelicula = new Pelicula("NPelicula",2);
		Disco disco = new Disco("S101",pelicula);	
		Alquiler alquilerTest = new Alquiler(disco,2);
		
		alquileres.add(alquilerTest);
						
					
		Cliente clienteTest = new Cliente("SuNombre",alquileres);
		
		String mensaje;
		
		mensaje ="Alquileres de " + "SuNombre" + ":\n";
		mensaje += "\t" +"NPelicula" + "\t" + "1.5" + "\n";
		mensaje +=  "Monto total:  " + "1.5" + "\n";
        mensaje += "Gano " + "1" + " puntos por alquiler frecuente";
        
        assertEquals(mensaje, clienteTest.statement());		
	}
	
}
