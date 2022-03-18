package po.matmac;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PlayButton extends JButton implements ActionListener {
	
	public PlayButton() {
		super();
		//settings
		this.setText("Rzuæ!");
		this.setFont(new Font("Calibri", Font.PLAIN, 28));
		this.setBackground(Color.red);
		this.addActionListener(this);
	}
	
	//action listener - when pressed, the button is unable to use until the animation is over
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);
	}

}
