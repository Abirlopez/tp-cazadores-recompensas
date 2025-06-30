package cazadoresDeRecompensas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cazadoresDeRecompensas.Agencia;
import cazadoresDeRecompensas.CazadorRural;
import cazadoresDeRecompensas.CazadorUrbano;
import cazadoresDeRecompensas.Profugo;
import cazadoresDeRecompensas.Zona;
import cazadoresDeRecompensas.CazadorSigiloso;

public class CazadoresDeRecompensasTest {

//	@Test
//	public void queSePuedaAgregarUnCazadorYUnProfugo() {
//		Zona zona1 = new Zona("Dodge City");
//		Agencia agencia = new Agencia();
//		CazadorUrbano cazadorUrbano = new CazadorUrbano(1, 0);
//		Profugo pacoElFlaco = new Profugo(50, 50, true);
//		
//		zona1.agregarProfugo(pacoElFlaco);
//		zona1.getProfugos().get(0);
//		assertEquals(true, pacoElFlaco.getEsNervioso());
//	}
	
	@Test
	public void queSePuedaAgregarUnProfugoALaZona() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50, true);
		
		assertEquals(true, zona.agregarProfugo(pacoElFlaco));
	}
	
	@Test
	public void queElCazadorPuedaCapturarAUnProfugo() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50, false);
		CazadorUrbano cazador = new CazadorUrbano(60);
		zona.agregarProfugo(pacoElFlaco);
		assertTrue(cazador.capturarProfugos(zona));
		
		
	}
	
	@Test
	public void queElCazadorNoPuedaCapturarAUnProfugoPorqueLaExperienciaDelCazadorEsMenor() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50, false);
		CazadorUrbano cazador = new CazadorUrbano(40);
		zona.agregarProfugo(pacoElFlaco);
		assertFalse(cazador.capturarProfugos(zona));
	}
	
	@Test
	public void queElCazadorNoPuedaCapturarAUnProfugoYLoVuelvaAPonerEnLaZona() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50, false);
		CazadorUrbano cazador = new CazadorUrbano(40);
		zona.agregarProfugo(pacoElFlaco);
		cazador.capturarProfugos(zona);
		assertEquals(Integer.valueOf(1), zona.cantidadDeProfugos());
	}
	
	@Test
	public void queElCazadorUrbanoPuedaCapturarAUnProfugoNoNervioso() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50, false);
		CazadorUrbano cazador = new CazadorUrbano(60);
		zona.agregarProfugo(pacoElFlaco);
		assertTrue(cazador.capturarProfugos(zona));
	}
	
	@Test
	public void queElCazadorUrbanoNoPuedaCapturarAUnProfugoNervioso() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50, true);
		CazadorUrbano cazador = new CazadorUrbano(60);
		zona.agregarProfugo(pacoElFlaco);
		assertFalse(cazador.capturarProfugos(zona));
	}
	
	@Test
	public void queElCazadorRuralPuedaCapturarAUnProfugoNervioso() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50, true);
		CazadorRural cazador = new CazadorRural(60);
		zona.agregarProfugo(pacoElFlaco);
		assertTrue(cazador.capturarProfugos(zona));
	}
	
	@Test
	public void queElCazadorRuralNoPuedaCapturarAUnProfugoNoNervioso() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50,false);
		CazadorRural cazador = new CazadorRural(60);
		zona.agregarProfugo(pacoElFlaco);
		assertFalse(cazador.capturarProfugos(zona));
	}
	
	@Test
	public void queElCazadorSigilosoNoPuedaCapturarAUnProfugoConMasDe50DeHabilidad() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 70,false);
		CazadorSigiloso cazador = new CazadorSigiloso(80);
		zona.agregarProfugo(pacoElFlaco);
		assertFalse(cazador.capturarProfugos(zona));
	}
	
	@Test
	public void queElCazadorSigilosoPuedaCapturarAUnProfugoConMenosDe50DeHabilidad() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 40,false);
		CazadorSigiloso cazador = new CazadorSigiloso(80);
		zona.agregarProfugo(pacoElFlaco);
		assertTrue(cazador.capturarProfugos(zona));
	}
	
	
	@Test
	public void queElCazadorSigilosoNoPuedaCapturarAUnProfugoPeroLoIntimideYReduzca5DeHabilidad() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 70,false);
		CazadorSigiloso cazador = new CazadorSigiloso(80);
		zona.agregarProfugo(pacoElFlaco);
		cazador.capturarProfugos(zona);
		assertEquals(Integer.valueOf(65), zona.getProfugos().get(0).getHabilidad());
	}
	
	@Test
	public void queElCazadorRuralNoPuedaCapturarAUnProfugoPeroLoIntimideYSeVuelvaNervioso() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 70,false);
		CazadorRural cazador = new CazadorRural(80);
		zona.agregarProfugo(pacoElFlaco);
		cazador.capturarProfugos(zona);
		assertTrue(zona.getProfugos().get(0).getEsNervioso());
	}
	
	@Test
	public void queElCazadorUrbanoNoPuedaCapturarAUnProfugoPeroLoIntimideYSeVuelvaNoNervioso() {
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 70,false);
		CazadorUrbano cazador = new CazadorUrbano(80);
		zona.agregarProfugo(pacoElFlaco);
		cazador.capturarProfugos(zona);
		assertFalse(zona.getProfugos().get(0).getEsNervioso());
	}
	
	@Test
	public void queHayaVariosProfugosEnLaZonaYElCazadorUrbanoAtrape3() {
		//no debe ser nervioso
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50,false);
		Profugo profugo2 = new Profugo(50, 60,false);
		Profugo profugo3 = new Profugo(50, 45,false);
		Profugo profugo4 = new Profugo(50, 30,true);
		Profugo profugo5 = new Profugo(50, 40,true);
		CazadorUrbano cazador = new CazadorUrbano(80);
		zona.agregarProfugo(pacoElFlaco);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);
		zona.agregarProfugo(profugo4);
		zona.agregarProfugo(profugo5);
		cazador.capturarProfugos(zona);
		assertEquals(Integer.valueOf(3),cazador.CantidadDeProfugosAtrapados());
	}
	
	@Test
	public void queHayaVariosProfugosEnLaZonaYElCazadorUrbanoAtrape3YAumenteExperiencia() {
		//no debe ser nervioso
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50,false);
		Profugo profugo2 = new Profugo(50, 60,false);
		Profugo profugo3 = new Profugo(50, 45,false);
		Profugo profugo4 = new Profugo(50, 30,true);
		Profugo profugo5 = new Profugo(50, 40,true);
		CazadorUrbano cazador = new CazadorUrbano(61);
		zona.agregarProfugo(pacoElFlaco);
		zona.agregarProfugo(profugo2);
		zona.agregarProfugo(profugo3);
		zona.agregarProfugo(profugo4);
		zona.agregarProfugo(profugo5);
		cazador.capturarProfugos(zona);
		
		assertEquals(Integer.valueOf(97), cazador.getExperiencia());
	}
	
	
	
	
	
	
	
	
	
	
	


	

}
