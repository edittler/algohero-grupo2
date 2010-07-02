package algo3c1g2.controlador;

import java.awt.event.KeyEvent;

import algo3c1g2.modelo.Guitarra;
import algo3c1g2.modelo.Puntaje;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class Escuchador implements KeyPressedObservador {

	private Guitarra guitarra;
	private Puntaje puntaje;
	private boolean estaPresionado;

	public Escuchador(Guitarra guitarra) {
		this.guitarra = guitarra;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (!this.estaPresionado) {
			this.estaPresionado = true;
			double instante=this.guitarra.getInstanteDeCancion();
			char tecla=(char) event.getKeyCode();
			boolean acerto=this.puntaje.contarPuntos(instante, tecla);
			if(acerto){
			this.guitarra.reproducir(instante);
			}
			
		} else {
			this.estaPresionado = false;
		}
	}

}
