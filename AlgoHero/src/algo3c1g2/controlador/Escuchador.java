package algo3c1g2.controlador;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class Escuchador implements KeyPressedObservador {

	private Guitarra guitarra;
	private boolean estaPresionado;

	public Escuchador(Guitarra guitarra) {
		this.guitarra = guitarra;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (!this.estaPresionado) {
			this.estaPresionado = true;
			this.guitarra.contarPuntos((char) event.getKeyCode());
		} else {
			this.estaPresionado = false;
		}
	}

}
