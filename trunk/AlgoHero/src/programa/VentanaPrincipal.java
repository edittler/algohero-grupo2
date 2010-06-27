package programa;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipal extends Frame {
	public static final int TAMAÑO_VERTICAL=600;
	public static final int TAMAÑO_HORIZONTAL=800;
	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		this.controladorJuego = unControladorJuego;
		this.addKeyListener(new KeyPressedController(controladorJuego));
		this.setTitle("ALGO-HERO");
		this.setSize(TAMAÑO_HORIZONTAL,TAMAÑO_VERTICAL);
		this.setResizable(false);
		panel = new Panel(TAMAÑO_HORIZONTAL,TAMAÑO_VERTICAL,controladorJuego);
		this.add(panel);
		
		Button boton = new Button();
		boton.setLabel("Boton");
		this.add(boton);
		
		this.setBackground(Color.green);
		panel.setBackground(Color.gray);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;
	
	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return this.panel;
	}
}
