package po.matmac;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ScoreLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public ScoreLabel(String text) {
		super(text);
		setHorizontalAlignment(JLabel.LEFT);
		setForeground(Color.white);
		setFont(new Font("Calibri", Font.PLAIN,24));
	}

	

}
