package algo3c1g2.vista;

import java.awt.Color;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;

public class VistaMesa extends Cuadrado implements SuperficieDeDibujo {

	
	public VistaMesa() {
		super(100,559);
		setColor(Color.BLACK);
	}

	@Override
	public void actualizar() {
		
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getBuffer() {
		// TODO Auto-generated method stub
		return null;
	}

}
