package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;

//panel for the animation
public class AnimationPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	//stone object
	Stone stone;
	//motion track
	MotionTrack track;
	//reference to dataPanel
	DataPanel dataPanel;
	
	//constants for graphics
	final double waterLevel = 0.2;	//water level is a line at the height of waterLevel*animationPanelHeight
	//parameters for graphics
	double bankPosition = 0.1; //position of river bank is BankPosition*animationPanelWidth
	int[] coordinateOrigin; //position of coordinate system origin
	int[] startingPoint; //position of the stone
	int scale = 300; //number of pixels per 1 meter
	
	//animation
	boolean animation = false; //is the panel in initial state or in animation state
	
	public AnimationPanel() {
		this.setBackground(Color.CYAN);
		coordinateOrigin = new int[2];
		startingPoint = new int[2];
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//get width and height
		int width = this.getWidth();
		int height = this.getHeight();
		
		//coordinate system origin
		coordinateOrigin[0] = (int)(this.bankPosition*width); //bank position
		coordinateOrigin[1] = (int)((1-this.waterLevel)*height); //water level
		
		//water level
		int waterLevel = coordinateOrigin[1];
		g.setColor(Color.BLUE);
		g.fillRect(0, waterLevel, width, height-waterLevel);
		
		//river bank
		int bankPosition = coordinateOrigin[0];
		g.setColor(Color.ORANGE);
		g.fillRect(0, waterLevel, bankPosition, height-waterLevel);
		
		if(animation) {
			track.paint(g, scale, waterLevel, bankPosition, width, height, stone);
		}
		else {
			//stone
			this.startingPoint[0] = bankPosition;
			this.startingPoint[1] = waterLevel - (int)(this.getStone().getHeight()*scale);
			
			stone.paint(g, startingPoint[0], startingPoint[1], scale);
			//arrow
			Arrow.paint(g, startingPoint[0], startingPoint[1], stone.getThrowAngle(), stone.getVelocity(), scale);
		}
		
	}
	
	//getters and setters
	public Stone getStone() {
		return stone;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

	public MotionTrack getTrack() {
		return track;
	}

	public void setTrack(MotionTrack track) {
		this.track = track;
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}

	public void setDataPanel(DataPanel dataPanel) {
		this.dataPanel = dataPanel;
	}

}
