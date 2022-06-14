package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

//class made by Maciej Standerski
//text field for inserting values
public class InsertValueField extends JTextField implements ActionListener {
	
	double minValue, maxValue; //value the user inserts must be in this range: [minValue,maxValue]
	double lastValue; //last given value
	DataPanel dataPanel; //reference to data panel
	
	int labelType; //which parameter the field gets
	
	//labeTypes
	public static final int VELOCITY = 0;
	public static final int THROW_ANGLE = 1;
	public static final int STONE_ANGLE = 2;
	public static final int MASS = 3;
	public static final int HEIGHT = 4;
	public static final int COEFFICIENT = 5;
	
	public InsertValueField(double minValue, double maxValue, int labelType, DataPanel dataPanel) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.labelType = labelType;
		this.dataPanel = dataPanel;
		
		//settings
		this.setText(Double.toString((minValue + maxValue) / 2));
		this.setFont(new Font("Calibri", Font.PLAIN, 24));
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setToolTipText(Main.stats.getString("dz") + minValue + "," + maxValue + "]");
		this.lastValue = Double.parseDouble(this.getText());
		
		this.addActionListener(this);
		this.addFocusListener(new FieldFocusListener());
	}
	
	
	//getters and setters
	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
	
	public double getValue() {
		return Double.parseDouble(this.getText());
	}
	
	//private method for listeners
	void insertValue() {
		try {
			//get text from the field
			String text = this.getText();
			text = text.replace(',', '.'); //replaces commas with dots
			this.setText(text);
			double value;
			value = Double.parseDouble(text);
			
			if(value < minValue) {
				//if value is too small, set to minValue
				this.setText(Double.toString(minValue));
				value = Double.parseDouble(this.getText());
				this.lastValue = Double.parseDouble(this.getText());
				System.out.println("Given value is less than " + minValue);
			}
			else if(value > maxValue) {
				//if value is too big, set to maxValue
				this.setText(Double.toString(maxValue));
				value = Double.parseDouble(this.getText());
				this.lastValue = Double.parseDouble(this.getText());
				System.out.println("Given value is greater than " + maxValue);
			}
			else {
				//set the last given value
				this.lastValue = Double.parseDouble(text);
			}
			
			//reference to stone
			Stone stone = dataPanel.getAnimationPanel().getStone();
			//set value to stone
			switch(labelType) {
				case VELOCITY:
					stone.setVelocity(value);
					break;
				case THROW_ANGLE:
					stone.setThrowAngle(value);
					break;
				case STONE_ANGLE:
					stone.setStoneAngle(value);
					break;
				case MASS:
					stone.setMass(value);
					break;
				case HEIGHT:
					stone.setHeight(value);
					break;
				case COEFFICIENT:
					stone.setCoefficient(value);
					break;
				default:
					System.out.println("The label has no type");
					break;
			}
			
			//repaint animation panel
			dataPanel.getAnimationPanel().repaint();
			
		}
		catch(NumberFormatException exception) {
			//if text is not a number format
			System.out.println("The given format is not a number");
			this.setText(Double.toString(lastValue));
		}
	}
	
	//action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		insertValue();
	}
	//focus listener
	public class FieldFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			InsertValueField.this.setText("");
		}

		@Override
		public void focusLost(FocusEvent e) {
			insertValue();
		}
	}
}
