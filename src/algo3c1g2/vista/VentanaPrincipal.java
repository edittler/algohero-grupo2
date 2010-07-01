package algo3c1g2.vista;

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

	private ControladorJuego controladorJuego;
	private static final long serialVersionUID = 1L;
	private Panel panel;
	private JPanel panelSup = new JPanel(new GridLayout(1,0));
	private JButton BotonJugar= new JButton("JUGAR");
    private JButton BotonPausar= new JButton("PAUSA");
    private JButton BotonSalir= new JButton("SALIR");
    private JButton BotonReglas= new JButton("REGLAS");
    private JButton BotonAcercade= new JButton("ACERCA DE...");
    
	
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
		
		//Agregos los botones al panel
		
		 panelSup.add(BotonJugar);
		 panelSup.add(BotonPausar);
		 panelSup.add(BotonSalir);
		 panelSup.add(BotonReglas);
		 panelSup.add(BotonAcercade);
		 
		setJMenuBar(mbarra);
		mbarra.add(panelSup);
		

		
		//Asignamos las acciones de nuestros items del menu Archivo y Ayuda.
		
		BotonJugar.addActionListener(new java.awt.event.ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				;
				if(!controladorJuego.estaEnEjecucion()){
					controladorJuego.comenzarJuegoAsyn();
					BotonJugar.setLabel("CONTINUAR");
				}
				}
		});
		
	
		
		BotonPausar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				controladorJuego.detenerJuego();
				
				}
		});
			
		BotonReglas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				
				;
				
				@SuppressWarnings("unused")//Solo se crea la instancia mostrando en pantalla.
				VistaRegla reglas = new VistaRegla(panel);
				
				}
			});
		
		BotonAcercade.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
	
				@SuppressWarnings("unused")//Solo se crea la instancia mostrando en pantalla.
				VistaAcercaDe acercaDe = new VistaAcercaDe(panel);
				
				}
			});
		
		BotonSalir.addActionListener(new java.awt.event.ActionListener() {
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
