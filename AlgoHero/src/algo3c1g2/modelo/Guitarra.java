package algo3c1g2.modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import algo3c1g2.vista.ObjetoTexto;
import algo3c1g2.vista.images.ImageCirculito;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.audio.Elemento;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class Guitarra implements ObjetoVivo {


	// Presicion con la que se obtiene un elemento
	private static double PRESICION_ELEMENTO = 0.0074;

	// Presicion admitida por la simulacion del juego
	private static double PRESICION_SIMULACION = 0.5;

	// Intervalo de tiempo en el que transcurre la simulacion
	private static double TIEMPO_INTERVALO_SIMULACION = 0.015;

	private static int CANTIDAD_DE_CUERDAS=6;
	
	private static double TIEMPO_ENTRE_MENSAJE_Y_ACCION = 2;//segundos
	private Cancion cancion;
	private double instanteActual;
	private ArrayList<Cuerda> cuerdas;
	private Puntaje puntaje;
	private Reproductor reproductor;

	public Guitarra(Cancion unaCancion,Reproductor reproductor) {
		this.cuerdas= new ArrayList<Cuerda>();
		for(int i=0;i<Guitarra.CANTIDAD_DE_CUERDAS;i++){
			Cuerda unaCuerda=new Cuerda();
			this.cuerdas.add(unaCuerda);
		}
		
		this.cancion = unaCancion;
		this.instanteActual = 0.00;
		this.reproductor=reproductor;
	
	}

	public void agregarCirculito(Circulito unCirculito){
		this.cuerdas.get(unCirculito.getNumeroDeCuerda()-1).agregarCirculito(unCirculito);
	}
	
	
	
	@Override
	public void vivir() {
		ElementoDeCompas elementoActual=cancion.getElemento(this.instanteActual, Guitarra.PRESICION_ELEMENTO);
		if (elementoActual != null) {
			
			if (elementoActual.isNota()) {

				Circulito unCirculito = this.habilitarUnNuevoCirculito((Nota)elementoActual);
				unCirculito.setInstanteASerReproducido(this.getInstanteActual());
			}
		}
		this.instanteActual += TIEMPO_INTERVALO_SIMULACION;
	}


//TODAVIA NO ESTA LISTO
	public void reproducir(double instante) {
		Nota nota=(Nota)this.cancion.getElemento(instante, Guitarra.PRESICION_ELEMENTO);
		int frecuencia = (int) nota.getFrecuencia();
		int duracion = (int) (900 * (nota.getFigura().getDuracion()) * (60.00 / this.cancion.getTempo()));
		
		
		String teclas=this.cancion.getMapaDeTeclasEnString(nota);
		boolean conto=false;

			Iterator<Circulito> itCir = this.cuerdas.get(nota.getCuerda()-1).iterator();

			while (itCir.hasNext() && !conto) {
				Circulito unCirculito = itCir.next();
				//Si no fue reproducido, si las teclas a tocar son las mismas y si el instante a ser reproducido es el mismo entonces lo cuenta
					if (!unCirculito.fueReproducido()&&(unCirculito.getTeclas()==teclas)&&(unCirculito.getInstanteASerReproducido()==instante)) {
						conto = true;
						this.reproductor.reproducir(new Elemento(frecuencia, duracion));
						unCirculito.establecerQueFueReproducido();
					}
				}
			}
		
		


	/****** Métodos Auxiliares *******/



	/* Busca y habilita un Circulito en la cuerda indicada */
	private Circulito habilitarUnNuevoCirculito(Nota nota) {
		
		String TeclasEnString = this.cancion.getMapaDeTeclasEnString(nota);
		int cuerda=nota.getCuerda();
		return this.cuerdas.get(cuerda-1).habilitarUnCirculito(TeclasEnString);
		
	}

	/* Obtiene el instante de reproduccion de la musica */
	public double getInstanteDeCancion() {
		return this.instanteActual - TIEMPO_ENTRE_MENSAJE_Y_ACCION;
	}

	public double getInstanteActual() {
		return this.instanteActual;
	}

}