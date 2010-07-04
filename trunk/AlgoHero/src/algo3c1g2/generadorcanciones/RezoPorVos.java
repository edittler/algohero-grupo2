package algo3c1g2.generadorcanciones;

import algo3c1g2.modelo.*;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.*;

public class RezoPorVos extends GeneradorCancion {

	public RezoPorVos() {
		this.cancion = new Cancion("Rezo por vos");
		/* el tempo de esta cancion, para que se asemeje a la real
		 * deberia ser por lo menos 115. 
		 */
		
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Silencio(new Corchea()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Si(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas(8,4);
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Mi(new Negra()));;
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Si(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas(8,4);
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Si(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas(8,4);
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Si(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas(8,4);
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Si(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas(8,4);
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new LaSostenido(new Negra()));
		unCompas.agregarElemento(new Do(new Corchea()));
		unCompas.agregarElemento(new Si(new Negra()));
		unCompas.agregarElemento(new Fa(new Corchea()));
		unCompas.agregarElemento(new Do(new Corchea()));
		cancion.agregarCompas(unCompas);
		
		CombinacionDeTeclas teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		cancion.mapear(new Do(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('A'));
		cancion.mapear(new DoSostenido(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('S'));
		cancion.mapear(new Re(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('S'));
		cancion.mapear(new ReSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('D'));
		cancion.mapear(new Mi(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('D'));
		cancion.mapear(new Fa(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('F'));
		cancion.mapear(new FaSostenido(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('F'));
		cancion.mapear(new Sol(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('G'));
		cancion.mapear(new SolSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('G'));
		cancion.mapear(new La(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('H'));
		cancion.mapear(new LaSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('H'));
		cancion.mapear(new Si(), teclas);
	}
}
