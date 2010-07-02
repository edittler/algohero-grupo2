package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Color;
import java.awt.Font;

public class TextoDinamico extends Texto {
	
	private ObjetoDeTexto objetoDeTexto;

	public TextoDinamico(ObjetoDeTexto objetoDeTexto) {
		super();
		this.objetoDeTexto = objetoDeTexto;
	}

	public TextoDinamico(ObjetoDeTexto objetoDeTexto, Color color, Font fuente) {
		super(color, fuente);
		this.objetoDeTexto = objetoDeTexto;
	}

	@Override
	protected String getTexto() {
		return this.objetoDeTexto.getTexto();
	}

}
