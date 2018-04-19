package com.renta.peliculas;

import static org.junit.Assert.*;

import java.util.HashMap;

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
	public void testStatementVacio() {
		
		Cliente clienteTest = new Cliente("SuNombre");		
		String mensaje;
		
		mensaje ="Alquileres de " + "SuNombre" + ":\n";
		mensaje +=  "Monto total:  " + "0.0" + "\n";
        mensaje += "Gano " + "0" + " puntos por alquiler frecuente";
		
        assertEquals(mensaje, clienteTest.statement());		
	}
	
}
