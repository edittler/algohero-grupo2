package algo3c1g2.vista.ventanas;

import java.awt.Component;

import javax.swing.JOptionPane;

public abstract class VentanaMensaje {

	public VentanaMensaje(Component ventana) {
		

		JOptionPane.showMessageDialog(ventana, this.getTexto(), this
				.getTitulo(), JOptionPane.INFORMATION_MESSAGE);
	}

	protected abstract String getTitulo();

	protected abstract String getTexto();

}
