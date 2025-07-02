package cazadoresDeRecompensas;

import java.util.ArrayList;

public class CazadorUrbano extends Cazador {

	public CazadorUrbano(Integer experiencia) {
		super(experiencia);
	}

	@Override
	public boolean capturarProfugos(Zona zona) {
		boolean capturado = false;
		ArrayList<Profugo> profugosNoEliminados = new ArrayList<Profugo>();
		for (int i = 0; i < zona.getProfugos().size(); i++) {
			if (this.experiencia > zona.getProfugos().get(i).getInocencia()
					&& !zona.getProfugos().get(i).getEsNervioso()) {
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

	@Override
	public void intimidar(Profugo profugo) {
		Integer inocenciaActual = profugo.getInocencia();
		if (profugo.getInocencia() >= 2) {
			profugo.setInocencia(inocenciaActual - 2);
			profugo.setEsNervioso(false);
		}

	}
	
	
	@Override
	public String toString() {
		return "Cazador Urbano [experiencia= " + experiencia + ", profugosAtrapados= " + this.CantidadDeProfugosAtrapados() + "]";
	}

}
