package cazadoresDeRecompensas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.hamcrest.collection.IsEmptyCollection;

import cazadoresDeRecompensas.PorHabilidadComparator;

public abstract class Cazador {

	protected Integer experiencia;
	protected ArrayList<Profugo> profugosAtrapados;

	public Cazador(Integer experiencia) {
		this.experiencia = experiencia;
		this.profugosAtrapados = new ArrayList<Profugo>();

	}

	public boolean capturarProfugos(Zona zona) {
		boolean capturado = false;
		ArrayList<Profugo> profugosNoEliminados = new ArrayList<Profugo>();
		for (int i = 0; i < zona.getProfugos().size(); i++) {
			if (this.experiencia > zona.getProfugos().get(i).getInocencia()) {
				capturado = this.profugosAtrapados.add(zona.getProfugos().get(i));
			} else {
				profugosNoEliminados.add(zona.getProfugos().get(i));
				this.intimidar(zona.getProfugos().get(i));
			}

		}
		
		zona.setProfugos(profugosNoEliminados);
		if (this.CantidadDeProfugosAtrapados() >= 1) {
			this.aumentaExperiencia(profugosNoEliminados);
		}
		return capturado;
	}


	public void aumentaExperiencia(ArrayList<Profugo> profugosIntimidados) {
		// experiencia += (Mínimo valor de habilidad entre todos los intimidados) + (2 *
		// prófugos capturados)
		 if (profugosIntimidados.size() > 0){
			ArrayList<Profugo> ordenados = new ArrayList<Profugo>(profugosIntimidados);
			Collections.sort(ordenados, new PorHabilidadComparator());
			this.experiencia += ordenados.get(0).getHabilidad() + (2 * this.CantidadDeProfugosAtrapados());
		} else if(profugosIntimidados.size() == 0) {
			this.experiencia +=  2 * this.CantidadDeProfugosAtrapados();
		}

	}

	public void intimidar(Profugo profugo) {
		Integer inocenciaActual = profugo.getInocencia();
		if (profugo.getInocencia() >= 2) {
			profugo.setInocencia(inocenciaActual - 2);
		}

//		El nivel de inocencia del prófugo disminuye en 2 unidades (se lo considera más
//				culpable y nunca puede ser negativa)

	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public Integer CantidadDeProfugosAtrapados() {
		return this.profugosAtrapados.size();
	}

	public ArrayList<Profugo> getProfugosAtrapados() {
		return profugosAtrapados;
	}

	public String toString() {
		return "Cazador [experiencia=" + experiencia + ", profugosAtrapados=" + profugosAtrapados + "]";
	}
	
	

	
	
	
}