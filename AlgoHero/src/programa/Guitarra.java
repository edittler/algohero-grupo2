package programa;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.nota.Do;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Circulo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Guitarra implements ObjetoVivo {

	private Cancion cancion;
	private double instanteActual;
	private ArrayList<ArrayList<Circulito>> cuerdas;
	private ControladorJuego controlador;
	private int puntos;
	private TextoEstatico puntosEnTexto;
	private VistaCirculito vista;
	
	
	public Guitarra(Cancion unaCancion,ArrayList<ArrayList<Circulito>> cuerdas,ControladorJuego controlador){
		this.cancion=unaCancion;
		this.instanteActual=0.00;
		this.cuerdas=cuerdas;
		this.controlador=controlador;
		this.puntos=0;
		TablaDePuntos Tabla=new TablaDePuntos(10,100);
		Cuadrado VistaPuntos=new Cuadrado(50,1);
		puntosEnTexto=new TextoEstatico(Integer.toString(this.puntos));
		puntosEnTexto.setPosicionable(Tabla);
		VistaPuntos.setPosicionable(Tabla);
		this.controlador.agregarDibujable(puntosEnTexto);
		this.controlador.agregarDibujable(VistaPuntos);
		this.vista = new VistaCirculito();
		vista.setColor(Color.GREEN);
	}
	@Override
	public void vivir() {
		this.addCirculito(cancion.getElemento(this.instanteActual));
		this.instanteActual+=0.015;
	}
	
	/*Habilita un Circulito dependiendo el Elemento que se pa*/
	
	private void addCirculito(ElementoDeCompas elemento) {
		if(elemento!=null){
			if(elemento.isNota()){
				Circulito unCirculito=((Nota)elemento).ubicarCuerda(this.cuerdas); //Obtiene una referencia al Circulito habilitado
				String TeclasEnTexto=this.cancion.getMapeo().obtenerCombinacion(((Nota)elemento)).getTeclasTexto(); //Obtiene la combinacion de teclas en formato Texto
				ObjetoTexto unObjetoTexto= new ObjetoTexto(TeclasEnTexto); 
				TextoDinamico unTexto= new TextoDinamico(unObjetoTexto);
				unTexto.setColor(Color.MAGENTA);
				unTexto.setPosicionable(unCirculito);
				this.controlador.agregarDibujable(unTexto);
			}
		}
	}
	
	//Chequea que el caracater presionado sea correcto en el instante que va de la cancion
	
	public void contarPuntos(char unChar){//TODO refactorizar y comentar
			CombinacionDeTeclas combi=new CombinacionDeTeclas();
			Tecla unaTecla= new Tecla(unChar);
			combi.agregarTecla(unaTecla);
			Iterator<ArrayList<Circulito>> itCuer=this.cuerdas.iterator();
			//Recorremos buscando Circulitos en el area de habilitacion
			while(itCuer.hasNext()){
			Iterator<Circulito> itCir = itCuer.next().iterator();
			while(itCir.hasNext()){
				Circulito unCirculito=itCir.next();

				if(this.entraEnElAreaDeHabilitacion(unCirculito)&&this.cancion.chequear(combi, this.getInstanteDeCancion())){ 
					if(Math.abs((double)(533-unCirculito.getY()))>18){
						this.puntos+=100;
					}
					else{
						this.puntos+=1000;
					}
//					this.controlador.removerDibujable(vista);
//					vista.setPosicionable(unCirculito);
//					this.controlador.agregarDibujable(vista);
				}

				puntosEnTexto.setTexto(Integer.toString(this.puntos));
			}
			}
			
	}

	private boolean entraEnElAreaDeHabilitacion(Circulito unCirculito){
		return (unCirculito.getY()<559)&&(unCirculito.getY()>507);
	}
	
	private double getInstanteDeCancion(){
		return this.instanteActual-4;
	}
	
}
