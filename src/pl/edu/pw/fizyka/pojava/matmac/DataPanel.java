package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//class made by Maciej Standerski
//right panel is responsible for inserting data
public class DataPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	//Stone stone; //stone object
	
	//fields
	static InsertValueField velocityField;
	static InsertValueField throwAngleField;
	static InsertValueField stoneAngleField;
	static InsertValueField massField;
	static InsertValueField heightField;
	static InsertValueField coefficientField;
	static PlayButton playButton;
	
	//labels
	static InsertValueLabel velocityLabel;
	static InsertValueLabel throwAngleLabel;
	static InsertValueLabel stoneAngleLabel;
	static InsertValueLabel massLabel;
	static InsertValueLabel heightLabel;
	static InsertValueLabel coefficientLabel;
	
	//reference to animation panel
	AnimationPanel animationPanel;
	ScorePanel scorePanel;
	
	public DataPanel() {
		super();
		JPanel container = new JPanel();
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
		this.add(container);
		container.setLayout(new GridLayout(13,1,0,10));
		Color bgColor = new Color(153, 255, 153);
		container.setBackground(bgColor);
		container.setBorder(BorderFactory.createLineBorder(bgColor, 15));
		
		//velocity
		velocityLabel = new InsertValueLabel("Prędkość rzutu [m/s]");
		container.add(velocityLabel);
		velocityField = new InsertValueField(1.0, 50.0, InsertValueField.VELOCITY, this);
		container.add(velocityField);
		
		//throw angle
		throwAngleLabel = new InsertValueLabel("Kąt rzutu (do osi OX) [o]");
		container.add(throwAngleLabel);
		throwAngleField = new InsertValueField(0.0, 85.0, InsertValueField.THROW_ANGLE, this);
		container.add(throwAngleField);
		
		//stone angle - the angle between stone's surface and x axis
		stoneAngleLabel = new InsertValueLabel("Kąt kamienia (do osi OX) [o]");
		container.add(stoneAngleLabel);
		stoneAngleField = new InsertValueField(0.0, 90.0, InsertValueField.STONE_ANGLE, this);
		container.add(stoneAngleField);
		
		//mass
		massLabel = new InsertValueLabel("Masa kamienia [g]");
		container.add(massLabel);
		massField = new InsertValueField(10.0, 100.0, InsertValueField.MASS, this);
		container.add(massField);
		
		//height
		heightLabel = new InsertValueLabel("Wysokość rzutu [m]");
		container.add(heightLabel);
		heightField = new InsertValueField(0.1, 1.5, InsertValueField.HEIGHT, this);
		container.add(heightField);
		
		//drag coefficient
		coefficientLabel = new InsertValueLabel("Wspóczynnik oporu powietrza [kg/s]");
		container.add(coefficientLabel);
		coefficientField = new InsertValueField(0.2, 0.6, InsertValueField.COEFFICIENT, this);
		container.add(coefficientField);
		
		//play button
		playButton = new PlayButton();
		playButton.addActionListener(this);
		container.add(playButton);
	}
	
	public AnimationPanel getAnimationPanel() {
		return animationPanel;
	}

	public void setAnimationPanel(AnimationPanel animationPanel) {
		this.animationPanel = animationPanel;
		//stone
		double velocity = velocityField.getValue();
		double throwAngle = throwAngleField.getValue();
		double stoneAngle = stoneAngleField.getValue();
		double mass = massField.getValue();
		double height = heightField.getValue();
		double coefficient = coefficientField.getValue();
				
		this.animationPanel.setStone(new Stone(velocity, throwAngle, stoneAngle, mass, height, coefficient));
	}
	
	//action listener for play button
	@Override
	public void actionPerformed(ActionEvent e) {
		Stone stone = this.getAnimationPanel().getStone();
		System.out.println("Velocity: " + stone.getVelocity());
		System.out.println("Throw angle: " + stone.getThrowAngle());
		System.out.println("Stone angle: " + stone.getStoneAngle());
		System.out.println("Mass: " + stone.getMass());
		System.out.println("Height: " + stone.getHeight());
		System.out.println("Coefficient: " + stone.getCoefficient());
		
		DataPanel.velocityField.setEnabled(false);
		DataPanel.throwAngleField.setEnabled(false);
		DataPanel.stoneAngleField.setEnabled(false);
		DataPanel.massField.setEnabled(false);
		DataPanel.heightField.setEnabled(false);
		DataPanel.coefficientField.setEnabled(false);
	}

}
