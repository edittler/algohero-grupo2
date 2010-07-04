package algo3c1g2.controlador;

import java.awt.event.KeyEvent;

import algo3c1g2.modelo.Guitarra;
import algo3c1g2.modelo.Puntaje;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class Escuchador implements KeyPressedObservador {

        private Guitarra guitarra;
        private Puntaje puntaje;
        private boolean estaPresionado;

        public Escuchador(Guitarra guitarra,Puntaje puntaje) {
                this.guitarra = guitarra;
                this.puntaje = puntaje;
        }

        @Override
        public void keyPressed(KeyEvent event) {
                if (!this.estaPresionado) { //no le hagan caso a este if
                        this.estaPresionado = true;
                        double instante=this.guitarra.getInstanteActual();
                        char tecla=(char) event.getKeyCode();
                        boolean acerto=this.puntaje.contarPuntos(instante, tecla);
                        if(acerto){
                        this.guitarra.reproducir(puntaje.getElementoAReproducir(instante-Puntaje.TIEMPO_ENTRE_MENSAJE_Y_ACCION),instante-Puntaje.TIEMPO_ENTRE_MENSAJE_Y_ACCION,Puntaje.PRESICION_DEL_JUEGO);
                        }
                        
                } else {
                        this.estaPresionado = false;
                }
        }

}