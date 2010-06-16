package algo3c1g2.modelo;

import java.util.*;

import algo3c1g2.modelo.excepciones.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.*;

public class Cancion {

	//Tempo por default de una cancion
	private final static int TEMPO_DEFAULT = 90;
	
	//Nivel de presicion exigida en el juego (por ahora es constante) medida en segundos
	private final static double PRESICION = 0.20; 
	
	private String nombre;
	private int tempo; //[negras/minuto]
	private ArrayList<Compas> compaces;
	
	private MapaDeTeclas mapeo;
	/* mapeo: almacanena correspondencias entre un tono
	 * (diferenciado por su frecuencia) y una combinacion de teclas
	 */
	
	// Constructor por defecto sin parametros
	public Cancion() {
		this.setNombre("Sin Nombre");
		this.tempo = TEMPO_DEFAULT;
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new MapaDeTeclas();
	}
	
	// Constructor que asigna nombre a la cancion e inicializa colecciones
	public Cancion(String Nombre) {
		this.setNombre(Nombre);
		this.tempo = TEMPO_DEFAULT;
		this.compaces = new ArrayList<Compas>();
		this.mapeo = new MapaDeTeclas();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	/* Pre-condicion: El tempo debe estar en un valor entre 30 y 150
	 * Post-concicion: Si no se cumple la pre-condicion, se lanza una excepcion
	 */
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
	
	/* Pre-condicion: El compas a agregar debe estar completo (en terminos del tiempo)
	 * Post-concicion: Si no se cumple la pre-condicion, se lanza una excepcion
	 */
	public void agregarCompas(Compas unCompas) {
		if (unCompas.estaInconcluso()){
			throw new CompasInvalidoExcepcion();
		}
		this.compaces.add(unCompas);
	}

	public void mapear(Nota nota, CombinacionDeTeclas combinacion){
		this.mapeo.agregarMapeo(nota, combinacion);
	}

	
	/* Post-condicion: devuelve el elemento de la cancion correspondiente
	 * al instante ingresado
	 * TODO refactorizar el método
	 */
	public ElementoDeCompas getElemento(double instante){
		Iterator<Compas> itCompaces=this.getIteratorCompaces();
		double LineaDeTiempo = 0.00; //Cuenta el tiempo transcurrido total a medida q se recorre la cancion
		boolean LlegoAlElemento= false;  
		int ContadorCompas=0; 
		int ContadorElemento=0; 
		
		//Recorro los compaces hasta llegar al instante ingresado
		while(!LlegoAlElemento && itCompaces.hasNext()){
			Compas unCompas = itCompaces.next();
			Iterator<ElementoDeCompas> itElementos = unCompas.getIteratorElementos();
			ContadorElemento=0;//Reiniciamos el contador para el siguiente compas
			//Recorremos los elementos del compas 
			while(itElementos.hasNext() && !LlegoAlElemento){
				ElementoDeCompas unElemento = itElementos.next();
				LlegoAlElemento = this.entraEnElRangoDePresicion(LineaDeTiempo, instante);
				ContadorElemento++; 
				LineaDeTiempo += unElemento.getDuracionEnSegundos(this.getTempo()); 
			}
			ContadorCompas++;
		}
		ContadorElemento--;//Como siempre cuenta uno de mas le restamos uno al final
		ContadorCompas--; 
		return this.getCompas(ContadorCompas).getElemento(ContadorElemento);
	}
	
	/* Pre-condicion: Recibe una combinacion de teclas y un instante en que fueron presionadas
	 * Post-condicion: devuelve true si coincide con el mapeo de la cancion en el instante indicado.
	 */
	public boolean chequear(CombinacionDeTeclas teclasPresionadas, double instante) {
		ElementoDeCompas unElemento=this.getElemento(instante); 
		return unElemento.chequear(this.getMapeo(), teclasPresionadas);
	}
	
	
	/***
	 *  METODOS AUXILIARES INTERNOS
	 ***/
	
	private MapaDeTeclas getMapeo(){
		return mapeo;
	}
	
	private Iterator<Compas> getIteratorCompaces(){
		IteradorCliente<Compas> unIterator = new IteradorCliente<Compas>(this.compaces);
		return unIterator;
	}
	
	private Compas getCompas(int index){
		return this.compaces.get(index);
	}
	
	//devuelve true si el valor ingresado se encuentra dentro del rango de presicion entorno a entorno segun la presicion del juego 
	private boolean entraEnElRangoDePresicion(double valor,double entorno){ 
		return ((valor<=(entorno+PRESICION))&&(valor>=(entorno-PRESICION)));
	}
}
