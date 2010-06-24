package algo3c1g2.modelo.nota;

import java.util.ArrayList;
import java.util.Iterator;

import programa.Circulito;

import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.tecla.*;


public abstract class Nota extends ElementoDeCompas {

	private float frecuencia;
	private Figura figura;
	
	/*
	 * Poscondicion: Asigna la frecuencia pasada por parametro y la Figura Negra por default
	 */
	public Nota(float frecuencia){
		this.setFrecuencia(frecuencia);
		this.setFigura(new Negra());
	}
	
	/*
	 * Poscondicion: Asigna la frecuencia y Figura pasadas por parametro
	 */
	public Nota(float frecuencia, Figura unaFigura){
		this.setFrecuencia(frecuencia);
		this.setFigura(unaFigura);
	}
	
	protected void setFrecuencia(float frecuencia) {
		this.frecuencia = frecuencia;
	}

	public float getFrecuencia() {
		return frecuencia;
	}

	protected void setFigura(Figura figura) {
		this.figura = figura;
	}

	public Figura getFigura() {
		return figura;
	}
	
	public boolean equals(Object o){
		
		//Compruebo si se referencia al mismo objeto 
	    if ( this == o ) return true; 
	    
	    //Compruebo si el objeto es nulo 
	    if ( o == null ) return false; 
	    
	    //Compruebo si son de distinta clase 
	    if ( this.getClass() != o.getClass() ) return false; 
	    
	    //Si no paso la comprobacion anterior, es porque es de la misma clase
	    //Ahora comparo la frecuencia y la duracion de la figura.
	    // Antes debo castear el objeto recibido
	    if ((this.getFrecuencia()==this.getClass().cast(o).getFrecuencia())
	    		&&(this.getFigura().equals(this.getClass().cast(o).getFigura()))) return true; 
	    else return false;
	}
	
	// Devuelve la duracion de la negra medida en figuras negras
	public double getDuracion() {
		return this.getFigura().getDuracion();
	}

	//devuelve true si las teclas presionadas se corresponden a las teclas asociadas a la nota en el mapeo
	
	public boolean chequear(MapaDeTeclas mapeo,	CombinacionDeTeclas teclasPresionadas){
		Iterator<Tecla> itTeclasPresionadas = teclasPresionadas.getIteradorTeclas();
		boolean resultado= true;
		while(itTeclasPresionadas.hasNext()&&resultado){
			Tecla unaTeclaPresionada = itTeclasPresionadas.next();
			resultado = (mapeo.obtenerCombinacion(this).contains(unaTeclaPresionada));
		}
		return resultado;
	}
	public boolean isNota(){
		return true;
	}
	public abstract int ubicacionCuerda();
	
	
	/* Ubica la cuerda correspondiente a la nota, recorre la cuerda buscando Circulitos NO habilitados,
	 * cuando lo encuentra lo habilita y lo devuelve
	 */
	public Circulito ubicarCuerda(ArrayList<ArrayList<Circulito>> cuerdas) {
		Iterator<ArrayList<Circulito>> itCuer=cuerdas.iterator();
		iterarHastaLaCuerda(itCuer);
		Iterator<Circulito> itCir =itCuer.next().iterator();
		Circulito unCirculito=new Circulito(new Do());
		boolean habilito=false;
		while(itCir.hasNext()&&!habilito){
			unCirculito=itCir.next();
			if(!unCirculito.estaHabilitado()){
				unCirculito.habilitar();
				habilito=true;
			}
		}
		return unCirculito;
		}

	protected abstract void iterarHastaLaCuerda(Iterator<ArrayList<Circulito>> itCuer);
}
