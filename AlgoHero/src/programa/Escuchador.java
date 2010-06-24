package programa;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class Escuchador implements KeyPressedObservador {

	private Guitarra guitarra;

	
	public Escuchador(Guitarra guitarra){
		this.guitarra=guitarra;
	}
	@Override
	public void keyPressed(KeyEvent event) {
		this.guitarra.contarPuntos((char)event.getKeyCode());
	}

}
