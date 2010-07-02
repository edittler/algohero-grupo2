package algo3c1g2.vista.images;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImageFondoInicio extends Imagen {

	public ImageFondoInicio() {
		setNombreArchivoImagen("ImageFondoInicio.jpg");
		setPosicionable(new Ubicacion());
	}

	/*
	 * Como Imagen debe contener un Posicionable para poder ser dibujada por
	 * pantalla, se crea esta clase privada para suplir ese fin.
	 */
	private class Ubicacion implements Posicionable {

		private int x;
		private int y;
		private int hashCode;

		public Ubicacion() {
			this.x = 0;
			this.y = 0;
			this.hashCode = 0;
		}

		@Override
		public int hashCode() {
			this.hashCode = this.x;
			this.hashCode += this.y;
			return this.hashCode;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}
	}

}
