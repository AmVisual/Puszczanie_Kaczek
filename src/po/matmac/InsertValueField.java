package po.matmac;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

//class made by Maciej Standerski
//text field for inserting values
public class InsertValueField extends JTextField implements ActionListener {
	
	double minValue, maxValue; //value the user inserts must be in this range: [minValue,maxValue]
	double lastValue; //last given value
	DataPanel dataPanel; //reference to data panel
	
	String labelType; //which parameter the field gets
	
	//labeTypes
	public static final String VELOCITY = "VELOCITY";
	public static final String THROW_ANGLE = "THROW_ANGLE";
	public static final String STONE_ANGLE = "STONE_ANGLE";
	public static final String MASS = "MASS";
	public static final String HEIGHT = "HEIGHT";
	public static final String COEFFICIENT = "COEFFICIENT";
	
	public InsertValueField(double minValue, double maxValue, String labelType, DataPanel dataPanel) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.labelType = labelType;
		this.dataPanel = dataPanel;
		
		//settings
		this.setText(Double.toString((minValue + maxValue) / 2));
		this.setFont(new Font("Calibri", Font.PLAIN, 24));
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setToolTipText("Dopuszczalny zakres: [" + minValue + "," + maxValue + "]");
		this.lastValue = Double.parseDouble(this.getText());
		
		this.addActionListener(this);
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
	
	//action listener
	@Override
	public void actionPerformed(ActionEvent e) {
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
			
			//set value to stone
			switch(labelType) {
				case "VELOCITY":
					dataPanel.getStone().setVelocity(value);
					break;
				case "THROW_ANGLE":
					dataPanel.getStone().setThrowAngle(value);
					break;
				case "STONE_ANGLE":
					dataPanel.getStone().setStoneAngle(value);
					break;
				case "MASS":
					dataPanel.getStone().setMass(value);
					break;
				case "HEIGHT":
					dataPanel.getStone().setHeight(value);
					break;
				case "COEFFICIENT":
					dataPanel.getStone().setCoefficient(value);
					break;
				default:
					System.out.println("The label has no type");
					break;
			}
			
		}
		catch(NumberFormatException exception) {
			//if text is not a number format
			System.out.println("The given format is not a number");
			this.setText(Double.toString(lastValue));
		}
		
	}

}
