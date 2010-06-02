package CancionHero;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import CancionHero.Nota.*;
import CancionHero.Tecla.*;

public class Compas {

	private int numerador; // representa una cantidad de figuras
	private int denominador; // representa una figura
	private ArrayList<ElementoDeCompas> elementos; // almacena notas, silencios
													// o acordes

	// Construcctor por default asigna 4/4
	public Compas() {
		this.setNumerador(4);
		this.setDenominador(4);
		this.elementos = new ArrayList<ElementoDeCompas>();
	}

	public Compas(int numerador, int denominador) {
		this.setNumerador(numerador);
		this.setDenominador(denominador);
		this.elementos = new ArrayList<ElementoDeCompas>();
				
	}

	private void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getNumerador() {
		return numerador;
	}

	private void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public int getDenominador() {
		return denominador;
	}
	

	public ArrayList<ElementoDeCompas> getElementos() {
		return elementos;
	}

	public void agregarElemento(ElementoDeCompas elemento) {
		this.elementos.add(elemento);

	}
	
	public void mapear(Hashtable<Tono,Tecla> mapeo, ArrayList<Tecla> itTeclas, int indiceTeclas){
		Iterator<ElementoDeCompas> itElementos = this.getElementos().iterator();
		
		while (itElementos.hasNext()){
			/* Le pido a las notas del compas que se mapeen.
			 */
			ElementoDeCompas unElemento = itElementos.next();
			unElemento.mapear(mapeo, itTeclas, indiceTeclas);
		}
	}
 
}
