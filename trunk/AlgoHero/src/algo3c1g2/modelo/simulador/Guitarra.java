package algo3c1g2.modelo.simulador;

import java.util.ArrayList;
import java.util.Iterator;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.audio.Elemento;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;

public class Guitarra implements ObjetoVivo {

	// Presicion con la que se obtiene un elemento.
	// Es una cota del error cometido al almacenar numeros en punto flotante en la PC
	private static double PRESICION_ELEMENTO = 0.0005;

	// Intervalo de tiempo entre actualizaciones de la simulacion en segundos
	private static double TIEMPO_INTERVALO_SIMULACION = 0.01875;//0.0104166666666;

	private static int CANTIDAD_DE_CUERDAS = 6;

	private Cancion cancion;
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
		this.instanteActual = 0.00;
		this.reproductor = reproductor;
		TIEMPO_INTERVALO_SIMULACION=(60.00/this.cancion.getTempo())/32;
	}

	public void agregarCirculito(Circulito unCirculito) {
		int cuerda =unCirculito.getNumeroDeCuerda() - 1;
		this.cuerdas.get(cuerda).agregarCirculito(unCirculito);
	}

	@Override
	public void vivir() {
		if (this.cancion!=null){
			//Obtiene el elemento asociado al instanteActual de la simulacion
			ElementoDeCompas elementoActual = cancion.getElemento(this.instanteActual, Guitarra.PRESICION_ELEMENTO);
			if (elementoActual != null) {
				if (elementoActual.isNota()) { //Si es de tipo Nota habilita un Circulito con los datos de esa nota 
					this.habilitarUnNuevoCirculito((Nota) elementoActual);
					
				}
			}
		}
		this.instanteActual += TIEMPO_INTERVALO_SIMULACION;
	}

	/*
	 * Recibe un instante y una presicion reproduce la nota asociada al instante
	 * y modifica el estado del Circulito para que la vista cambie
	 */
	public void reproducir(char tecla,double instante, double presicion) {
		CombinacionDeTeclas TeclasPresionadas = new CombinacionDeTeclas();
		Tecla unaTecla = new Tecla(tecla);
		TeclasPresionadas.agregarTecla(unaTecla);
		
		
			boolean conto = false;
			Iterator<Cuerda> itCuer=this.cuerdas.iterator();
			while(itCuer.hasNext()){
			Iterator<Circulito> itCir = itCuer.next().iteradorCirculitos();
			
			/* Iteramos los circulitos de la cuerda asociada a la nota
			 * en busqueda de un circulito que cumpla las 3 condiciones
			 * de reproduccion que lo diferencian de demas circulitos.
			 * Ver cumpleConLaCondicionDeReproduccion en Circulito
			 */
			while (itCir.hasNext() && !conto) {
				Circulito unCirculito = itCir.next();
				if (unCirculito.cumpleConLaCondiccionDeReproduccion(instante, presicion, TeclasPresionadas.getTeclasTexto())) {
					conto = true;
					this.reproductor.reproducir(new Elemento(unCirculito.getFrecuencia(), unCirculito.getDuracion()));
					unCirculito.establecerQueFueReproducido();
				}
			}
			}
		}
	


	/****** Métodos Auxiliares *******/

	/* Busca y habilita un Circulito en la cuerda indicada */
	private Circulito habilitarUnNuevoCirculito(Nota nota) {
		String TeclasEnString = this.cancion.getMapaDeTeclasEnString(nota);
		int cuerda = nota.getCuerda();
		int frecuencia = (int) nota.getFrecuencia();
		/* Obtengo la duracion en segundos de la nota
		 * teniendo en cuenta el tempo de la cancion.
		 * Lo multimpico por 1000 para obtenerlo en milisegundos
		 */
		int duracion = (int) (1000 * (nota.getDuracionEnSegundos(this.cancion.getTempo())));
		return this.cuerdas.get(cuerda - 1).habilitarUnCirculito(TeclasEnString,frecuencia,duracion,this.getInstanteActual());
	}

	public double getInstanteActual() {
		return this.instanteActual;
	}

	public void reproducirError() {
		this.reproductor.reproducir(new Elemento(44, 17));
	}

}