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

public class PersistidorMapeo {

	public Element persistir(MapaDeTeclas mapeo) {
		Element root = new Element(mapeo.getClass().getSimpleName());
		
		//Obtengo el mapeo.
		Hashtable<String, CombinacionDeTeclas> mapa = new Hashtable<String, CombinacionDeTeclas>();
		mapa = (Hashtable<String, CombinacionDeTeclas>) mapeo.getMapa();
		
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
	
	@SuppressWarnings("unchecked")
	public void cargarMapeo(Cancion unaCancion, Element unElementoMapa) {
		try {
			//Obtengo las claves y valores del Elemento y los cargo al mapeo
			List elementosClaves = unElementoMapa.getChildren("Clave");
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
