package algo3c1g2.persistencia;

import org.jdom.Element;

public class PersistidorPartida {

	public Element persistir(String text){
		Element root = new Element("Partida");
		root.setText(text);
		Element Puntos = new Element("Puntos");
		root.addContent(Puntos);
		
		
		
		return root;
	}
}
