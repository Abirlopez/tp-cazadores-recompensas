package cazadoresDeRecompensas;

import java.util.ArrayList;

public class Agencia {
	private ArrayList<Cazador> cazadores;

	public Agencia() {
		this.cazadores = new ArrayList<Cazador>();
	}

	public boolean agregarCazador(Cazador cazador) {
		return this.cazadores.add(cazador);

	}
	
	public Integer cantidadDeCazadores() {
		return this.cazadores.size();
	}
	
	public String profugosAtrapadosPorLosCazadores() throws NoHayCazadoresEnLaAgenciaException {
		String reporte = "";
		for (Cazador cazador : cazadores) {
			for (Profugo profugo : cazador.getProfugosAtrapados()) {
				reporte += profugo.toString() + "\n";
			}
		}
		if(cazadores.isEmpty()) {
			throw new NoHayCazadoresEnLaAgenciaException("No se han agregado cazadores a la agencia");
		}
		return reporte;
	}
	
	public Profugo devolverElProfugoMasHabilCapturado() throws NoHayCazadoresEnLaAgenciaException {
		Profugo profugoMasHabil = null;
		for (Cazador cazador : cazadores) {
			for (Profugo profugo : cazador.getProfugosAtrapados()) {
				if(profugoMasHabil == null || profugo.getHabilidad() > profugoMasHabil.getHabilidad()) {
					profugoMasHabil = profugo;
				}
			}
		}
		if(cazadores.isEmpty()) {
			throw new NoHayCazadoresEnLaAgenciaException("No se han agregado cazadores a la agencia");
		}
		return profugoMasHabil;
	
	}

	public Cazador devolverAlCazadorConMasProfugosAtrapados() throws NoHayCazadoresEnLaAgenciaException {
	Cazador cazadorConMasProfugosAtrapados = null;
	for (Cazador cazador : cazadores) {
		if(cazadorConMasProfugosAtrapados == null || cazador.CantidadDeProfugosAtrapados() > cazadorConMasProfugosAtrapados.CantidadDeProfugosAtrapados()) {
			cazadorConMasProfugosAtrapados = cazador;
		}
		}
	
	if(cazadores.isEmpty()) {
		throw new NoHayCazadoresEnLaAgenciaException("No se han agregado cazadores a la agencia");
	}
	
	
	return cazadorConMasProfugosAtrapados;
	}
}
