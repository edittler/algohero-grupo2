package CancionHero;

import java.util.ArrayList;

public class Compas {

	private int numerador; // representa una cantidad de figuras
	private int denominador; // representa una figura
	private ArrayList<ElementoDeCompas> elementos; // almacena notas, silencios o acordes
	
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	
	public int getNumerador() {
		return numerador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public int getDenominador() {
		return denominador;
	}

	public ArrayList<ElementoDeCompas> getElementos() {
		return elementos;
	}
	
}
