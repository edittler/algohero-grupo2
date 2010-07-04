package algo3c1g2.vista.images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import algo3c1g2.modelo.simulador.Circulito;
import algo3c1g2.vista.VistaCuerda;
import algo3c1g2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImageCirculito extends Imagen{
	
	private static final String IMAGE_CIRCULITO = "ImageCirculito.png";
	private static final String IMAGE_CIRCULITO_REPRODUCIDO = "ImageCirculitoReproducido.png";
	private int posicionCuerda;
	private String nombreArchivoImagen2; 
    protected BufferedImage imagen2; 
    public static final int POSICION_INICIAL_Y = -85;
    public static final int PIXELES_POR_CICLO = 2;
    
    /*Nota: guardo una imagen2 para q no tenga q ir al disco cada vez q cambia de imagen*/

	public ImageCirculito(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO);
		this.setNombreArchivoImagen2(IMAGE_CIRCULITO_REPRODUCIDO);
	}
	
	public void establecerImagenOriginal(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO);
	}
	
	public void establecerImagenDeReproducido(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO_REPRODUCIDO);
	}
	
	
	public void setNombreArchivoImagen2(String nombreArchivoImagen) {
		this.nombreArchivoImagen2 = nombreArchivoImagen;
		try{
			URL u = this.getClass().getResource(this.nombreArchivoImagen2);
			this.imagen2 = ImageIO.read(u);
		}catch(Exception ex){

		}			
	}
	
	
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		BufferedImage image = null;
		if(((Circulito)this.posicionable).fueReproducido()){
		   image=this.imagen2;
		}
		else{
			image=this.imagen;
		}
		if(((Circulito)this.posicionable).getY()>VentanaPrincipal.TAMAÑO_VERTICAL){
			((Circulito)this.posicionable).reiniciar();
		}
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(image, this.posicionCuerda, (PIXELES_POR_CICLO*this.posicionable.getY())+POSICION_INICIAL_Y, null);
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
