package programa;

import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

public class ObjetoTexto implements ObjetoDeTexto {

	private String texto;
	
	public ObjetoTexto(String texto){
		this.texto=texto;
	}
	
	@Override
	public String getTexto() {
		return this.texto;
	}

}
