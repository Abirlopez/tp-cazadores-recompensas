package cazadoresDeRecompensas;

public class Profugo {
	private Integer Inocencia;
	private Integer habilidad;
	private Boolean esNervioso;
	
	private Boolean artesMaricales;
	private Boolean entrenamientoDeElite;
	private Boolean proteccionLegal;
	
	public Profugo(Integer Inocencia, Integer habilidad, boolean esNervioso) {
		this.esNervioso=esNervioso;
		this.habilidad=habilidad;
		this.Inocencia=Inocencia;
		this.artesMaricales= false;
		this.entrenamientoDeElite = false;
		this.proteccionLegal = false;
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
		this.Inocencia = inocencia;
		if(this.proteccionLegal && this.Inocencia<40) {
			this.Inocencia = 40;
		}
		
	}

	public void setHabilidad(Integer habilidad) {
		this.habilidad = habilidad;
		
		
	}

	public void setEsNervioso(Boolean esNervioso) {
		if(!this.entrenamientoDeElite) {
			this.esNervioso = esNervioso;
		}
	}
	

	
	public String toString() {
		return "Profugo [Inocencia=" + Inocencia + ", habilidad=" + habilidad + ", esNervioso=" + esNervioso + "]";
	}

	public void entrenarEnArtesMarciales() throws LaHabilidadNoDebeSerMayorACienException{
		if(!this.artesMaricales) {
			if(this.habilidad >= 100) {
				throw new 
				LaHabilidadNoDebeSerMayorACienException("La habilidad no puede ser mayor a 100");
			}else if(this.habilidad > 50) {
				this.artesMaricales = true;
				this.setHabilidad(100);;
				
			}else {
				this.artesMaricales = true;
				this.setHabilidad(this.habilidad*2);
				
			}
		}
		
	}

	public void entrenarEnEntrenamientoDeElite() {
		if(!this.entrenamientoDeElite) {
			this.setEsNervioso(false);
			this.entrenamientoDeElite = true;
			
		}
		
	}

	public void entrenarEnProteccionLegal() {
		if(!this.proteccionLegal) {
			if(this.Inocencia < 40) {
				this.setInocencia(40);
				this.proteccionLegal = true;
			}else {
				this.proteccionLegal = true;
			}
			
			
		}
		
	}
	
	
	
	

}
