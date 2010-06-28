package ar.uba.fi.algo3.titiritero.audio;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public abstract class Instrumento {

	private Synthesizer synthesizer = null;
	private MidiChannel canal = null;
	
	public Instrumento(int numeroDeCanal){
        try {
			this.synthesizer = MidiSystem.getSynthesizer();
	        this.synthesizer.open();
	        this.canal = synthesizer.getChannels()[numeroDeCanal];

		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract void reproducir(int numeroDeNota, int duracion);
	

	public void finalize(){
		synthesizer.close();
		try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void reproducirAsinc(int numeroDeNota, int duracion){
        try {
            this.canal.noteOn(numeroDeNota, 93);
			Thread.sleep(duracion);
	        this.canal.noteOff(numeroDeNota);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
// http://tomscarff.110mb.com/midi_analyser/midi_note_numbers_for_octaves.htm