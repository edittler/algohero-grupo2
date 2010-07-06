package algo3c1g2.modelo.simulador;

import java.util.ArrayList;
import java.util.Iterator;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.excepciones.ParametroNuloExcepcion;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.audio.Elemento;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;

/**
 * Esta clase simula un instrumento guitarra que reproduce canciones
 * 
 * @author Juan Igancio Badano
 */

public class Guitarra implements ObjetoVivo,Posicionable {

	// Presicion con la que se obtiene un elemento.
	// Es una cota del error cometido al almacenar numeros en punto flotante en la PC
	private static double PRESICION_ELEMENTO = 0.0005;
	
	private static int CANTIDAD_DE_CUERDAS = 6;
	
	// Intervalo de tiempo entre actualizaciones de la simulacion en segundos
	private double tiempoIntervaloSimulacion;

	private Cancion cancion;
	private double instanteActual;
	private ArrayList<Cuerda> cuerdas;
	private Reproductor reproductor;

	/**
	 * Constructor de la clase Cancion.
	 * 
	 * @param unaCancion Cancion que se va a reproducir con mapeo completo.
	 * @param unReproductor Reproductor a usar.
	 * @throws ParametroNuloExcepcion Si los parametros son nulos.
	 */
	public Guitarra(Cancion unaCancion, Reproductor unReproductor) {
		/* Los parametros no deben ser nulos, sino lanza excepcion
		 */
		if ((unaCancion==null)||(unReproductor==null)) throw new ParametroNuloExcepcion();
		
		this.cuerdas = new ArrayList<Cuerda>();

		for (int i = 0; i < Guitarra.CANTIDAD_DE_CUERDAS; i++) {
			Cuerda unaCuerda = new Cuerda();
			this.cuerdas.add(unaCuerda);
		}

		this.cancion = unaCancion;
		this.instanteActual = 0.00;
		this.reproductor = unReproductor;
		tiempoIntervaloSimulacion=(60.00/this.cancion.getTempo())/64;
	}
	
	/**
	 * Metodo para agregar un {@code Circulito} (representacion de nota en
	 * la guitarra) a la guitarra. 
	 * @param unCirculito El {@code Circulito} a agregar.
	 * @throws ParametroNuloExcepcion Si se para un parametro nulo.
	 */
	public void agregarCirculito(Circulito unCirculito) {
		if (unCirculito == null) throw new ParametroNuloExcepcion();
		int cuerda = unCirculito.getNumeroDeCuerda() - 1;
		this.cuerdas.get(cuerda).agregarCirculito(unCirculito);
	}
	
	/**
	 * Metodo que hace "vivir" a la guitarra incrementando el tiempo
	 * de reproduccion de la cancion.
	 */
	@Override
	public void vivir() {
		//Obtiene el elemento asociado al instanteActual de la simulacion
		ElementoDeCompas elementoActual = cancion.getElemento(this.instanteActual, Guitarra.PRESICION_ELEMENTO);
		if (elementoActual != null) {
			if (elementoActual.isNota()) { //Si es de tipo Nota habilita un Circulito con los datos de esa nota 
				this.habilitarUnNuevoCirculito((Nota) elementoActual);
			}
		}
		this.instanteActual += tiempoIntervaloSimulacion;
	}
	
	/**
	 * Metodo para conocer el instante en que que se encuentra reproduciendo
	 * la cancion.
	 * @return Devuelve el instante actual de reproduccion de la cancion.
	 */
	public double getInstanteActual() {
		return this.instanteActual;
	}

	/**
	 * Reproduce la nota asociada al instante si concuerda la tecla
	 * precionada segun el mapeo de la cancion.
	 * @param tecla Tecla presionada
	 * @param instante Intante de la cancion que se quiere reproducir
	 * @param presicion Presicion con la que se quiere obtener la nota
	 * a reproducir
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
	
	/**
	 * Reproduce una nota de error.
	 */
	public void reproducirError() {
		this.reproductor.reproducir(new Elemento(44, 17));
	}

	/* ********************
	/* METODOS AUXILIARES *
	 ********************** /

	/* Busca y habilita un Circulito en la cuerda indicada */
	private void habilitarUnNuevoCirculito(Nota nota) {
		String TeclasEnString = this.cancion.getMapaDeTeclasEnString(nota);
		int cuerda = nota.getCuerda();
		int frecuencia = (int) nota.getFrecuencia();
		/* Obtengo la duracion en segundos de la nota
		 * teniendo en cuenta el tempo de la cancion.
		 * Lo multimpico por 1000 para obtenerlo en milisegundos
		 */
		int duracion = (int) (1000 * (nota.getDuracionEnSegundos(this.cancion.getTempo())));
		this.cuerdas.get(cuerda - 1).habilitarUnCirculito(TeclasEnString,frecuencia,duracion,this.getInstanteActual());
	}
	
	public boolean termino(){
		return this.cancion.getDuracionTotal()+1<this.getInstanteActual();
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}