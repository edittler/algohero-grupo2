package algo3c1g2.vista.images;

import java.awt.Graphics;

import algo3c1g2.modelo.Circulito;
import algo3c1g2.vista.VistaCuerda;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImageCirculito extends Imagen{
	
	private static final String IMAGE_CIRCULITO = "ImageCirculito.png";
	private static final String IMAGE_CIRCULITO_REPRODUCIDO = "ImageCirculitoReproducido.png";
	private int posicionCuerda;
	
	
	public ImageCirculito(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO);
	}
	
	public void establecerImagenOriginal(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO);
	}
	
	public void establecerImagenDeReproducido(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO_REPRODUCIDO);
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen, this.posicionCuerda, this.posicionable.getY(), null);
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;	
		switch(((Circulito)this.posicionable).getNumeroDeCuerda()){
		case 1: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_1;
		break;
		case 2: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_2;
		break;
		case 3: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_3;
		break;
		case 4: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_4;
		break;
		case 5: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_5;
		break;
		case 6: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_6;
		break;
		default: this.posicionCuerda=0;
		}
	}
	public void setPosicionCuerda(int posicionCuerda) {
		this.posicionCuerda = posicionCuerda;
	}

	public int getPosicionCuerda() {
		return posicionCuerda;
	}
	
}
