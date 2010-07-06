package algo3c1g2.vista.ventanas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static final int TAMA�O_VERTICAL=655;
	public static final int TAMA�O_HORIZONTAL=800;
	
	private ControladorJuego controladorJuego;
	private Panel panel;
	private JPanel panelSuperior = new JPanel(new GridLayout(1, 0));
	private JButton botonJugar = new JButton("JUGAR");
	private JButton botonPausar = new JButton("PAUSA");
	private JButton botonSalir = new JButton("SALIR");
	private JButton botonReglas = new JButton("REGLAS");
	private JButton botonAcercaDe = new JButton("ACERCA DE...");

	public VentanaPrincipal(ControladorJuego unControladorJuego) {

		this.controladorJuego = unControladorJuego;
		this.addKeyListener(new KeyPressedController(controladorJuego));
		this.setTitle("ALGO-HERO GAME");
		this.setSize(TAMA�O_HORIZONTAL, TAMA�O_VERTICAL);
		this.setResizable(false);
		this.setLocation(150, 0);
		this.setBackground(Color.black);
		panel = new Panel(666, 726, controladorJuego);
		panel.setBackground(Color.black);
		this.add(panel);

		// Se crea la barra de menus.
		JMenuBar barraMenu = new JMenuBar();

		// Se agregan los botones al panel
		panelSuperior.add(botonJugar);
		panelSuperior.add(botonPausar);
		panelSuperior.add(botonSalir);
		panelSuperior.add(botonReglas);
		panelSuperior.add(botonAcercaDe);

		setJMenuBar(barraMenu);
		barraMenu.add(panelSuperior);

		// Se asigna la accion al boton JUGAR-CONTINUAR
		botonJugar.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (!controladorJuego.estaEnEjecucion()) {
					controladorJuego.comenzarJuegoAsyn();
					botonJugar.setLabel("CONTINUAR");
				}
			}
		});

		// Se asigna la accion al boton PAUSAR
		botonPausar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				controladorJuego.detenerJuego();
			}
		});

		// Se asigna la accion al boton REGLAS
		botonReglas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// Solo se crea la instancia mostrando en pantalla.
				@SuppressWarnings("unused")
				VentanaReglas reglas = new VentanaReglas(panel);
			}
		});

		// Se asigna la accion al boton ACERCA DE
		botonAcercaDe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// Solo se crea la instancia mostrando en pantalla.
				@SuppressWarnings("unused")
				VentanaAcercaDe acercaDe = new VentanaAcercaDe(panel);
			}
		});

		// Se asigna la accion al boton SALIR
		botonSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"�Desea salir del juego?", "Salir",
						JOptionPane.OK_CANCEL_OPTION) == 0)
					System.exit(0);
			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return this.panel;
	}

	public void cerrarJuego() {
		dispose();
		System.exit(0);
	}

}