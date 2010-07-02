package algo3c1g2.vista.ventanas;

import java.awt.Component;


public class VentanaAcercaDe extends VentanaMensaje {

	public VentanaAcercaDe(Component ventana) {
		super(ventana);
	}

	@Override
	public String getTexto() {

		String informacionDeCreacion;

		informacionDeCreacion = "NOMBRE DEL JUEGO: \n"
								+ "\n ALGO-HERO 2010 \n" +

		"\n AUTORES: \n" + "\n Badano, Juan Ignacio \n" + 
							"Lucero, Emmanuel \n" +
							"Perez Dittler, Ezequiel \n" +
							"Villanueva, Cecilia Azul \n" +

		"\n FECHA DE CREACION: \n" + "\n Julio de 2010";

		return informacionDeCreacion;
	}

	@Override
	protected String getTitulo() {
		return "Acerca De";
	}

}
