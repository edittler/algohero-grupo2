package grupo2.modelo;

import grupo2.modelo.excepciones.CompasInvalidoExcepcion;
import grupo2.modelo.excepciones.CompasSobrepasadoExcepcion;

import java.util.*;




public class Compas {
	private int numerador; // representa una cantidad de figuras
	private int denominador; // representa una figura
	private Iterator<ElementoDeCompas> itElementos;
	private ArrayList<ElementoDeCompas> elementos; // almacena notas, silencios
													// o acordes

	// Construcctor por default asigna 4/4
	public Compas() {
		this.setNumerador(4);
		this.setDenominador(4);
		this.elementos = new ArrayList<ElementoDeCompas>();
		this.itElementos = this.elementos.iterator();
	}
//denominador representa una figura y se escribe como multiplos de Redonda (2 blanca, 4 negra, 8 corchea,etc) 
	public Compas(int numerador, int denominador) {
		this.setNumerador(numerador);
		this.setDenominador(denominador);
		this.elementos = new ArrayList<ElementoDeCompas>();
		this.itElementos = this.elementos.iterator();
				
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
	

	public void agregarElemento(ElementoDeCompas elemento) {
		if ((this.getDuracionParcial()+elemento.getDuracion())>(this.getDuracionTotal())){
			throw new CompasSobrepasadoExcepcion();
		}
		this.elementos.add(elemento);

	}
//retorna null si ya se recorrio todo el compas y sino retorna el siguiente elemento
	public ElementoDeCompas getSiguienteElemento(){
		ElementoDeCompas elemento=null;
		if(!this.itElementos.hasNext()){
			this.itElementos = this.elementos.iterator();
		}
		else{
			elemento=this.itElementos.next();
		}
		return elemento;
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
		Iterator<ElementoDeCompas> itElementos = this.elementos.iterator();
		double sumaDuracion=0;
		while(itElementos.hasNext()){
			ElementoDeCompas unElemento = itElementos.next();
			sumaDuracion += unElemento.getDuracion();
		}
		return sumaDuracion;
	}

}