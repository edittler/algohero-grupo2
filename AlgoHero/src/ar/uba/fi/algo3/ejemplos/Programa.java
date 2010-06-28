package ar.uba.fi.algo3.ejemplos;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
			 	ejemplo1();
		    } catch (Exception e)
		    {
		        e.printStackTrace();
		    }
	}
	
	public static void ejemplo1() throws MidiUnavailableException, InterruptedException{
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();

        MidiChannel[] channels = synthesizer.getChannels();

        channels[0].noteOn(69, 93);
        Thread.sleep(2000);
        channels[0].noteOff(69);

        synthesizer.close();
	}
}