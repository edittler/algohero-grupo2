package algo3c1g2.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import algo3c1g2.modelo.IteradorCliente;
import algo3c1g2.modelo.nota.Nota;
import algo3c1g2.vista.Circulito;
import algo3c1g2.vista.VistaCirculito;

public class Cuerda {

	private ArrayList<Circulito> circulitos;
	private ArrayList<VistaCirculito> vistas;
	
	public Cuerda(int ubicacionDeLaCuerda, int cantidadCirculitos){
		this.circulitos=new ArrayList<Circulito>();
		this.vistas=new ArrayList<VistaCirculito>();
		Circulito unCirculito = null;
		VistaCirculito vistaCir = null;
		for(int i=0; i<cantidadCirculitos; i++){
			unCirculito = new Circulito(ubicacionDeLaCuerda);
			vistaCir = new VistaCirculito();
			vistaCir.setPosicionable(unCirculito);
			unCirculito.setDibujable(vistaCir);
			this.circulitos.add(unCirculito);
			this.vistas.add(vistaCir);
		}
	}
	
	
	public Iterator<Circulito> iterator(){
		IteradorCliente<Circulito> unIterator = new IteradorCliente<Circulito>(this.circulitos);
		return unIterator;
	}
	
	
	public Iterator<VistaCirculito> iteratorVista(){
		IteradorCliente<VistaCirculito> unIterator = new IteradorCliente<VistaCirculito>(this.vistas);
		return unIterator;
	}
	
	
	/*Habilita el 1er circulito que encuentra deshabilitado en la cuerda*/
	public Circulito habilitarUnCirculito(Nota nota){
		Iterator<Circulito> itCir = this.iterator();
		
		Circulito unCirculito=null;
		boolean habilito = false;
		while(itCir.hasNext()&&(!habilito)){ //Recorro los circulitos de la cuerda
			unCirculito=itCir.next();
			
			if(!unCirculito.estaHabilitado()){ //Si no esta habilitado lo habilito y termino el while
				unCirculito.habilitar();
				habilito=true;
				unCirculito.setNota(nota);
			}
		}
		return unCirculito; //Devuelvo el Circulito habilitado
	}
	
	
	public VistaCirculito getVista(Circulito unCirculito){
		Iterator<VistaCirculito> itVista= this.vistas.iterator();
		VistaCirculito resultado=null;
		boolean encontro=false;
		while(itVista.hasNext()&&!encontro){
			resultado=itVista.next();
			encontro=(resultado.getPosicionable()==unCirculito);
		}
		return resultado;
	}
	
}
