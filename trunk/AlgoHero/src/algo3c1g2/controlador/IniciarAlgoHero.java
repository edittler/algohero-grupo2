package algo3c1g2.controlador;

import javax.sound.midi.MidiUnavailableException;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.Silencio;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import algo3c1g2.persistencia.PersistidorCancion;
import algo3c1g2.vista.*;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class IniciarAlgoHero {
	
	
public static void main(String[] args) {
		
		ControladorJuego controlador = new ControladorJuego(true);
		
		// PANTALLA DE BIENVENIDA
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		
		VistaPrincipal principal = new VistaPrincipal();
		controlador.agregarDibujable(principal);
	    controlador.comenzarJuego(1);
		controlador.detenerJuego();
		
		
		
		/************CREAMOS UNA CANCION********************/
//	Cancion unaCancion = new Cancion("cancionRandom");
//	Compas unCompas = new Compas();
//	unCompas.agregarElemento(new Silencio(new Blanca()));
//	unCompas.agregarElemento(new Do(new Corchea()));
//	unCompas.agregarElemento(new Silencio(new Semicorchea()));
//	unCompas.agregarElemento(new Do(new Semicorchea()));
//	unaCancion.agregarCompas(unCompas);
	


	Cancion unaCancion = new PersistidorCancion().cargarCancion("Cancion.xml");
	
	CombinacionDeTeclas teclas = new CombinacionDeTeclas();
	teclas.agregarTecla(new Tecla('A'));
	unaCancion.mapear(new DoSostenido(),teclas);
	
	// combinacion de teclas para la nota LaSostenido
	teclas = new CombinacionDeTeclas();
	teclas.agregarTecla(new Tecla('B'));
	unaCancion.mapear(new Re(), teclas);
	
	teclas = new CombinacionDeTeclas();
	teclas.agregarTecla(new Tecla('C'));
	unaCancion.mapear(new Fa(),teclas);
	
	// combinacion de teclas para la nota LaSostenido
	teclas = new CombinacionDeTeclas();
	teclas.agregarTecla(new Tecla('D'));
	unaCancion.mapear(new Sol(), teclas);
	
	teclas = new CombinacionDeTeclas();
	teclas.agregarTecla(new Tecla('E'));
	unaCancion.mapear(new Si(), teclas);
	
	teclas = new CombinacionDeTeclas();
	teclas.agregarTecla(new Tecla('F'));
	unaCancion.mapear(new Mi(), teclas);
	
	teclas = new CombinacionDeTeclas();
	teclas.agregarTecla(new Tecla('G'));
	unaCancion.mapear(new La(), teclas);
	
		/************************************************/
		
	
	
	Mesa unaMesa = new Mesa(717,538);
	VistaFondo vistaMesa = new VistaFondo();
	vistaMesa.setPosicionable(unaMesa);
	controlador.agregarDibujable(vistaMesa);
	
	Guitarra unaGuitarra=new Guitarra(unaCancion,controlador);
	Escuchador escu = new Escuchador(unaGuitarra);
	controlador.agregarKeyPressObservador(escu);
	controlador.agregarObjetoVivo(unaGuitarra);

		
}

}
