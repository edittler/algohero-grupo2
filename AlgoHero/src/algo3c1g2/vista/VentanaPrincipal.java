package algo3c1g2.vista;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipal extends JFrame {

	private JMenu menuArchivo;
	private JMenu menuAyuda;
	private JMenuItem nuevo;
	private JMenuItem pausa;
	private JMenuItem salir;
	private JMenuItem reglas;
	private JMenuItem acercaDe;
	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;
	
	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		
		this.controladorJuego = unControladorJuego;
		this.addKeyListener(new KeyPressedController(controladorJuego));
		this.setTitle("ALGO-HERO");
		this.setSize(800,655);
		this.setResizable(false);
		this.setLocation(150, 0);
		
		panel = new Panel(666,726,controladorJuego);
		
		this.add(panel);
		
		
		//Creamos la barra de menus.
		
		JMenuBar mbarra = new JMenuBar();
		
		
		//Aï¿½adimos un menu Archivo que contiene Nuevo y Salir.
		
		menuArchivo = new JMenu( "Archivo  " );
		nuevo = new JMenuItem("Nuevo  ");
		pausa = new JMenuItem ("Pausar  ");
		salir = new JMenuItem("Salir  ");
		menuArchivo.add(nuevo);
		menuArchivo.add(pausa);
		menuArchivo.add(salir);
		
		mbarra.add(menuArchivo);
	 
		//Agregamos un menu Ayuda que contiene Reglas y AcercaDe.
		
		menuAyuda = new JMenu( "Ayuda  " );
		reglas = new JMenuItem("Reglas  ");
		acercaDe = new JMenuItem("Acerca de..  ");
		mbarra.add(menuAyuda);
		menuAyuda.add(reglas);
		menuAyuda.add(acercaDe);
		setJMenuBar(mbarra);
		

		
		//Asignamos las acciones de nuestros items del menu Archivo y Ayuda.
		
		
		nuevo.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				;
				if(!controladorJuego.estaEnEjecucion()){
					nuevo.setLabel("Continuar");
					controladorJuego.comenzarJuegoAsyn();	
				}
				}
		});

		
		pausa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				controladorJuego.detenerJuego();
				
				}
		});
			
		reglas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				;
				
				@SuppressWarnings("unused")//Solo se crea la instancia mostrando en pantalla.
				VistaRegla reglas = new VistaRegla(panel);
				
				}
			});
		
		acercaDe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
	
				@SuppressWarnings("unused")//Solo se crea la instancia mostrando en pantalla.
				VistaAcercaDe acercaDe = new VistaAcercaDe(panel);
				
				}
			});
		
		salir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Desea salir del juego?", "Salir", JOptionPane.OK_CANCEL_OPTION) == 0)
					   System.exit(0);
			}
		
		});
		
	
		this.setBackground(Color.black);
		panel.setBackground(Color.black);
		
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
	
	
	public void cerrarJuego(){
		dispose();
		System.exit(0);
	}
	

	
}
