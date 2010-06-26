package programa;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class Guitarra implements ObjetoVivo {

	private static int UbicacionCuerda1=168;
	private static int UbicacionCuerda2=257;
	private static int UbicacionCuerda3=345;
	private static int UbicacionCuerda4=427;
	private static int UbicacionCuerda5=504;
	private static int UbicacionCuerda6=576;
	
	private static double presicion = 0.0075; //es la presicion con la que se obtiene un elemento
	private static double presicion2 = 0.8;   //es la presicion que admite el juego
	
	private Cancion cancion;
	private double instanteActual;
	private ArrayList<Cuerda> cuerdas;
	private ControladorJuego controlador;
	private TextoEstatico puntosEnTexto;
	private TablaDePuntos puntos;
	private int elementosNulos;
	
	public Guitarra(Cancion unaCancion,ControladorJuego controlador){
		this.cancion=unaCancion;
		this.instanteActual=0.00;
		//creamos las 6 cuerdas, cada una crea una cuerda con una ubicacion (en el mástil) con 5 circulitos habilitables 
		this.cuerdas=new ArrayList<Cuerda>();
		this.cuerdas.add(new Cuerda(Guitarra.UbicacionCuerda1,5));
		this.cuerdas.add(new Cuerda(Guitarra.UbicacionCuerda2,5));
		this.cuerdas.add(new Cuerda(Guitarra.UbicacionCuerda3,5));
		this.cuerdas.add(new Cuerda(Guitarra.UbicacionCuerda4,5));
		this.cuerdas.add(new Cuerda(Guitarra.UbicacionCuerda5,5));
		this.cuerdas.add(new Cuerda(Guitarra.UbicacionCuerda6,5));
		
		this.controlador=controlador;
		this.controlador.setIntervaloSimulacion(15);
		this.agregarCirculosAControlador();
		this.crearTablaDePuntos();
		this.elementosNulos=0; //esto no es necesario lo agrege para q termine el juego despues hay q cambiarlo TODO
	}
	


	@Override
	public void vivir() {
		this.addCirculito(cancion.getElemento(this.instanteActual,this.presicion));
		this.instanteActual+=0.015;//el intervalo de simulacion
	}
	
	
	//Agrega un circulito al juego
	//TODO Hay """""malos olores""""" en estos métodos si encuentran algo avisenme asi lo corregimos!
	private void addCirculito(ElementoDeCompas elemento) {
		if(elemento!=null){
			if(elemento.isNota()){
				String TeclasEnTexto=this.cancion.getMapeo().obtenerCombinacion(((Nota)elemento)).getTeclasTexto(); //Obtiene la combinacion de teclas en formato Texto
				Circulito unCirculito = this.habilitarUnNuevoCirculito(((Nota)elemento).getCuerda()); //Habilita un Circulito en la Cuerda correspondiente a la Nota y obtiene una referencia al Circulito habilitado

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
			CombinacionDeTeclas combi=new CombinacionDeTeclas();
			Tecla unaTecla= new Tecla(unChar);
			combi.agregarTecla(unaTecla);
			Iterator<Cuerda> itCuer=this.cuerdas.iterator();
			int cuerda=0;
			boolean conto=false;
			//Recorremos buscando Circulitos en el area de habilitacion
			while(itCuer.hasNext()&&!conto){
			Iterator<Circulito> itCir = itCuer.next().iterator();
			cuerda++;
			while(itCir.hasNext()&&!conto){
				Circulito unCirculito=itCir.next();
				//chequeo si es correcto 
				if(this.cancion.chequear(combi, this.getInstanteDeCancion(), this.presicion2)){
				
					this.puntos.contarPuntos(unCirculito.getY());
					conto=this.puntos.conto(unCirculito.getY());
					if(conto){ //TODO REFACTORIZAME!!!
						VistaCirculito vista = this.cuerdas.get(cuerda-1).getVista(unCirculito);
						vista.setColor(Color.GREEN);
					}
				}
				puntosEnTexto.setTexto(Integer.toString(this.puntos.getPuntos()));
			}
			}
	}



	
	/****** Métodos Auxiliares*******/
	
	private void crearTablaDePuntos(){
	this.puntos=new TablaDePuntos(10,100);
	Cuadrado VistaPuntos=new Cuadrado(50,1);
	puntosEnTexto=new TextoEstatico(Integer.toString(this.puntos.getPuntos()));
	puntosEnTexto.setPosicionable(this.puntos);
	VistaPuntos.setPosicionable(this.puntos);
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
