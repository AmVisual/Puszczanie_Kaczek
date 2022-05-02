package pl.edu.pw.fizyka.pojava.matmac;

import javax.swing.SwingUtilities;

public class Main {
	static WindowFrame frame;
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
