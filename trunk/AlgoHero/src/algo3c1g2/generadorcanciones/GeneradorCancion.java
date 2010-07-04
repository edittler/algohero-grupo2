package algo3c1g2.generadorcanciones;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.persistencia.PersistidorCancion;

public abstract class GeneradorCancion {
	protected Cancion cancion;
	
	public String obtenerArchivoCancion(){
		String rutaArchivo = "canciones/"+this.cancion.getNombre()+".xml";
		PersistidorCancion unPersistidor = new PersistidorCancion();
		unPersistidor.persistirYGuardar(cancion, rutaArchivo);
		return rutaArchivo;
	}
	
	public Cancion getCancion(){
		return this.cancion;
	}

}
