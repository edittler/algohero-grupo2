package algo3c1g2.persistencia;

import org.jdom.Element;

import algo3c1g2.modelo.tecla.MapaDeTeclas;

public class PersistidorMapeo {

	public Element persistir(MapaDeTeclas mapeo){
		Element root = new Element(mapeo.getClass().getSimpleName());
		//como se puede guardar el Hastable????
		return root;
	}

}
