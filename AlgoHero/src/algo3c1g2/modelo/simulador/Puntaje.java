package algo3c1g2.modelo.simulador;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Puntaje implements Posicionable {

	private int puntos;
	private Cancion cancion;
	private double instanteAnterior;
	public static final double PRESICION_DEL_JUEGO = 0.125; // segundos
	public static final double TIEMPO_ENTRE_MENSAJE_Y_ACCION = 3; // segundos
	private static final int PUNTOS = 1000;

	public Puntaje(Cancion unaCancion) {
		this.puntos = 0;
		this.cancion = unaCancion;
		this.instanteAnterior = 0.00;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public boolean contarPuntos(double instante, char tecla) {
		CombinacionDeTeclas TeclasPresionadas = new CombinacionDeTeclas();
		Tecla unaTecla = new Tecla(tecla);
		TeclasPresionadas.agregarTecla(unaTecla);
		/* Le resta el tiempo entre que se mostro por primera vez
		 * el circulito hasta que llega al rango de habilitacion
		 * Y obtiene el instante actual de la reproduccion. 
		 */
		instante -= TIEMPO_ENTRE_MENSAJE_Y_ACCION;
							 
		boolean acerto = false;
		// chequea que no vuelva a contar un circulito presionado varias veces
		if (!(this.yaFueContado(instante))) {
			acerto = this.cancion.verificarTeclas(TeclasPresionadas, instante,
					PRESICION_DEL_JUEGO);
			/*
			 * Esto significa que si acerto le suma PUNTOS a this.puntos y
			 * sino le suma 0
			 */
			this.puntos += (acerto) ? PUNTOS : 0;
		}
		this.instanteAnterior = instante;
		return acerto;
	}

	private boolean yaFueContado(double instante){
		return (this.instanteAnterior>=(instante-(2*PRESICION_DEL_JUEGO)));

	}

	public Nota getElementoAReproducir(double instante) {
		Nota unaNota = (Nota) this.cancion.getElemento(instante, PRESICION_DEL_JUEGO);
		return unaNota;
	}

}