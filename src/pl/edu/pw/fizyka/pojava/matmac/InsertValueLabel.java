package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

//class made by Maciej Standerski
//label describing InsertValueField
public class InsertValueLabel extends JLabel {

	public InsertValueLabel(String text) {
		super(text);
		//settings
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(Color.gray);
		this.setFont(new Font("Calibri", Font.PLAIN, 24));
	}

}
