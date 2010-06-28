package algo3c1g2.vista;

import java.awt.Component;

public class VistaAcercaDe extends VistaMensaje{

	
	public VistaAcercaDe(Component ventana){
		super(ventana);
	}
	public String getTexto(){
		
		String informacionDeCreacion;
		
		informacionDeCreacion = "NOMBRE DEL JUEGO: \n" +
								"\nALGO-HERO 2010\n" +
			
								"\nAUTORES:\n"+
								"\nBadano Juan Ignacio\n" + 
								"Lucero Emmanuel\n" +
								"Perez Dittler Ezequiel\n" + 
								"Villanueva Cecilia Azul\n"+ 
								
								"\nFECHA DE CREACION: \n" +
								"		\n07/2010";
			
				
		
		return informacionDeCreacion;
	}
	@Override
	protected String getTitulo() {
		return "Acerca De";
	}
	
}
	


