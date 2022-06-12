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
		//timer
		int timer = 0;
		//audio is active
		boolean activeAudio = true;
		//audio file comes from https://www.soundjay.com/lake-sound-effects.html
		String fileName = "audio/lake.wav";
		
		//file's URL
		URL file = getClass().getResource(fileName);
		
		AudioInputStream inputAudio = null;
		Clip clip = null;
		
		while(true) {
			
			//sound off - stop audio
			if(activeAudio && ScorePanel.soundButtonMode == 0) {
				clip.stop();
				activeAudio = false;
			}
				
			//sound on - play audio
			if(!activeAudio && ScorePanel.soundButtonMode == 1) {
				timer = 0;
				activeAudio = true;
			}
			
			if(timer == 10000)
				timer = 0; //set timer to 0 when 10000 miliseconds passed
			
			if(timer == 0 && activeAudio) {
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
			}
			
			if(activeAudio)
				timer++;
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
