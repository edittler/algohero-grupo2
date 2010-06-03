package CancionHero;

import java.util.*;


import Excepciones.CompasInvalidoExcepcion;
import Excepciones.CompasSobrepasadoExcepcion;


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
//denominador representa una figura y se escribe como multiplos de Redonda (2 blanca, 4 negra, 8 corchea,etc) 
	public Compas(int numerador, int denominador) {
		this.setNumerador(numerador);
		this.setDenominador(denominador);
		this.elementos = new ArrayList<ElementoDeCompas>();
				
	}
	

	public void setNumerador(int numerador) {
		if(numerador<=0){
			throw new CompasInvalidoExcepcion();
		}
		this.numerador = numerador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setDenominador(int denominador) {
		if(!this.esFigura(denominador)||(denominador<=0)){
			throw new CompasInvalidoExcepcion();
		}
		this.denominador = denominador;
	}

	public int getDenominador() {
		return denominador;
	}
	

	public ArrayList<ElementoDeCompas> getElementos() {
		return elementos;
	}

	public void agregarElemento(ElementoDeCompas elemento) {
		if ((this.getDuracionParcial()+elemento.getDuracion())>(this.getDuracionTotal())){
			throw new CompasSobrepasadoExcepcion();
		}
		this.elementos.add(elemento);

	}
	
	public void mapear(Hashtable<Float,Integer> mapeo, ArrayList<Tecla> itTeclas, int indiceTeclas){
		Iterator<ElementoDeCompas> itElementos = this.getElementos().iterator();
		
		while (itElementos.hasNext()){
			/* Le pido a las notas del compas que se mapeen.
			 */
			ElementoDeCompas unElemento = itElementos.next();
			unElemento.mapear(mapeo, itTeclas, indiceTeclas);
		}
	}
 
	
	

	
	/*Metodos auxiliares*/
	
	private boolean esFigura(int a){
		boolean resultado=false;
		switch (a){
		case 1:
		case 2:
		case 4:
		case 8:
		case 16: resultado=true;
		break;
		}
		return resultado;
	}

	public boolean estaInconcluso(){ 
		return (this.getDuracionParcial()!=this.getDuracionTotal());
	}
	
	private double getDuracionTotal(){ //medido en negras
		double aux=((double)this.getNumerador()/(double)this.getDenominador());
		return 	(aux*4);
	}
	
	private double getDuracionParcial(){ 
		Iterator<ElementoDeCompas> itElementos = this.getElementos().iterator();
		double sumaDuracion=0;
		while(itElementos.hasNext()){
			ElementoDeCompas unElemento = itElementos.next();
			sumaDuracion += unElemento.getDuracion();
		}
		return sumaDuracion;
	}

}
