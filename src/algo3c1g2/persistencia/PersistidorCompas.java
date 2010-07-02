package algo3c1g2.persistencia;

import java.util.Iterator;
import java.util.List;

import org.jdom.DataConversionException;
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

	@SuppressWarnings("unchecked")
	public Compas obtenerCompas(Element root) throws DataConversionException {
		//creo el compas a devolver
		Compas unCompas = new Compas();
		
		//agrego los atributos
		int numerador = (int) root.getAttribute("numerador").getLongValue();
		int denominador = (int) root.getAttribute("denominador").getLongValue();
		unCompas.setNumerador(numerador);
		unCompas.setDenominador(denominador);
				
		//ahora tengo que obtener los elementos del compas
		List elementos = root.getChildren("ElementoDeCompas");
		Iterator itElementos = elementos.iterator();
		PersistidorElemento unPersistidorCompas = new PersistidorElemento();
		
		//recorro la coleccion para cargar los elementos al compas
		while (itElementos.hasNext()){
			Element unElemento = (Element) itElementos.next();
			ElementoDeCompas unElementDeCompas = unPersistidorCompas.obtenerElemento(unElemento);
			unCompas.agregarElemento(unElementDeCompas);
		}
		
		return unCompas;
	}

}
