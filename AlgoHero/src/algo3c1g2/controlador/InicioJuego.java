package algo3c1g2.controlador;

import algo3c1g2.ControladorJuego;
import algo3c1g2.ObjetoVivo;
import algo3c1g2.SuperficieDeDibujo;
import algo3c1g2.vista.*;



public class InicioJuego implements ObjetoVivo{
	
	private ControladorJuego controlador = null;
	
	
	
	public InicioJuego(SuperficieDeDibujo superficieDeDibujo){
		Pentagrama pentagrama = new Pentagrama(600,600);
		
		controlador = new ControladorJuego();
		controlador.setSuperficieDeDibujo(superficieDeDibujo);
		
		VistaPentagrama vistaPentagrama = new VistaPentagrama();
		vistaPentagrama.setPosicionable(pentagrama);
		controlador.agregarDibujable(vistaPentagrama);
		controlador.setIntervaloSimulacion(20);
			
	}
	
	
	public void comenzar(){
		controlador.comenzarJuegoAsyn();	
	}

	public void detener() {
		controlador.detenerJuego();
	}


	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}

}