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

	Stone stone; //stone object
	
	//fields
	InsertValueField velocityField;
	InsertValueField throwAngleField;
	InsertValueField stoneAngleField;
	InsertValueField massField;
	InsertValueField heightField;
	InsertValueField coefficientField;
	
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
		InsertValueLabel velocityLabel = new InsertValueLabel("Prêdkoœæ rzutu [m/s]");
		container.add(velocityLabel);
		velocityField = new InsertValueField(1.0, 50.0, InsertValueField.VELOCITY, this);
		container.add(velocityField);
		
		//throw angle
		InsertValueLabel throwAngleLabel = new InsertValueLabel("K¹t rzutu (do osi OX) [o]");
		container.add(throwAngleLabel);
		throwAngleField = new InsertValueField(0.0, 85.0, InsertValueField.THROW_ANGLE, this);
		container.add(throwAngleField);
		
		//stone angle - the angle between stone's surface and x axis
		InsertValueLabel stoneAngleLabel = new InsertValueLabel("K¹t kamienia (do osi OX) [o]");
		container.add(stoneAngleLabel);
		stoneAngleField = new InsertValueField(0.0, 90.0, InsertValueField.STONE_ANGLE, this);
		container.add(stoneAngleField);
		
		//mass
		InsertValueLabel massLabel = new InsertValueLabel("Masa kamienia [g]");
		container.add(massLabel);
		massField = new InsertValueField(10.0, 100.0, InsertValueField.MASS, this);
		container.add(massField);
		
		//height
		InsertValueLabel heightLabel = new InsertValueLabel("Wysokoœæ rzutu [m]");
		container.add(heightLabel);
		heightField = new InsertValueField(10.0, 150.0, InsertValueField.HEIGHT, this);
		container.add(heightField);
		
		//drag coefficient
		InsertValueLabel coefficientLabel = new InsertValueLabel("Wspó³czynnik oporu powietrza [kg/s]");
		container.add(coefficientLabel);
		coefficientField = new InsertValueField(0.2, 0.6, InsertValueField.COEFFICIENT, this);
		container.add(coefficientField);
		
		//stone
		double velocity = velocityField.getValue();
		double throwAngle = throwAngleField.getValue();
		double stoneAngle = stoneAngleField.getValue();
		double mass = massField.getValue();
		double height = heightField.getValue();
		double coefficient = coefficientField.getValue();
		
		this.stone = new Stone(velocity, throwAngle, stoneAngle, mass, height, coefficient);
		
		//play button
		PlayButton playButton = new PlayButton();
		playButton.addActionListener(this);
		container.add(playButton);
	}
	
	//getter for stone object
	public Stone getStone() {
		return stone;
	}
	
	//action listener for play button
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Velocity: " + this.stone.getVelocity());
		System.out.println("Throw angle: " + this.stone.getThrowAngle());
		System.out.println("Stone angle: " + this.stone.getStoneAngle());
		System.out.println("Mass: " + this.stone.getMass());
		System.out.println("Height: " + this.stone.getHeight());
		System.out.println("Coefficient: " + this.stone.getCoefficient());
		
		this.velocityField.setEnabled(false);
		this.throwAngleField.setEnabled(false);
		this.stoneAngleField.setEnabled(false);
		this.massField.setEnabled(false);
		this.heightField.setEnabled(false);
		this.coefficientField.setEnabled(false);
	}

}
