package algo3c1g2.vista;

import java.awt.Graphics;

import algo3c1g2.modelo.simulador.Guitarra;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaGuitarra extends Imagen {

	public VistaGuitarra(){
		this.setNombreArchivoImagen("gameover.jpg");
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		if(((Guitarra)this.posicionable).termino()){
			Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
			grafico.drawImage(this.imagen, 240, 160, null);
		}
		
	}
	
}
