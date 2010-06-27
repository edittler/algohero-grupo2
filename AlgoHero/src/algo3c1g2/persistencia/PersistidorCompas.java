package algo3c1g2.persistencia;

import java.util.Iterator;

import org.jdom.Element;

import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.ElementoDeCompas;

public class PersistidorCompas {

	@SuppressWarnings("unchecked")
	public Element persistir(Compas unCompas) {
		Element root = new Element(unCompas.getClass().getSimpleName());
		
		//Guardo los atributos...
		Integer numeradorInteger = unCompas.getNumerador();
		Integer denominadorInteger = unCompas.getDenominador();
		root.setAttribute("numerador", numeradorInteger.toString());
		root.setAttribute("denominador", denominadorInteger.toString());
			
		//Almaceno la lista de compaces en un nodo hijo
		Iterator itElementos = unCompas.getIteratorElementos();
		PersistidorElemento unPersistidorElemento = new PersistidorElemento();
		
		//recorro la coleccion ElementosDeCompas y los voy persistiendo
		while (itElementos.hasNext()){
			ElementoDeCompas unElemento = (ElementoDeCompas) itElementos.next();
			Element unNodoCompas = unPersistidorElemento.persistir(unElemento);
			root.addContent(unNodoCompas);
		}
		
		return root;
	}

}
