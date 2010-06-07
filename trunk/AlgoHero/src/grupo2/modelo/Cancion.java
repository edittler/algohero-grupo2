package grupo2.modelo;

import java.util.*;

import grupo2.modelo.constantes.Constantes;
import grupo2.modelo.excepciones.*;
import grupo2.modelo.nota.Nota;
import grupo2.modelo.tecla.*;

public class Cancion {

	private String nombre;
	private int tempo; // [negras/minuto]
	private ArrayList<Compas> compaces;
	private MapaDeTeclas mapeo;// almacanena correspondencias entre un tono (diferenciadopor su frecuencia)
										// y una combinacion de teclas
	// Constructor que asigna nombre a la cancion e inicializa colecciones
	public Cancion(String Nombre) {
		this.setNombre(Nombre);
		this.tempo = 90;
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new MapaDeTeclas();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
// 30<= tempo <= 150
	public void setTempo(int tempo)
	{
		if ((tempo<30)||(tempo>150)){
			throw new TempoInvalidoException();
		}
		this.tempo = tempo;
	}

	public int getTempo() {
		return tempo;
	}
	
	public MapaDeTeclas getMapeo(){
		return mapeo;
	}
	
	public void agregarCompas(Compas unCompas) {
		if (unCompas.estaInconcluso()){
			throw new CompasInvalidoExcepcion();
		}
		this.compaces.add(unCompas);
	}

	public void mapear(Nota nota, CombinacionDeTeclas combinacion){
		this.mapeo.agregarMapeo(nota, combinacion);
	}

	public Compas getCompas(int index){
		return this.compaces.get(index);
	}
	
	//devuelve el elemento de la cancion correspondiente al instante ingresado
	public ElementoDeCompas getElemento(double instante){
		Iterator<Compas> itCompaces=this.getIteratorCompaces();
		double LineaDeTiempo = 0.00; //Cuenta el tiempo transcurrido total a medida q se recorre la cancion
		boolean entro= false; //marca cuando entra en el rango de presicion entorno al elemento buscado 
		int compas=0; //cuenta los compaces recorridos
		int elemento=0; //cuenta los elementos recorridos (correspondiente a un compas)
		//Recorro los compaces hasta llegar al instante ingresado
		while(!entro&&itCompaces.hasNext()){
			Compas unCompas = itCompaces.next();
			Iterator<ElementoDeCompas> itElementos = unCompas.getIteratorElementos();
			elemento=0;
			while(itElementos.hasNext()&&!entro){
				ElementoDeCompas unElemento=itElementos.next();
				entro=this.entraEnElRangoDePresicion(LineaDeTiempo, instante); //"entra dentro del rango?"
				elemento++; 
				LineaDeTiempo += (double)(unElemento.getDuracion()/((this.getTempo()/60.00))); 
			}
			compas++;
			elemento--;
		}
		compas--;
		return this.getCompas(compas).getElemento(elemento);
	}
	
	
	
	public Iterator<Compas> getIteratorCompaces(){
		IteradorCliente<Compas> unIterator = new IteradorCliente<Compas>(this.compaces);
		return unIterator;
	}

	//Recive una combinacion de teclas y un instante en que fueron presionadas y devuelve true si 
	//coincide con el mapeo de la cancion en el instante indicado.
	
	public boolean chequear(CombinacionDeTeclas teclasPresionadas, double instante) {
		ElementoDeCompas unElemento=this.getElemento(instante); 
		return unElemento.chequear(this.getMapeo(), teclasPresionadas);
	}
/*** método auxiliar***/
	
	//devuelve true si el valor ingresado se encuentra dentro del rango de presicion entorno a entorno segun la presicion del juego 
	private boolean entraEnElRangoDePresicion(double valor,double entorno){ 
		return ((valor<=(entorno+Constantes.PRESICION))&&(valor>=(entorno-Constantes.PRESICION))); //0.25 es el rango de dificultad hay q meterlo en constantes o un atributo de cada cancion
	}
}
