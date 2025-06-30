package cazadoresDeRecompensas;

import java.util.ArrayList;

public class Zona {
	private String nombre;
	private ArrayList<Profugo> profugos;
	
	public Zona(String nombre) {
		this.nombre=nombre;
		this.profugos = new ArrayList<Profugo>(); 
	}

	public boolean agregarProfugo(Profugo profugo) {
		return this.profugos.add(profugo);
	}

	public ArrayList<Profugo> getProfugos() {
		return this.profugos;
	}

	public void setProfugos(ArrayList<Profugo> profugos) {
		this.profugos = profugos;
	}
	
	public Integer cantidadDeProfugos() {
		return this.profugos.size();
	}
	

}
