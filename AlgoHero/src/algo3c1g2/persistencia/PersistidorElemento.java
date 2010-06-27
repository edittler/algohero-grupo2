package algo3c1g2.persistencia;

import org.jdom.Element;

import algo3c1g2.modelo.ElementoDeCompas;


public class PersistidorElemento {

	public Element persistir(ElementoDeCompas unElemento) {
		Element root = new Element(unElemento.getClass().getSimpleName());
		
		/* Como cada nota ya tiene asociada su frecuencia,
		 * solo guardo la figura correspondiente.
		 */
		Element unElementoFigura = new Element(unElemento.getFigura().getClass().getSimpleName());
		root.addContent(unElementoFigura);
		
		return root;
	}

}
