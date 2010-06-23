package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;
import java.awt.Font;

public class TextoEstatico extends Texto {

	private String texto;	
	
	public TextoEstatico(String texto) {
		super();
		this.texto = texto;
	}

	public TextoEstatico(String texto, Color color, Font fuente) {
		super(color, fuente);
		this.texto = texto;
	}

	@Override
	protected String getTexto() {
		return this.texto;
	}

}
