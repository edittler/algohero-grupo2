package grupo2.modelo;

import java.util.*;

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
	
	public ElementoDeCompas getElemento(int compas,int index){
		return this.compaces.get(compas).getElemento(index);
	}
	
	
	
	public Iterator<Compas> getIteratorCompaces(){
		IteradorCliente<Compas> unIterator = new IteradorCliente<Compas>(this.compaces);
		return unIterator;
	}

	public boolean chequear(CombinacionDeTeclas teclasPresionadas, double instante) {
		double LineaDeTiempo=0;
		boolean resultado = false;
		Iterator<Compas> itCompaces=this.getIteratorCompaces();
		boolean entro= false;
		while((!entro)&&(itCompaces.hasNext())){
			Compas unCompas = itCompaces.next();

			Iterator<ElementoDeCompas> itElementos = unCompas.getIteratorElementos();
			while(itElementos.hasNext()&&!entro){
				ElementoDeCompas unElemento = itElementos.next();
				
				if(this.entraEnElRango(LineaDeTiempo, instante)){
					resultado=unElemento.chequear(this.getMapeo(),teclasPresionadas);
					entro=true;
				}
				LineaDeTiempo += (double)(unElemento.getDuracion()/((this.getTempo()/60.00)));
			}
		}

		return resultado;
	}
/*** método auxiliar***/
	public boolean entraEnElRango(double valor,double entorno){
		return ((valor<=(entorno+0.25))&&(valor>=(entorno-0.25))); //0.25 es el rango de dificultad hay q meterlo en constantes o un atributo de cada cancion
	}
}
