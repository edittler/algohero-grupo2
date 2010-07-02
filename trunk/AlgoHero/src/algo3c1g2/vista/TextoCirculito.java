package algo3c1g2.vista;

import java.awt.Graphics;

import algo3c1g2.modelo.Circulito;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.TextoEstatico;

public class TextoCirculito extends TextoEstatico {

	private int posicionCuerda;
	
	public TextoCirculito(String texto) {
		super(texto);

	}

	public void dibujar(SuperficieDeDibujo superfice) {
		this.setTexto(((Circulito)this.getPosicionable()).getTeclas());
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(this.getColor());
		grafico.setFont(fuente);
		grafico.drawString(getTexto(), this.posicionCuerda, this.getPosicionable().getY());
	}
	
	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;	
		switch(((Circulito)this.posicionable).getNumeroDeCuerda()){
		case 1: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_1;
		break;
		case 2: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_2;
		break;
		case 3: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_3;
		break;
		case 4: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_4;
		break;
		case 5: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_5;
		break;
		case 6: this.posicionCuerda=VistaCuerda.POSICION_CUERDA_6;
		break;
		default: this.posicionCuerda=0;
		}
	}
	
	

	
}
