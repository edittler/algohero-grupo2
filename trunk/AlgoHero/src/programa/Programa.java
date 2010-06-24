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
		teclas.agregarTecla(new Tecla('H'));
		unaCancion.mapear(new DoSostenido(),teclas);
		
		// combinacion de teclas para la nota LaSostenido
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('L'));
		unaCancion.mapear(new Re(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('C'));
		unaCancion.mapear(new Fa(),teclas);
		
		// combinacion de teclas para la nota LaSostenido
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('M'));
		unaCancion.mapear(new Sol(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('S'));
		unaCancion.mapear(new Si(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('N'));
		unaCancion.mapear(new Mi(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('T'));
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
		

		
		/******** CREA LOS CIRCULITOS***********/
		ArrayList<ArrayList<Circulito>> cuerdas=new ArrayList<ArrayList<Circulito>>();
		ArrayList<Circulito> cuerda1= new ArrayList<Circulito>();
		ArrayList<Circulito> cuerda2= new ArrayList<Circulito>();
		ArrayList<Circulito> cuerda3= new ArrayList<Circulito>();
		ArrayList<Circulito> cuerda4= new ArrayList<Circulito>();
		ArrayList<Circulito> cuerda5= new ArrayList<Circulito>();
		ArrayList<Circulito> cuerda6= new ArrayList<Circulito>();
		
		Circulito c1 = new Circulito(new Do());
		Circulito c2 = new Circulito(new Do());
		Circulito c3 = new Circulito(new Do());
		Circulito c4 = new Circulito(new Re());
		Circulito c5 = new Circulito(new Re());
		Circulito c6 = new Circulito(new Re());
		Circulito c7 = new Circulito(new Mi());
		Circulito c8 = new Circulito(new Mi());
		Circulito c9 = new Circulito(new Mi());
		Circulito c10 = new Circulito(new Sol());
		Circulito c11 = new Circulito(new Sol());
		Circulito c12 = new Circulito(new Sol());
		Circulito c13 = new Circulito(new La());
		Circulito c14 = new Circulito(new La());
		Circulito c15 = new Circulito(new La());
		Circulito c16 = new Circulito(new Si());
		Circulito c17 = new Circulito(new Si());
		Circulito c18 = new Circulito(new Si());
		
		VistaCirculito v1 = new VistaCirculito();
		VistaCirculito v2 = new VistaCirculito();
		VistaCirculito v3 = new VistaCirculito();
		VistaCirculito v4 = new VistaCirculito();
		VistaCirculito v5 = new VistaCirculito();
		VistaCirculito v6 = new VistaCirculito();
		VistaCirculito v7 = new VistaCirculito();
		VistaCirculito v8 = new VistaCirculito();
		VistaCirculito v9 = new VistaCirculito();
		VistaCirculito v10 = new VistaCirculito();
		VistaCirculito v11 = new VistaCirculito();
		VistaCirculito v12 = new VistaCirculito();
		VistaCirculito v13 = new VistaCirculito();
		VistaCirculito v14 = new VistaCirculito();
		VistaCirculito v15 = new VistaCirculito();
		VistaCirculito v16 = new VistaCirculito();
		VistaCirculito v17 = new VistaCirculito();
		VistaCirculito v18 = new VistaCirculito();
		
		v1.setPosicionable(c1);
		v2.setPosicionable(c2);
		v3.setPosicionable(c3);
		v4.setPosicionable(c4);
		v5.setPosicionable(c5);
		v6.setPosicionable(c6);
		v7.setPosicionable(c7);
		v8.setPosicionable(c8);
		v9.setPosicionable(c9);
		v10.setPosicionable(c10);
		v11.setPosicionable(c11);
		v12.setPosicionable(c12);
		v13.setPosicionable(c13);
		v14.setPosicionable(c14);
		v15.setPosicionable(c15);
		v16.setPosicionable(c16);
		v17.setPosicionable(c17);
		v18.setPosicionable(c18);
		
		controlador.agregarDibujable(v1);
		controlador.agregarDibujable(v2);
		controlador.agregarDibujable(v3);
		controlador.agregarDibujable(v4);
		controlador.agregarDibujable(v5);
		controlador.agregarDibujable(v6);
		controlador.agregarDibujable(v7);
		controlador.agregarDibujable(v8);
		controlador.agregarDibujable(v9);
		controlador.agregarDibujable(v10);
		controlador.agregarDibujable(v11);
		controlador.agregarDibujable(v12);
		controlador.agregarDibujable(v13);
		controlador.agregarDibujable(v14);
		controlador.agregarDibujable(v15);
		controlador.agregarDibujable(v16);
		controlador.agregarDibujable(v17);
		controlador.agregarDibujable(v18);
		
		controlador.agregarObjetoVivo(c1);
		controlador.agregarObjetoVivo(c2);
		controlador.agregarObjetoVivo(c3);
		controlador.agregarObjetoVivo(c4);
		controlador.agregarObjetoVivo(c5);
		controlador.agregarObjetoVivo(c6);
		controlador.agregarObjetoVivo(c7);
		controlador.agregarObjetoVivo(c8);
		controlador.agregarObjetoVivo(c9);
		controlador.agregarObjetoVivo(c10);
		controlador.agregarObjetoVivo(c11);
		controlador.agregarObjetoVivo(c12);
		controlador.agregarObjetoVivo(c13);
		controlador.agregarObjetoVivo(c14);
		controlador.agregarObjetoVivo(c15);
		controlador.agregarObjetoVivo(c16);
		controlador.agregarObjetoVivo(c17);
		controlador.agregarObjetoVivo(c18);

		cuerda1.add(c1);
		cuerda1.add(c2);
		cuerda1.add(c3);
		
		cuerda2.add(c4);
		cuerda2.add(c5);
		cuerda2.add(c6);
		
		cuerda3.add(c7);
		cuerda3.add(c8);
		cuerda3.add(c9);
		
		cuerda4.add(c10);
		cuerda4.add(c11);
		cuerda4.add(c12);
		
		cuerda5.add(c13);
		cuerda5.add(c14);
		cuerda5.add(c15);
		
		cuerda6.add(c16);
		cuerda6.add(c17);
		cuerda6.add(c18);
		
		cuerdas.add(cuerda1);
		cuerdas.add(cuerda2);
		cuerdas.add(cuerda3);
		cuerdas.add(cuerda4);
		cuerdas.add(cuerda5);
		cuerdas.add(cuerda6);
		
		/*******************************/
		
		Guitarra unaGuitarra=new Guitarra(unaCancion,cuerdas,controlador);
		Escuchador escu = new Escuchador(unaGuitarra);
		controlador.agregarKeyPressObservador(escu);
		controlador.agregarObjetoVivo(unaGuitarra);


		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		controlador.setIntervaloSimulacion(15);
		controlador.comenzarJuego();
	}

}
