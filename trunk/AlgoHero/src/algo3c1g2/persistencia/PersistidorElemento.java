package algo3c1g2.persistencia;

import org.jdom.Element;

import algo3c1g2.modelo.ElementoDeCompas;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.figura.*;


@SuppressWarnings("unused")
public class PersistidorElemento {

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

	@SuppressWarnings("unchecked")
	public ElementoDeCompas obtenerElemento(Element unElemento) {
		try {
			String nombreClase = unElemento.getTextNormalize();
			
			/*Creo una Clase cuyo nombre esta almacenado en el Elemento
			 * e instancio el objeto.
			 */
			Class unaClase = Class.forName(nombreClase);
			ElementoDeCompas elElemento = (ElementoDeCompas) unaClase.newInstance();
			
			/* Ahora obtengo la figura y la agrego al elemento de Compas
			 */
			Element elementoFigura = (Element) unElemento.getChild("Figura");
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
