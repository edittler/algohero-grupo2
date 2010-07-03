package algo3c1g2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.audio.Elemento;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;

public class Guitarra implements ObjetoVivo {

	// Presicion con la que se obtiene un elemento
	private static double PRESICION_ELEMENTO = 0.0074;

	// Intervalo de tiempo en el que transcurre la simulacion
	private static double TIEMPO_INTERVALO_SIMULACION = 0.015;

	private static int CANTIDAD_DE_CUERDAS = 6;

	private static double TIEMPO_ENTRE_MENSAJE_Y_ACCION = 2;// segundos
	private Cancion cancion;
	private Puntaje puntaje;
	private double instanteActual;
	private ArrayList<Cuerda> cuerdas;
	private Reproductor reproductor;

	public Guitarra(Cancion unaCancion, Reproductor reproductor) {
		this.cuerdas = new ArrayList<Cuerda>();
		for (int i = 0; i < Guitarra.CANTIDAD_DE_CUERDAS; i++) {
			Cuerda unaCuerda = new Cuerda();
			this.cuerdas.add(unaCuerda);
		}

		this.cancion = unaCancion;
		this.puntaje = new Puntaje();
		this.instanteActual = 0.00;
		this.reproductor = reproductor;

	}

	public void agregarCirculito(Circulito unCirculito) {
		this.cuerdas.get(unCirculito.getNumeroDeCuerda() - 1).agregarCirculito(
				unCirculito);
	}

	@Override
	public void vivir() {
		ElementoDeCompas elementoActual = cancion.getElemento(
				this.instanteActual, Guitarra.PRESICION_ELEMENTO);
		if (elementoActual != null) {

			if (elementoActual.isNota()) {

				Circulito unCirculito = this
						.habilitarUnNuevoCirculito((Nota) elementoActual);
				unCirculito
						.setInstanteASerReproducido(this.getInstanteActual());
			}
		}
		this.instanteActual += TIEMPO_INTERVALO_SIMULACION;
	}

	// TODAVIA NO ESTA LISTO
	public void reproducir(double instante) {
		Nota nota = (Nota) this.cancion.getElemento(instante,
				Guitarra.PRESICION_ELEMENTO);
		int frecuencia = (int) nota.getFrecuencia();
		int duracion = (int) (900 * (nota.getFigura().getDuracion()) * (60.00 / this.cancion
				.getTempo()));

		String teclas = this.cancion.getMapaDeTeclasEnString(nota);
		boolean conto = false;

		Iterator<Circulito> itCir = this.cuerdas.get(nota.getCuerda() - 1)
				.iterator();

		while (itCir.hasNext() && !conto) {
			Circulito unCirculito = itCir.next();
			// Si no fue reproducido, si las teclas a tocar son las mismas y si
			// el instante a ser reproducido es el mismo entonces lo cuenta
			if (!unCirculito.fueReproducido()
					&& (unCirculito.getTeclas() == teclas)
					&& (unCirculito.getInstanteASerReproducido() == instante)) {
				System.out.println("ENTRE ACA");
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
		int cuerda = nota.getCuerda();
		return this.cuerdas.get(cuerda - 1)
				.habilitarUnCirculito(TeclasEnString);

	}

	/* Obtiene el instante de reproduccion de la musica */
	public double getInstanteDeCancion() {
		return (this.instanteActual - TIEMPO_ENTRE_MENSAJE_Y_ACCION);
	}

	public double getInstanteActual() {
		return this.instanteActual;
	}

	private static final double PRESICION_DEL_JUEGO = 0.5; // segundos

	public boolean contarPuntos(int keyCode) {
		CombinacionDeTeclas TeclasPresionadas = new CombinacionDeTeclas();
		Tecla unaTecla = new Tecla(keyCode);
		boolean acerto = false;

		TeclasPresionadas.agregarTecla(unaTecla);
		acerto = this.cancion.verificarTeclas(TeclasPresionadas, this
				.getInstanteActual(), PRESICION_DEL_JUEGO);
		this.puntaje.sumarPuntos();
		return acerto;
	}

	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}

	public Puntaje getPuntaje() {
		return puntaje;
	}

}