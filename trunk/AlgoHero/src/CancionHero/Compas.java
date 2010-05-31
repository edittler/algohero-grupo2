package CancionHero;

import java.util.ArrayList;

public class Compas {

	private int numerador; // representa una cantidad de figuras
	private int denominador; // representa una figura
	private ArrayList<ElementoDeCompas> elementos; // almacena notas, silencios
													// o acordes

	// Construcctor por default asigna 4/4
	public Compas() {
		this.setNumerador(4);
		this.setDenominador(4);
	}

	public Compas(int numerador, int denominador) {
		this.setNumerador(numerador);
		this.setDenominador(denominador);
	}

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

	public void agregarElemento(ElementoDeCompas elemento) {
		this.elementos.add(elemento);

	}

}
