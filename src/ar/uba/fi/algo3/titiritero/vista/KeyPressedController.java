package ar.uba.fi.algo3.titiritero.vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class KeyPressedController extends KeyAdapter implements KeyListener {
	
	private ControladorJuego controlador;
	
	public KeyPressedController(ControladorJuego controlador){
		this.controlador = controlador;
	}

	public void keyPressed(KeyEvent e) {
		this.controlador.despacharKeyPress(e);
	}

	public void keyReleased(KeyEvent e) {
		this.controlador.despacharKeyPress(e);
	}

}
