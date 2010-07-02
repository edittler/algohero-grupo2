package algo3c1g2.vista.images;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImageCirculito extends Imagen{
	
	private static final String IMAGE_CIRCULITO = "ImageCirculito.png";
	private static final String IMAGE_CIRCULITO_REPRODUCIDO = "ImageCirculitoReproducido.png";
	
	public ImageCirculito(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO);
	}
	
	public void establecerImagenOriginal(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO);
	}
	
	public void establecerImagenDeReproducido(){
		this.setNombreArchivoImagen(IMAGE_CIRCULITO_REPRODUCIDO);
	}
	
}
