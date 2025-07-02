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
		Profugo pacoElFlaco = new Profugo(50, 70,true);
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
		
		//experiencia += (Mínimo valor de habilidad entre todos los intimidados) + (2 * prófugos capturados)
		// 61 + 30 + (2*3)
		assertEquals(Integer.valueOf(97), cazador.getExperiencia());
	}
	
	@Test
	public void queHayaVariosProfugosEnLaZonaYElCazadorUrbanoAtrape1YHaya2Intimidados() {
		//no debe ser nervioso
		Zona zona = new Zona("Dodge City");
		Profugo pacoElFlaco = new Profugo(50, 50,false);
		Profugo profugo5 = new Profugo(50, 40,true);
		Profugo profugo4 = new Profugo(50, 30,true);
		CazadorUrbano cazador = new CazadorUrbano(61);
		zona.agregarProfugo(pacoElFlaco);
		zona.agregarProfugo(profugo4);
		zona.agregarProfugo(profugo5);
		cazador.capturarProfugos(zona);
		
		//experiencia += (Mínimo valor de habilidad entre todos los intimidados) + (2 * prófugos capturados)
		// 61 + 30 + + (2*1)
		assertEquals(Integer.valueOf(93), cazador.getExperiencia());
	}
	
	@Test
	public void queSeAgregueUnCazadorALaAgencia() {
	Agencia agencia = new Agencia();
	CazadorUrbano cazador = new CazadorUrbano(70);
	assertTrue(agencia.agregarCazador(cazador));
	}
	
	@Test
	public void queSeAgreguen4CazadoresDeDistintoAmbito() {
	Agencia agencia = new Agencia();
	CazadorUrbano cazadorU = new CazadorUrbano(70);
	CazadorRural cazadorR = new CazadorRural(60);
	CazadorSigiloso cazadorS = new CazadorSigiloso(80);
	CazadorUrbano cazadorU2 = new CazadorUrbano(65);
	agencia.agregarCazador(cazadorU);
	agencia.agregarCazador(cazadorR);
	agencia.agregarCazador(cazadorS);
	agencia.agregarCazador(cazadorU2);
	
	assertEquals(Integer.valueOf(4), agencia.cantidadDeCazadores());
	}
	
	
	@Test
	public void queMuestreAljefeDeLaAgenciaLosProfugosAtrapados() {
	Agencia agencia = new Agencia();
	Zona zona = new Zona("Dodge City");
	CazadorUrbano cazador = new CazadorUrbano(80);
	CazadorSigiloso cazadorS = new CazadorSigiloso(80);
	Profugo profugo1 = new Profugo(50, 60,false);
	Profugo profugo2 = new Profugo(50, 45,true);
	Profugo profugo3 = new Profugo(50, 40,true);
	
	agencia.agregarCazador(cazador);
	agencia.agregarCazador(cazadorS);
	
	
	zona.agregarProfugo(profugo1);
	zona.agregarProfugo(profugo2);
	zona.agregarProfugo(profugo3);
	
	cazador.capturarProfugos(zona);
	cazadorS.capturarProfugos(zona);
	System.out.println(agencia.profugosAtrapadosPorLosCazadores());
	}
	
	@Test
	public void queMuestreAljefeDeLaAgenciaElProfugoMasHabilCapturado() {
	Agencia agencia = new Agencia();
	Zona zona = new Zona("Dodge City");
	CazadorUrbano cazador = new CazadorUrbano(80);
	CazadorSigiloso cazadorS = new CazadorSigiloso(80);
	Profugo profugo1 = new Profugo(50, 60,false);
	Profugo profugo2 = new Profugo(50, 45,true);
	Profugo profugo3 = new Profugo(50, 40,true);
	
	
	agencia.agregarCazador(cazador);
	agencia.agregarCazador(cazadorS);
	
	
	zona.agregarProfugo(profugo1);
	zona.agregarProfugo(profugo2);
	zona.agregarProfugo(profugo3);
	
	cazador.capturarProfugos(zona);
	cazadorS.capturarProfugos(zona);
	System.out.println(agencia.devolverElProfugoMasHabilCapturado());
	}
	
	@Test
	public void queMuestreAljefeDeLaAgenciaElCazadorConMasProfugosAtrapados() {
	Agencia agencia = new Agencia();
	Zona zona = new Zona("Dodge City");
	CazadorUrbano cazador = new CazadorUrbano(80);
	CazadorSigiloso cazadorS = new CazadorSigiloso(80);
	Profugo profugo1 = new Profugo(50, 60,false);
	Profugo profugo2 = new Profugo(50, 45,true);
	Profugo profugo3 = new Profugo(50, 40,true);
	
	
	agencia.agregarCazador(cazador);
	agencia.agregarCazador(cazadorS);
	

	zona.agregarProfugo(profugo1);
	zona.agregarProfugo(profugo2);
	zona.agregarProfugo(profugo3);
	
	cazador.capturarProfugos(zona);
	cazadorS.capturarProfugos(zona);
	System.out.println(agencia.devolverAlCazadorConMasProfugosAtrapados());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

}
