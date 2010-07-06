package algo3c1g2.persistencia;

import org.jdom.DataConversionException;
import org.jdom.Element;

import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.figura.*;

/**
 * Clase de persistencia externa del {@code ElementoDeCompas}.
 * Utiliza las librerias JDOM.
 * 
 * @author Ezequiel Pérez Dittler
 */
@SuppressWarnings("unused")
public class PersistidorElemento {

	/**
	 * Persiste el {@code ElementoDeCompas} y sus atributos.
	 * 
	 * @param unElemento {@code ElementoDeCompas} a persistir.
	 * @return Retorna el {@code Element} correspondiente a un nodo XML.
	 */
	public Element persistir(ElementoDeCompas unElemento) {
		Element root = new Element("ElementoDeCompas");
		root.setText(unElemento.getClass().getName());
		
		/* Como cada nota ya tiene asociada su frecuencia,
		 * solo guardo la figura correspondiente.
		 */
		Element unElementoFigura = new Element("Figura");
		unElementoFigura.setText(unElemento.getFigura().getClass().getName());
		root.addContent(unElementoFigura);
		
		return root;
	}

	/**
	 * Obtiene el {@code ElementoDeCompas} a traves de un {@code Element}.
	 * 
	 * @param root Nodo raiz que deberia contener el {@code ElementoDeCompas}.
	 * @return Devuelve el {@code ElementoDeCompas} obtenido.
	 * @throws DataConversionException Si el elemento no tiene {@code ElementoDeCompas}.
	 */
	@SuppressWarnings("unchecked")
	public ElementoDeCompas obtenerElemento(Element root) {
		try {
			String nombreClase = root.getTextNormalize();
			
			/*Creo una Clase cuyo nombre esta almacenado en el Elemento
			 * e instancio el objeto.
			 */
			Class unaClase = Class.forName(nombreClase);
			ElementoDeCompas elElemento = (ElementoDeCompas) unaClase.newInstance();
			
			/* Ahora obtengo la figura y la agrego al elemento de Compas
			 */
			Element elementoFigura = (Element) root.getChild("Figura");
			String nombreFigura = elementoFigura.getTextNormalize();
			Class unaClaseFigura = Class.forName(nombreFigura);
			Figura unaFigura = (Figura) unaClaseFigura.newInstance();
			
			elElemento.setFigura(unaFigura);
			
			return elElemento;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
