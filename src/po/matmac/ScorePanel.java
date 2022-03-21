package po.matmac;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//top panel shows the best shot and the latest shot, as well as saves them in the chosen file
public class ScorePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel panelLeft=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelRight=new JPanel();
	ScoreLabel label1=new ScoreLabel("Najlepszy rzut:");
	ScoreLabel label2=new ScoreLabel("Liczba odbiæ: n");
	ScoreLabel label3=new ScoreLabel("Odleg³oœæ: s");
	ScoreLabel label4=new ScoreLabel("Czas lotu: t");
	ScoreLabel label5=new ScoreLabel("Ostatni rzut:");
	ScoreLabel label6=new ScoreLabel("Liczba odbiæ: n");
	ScoreLabel label7=new ScoreLabel("Odleg³oœæ: s");
	ScoreLabel label8=new ScoreLabel("Czas lotu: t");
	ImageIcon icon1;
	JButton button1=new JButton("Zapisz");
	JButton button2=new JButton("Zapisz");
	JButton button3;
	JButton button4=new JButton("PL/EN");
	JButton button5=new JButton("HISTORIA");
	
	
	
	
	public ScorePanel() {
		super();
		setLayout(new GridLayout(1,3));
		
		//splitting ScorePanel into 3 panels
		add(panelLeft);
		add(panelCenter);
		add(panelRight);
		//working on left panel
		panelLeft.setBackground(Color.black);
		panelLeft.setLayout(new GridBagLayout());
		//adding "Najlepszy rzut:" label
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.5;
		c.weighty=0.5;
		c.insets=new Insets(5,5,5,5);
		label1.setHorizontalAlignment(JLabel.CENTER);
		panelLeft.add(label1,c);
		//adding "Liczba odbiæ: n" label
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(5,5,5,5);
		panelLeft.add(label2,c);
		//adding "Zapisz" button
		c.gridx=0;
		c.gridy=1;
		c.gridheight=2;
		c.ipady=10;
		c.insets=new Insets(5,15,5,15);
		button1.setBackground(Color.green);
		button1.setForeground(Color.white);
		button1.setFont(new Font("Calibri", Font.PLAIN,24));
		panelLeft.add(button1,c);
		//adding "Odleg³oœæ: s" label
		c.gridx=1;
		c.gridy=1;
		c.gridheight=1;
		c.ipady=0;
		c.insets=new Insets(5,5,5,5);
		panelLeft.add(label3,c);
		//adding "Czas lotu: t" label
		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(0,5,0,5);
		panelLeft.add(label4,c);
		
		
		//working on center panel
		panelCenter.setBackground(Color.black);
		panelCenter.setLayout(new GridBagLayout());
		//adding "Ostatni rzut:" label
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.5;
		c.weighty=0.5;
		c.insets=new Insets(5,5,5,5);
		label5.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(label5,c);
		//adding "Liczba odbiæ: n" label
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(label6,c);
		//adding "Zapisz" button
		c.gridx=0;
		c.gridy=1;
		c.gridheight=2;
		c.ipady=10;
		c.insets=new Insets(5,15,5,15);
		button2.setBackground(Color.green);
		button2.setForeground(Color.white);
		button2.setFont(new Font("Calibri", Font.PLAIN,24));
		panelCenter.add(button2,c);
		//adding "Odleg³oœæ: s" label
		c.gridx=1;
		c.gridy=1;
		c.gridheight=1;
		c.ipady=0;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(label7,c);
		//adding "Czas lotu: t" label
		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(5,5,5,5);
		panelCenter.add(label8,c);
		
		
		//working on right panel
		panelRight.setBackground(Color.black);
		panelRight.setLayout(new GridBagLayout());
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.5;
		c.weighty=0.5;
		c.insets=new Insets(20,10,20,10);
		//adding music icon to button1
		ImageIcon icon1=new ImageIcon("D:\\Maciek\\PO\\puszczanie_kaczek\\src\\po\\matmac\\images\\sound.png");
		button3=new JButton(icon1);
		button3.setBackground(Color.green);
		panelRight.add(button3,c);
		
		c.gridx=1;
		c.gridy=0;
		button4.setBackground(Color.green);
		button4.setForeground(Color.white);
		button4.setFont(new Font("Calibri", Font.PLAIN, 20));
		panelRight.add(button4,c);
		c.gridx=2;
		c.gridy=0;
		button5.setBackground(Color.green);
		button5.setForeground(Color.white);
		button5.setFont(new Font("Calibri", Font.PLAIN, 20));
		panelRight.add(button5,c);
		
	}
}
