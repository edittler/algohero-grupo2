package algo3c1g2.persistencia;

import java.io.FileOutputStream;
import java.util.Iterator;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import algo3c1g2.modelo.Cancion;
import algo3c1g2.modelo.Compas;

public class PersistidorCancion {

	
	@SuppressWarnings({ "unchecked" })
	public void persistir(Cancion unaCancion){
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
		
		// Ahora almacenamos en disco
		XMLOutputter outputter = new XMLOutputter (Format.getPrettyFormat());
		try{
			String rutaArchivo = unaCancion.getNombre() + ".xml";
			outputter.output (new Document(root),new FileOutputStream (rutaArchivo));
		   } catch (Exception e){
		    e.getMessage();
		}
	}
	
	

}

