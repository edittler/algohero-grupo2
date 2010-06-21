package algo3c1g2.vista;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	 private static final long serialVersionUID = 1L;
	   Font letra = new Font("Verdana", Font.BOLD, 12);
	   private JPanel panelPrincipal = new JPanel(new BorderLayout());
	   private JLabel imgLabel = new JLabel();
	   private JPanel panelSup = new JPanel(new GridLayout(2,0));
	   private JPanel pBotonesSuperiores = new JPanel(new GridLayout(1,0)); 
	   private JPanel pLabel = new JPanel();
	   private JPanel pBotonesInferiores = new JPanel(new GridLayout(1,0));
	   private JButton[] botonesSuperiores =  {new JButton("Nuevo Juego"), 
	                         new JButton("Puntajes"),
	                         new JButton("Acerca de...")};   
	   
	   
	   // BOTONES DE LA PARTE INFERIOR
	   private JButton Ayuda = new JButton("Ayuda");
	   private JButton Salir = new JButton("Salir");   
	   private boolean activado = false;
	   
	   // MÉTODO CONSTRUCTOR DE LA CLASE VENTANA PRINCIPAL QUE CREA Y MUESTRA LA INTERFAZ
	   public VentanaPrincipal() {    
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	     Ayuda.setActionCommand ("Ayuda");
	     Ayuda.addActionListener(this);
	     Salir.setActionCommand ("Salir");
	     Salir.addActionListener(this);
	     
	     // MOSTRAR LOS BOTONES SUPERIORES, CONFIGURAR LA FUENTE
	     //ENLAZARLOS CON addActionListener
	     for(int i = 0; i < botonesSuperiores.length; i++) {
	       pBotonesSuperiores.add(botonesSuperiores[i]);
	       botonesSuperiores[i].setFont(letra);
	       botonesSuperiores[i].addActionListener(this);
	       }

	     // CONFIGURAR LA ETIQUETA imgLabel
	     imgLabel.setHorizontalAlignment(JLabel.CENTER);
	     imgLabel.setOpaque(true);
	     imgLabel.setBackground(Color.BLACK);

	     panelPrincipal.setOpaque(true);
	     this.setContentPane(panelPrincipal);
	     panelSup.add(pBotonesSuperiores);
	     panelPrincipal.add(panelSup, BorderLayout.NORTH);    
	     panelSup.add(pLabel);
	     panelPrincipal.add(imgLabel, BorderLayout.CENTER);
	     panelPrincipal.add(pBotonesInferiores, BorderLayout.SOUTH);
	     pBotonesInferiores.add(Ayuda);
	     pBotonesInferiores.add(Salir);     

	     // MOSTRAR LA VENTANA EN PANTALLA
	     this.setTitle("ALGOHERO");
	     this.setSize(new Dimension(670,700));
	     this.setLocationRelativeTo(null);
	     this.setResizable(false);
	     this.setVisible(true);
	     setLabelPicture();
	   }
	   
	   public void esperarInicioDeJuego() {
		   this.setVisible(true);
		   activado = false;
		   
		   while(!activado) {
		    	 try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     }
		     
		     this.setVisible(false);
	   }
	   
	   // MOSTRAR LA IMAGEN EN LA ETIQUETA
	   private void setLabelPicture() {
	     String nombreCompleto = "/recursos/inicio.jpg";
	     URL url = this.getClass().getResource( nombreCompleto );
	     imgLabel.setIcon(new ImageIcon(url));
	}

	   // LO QUE SUCEDE AL PULSAR UNO DE LOS BOTONES
	   public void actionPerformed(ActionEvent e) {	   
		   String desarrolladores="Creadores de este juego:  \n"+
		   							"Juan Ignacio Badano, Ezequiel Perez Dittler, "+
		   							"Emmanuel Lucero, Azul  ";
		   String ayuda="ACA IRIAN LAS REGLAS DEL JUEGO: ";
		   				
		   if ("Ayuda".equals(e.getActionCommand())) {
			   JOptionPane.showMessageDialog(null, ayuda, "Ayuda", -1);		  
		   }
		   else if ("Salir".equals(e.getActionCommand())) {
			   if(JOptionPane.showConfirmDialog(null, "¿Desea salir del juego?", "Salir", JOptionPane.OK_CANCEL_OPTION) == 0)
				   System.exit(0);
			  	}  
		   else if ("Nuevo Juego".equals(e.getActionCommand())) {	
			   activado = true;
		   }   
		   else if ("Puntajes".equals(e.getActionCommand())) {
			
		   }   
		   else if ("Acerca de...".equals(e.getActionCommand())) {
			   JOptionPane.showMessageDialog(null, desarrolladores, "Algo Hero Game", -1);
		   }   
	   }
	   //ESTE MAIN LO PONGO PARA PROBAR LAS VENTANA, SACAR DE ACA
	   
	   public static void main(String[] args) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					VentanaPrincipal thisClass = new VentanaPrincipal();
					thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					
					
				}
			});
		}

}
