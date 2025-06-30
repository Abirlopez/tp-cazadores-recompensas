package ar.edu.unlam.pb2.supermercado;

public class Cliente {
	
	private int numeroUbicacion;
	private int cantidadProductos;
	
	public Cliente (int numeroUbicacion, int cantidadProductos) {
		this.numeroUbicacion = numeroUbicacion;
		this.cantidadProductos = cantidadProductos;
	}

	public int getNumeroUbicacion() {
		return numeroUbicacion;
	}

	public void setNumeroUbicacion(int numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public int getCantidadProductos() {
		return cantidadProductos;
	}

//	public void setCantidadProductos(int cantidadProductos) {
//		this.cantidadProductos = cantidadProductos;
//	}
	
	
	
	

}
