package vista;

import titiritero.Posicionable;
import titiritero.vista.Imagen;
/*
 * Auxiliar de la clase imagen. Sirve para ajustar la posicion de un objeto a una escala determinada.
 */
public class Posicion implements Posicionable {
	Posicionable posicionable;
	
	public Posicion(Posicionable posicionable){
		this.posicionable = posicionable;
		
	}

	@Override
	public int getX() {

		return posicionable.getX() * Imagen.getEscala();
	}

	@Override
	public int getY() {
		return posicionable.getY() * Imagen.getEscala();
	}

}