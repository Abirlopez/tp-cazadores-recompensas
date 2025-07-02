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
	
	public String profugosAtrapadosPorLosCazadores() {
		String reporte = "";
		for (Cazador cazador : cazadores) {
			for (Profugo profugo : cazador.getProfugosAtrapados()) {
				reporte += profugo.toString() + "\n";
			}
		}
		return reporte;
	}
	
	public Profugo devolverElProfugoMasHabilCapturado() {
		Profugo profugoMasHabil = null;
		for (Cazador cazador : cazadores) {
			for (Profugo profugo : cazador.getProfugosAtrapados()) {
				if(profugoMasHabil == null || profugo.getHabilidad() > profugoMasHabil.getHabilidad()) {
					profugoMasHabil = profugo;
				}
			}
		}
		
		return profugoMasHabil;
	
	}

	public Cazador devolverAlCazadorConMasProfugosAtrapados() {
	Cazador cazadorConMasProfugosAtrapados = null;
	for (Cazador cazador : cazadores) {
		if(cazadorConMasProfugosAtrapados == null || cazador.CantidadDeProfugosAtrapados() > cazadorConMasProfugosAtrapados.CantidadDeProfugosAtrapados()) {
			cazadorConMasProfugosAtrapados = cazador;
		}
		}
	
	
	return cazadorConMasProfugosAtrapados;
	}
}
