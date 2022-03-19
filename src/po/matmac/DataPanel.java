package po.matmac;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//class made by Maciej Standerski
//right panel is responsible for inserting data
public class DataPanel extends JPanel {

	Stone stone; //stone object
	
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
		InsertValueField velocityField = new InsertValueField(1.0, 50.0);
		container.add(velocityField);
		
		//throw angle
		InsertValueLabel throwAngleLabel = new InsertValueLabel("K¹t rzutu (do osi OX) [o]");
		container.add(throwAngleLabel);
		InsertValueField throwAngleField = new InsertValueField(0.0, 85.0);
		container.add(throwAngleField);
		
		//stone angle - the angle between stone's surface and x axis
		InsertValueLabel stoneAngleLabel = new InsertValueLabel("K¹t kamienia (do osi OX) [o]");
		container.add(stoneAngleLabel);
		InsertValueField stoneAngleField = new InsertValueField(0.0, 90.0);
		container.add(stoneAngleField);
		
		//mass
		InsertValueLabel massLabel = new InsertValueLabel("Masa kamienia [g]");
		container.add(massLabel);
		InsertValueField massField = new InsertValueField(10.0, 100.0);
		container.add(massField);
		
		//height
		InsertValueLabel heightLabel = new InsertValueLabel("Wysokoœæ rzutu [m]");
		container.add(heightLabel);
		InsertValueField heightField = new InsertValueField(10.0, 150.0);
		container.add(heightField);
		
		//drag coefficient
		InsertValueLabel coefficientLabel = new InsertValueLabel("Wspó³czynnik oporu powietrza [kg/s]");
		container.add(coefficientLabel);
		InsertValueField coefficientField = new InsertValueField(0.2, 0.6);
		container.add(coefficientField);
		
		//play button
		PlayButton playButton = new PlayButton();
		container.add(playButton);
		
		//add stone object
		double velocity = velocityField.getValue();
		double throwAngle = throwAngleField.getValue();
		double stoneAngle = stoneAngleField.getValue();
		double mass = massField.getValue();
		double height = heightField.getValue();
		double coefficient = coefficientField.getValue();
		this.stone = new Stone(velocity, throwAngle, stoneAngle, mass, height, coefficient);
	}
	
	//getter for stone object
	public Stone getStone() {
		return stone;
	}
	
	

}
