package grupo2.modelo;


import java.util.ArrayList;
import java.util.Iterator;

public class IteradorCliente<T> implements Iterator<T> {
		
		private Iterator<T> itCliente;
		
		public IteradorCliente(ArrayList<T> unaLista){
			this.itCliente = unaLista.iterator();
		}
		
		@Override
		public boolean hasNext() {
			
			return this.itCliente.hasNext();
		}
		
		@Override
		public T next() {
			
			return this.itCliente.next();
		}

		@Override
		public void remove() {
			/* Como no hay necesidad de que el cliente elimine los elementos
			 * del compas, se deja este metodo en blanco
			 */
		}
		
	}

