package po.matmac;

import java.awt.Font;

import javax.swing.JTextField;

//class made by Maciej Standerski
//text field for inserting values
public class InsertValueField extends JTextField {
	
	double minValue, maxValue; //value the user inserts must be in this range: [minValue,maxValue]
	
	public InsertValueField(double minValue, double maxValue) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
		
		//settings
		this.setText(Double.toString((minValue + maxValue) / 2));
		this.setFont(new Font("Calibri", Font.PLAIN, 24));
		this.setHorizontalAlignment(JTextField.CENTER);
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

}
