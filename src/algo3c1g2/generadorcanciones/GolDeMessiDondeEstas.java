package algo3c1g2.generadorcanciones;

import algo3c1g2.modelo.*;
import algo3c1g2.modelo.figura.*;
import algo3c1g2.modelo.nota.*;
import algo3c1g2.modelo.tecla.CombinacionDeTeclas;
import algo3c1g2.modelo.tecla.Tecla;

public class GolDeMessiDondeEstas extends GeneradorCancion {

	public GolDeMessiDondeEstas() {
		this.cancion = new Cancion("Gol de Messi donde estas");
		
		Compas unCompas = new Compas();
		unCompas.agregarElemento(new Silencio(new Blanca()));
		unCompas.agregarElemento(new Do(new Negra()));
		unCompas.agregarElemento(new Do(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Sol(new Negra()));
		unCompas.agregarElemento(new Sol(new Negra()));
		unCompas.agregarElemento(new La(new Negra()));
		unCompas.agregarElemento(new La(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Sol(new Blanca()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new Fa(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Re(new Negra()));
		unCompas.agregarElemento(new Re(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Do(new Blanca()));
		unCompas.agregarElemento(new Sol(new Negra()));
		unCompas.agregarElemento(new Sol(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Mi(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Re(new Negra()));
		unCompas.agregarElemento(new Re(new Negra()));
		unCompas.agregarElemento(new Sol(new Negra()));
		unCompas.agregarElemento(new Sol(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new Fa(new Negra()));
		unCompas.agregarElemento(new Mi(new Negra()));
		unCompas.agregarElemento(new Mi(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Re(new Negra()));
		unCompas.agregarElemento(new Re(new Negra()));
		unCompas.agregarElemento(new Do(new Negra()));
		unCompas.agregarElemento(new Do(new Negra()));
		cancion.agregarCompas(unCompas);

		unCompas = new Compas();
		unCompas.agregarElemento(new Sol(new Negra()));
		unCompas.agregarElemento(new Sol(new Negra()));
		unCompas.agregarElemento(new La(new Negra()));
		unCompas.agregarElemento(new La(new Negra()));
		cancion.agregarCompas(unCompas);
		
		unCompas = new Compas();
		unCompas.agregarElemento(new Sol(new Blanca()));
		unCompas.agregarElemento(new Silencio(new Blanca()));
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
		teclas.agregarTecla(new Tecla('F'));
		cancion.mapear(new Fa(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('F'));
		cancion.mapear(new FaSostenido(),teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('G'));
		cancion.mapear(new Sol(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('G'));
		cancion.mapear(new SolSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('H'));
		cancion.mapear(new La(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('H'));
		cancion.mapear(new LaSostenido(), teclas);
		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('J'));
		cancion.mapear(new Si(), teclas);
		

		
		teclas = new CombinacionDeTeclas();
		teclas.agregarTecla(new Tecla('G'));
		cancion.mapear(new La(), teclas);
	}

}
