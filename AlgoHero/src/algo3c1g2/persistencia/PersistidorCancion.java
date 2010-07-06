package algo3c1g2.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.DataConversionException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Compas;
import algo3c1g2.modelo.excepciones.CompasInvalidoExcepcion;

/**
 * Clase de persistencia externa de la {@code Cancion}.
 * Utiliza las librerias JDOM.
 * 
 * @author Ezequiel Pérez Dittler
 */
public class PersistidorCancion {
	
	/**
	 * Persiste la cancion, sus compaces, notas y el mapeo asociado.
	 * 
	 * @param unaCancion {@code Cancion} a persistir.
	 * @return Retorna el {@code Element} correspondiente a un nodo XML.
	 */
	@SuppressWarnings({ "unchecked" })
	public Element persistir(Cancion unaCancion){
		//Nombra al elemento raiz con el nombre de la clase
		Element root = new Element (unaCancion.getClass().getSimpleName());
		
		// Agrego los atributos 
		root.setAttribute("nombre", unaCancion.getNombre());
		Integer tempo = unaCancion.getTempo();
		root.setAttribute("tempo", tempo.toString());
		
		//Almaceno el mapeo en un nodo hijo
		PersistidorMapeo unPersistidorMapeo = new PersistidorMapeo();
		Element mapaDeTeclas = unPersistidorMapeo.persistir(unaCancion.getMapeo());
		root.addContent(mapaDeTeclas);
				
		//Almaceno la lista de compaces en un nodo hijo
		Iterator itCompaces = unaCancion.getIteratorCompaces();
		PersistidorCompas unPersistidorCompas = new PersistidorCompas();
		
		//recorro la coleccion de compaces y los voy persistiendo
		while (itCompaces.hasNext()){
			Compas unCompas = (Compas) itCompaces.next();
			Element unNodoCompas = unPersistidorCompas.persistir(unCompas);
			root.addContent(unNodoCompas);
		}
		
		return root;
	}
	
	/**
	 * Persiste la cancion, sus compaces, notas, el mapeo asociado
	 * y la almacena en la ruta especificada.
	 * 
	 * @param unaCancion Cancion a persistir.
	 * @param rutaArchivo Ruta del archivo que se debe ingresar con el siguiente formato: "archivo.xml"
	 */
	public void persistirYGuardar(Cancion unaCancion, String rutaArchivo){
		//Obtengo el elemento nodo de Cancion
		Element root = this.persistir(unaCancion);

		// Ahora almacenamos en disco
		try{
			XMLOutputter outputter = new XMLOutputter (Format.getPrettyFormat());
			outputter.output (new Document(root),new FileOutputStream (rutaArchivo));
		} catch (Exception e){
		    e.getMessage();
		}
	}
	
	/**
	 * Carga {@code Cancion} a partir de un archivo XML.
	 * 
	 * @param rutaArchivo Ruta del archivo XML donde se encuentra almacenada
	 * 					  la {@code Cancion} almacenada.
	 * 					  El formato debe ser: "archivo.xml"
	 * @return Si no hubo errores, devuelve la {@code Cancion}, sino retorna un elemento nulo.
	 * @throws FileNotFoundException En caso que no encuentre el archivo especificado.
	 */
	@SuppressWarnings("unchecked")
	public Cancion cargarCancion(String rutaArchivo) throws FileNotFoundException{
		try {
			// Obtengo el Documento del Archivo y lo proceso
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new FileInputStream(rutaArchivo));
			Element root = doc.getRootElement();
			
			//Obtengo los atributos del Elemento
			String nombre = root.getAttributeValue("nombre");
			int tempo = (int) root.getAttribute("tempo").getLongValue();
			
			//Creo la cancion e inicializo sus atributos
			Cancion unaCancion = new Cancion(nombre);
			unaCancion.setTempo(tempo);
			
			//Obtengo el Mapeo y lo cargo a la cancion
			Element unElementoMapa = root.getChild("MapaDeTeclas");
			PersistidorMapeo unPersistidorMapeo = new PersistidorMapeo();
			unPersistidorMapeo.cargarMapeo(unaCancion, unElementoMapa);
			
			//Obtengo los compaces y los cargo a la cancion
			List elementosCompaces = root.getChildren("Compas");
			Iterator itElementosCompaces = elementosCompaces.iterator();
			PersistidorCompas unPersistidorCompas = new PersistidorCompas();
			
			while (itElementosCompaces.hasNext()){
				Element unElementoCompas = (Element) itElementosCompaces.next();
				Compas unCompas = unPersistidorCompas.obtenerCompas(unElementoCompas);
				unaCancion.agregarCompas(unCompas);
			}
			
			/* FALTA AGREGAR QUE DESERIALIZE EL MAPEO,
			 * QUE TODAVIA NO SE PERSISTE
			 */
			return unaCancion;
		
		} catch (DataConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (CompasInvalidoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	

}

