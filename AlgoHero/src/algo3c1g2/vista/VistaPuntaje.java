package algo3c1g2.vista;

import java.awt.Graphics;

import algo3c1g2.modelo.Puntaje;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class VistaPuntaje extends TextoEstatico {

	public final static int PosicionCentralDelAreaHabilitada= 500;

	private final static int PosicionPuntajeX = 50;
	private final static int PosicionPuntajeY = 50;
	
	public VistaPuntaje(String texto) {
		super(texto);
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		String PuntosEnString=Integer.toString(((Puntaje)this.posicionable).getPuntos());
		this.setTexto(PuntosEnString);
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(this.getColor());
		grafico.setFont(fuente);
		grafico.drawString(getTexto(), VistaPuntaje.PosicionPuntajeX, VistaPuntaje.PosicionPuntajeY);
	}

	
}
