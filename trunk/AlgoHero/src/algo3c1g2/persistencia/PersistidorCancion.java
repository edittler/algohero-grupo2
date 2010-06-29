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

public class PersistidorCancion {

	
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
	 * 
	 * @param unaCancion Cancion a persistir
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
	
	@SuppressWarnings("unchecked")
	public Cancion cagarCancion(String rutaArchivo){
		try {
			SAXBuilder builder = new SAXBuilder();
			
			Document doc = builder.build(new FileInputStream(rutaArchivo));
			Element root = doc.getRootElement();
			String nombre = root.getAttributeValue("nombre");
			int tempo = (int) root.getAttribute("tempo").getLongValue();
			
			Cancion unaCancion = new Cancion(nombre);
			unaCancion.setTempo(tempo);
			
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
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataConversionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CompasInvalidoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}

