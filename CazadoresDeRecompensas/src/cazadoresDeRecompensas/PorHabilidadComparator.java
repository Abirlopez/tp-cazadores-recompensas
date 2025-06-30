package cazadoresDeRecompensas;

import java.util.Comparator;
public class PorHabilidadComparator implements Comparator<Profugo>{

	@Override
	public int compare(Profugo profugo1, Profugo profugo2) {
		return profugo1.getHabilidad().compareTo(profugo2.getHabilidad());
	}
	

}
