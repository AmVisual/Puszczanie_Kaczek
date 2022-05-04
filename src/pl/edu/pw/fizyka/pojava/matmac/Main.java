package pl.edu.pw.fizyka.pojava.matmac;


import java.util.Locale;
import java.util.ResourceBundle;


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
			}
		});
	}

}
