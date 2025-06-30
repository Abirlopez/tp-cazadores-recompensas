package ar.edu.unlam.pb2.supermercado;

import static org.junit.Assert.*;

import org.junit.Test;

public class SupermercadoTest {

	@Test
	public void clientesConMasDeCincoProductos() {
		Supermercado supermercado = new Supermercado();
		Cliente cliente = new Cliente (2, 7);
		Cliente cliente2 = new Cliente(3, 8);
		assertFalse(supermercado.cambioDeCola(cliente));
		assertFalse(supermercado.cambioDeCola(cliente2));
	}
	
	@Test
	public void clientesConMenosDeCincoProductos() {
		Supermercado supermercado = new Supermercado();
		Cliente cliente = new Cliente (2, 3);
		Cliente cliente2 = new Cliente(3, 2);
		assertTrue(supermercado.cambioDeCola(cliente));
		assertTrue(supermercado.cambioDeCola(cliente2));
	}
	
	@Test
	public void clientesConMenosDeCincoProductosYClientesConMasDeCincoProductos() {
		Supermercado supermercado = new Supermercado();
		Cliente cliente = new Cliente (2, 3);
		Cliente cliente2 = new Cliente(3, 2);
		Cliente cliente3 = new Cliente (4, 7);
		Cliente cliente4 = new Cliente(5, 8);
		assertTrue(supermercado.cambioDeCola(cliente));
		assertTrue(supermercado.cambioDeCola(cliente2));
		assertFalse(supermercado.cambioDeCola(cliente3));
		assertFalse(supermercado.cambioDeCola(cliente4));
		
	}
	
	
	@Test
	public void clientesConMenosDeCincoProductosQueCambianSuUbicacion() {
		Supermercado supermercado = new Supermercado();
		Cliente cliente = new Cliente (2, 3);
		Cliente cliente2 = new Cliente(3, 2);
		supermercado.cambioDeCola(cliente);
		supermercado.cambioDeCola(cliente2);
		assertEquals(1, cliente.getNumeroUbicacion());
		assertEquals(2, cliente2.getNumeroUbicacion());
	}
	
	
	

}
