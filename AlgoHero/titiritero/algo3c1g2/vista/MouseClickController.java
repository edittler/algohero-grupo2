package algo3c1g2.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algo3c1g2.ControladorJuego;


public class MouseClickController extends MouseAdapter {

	private ControladorJuego controlador; 
	
	public MouseClickController(ControladorJuego unControlador) {
		this.controlador = unControlador;
	}
	
	public void mouseClicked(MouseEvent e){
		this.controlador.despacharMouseClick(e.getX(), e.getY());
	}
	
}
