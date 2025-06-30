package ar.edu.unlam.pb2.supermercado;

import java.util.Iterator;
import java.util.LinkedList;

public class Supermercado {
	
	LinkedList<Cliente> colaA;
	LinkedList <Cliente> colaB;
	int nuevoNumeroFilaA = 0;
	int nuevoNumeroFilaB = 0;
	
	public Supermercado() {
		this.colaA = new LinkedList<Cliente>();
		this.colaB = new LinkedList <Cliente>();
	}
	
	public Boolean cambioDeCola(Cliente cliente) {
		if(cliente.getCantidadProductos() <5) {
			cliente.setNumeroUbicacion(this.nuevoNumeroFilaB+=1);
			return this.colaB.add(cliente);
		}else if(cliente.getCantidadProductos()>=5) {
			cliente.setNumeroUbicacion(this.nuevoNumeroFilaA+=1);
			this.colaA.add(cliente);
			return false;
		}
		return false;
	}
	
	
	
	

}
