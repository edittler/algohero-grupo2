package algo3c1g2.vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algo3c1g2.controlador.InicioAlgoHero;
import algo3c1g2.generadorcanciones.GeneradorCancion;
import algo3c1g2.generadorcanciones.GolDeMessiDondeEstas;
import algo3c1g2.modelo.Cancion;
import algo3c1g2.persistencia.PersistidorCancion;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaEleccionCancion extends JFrame {
private static final long serialVersionUID = 1L;
	
	public static final int TAMAÑO_VERTICAL=655;
	public static final int TAMAÑO_HORIZONTAL=800;
	
	private ControladorJuego controladorJuego;
	private Panel panel;
	private JPanel panelSuperior = new JPanel(new GridLayout(1, 5));
	private JPanel panelEleccion = new JPanel(new GridLayout (1,5));
	private JPanel panelJuego= new JPanel(new GridLayout (1,5));
	private JButton botonJugar = new JButton("JUGAR");
	private JButton botonPausar = new JButton("PAUSA");
	private JButton botonSalir = new JButton("SALIR");
	private JButton cancion1 = new JButton("CANCION 1");
	private JButton cancion2 = new JButton("CANCION 2");
	private JButton cancion3 = new JButton("CANCION 3");
	private JButton cancion4 = new JButton("CANCION 4");


	public VentanaEleccionCancion(ControladorJuego unControladorJuego) {

		this.controladorJuego = unControladorJuego;
		this.addKeyListener(new KeyPressedController(controladorJuego));
		this.setTitle("ALGO-HERO GAME");
		this.setSize(TAMAÑO_HORIZONTAL, TAMAÑO_VERTICAL);
		this.setResizable(false);
		this.setLocation(150, 0);
		this.setBackground(Color.black);
		panel = new Panel(666, 726, controladorJuego);
		panel.setBackground(Color.black);
		this.add(panel);

		// Se crea la barra de menus.
		JMenuBar barraMenu = new JMenuBar();
		

		// Se agregan los botones al panel
		panelSuperior.add(panelEleccion);
		panelSuperior.add(panelJuego);

		
		botonJugar.setBackground(Color.BLACK);
		botonJugar.setForeground(Color.WHITE);
		botonPausar.setBackground(Color.BLACK);
		botonPausar.setForeground(Color.WHITE);
		botonSalir.setBackground(Color.BLACK);
		botonSalir.setForeground(Color.WHITE);
		
		panelJuego.add(botonJugar);
		panelJuego.add(botonSalir);
		
		panelEleccion.add(cancion1);
		panelEleccion.add(cancion2);
		panelEleccion.add(cancion3);
		panelEleccion.add(cancion4);
		
		cancion1.setBackground(Color.BLACK);
		cancion1.setForeground(Color.WHITE);
		cancion2.setBackground(Color.BLACK);
		cancion2.setForeground(Color.WHITE);
		cancion3.setBackground(Color.BLACK);
		cancion3.setForeground(Color.WHITE);
		cancion4.setBackground(Color.BLACK);
		cancion4.setForeground(Color.WHITE);
		
		

		setJMenuBar(barraMenu);
		barraMenu.add(panelSuperior);

		// Se asigna la accion al boton JUGAR-CONTINUAR
		botonJugar.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (!controladorJuego.estaEnEjecucion())
				{
					comenzar();
					botonJugar.setLabel("CONTINUAR");
					 panelSuperior.remove(panelEleccion);
					 panelJuego.add(botonPausar);
				}
			}
		});

		// Se asigna la accion al boton PAUSAR
		botonPausar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				controladorJuego.detenerJuego();
			}
		});


		// Se asigna la accion al boton SALIR
		botonSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,
						"¿Desea salir del juego?", "Salir",
						JOptionPane.OK_CANCEL_OPTION) == 0)
					System.exit(0);
			}
		});
		
		// Se asigna la accion al boton SALIR
		cancion1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				/************ CREAMOS UNA CANCION ********************/
				GeneradorCancion unGenerador = new GolDeMessiDondeEstas();
				String rutaArchivo = unGenerador.obtenerArchivoCancion();

				PersistidorCancion unPersistidor = new PersistidorCancion();
				Cancion unaCancion = unPersistidor.cargarCancion(rutaArchivo);
				/************************************************/
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
    private void comenzar(){
		   InicioAlgoHero inicio = new InicioAlgoHero(controladorJuego);
		   inicio.comenzar();
	   }


}
