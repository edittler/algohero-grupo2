package algo3c1g2.persistencia;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.jdom.Element;

import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.MapaDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;

public class PersistidorMapeo {

	@SuppressWarnings("unchecked")
	public Element persistir(MapaDeTeclas mapeo) {
		try {
			Element root = new Element(mapeo.getClass().getName());
		
			//Obtengo el mapeo.
			Field campo;
			campo = mapeo.getClass().getDeclaredField("mapa");
			campo.setAccessible(true);
			// --- INICIO DEL PROBLEMA!! HELP!!!
			Hashtable<String, CombinacionDeTeclas> mapa = new Hashtable<String, CombinacionDeTeclas>();
			mapa = (Hashtable<String, CombinacionDeTeclas>) campo.get(mapa);
			
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
		
		} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
