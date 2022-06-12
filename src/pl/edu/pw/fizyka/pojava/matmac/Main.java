package pl.edu.pw.fizyka.pojava.matmac;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.SwingUtilities;


public class Main {
	static WindowFrame frame;
	static Locale currentLocale=new Locale("pl","PL");
	static ResourceBundle stats=ResourceBundle.getBundle("pl.edu.pw.fizyka.pojava.matmac.bundles.StatsBundle",currentLocale);
	
	public static void main(String[] args) {
		//this is project's main class
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				frame = new WindowFrame("Puszczanie kaczek");
				frame.setVisible(true);
				
				AmbienceRunnable ambience = new AmbienceRunnable();
				ExecutorService exec = Executors.newFixedThreadPool(1);
				exec.execute(ambience);
				exec.shutdown();
			}
		});
	}

}
