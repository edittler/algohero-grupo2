package algo3c1g2.vista;

import ar.uba.fi.algo3.titiritero.Posicionable;

public class TablaDePuntos implements Posicionable {

	private int x;
	private int y;
	private int puntos;
	private final static int PosicionCentralDelAreaHabilitada= 533;
	private final static int RangoDeMaximaPresicion= 18;
	private final static int RangoDePresicionNormal= 26;
	private final static int PuntosMaximaPresicion=1000;
	private final static int PuntosPresicionNormal=100;
	private final static int PosicionInicialDelAreaDeHabilitacion=TablaDePuntos.PosicionCentralDelAreaHabilitada-TablaDePuntos.RangoDePresicionNormal;
	private final static int PosicionFinalDelAreaDeHabilitacion=TablaDePuntos.PosicionCentralDelAreaHabilitada+TablaDePuntos.RangoDePresicionNormal;
	
	public TablaDePuntos(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
	
	public int getPuntos(){
		return this.puntos;
	}

	public void contarPuntos(int Posicion){

		if(Math.abs((int)(TablaDePuntos.PosicionCentralDelAreaHabilitada-Posicion))>TablaDePuntos.RangoDeMaximaPresicion){
			this.puntos+=TablaDePuntos.PuntosPresicionNormal;
		}
		else{
			this.puntos+=TablaDePuntos.PuntosMaximaPresicion;
		}
		
	}
	
	public boolean estaDentroDelRango(int Posicion){
		return ((Posicion<TablaDePuntos.PosicionFinalDelAreaDeHabilitacion)&&(Posicion>TablaDePuntos.PosicionInicialDelAreaDeHabilitacion)); 
	}
	
}
