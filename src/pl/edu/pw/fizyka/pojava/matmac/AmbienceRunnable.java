package pl.edu.pw.fizyka.pojava.matmac;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AmbienceRunnable implements Runnable {

	@Override
	public void run() {
		//audio file comes from https://www.soundjay.com/lake-sound-effects.html
		String fileName = "audio/lake.wav";
		
		//file's URL
		URL file = getClass().getResource(fileName);
		
		AudioInputStream inputAudio = null;
		Clip clip = null;
		
		while(true) {
			try {
				//opening audio input stream
				inputAudio = AudioSystem.getAudioInputStream(file);
				// getting a clip with sound
				clip = AudioSystem.getClip();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			//opening and playing sound
			try {
				clip.open(inputAudio);
			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			clip.start();
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
