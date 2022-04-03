package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

//panel for the animation
public class AnimationPanel extends JPanel {
	
	//stone object
	Stone stone;
	
	//reference to dataPanel
	DataPanel dataPanel;

	public AnimationPanel() {
		JLabel info = new JLabel("Animacja");
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setFont(new Font("Calibri", Font.PLAIN, 24));
		this.setLayout(new GridLayout(1,1));
		this.add(info);
	}

	public AnimationPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public AnimationPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public AnimationPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public Stone getStone() {
		return stone;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}

	public void setDataPanel(DataPanel dataPanel) {
		this.dataPanel = dataPanel;
	}

}
