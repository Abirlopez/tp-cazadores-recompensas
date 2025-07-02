package cazadoresDeRecompensas;

public class Profugo {
	private Integer Inocencia;
	private Integer habilidad;
	private Boolean esNervioso;
	
	public Profugo(Integer Inocencia, Integer habilidad, boolean esNervioso) {
		this.esNervioso=esNervioso;
		this.habilidad=habilidad;
		this.Inocencia=Inocencia;
	}

	public Integer getInocencia() {
		return Inocencia;
	}
	
	public Integer getHabilidad() {
		return habilidad;
	}

	public Boolean getEsNervioso() {
		return esNervioso;
	}

	public void setInocencia(Integer inocencia) {
		Inocencia = inocencia;
	}

	public void setHabilidad(Integer habilidad) {
		this.habilidad = habilidad;
	}

	public void setEsNervioso(Boolean esNervioso) {
		this.esNervioso = esNervioso;
	}

	
	public String toString() {
		return "Profugo [Inocencia=" + Inocencia + ", habilidad=" + habilidad + ", esNervioso=" + esNervioso + "]";
	}
	
	
	
	

}
