package com.renta.peliculas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.renta.peliculas.Alquiler;
import com.renta.peliculas.Cliente;
import com.renta.peliculas.Disco;
import com.renta.peliculas.Pelicula;

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
				
		ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();
		int tipoPelicula = 0;
		
		Pelicula pelicula = new Pelicula("NPelicula", tipoPelicula);
		Disco disco = new Disco("S101",pelicula);	
		Alquiler alquilerTest = new Alquiler(disco,4);
		
		alquileres.add(alquilerTest);
						
					
		Cliente clienteTest = new Cliente("SuNombre",alquileres);
		
		String mensaje;
		
		mensaje ="Alquileres de " + "SuNombre" + ":\n";
		mensaje += "\t" +"NPelicula" + "\t" + "5.0" + "\n";
		mensaje +=  "Monto total:  " + "5.0" + "\n";
        mensaje += "Gano " + "1" + " puntos por alquiler frecuente";
        
        assertEquals(mensaje, clienteTest.statement());		
	}
	
	
	@Test
	public void testStatementConAlquilerTipoEstreno() {
				
		ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();									
		int tipoPelicula = 1;
		
		Pelicula pelicula = new Pelicula("NPelicula",tipoPelicula);
		Disco disco = new Disco("S101",pelicula);	
		Alquiler alquilerTest = new Alquiler(disco,4);
		
		alquileres.add(alquilerTest);
						
					
		Cliente clienteTest = new Cliente("SuNombre",alquileres);
		
		String mensaje;
		
		mensaje ="Alquileres de " + "SuNombre" + ":\n";
		mensaje += "\t" +"NPelicula" + "\t" + "12.0" + "\n";
		mensaje +=  "Monto total:  " + "12.0" + "\n";
        mensaje += "Gano " + "2" + " puntos por alquiler frecuente";
        
        assertEquals(mensaje, clienteTest.statement());		
	}
	
	@Test
	public void testStatementConAlquilerTipoInfantil() {
				
		ArrayList<Alquiler> alquileres = new ArrayList<Alquiler>();		
		int tipoPelicula = 2;
		
		Pelicula pelicula = new Pelicula("NPelicula",tipoPelicula);
		Disco disco = new Disco("S101",pelicula);	
		Alquiler alquilerTest = new Alquiler(disco,4);
		
		alquileres.add(alquilerTest);							
		Cliente clienteTest = new Cliente("SuNombre",alquileres);
		
		String mensaje;
		
		mensaje ="Alquileres de " + "SuNombre" + ":\n";
		mensaje += "\t" +"NPelicula" + "\t" + "3.0" + "\n";
		mensaje +=  "Monto total:  " + "3.0" + "\n";
        mensaje += "Gano " + "1" + " puntos por alquiler frecuente";
        
        assertEquals(mensaje, clienteTest.statement());		
	}
	
}
