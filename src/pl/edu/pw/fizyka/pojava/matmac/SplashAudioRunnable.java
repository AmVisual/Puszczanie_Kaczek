package pl.edu.pw.fizyka.pojava.matmac;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Class made by Maciej Standerski
//this class is responsible for playing splash sound
public class SplashAudioRunnable implements Runnable {
	
	boolean isSplash;
	
	public SplashAudioRunnable(boolean isSplash) {
		this.isSplash = isSplash;
	}

	@Override
	public void run() {
		String fileName = "audio/sink.wav";
		if(isSplash) {
			//if the sound is a splash sound, change the file name
			//picking random sound
			Random r = new Random();
			int nr = r.nextInt(5);
			fileName = "audio/splash" + Integer.toString(nr) + ".wav";
		}
		
		//file's URL
		URL file = getClass().getResource(fileName);
		try {
			//opening audio input stream
			AudioInputStream inputAudio = AudioSystem.getAudioInputStream(file);
			// getting a clip with sound
			Clip clip = AudioSystem.getClip();
			//opening and playing sound
			clip.open(inputAudio);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
}
