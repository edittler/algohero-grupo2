package programa;

import java.awt.Color;
import java.util.ArrayList;


import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.Silencio;
import algo3c1g2.modelo.figura.Blanca;
import algo3c1g2.modelo.figura.Corchea;
import algo3c1g2.modelo.figura.Negra;
import algo3c1g2.modelo.figura.Semicorchea;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import ar.uba.fi.algo3.titiritero.ControladorJuego;


import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Programa {

	public static void main(String[] args) {

		
			/************CREAMOS UNA CANCION********************/
		Cancion unaCancion = new Cancion("cancionRandom");
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new DoSostenido(new Blanca()));
		unCompas.agregarElemento(new Re(new Negra()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unaCancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Sol(new Blanca()));
		unCompas.agregarElemento(new Si(new Corchea()));
		unCompas.agregarElemento(new Mi(new Negra()));	
		unCompas.agregarElemento(new La(new Corchea()));
		unaCancion.agregarCompas(unCompas);
		
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
		
		
		ControladorJuego controlador = new ControladorJuego();
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana.getSuperficieDeDibujo());
		ventana.setVisible(true);
		
		
		Mesa unaMesa = new Mesa(717,538);
		VistaFondo vistaMesa = new VistaFondo();
		vistaMesa.setPosicionable(unaMesa);
		controlador.agregarDibujable(vistaMesa);
		
//		Circulito c=new Circulito(200);
//		VistaCirculito v=new VistaCirculito();
//		v.setPosicionable(c);
//		controlador.agregarDibujable(v);
//		controlador.agregarObjetoVivo(c);
//		c.habilitar();
//
//		Circulito c2=new Circulito(200);
//		VistaCirculito vc=new VistaCirculito();
//		v.setPosicionable(c);
//		controlador.agregarDibujable(v);
//		controlador.agregarObjetoVivo(c);
//		c.habilitar();
		Guitarra unaGuitarra=new Guitarra(unaCancion,controlador);
		Escuchador escu = new Escuchador(unaGuitarra);
		controlador.agregarKeyPressObservador(escu);
		controlador.agregarObjetoVivo(unaGuitarra);

		
		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		//controlador.setIntervaloSimulacion(15);
		controlador.comenzarJuego();
	}

}
