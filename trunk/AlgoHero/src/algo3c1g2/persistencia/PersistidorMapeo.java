package algo3c1g2.persistencia;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jdom.DataConversionException;
import org.jdom.Element;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.*;

/**
 * Clase de persistencia externa del {@code Mapeo}.
 * Utiliza las librerias JDOM.
 * 
 * @author Ezequiel Pérez Dittler
 */
public class PersistidorMapeo {

	/**
	 * Persiste el {@code MapaDeTeclas} junto con sus claves y valores.
	 * 
	 * @param unMapeo {@code MapaDeTeclas} a persistir.
	 * @return Retorna el {@code Element} correspondiente a un nodo XML.
	 */
	public Element persistir(MapaDeTeclas unMapeo) {
		Element root = new Element(unMapeo.getClass().getSimpleName());
		
		//Obtengo el mapeo.
		Hashtable<String, CombinacionDeTeclas> mapa = new Hashtable<String, CombinacionDeTeclas>();
		mapa = (Hashtable<String, CombinacionDeTeclas>) unMapeo.getMapa();
		
		//Obtengo las claves del mapeo
		Set<String> claves = mapa.keySet();
		Iterator<String> itClaves = claves.iterator();
		
		//recorro las claves y las persisto junto con su valor
		while (itClaves.hasNext()){
			String nombreClave = itClaves.next();
			Element elementoClave = new Element ("Clave");
			elementoClave.setText(nombreClave);
			
			//persisto el valor de la clave
			Element elementoValor = this.persistirValor((CombinacionDeTeclas) mapa.get(nombreClave));
			elementoClave.addContent(elementoValor);
			root.addContent(elementoClave);
		}
			
		return root;
	}
	
	/**
	 * Carga el {@code MapaDeTeclas} en la {@code Cancion} dada.
	 * 
	 * @param unaCancion {@code Cancion} en la que se desea cargar el {@code MapaDeTeclas}.
	 * @param root Nodo raiz que deberia contener el {@code MapaDeTeclas}.
	 */
	@SuppressWarnings("unchecked")
	public void cargarMapeo(Cancion unaCancion, Element root) {
		try {
			//Obtengo las claves y valores del Elemento y los cargo al mapeo
			List elementosClaves = root.getChildren("Clave");
			Iterator itElementosClaves = elementosClaves.iterator();
					
			while (itElementosClaves.hasNext()){
				Element unElementoClave = (Element) itElementosClaves.next();
				
				//Obtengo la nota y tecla asociada y las agrego al mapeo
				Nota unaNota = this.obtenerNota(unElementoClave);
				CombinacionDeTeclas unaCombi = this.obtenerCombinacionDeTeclas(unElementoClave);
				
				unaCancion.mapear(unaNota, unaCombi);
			}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DataConversionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@SuppressWarnings("unchecked")
	private Nota obtenerNota(Element unElemento) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Obtengo el nombre de la nota y la instancio
		String nombreClase = unElemento.getTextNormalize();
		Class unaClase = Class.forName(nombreClase);
		Nota unaNota = (Nota) unaClase.newInstance();
		
		return unaNota;
	}
	
	@SuppressWarnings("unchecked")
	private CombinacionDeTeclas obtenerCombinacionDeTeclas(Element unElemento) throws DataConversionException {
		//Obtengo las Teclas y las cargo en una combinacion de teclas
		Element unElementoValor = unElemento.getChild("Valor");
		List elementosTeclas = unElementoValor.getChildren("Tecla");
		Iterator itElementosTeclas = elementosTeclas.iterator();
				
		CombinacionDeTeclas unaCombi = new CombinacionDeTeclas();
		
		while (itElementosTeclas.hasNext()){
			Element unElementoTecla = (Element) itElementosTeclas.next();
			int codigoASCII = (int) unElementoTecla.getAttribute("codigoASCII").getLongValue();
			
			Tecla unaTecla = new Tecla(codigoASCII);
			unaCombi.agregarTecla(unaTecla);
		}
		
		return unaCombi;
	}

	private Element persistirValor(CombinacionDeTeclas combinacionDeTeclas) {
		Element root = new Element ("Valor");
		
		/* Como la combinacion de teclas puede tener varias teclas,
		 * Debo obtener la coleccion de teclas y persistirlas.
		 * Almaceno los codigos ASCII de las teclas
		 */
		Iterator<Tecla> itTeclas = combinacionDeTeclas.getIteradorTeclas();
		
		while (itTeclas.hasNext()){
			Tecla unaTecla = itTeclas.next();
			Integer codigoASCII = unaTecla.getCodigoASCII();
			Element elementoTecla = new Element ("Tecla");
			elementoTecla.setAttribute("codigoASCII", codigoASCII.toString());
			
			root.addContent(elementoTecla);
		}
		
		return root;
	}

}
