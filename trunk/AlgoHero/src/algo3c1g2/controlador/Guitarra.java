package algo3c1g2.controlador;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;


import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import algo3c1g2.vista.Circulito;
import algo3c1g2.vista.ObjetoTexto;
import algo3c1g2.vista.TablaDePuntos;
import algo3c1g2.vista.VistaCirculito;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class Guitarra implements ObjetoVivo {

	private static int UBICACION_CUERDA_1=168;
	private static int UBICACION_CUERDA_2=257;
	private static int UBICACION_CUERDA_3=345;
	private static int UBICACION_CUERDA_4=427;
	private static int UBICACION_CUERDA_5=504;
	private static int UBICACION_CUERDA_6=576;
	
	//Presicion con la que se obtiene un elemento
	private static double PRESICION_ELEMENTO = 0.0075; 
	
	//Presicion admitida por la simulacion del juego
	private static double PRESICION_SIMULACION = 0.8;
	
	//Intervalo de tiempo en el que transcurre la simulacion
	private static final double TIEMPO_INTERVALO_SIMULACION = 0.015;
	
	private Cancion cancion;
	private double instanteActual;
	private ArrayList<Cuerda> cuerdas;
	private ControladorJuego controlador;
	private TextoEstatico puntosEnTexto;
	private TablaDePuntos tablaPuntos;
	private int elementosNulos;
	
	public Guitarra(Cancion unaCancion,ControladorJuego controlador){
		this.cancion=unaCancion;
		this.instanteActual=0.00;
		//creamos las 6 cuerdas, cada una crea una cuerda con una ubicacion (en el mástil) con 5 circulitos habilitables 
		this.cuerdas=new ArrayList<Cuerda>();
		this.cuerdas.add(new Cuerda(Guitarra.UBICACION_CUERDA_1,5));
		this.cuerdas.add(new Cuerda(Guitarra.UBICACION_CUERDA_2,5));
		this.cuerdas.add(new Cuerda(Guitarra.UBICACION_CUERDA_3,5));
		this.cuerdas.add(new Cuerda(Guitarra.UBICACION_CUERDA_4,5));
		this.cuerdas.add(new Cuerda(Guitarra.UBICACION_CUERDA_5,5));
		this.cuerdas.add(new Cuerda(Guitarra.UBICACION_CUERDA_6,5));
		
		this.controlador=controlador;
		this.controlador.setIntervaloSimulacion(15);
		this.agregarCirculosAControlador();
		this.crearTablaDePuntos();
		
		//esto no es necesario lo agrege para q termine el juego despues hay q cambiarlo TODO
		this.elementosNulos=0;
	}
	


	@Override
	public void vivir() {
		this.addCirculito(cancion.getElemento(this.instanteActual,Guitarra.PRESICION_ELEMENTO));
		this.instanteActual+=TIEMPO_INTERVALO_SIMULACION;
	}
	
	
	//Agrega un circulito al juego
	//TODO Hay """""malos olores""""" en estos métodos si encuentran algo avisenme asi lo corregimos!
	private void addCirculito(ElementoDeCompas elemento) {
		
		if(elemento!=null){
			
			if(elemento.isNota()){
				
				//Obtiene la combinacion de teclas en formato Texto
				String TeclasEnTexto=this.cancion.getMapeo().obtenerCombinacion(((Nota)elemento)).getTeclasTexto();
				
				//Habilita un Circulito en la Cuerda correspondiente a la Nota y obtiene una referencia al Circulito habilitado
				Circulito unCirculito = this.habilitarUnNuevoCirculito(((Nota)elemento).getCuerda());

				this.adjuntarTextoACirculito(TeclasEnTexto, unCirculito);
			}
		}
		else//TODO cambiar esto!
		{
			this.elementosNulos++;
			if(this.elementosNulos==1000){
				this.controlador.detenerJuego();
				System.out.print("SE TERMINO EL JUEGO");
			}
		}
	}
	

	
	//Chequea que el caracater presionado sea correcto en el instante que va de la cancion
	
	public void contarPuntos(char unChar){
		CombinacionDeTeclas unaCombinacionTeclas = new CombinacionDeTeclas();
		Tecla unaTecla = new Tecla(unChar);
		unaCombinacionTeclas.agregarTecla(unaTecla);
		Iterator<Cuerda> itCuerdas = this.cuerdas.iterator();
		int cuerda=0;
		boolean conto=false;
		
		//Recorremos buscando Circulitos en el area de habilitacion
		while(itCuerdas.hasNext()&&!conto){
			Iterator<Circulito> itCir = itCuerdas.next().iterator();
			cuerda++;

			while(itCir.hasNext()&&!conto){
				Circulito unCirculito=itCir.next();

				//chequeo si es correcto 
				if(this.cancion.chequear(unaCombinacionTeclas, this.getInstanteDeCancion(), Guitarra.PRESICION_SIMULACION)){
					this.tablaPuntos.contarPuntos(unCirculito.getY());
					conto=this.tablaPuntos.conto(unCirculito.getY());

					if(conto){ //TODO REFACTORIZAME!!!
						VistaCirculito vista = this.cuerdas.get(cuerda-1).getVista(unCirculito);
						vista.setColor(Color.GREEN);
					}
				}
				
				puntosEnTexto.setTexto(Integer.toString(this.tablaPuntos.getPuntos()));
			}
		}
	}



	
	/****** Métodos Auxiliares*******/
	
	private void crearTablaDePuntos(){
		this.tablaPuntos=new TablaDePuntos(10,100);
		Cuadrado VistaPuntos=new Cuadrado(50,1);
		puntosEnTexto = new TextoEstatico(Integer.toString(this.tablaPuntos.getPuntos()));
		puntosEnTexto.setPosicionable(this.tablaPuntos);
		VistaPuntos.setPosicionable(this.tablaPuntos);
		this.controlador.agregarDibujable(puntosEnTexto);
		this.controlador.agregarDibujable(VistaPuntos);
	}
	
	
	private void adjuntarTextoACirculito(String TeclasEnTexto,Circulito unCirculito){
		ObjetoTexto unObjetoTexto = new ObjetoTexto(TeclasEnTexto);
		TextoDinamico unTexto = new TextoDinamico(unObjetoTexto);
		unTexto.setColor(Color.YELLOW);
		unTexto.setPosicionable(unCirculito);
		this.controlador.agregarDibujable(unTexto);
	}
	
	private void agregarCirculosAControlador() {
		Iterator<Cuerda> itCuer=this.cuerdas.iterator();
		while(itCuer.hasNext()){
			Cuerda unaCuerda=itCuer.next();
			Iterator<Circulito> itCir=unaCuerda.iterator();
			Iterator<VistaCirculito> itVistas=unaCuerda.iteratorVista();
			while(itCir.hasNext()&&itVistas.hasNext()){
				this.controlador.agregarObjetoVivo(itCir.next());
				this.controlador.agregarDibujable(itVistas.next());
			}
		}
	}
	
	/*Busca y habilita un Circulito en la cuerda indicada*/
	private Circulito habilitarUnNuevoCirculito(int cuerda) {
		return this.cuerdas.get(cuerda-1).habilitarUnCirculito();
		}
	
	/*Obtiene el instante de reproduccion de la musica*/
	private double getInstanteDeCancion(){
		return this.instanteActual-4;//HARDCODEAR EL 4 (ES UN CAMBIO DE VARIABLE ENTRE EL INSTANTE DE OBTENCION DE NOTAS Y REPRODUCCION (X-CTE)
	}
	
}