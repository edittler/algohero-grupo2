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

import algo3c1g2.controlador.SimulacionAlgoHero;
import algo3c1g2.generadorcanciones.GeneradorCancion;
import algo3c1g2.generadorcanciones.*;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaEleccionCancion extends JFrame {
private static final long serialVersionUID = 1L;
	
	public static final int TAMAÑO_VERTICAL=655;
	public static final int TAMAÑO_HORIZONTAL=800;
	
	private ControladorJuego controladorJuego;
	private String nombreCancion;
	private Boolean estadoJuego;
	private Panel panel;
	private JPanel panelSuperior = new JPanel(new GridLayout(1, 5));
	private JPanel panelEleccion = new JPanel(new GridLayout(10,5));
	private JPanel panelEspacios = new JPanel(new GridLayout(1,5));
	private JPanel panelJuego= new JPanel(new GridLayout (1,5));
	private JButton botonJugar = new JButton("JUGAR");
	private JButton botonPausar = new JButton("PAUSA");
	private JButton botonSalir = new JButton("SALIR");
	//Botones cancion
	private JButton cancion1 = new JButton("Gol de Messi donde estas");
	private JButton cancion2 = new JButton("Rezo por vos");
	private JButton cancion3 = new JButton("Sweet Child O Mine");
	


	public VentanaEleccionCancion(ControladorJuego unControladorJuego) {

		this.controladorJuego = unControladorJuego;
		//Indica que el juego no fue Iniciado
		this.estadoJuego = false;
		this.addKeyListener(new KeyPressedController(controladorJuego));
		this.setTitle("ALGO-HERO GAME");
		this.setSize(TAMAÑO_HORIZONTAL, TAMAÑO_VERTICAL);
		this.setResizable(false);
		this.setLocation(150, 0);
		this.setBackground(Color.black);
		panel = new Panel(666, 726, controladorJuego);
		panel.setBackground(Color.black);
		this.add(panel);
		
		
		//Creo la cancion por Default
		GeneradorCancion unGenerador = new GolDeMessiDondeEstas();
		String rutaArchivoDefault = unGenerador.obtenerArchivoCancion();
		ObtenerNombreCancion(rutaArchivoDefault);

		// Se crea la barra de menus.
		JMenuBar barraMenu = new JMenuBar();
		

		// Se agregan los botones al panel
		panelSuperior.add(panelEleccion);
		panelSuperior.add(panelJuego);

		//Agrego colores de letra y botones
		botonJugar.setBackground(Color.BLACK);
		botonJugar.setForeground(Color.WHITE);
		botonPausar.setBackground(Color.BLACK);
		botonPausar.setForeground(Color.WHITE);
		botonSalir.setBackground(Color.BLACK);
		botonSalir.setForeground(Color.WHITE);
		cancion1.setBackground(Color.ORANGE);
		cancion1.setForeground(Color.BLACK);
		cancion2.setBackground(Color.ORANGE);
		cancion2.setForeground(Color.BLACK);
		cancion3.setBackground(Color.ORANGE);
		cancion3.setForeground(Color.BLACK);
	
		
		//Agrego los botones a los paneles
		panelJuego.add(botonJugar);
		panelJuego.add(botonSalir);
		panelEleccion.add(panelEspacios);
		panelEleccion.add(cancion1);
		panelEleccion.add(cancion2);
		panelEleccion.add(cancion3);
		panel.add(panelEleccion);
		
		//Agrego a la barra de menu el panel
		setJMenuBar(barraMenu);
		barraMenu.add(panelSuperior);

		
		// ASIGNACION DE ACCIONES A LOS BOTONES

		// Se asigna la accion al boton JUGAR-CONTINUAR
		botonJugar.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (!controladorJuego.estaEnEjecucion())
				{
					if (!estadoJuego){
						comenzar(nombreCancion);
						botonJugar.setLabel("CONTINUAR");
						panel.remove(panelEleccion);
						panelJuego.add(botonPausar);
					}
					else{
						controladorJuego.comenzarJuegoAsyn();
					}
				}
				
			
			}
		});

		// Se asigna la accion al boton PAUSAR
		botonPausar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				controladorJuego.detenerJuego();
				estadoJuego=true;
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
		
		// Se asigna la accion al boton CANCION 1
		cancion1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				/************ CREAMOS UNA CANCION ********************/
				GeneradorCancion unGenerador = new GolDeMessiDondeEstas();
				String rutaArchivo = unGenerador.obtenerArchivoCancion();
				ObtenerNombreCancion(rutaArchivo);
				cancion1.setBackground(Color.GREEN);
				cancion2.setBackground(Color.ORANGE);
				cancion3.setBackground(Color.ORANGE);
			}
		});
		
		// Se asigna la accion al boton CANCION 2
		cancion2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				/************ CREAMOS UNA CANCION ********************/
				GeneradorCancion unGenerador = new RezoPorVos();
				String rutaArchivo = unGenerador.obtenerArchivoCancion();
				ObtenerNombreCancion(rutaArchivo);
				cancion2.setBackground(Color.GREEN);
				cancion1.setBackground(Color.ORANGE);
				cancion3.setBackground(Color.ORANGE);
			}
		});
		
		// Se asigna la accion al boton CANCION 3
		cancion3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				/************ CREAMOS UNA CANCION ********************/
				GeneradorCancion unGenerador = new SweetChildOMine();
				String rutaArchivo = unGenerador.obtenerArchivoCancion();
				ObtenerNombreCancion(rutaArchivo);
				cancion3.setBackground(Color.GREEN);
				cancion2.setBackground(Color.ORANGE);
				cancion1.setBackground(Color.ORANGE);
				
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
	
    private void comenzar(String cancionAreproducir){
		   SimulacionAlgoHero inicio = new SimulacionAlgoHero(controladorJuego,cancionAreproducir);
		   inicio.comenzar();
		 
	   }
    
    private void ObtenerNombreCancion(String nombreCancion){
    	this.nombreCancion = nombreCancion;
    	
    }


}
