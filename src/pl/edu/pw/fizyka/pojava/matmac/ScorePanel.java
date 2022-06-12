package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

//top panel shows the best shot and the latest shot, as well as saves them in the chosen file
public class ScorePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	JPanel panelLeft=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelRight=new JPanel();
	
	ScoreLabel label1=new ScoreLabel("Najlepszy rzut");
	ScoreLabel label2=new ScoreLabel("Liczba odbić:");
	ScoreLabel label3=new ScoreLabel("Odległość:");
	ScoreLabel label4=new ScoreLabel("Czas lotu:");
	ScoreLabel label5=new ScoreLabel("Ostatni rzut");
	ScoreLabel label6=new ScoreLabel("Liczba odbić:");
	ScoreLabel label7=new ScoreLabel("Odległość:");
	ScoreLabel label8=new ScoreLabel("Czas lotu:");
	static ScoreLabel labelN1=new ScoreLabel(" ");
	static ScoreLabel labelN2=new ScoreLabel(" ");
	static ScoreLabel labelS1=new ScoreLabel(" ");
	static ScoreLabel labelS2=new ScoreLabel(" ");
	static ScoreLabel labelT1=new ScoreLabel(" ");
	static ScoreLabel labelT2=new ScoreLabel(" ");

	ImageIcon icon1=new ImageIcon(getClass().getResource("images/sound.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/soundoff.png"));
	JButton button1=new JButton("Zapisz");
	JButton button2=new JButton("Zapisz");
	JButton button3=new JButton(icon1);
	JButton button4=new JButton("PL/EN");
	JButton button5=new JButton("Historia");
	JButton button6=new JButton("Zapisz");
	JButton button7=new JButton("Zamknij");
	JFileChooser chooser=new JFileChooser();
	JEditorPane pane=new JEditorPane();
	static int soundButtonMode=1;
	int languageMode=0;
	String dialogTitle="Historia";
	
	
	//data panel reference
	DataPanel dataPanel;
	
	//history
	static ArrayList<double[]> history;
	
	public ScorePanel(DataPanel dataPanel) {
		super();
		this.dataPanel = dataPanel;
		history = new ArrayList<double[]>();
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
		c.weightx=1;
		c.weighty=1;
		c.insets=new Insets(5,5,5,5);
		//label1.setHorizontalAlignment(JLabel.CENTER);
		panelLeft.add(label1,c);
		//adding "Liczba odbiï¿½: n" label
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
		//adding "Odlegï¿½oï¿½ï¿½: s" label
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
		
		c.gridx=2;
		c.gridy=0;
		panelLeft.add(labelN1,c);
		
		c.gridx=2;
		c.gridy=1;
		panelLeft.add(labelS1,c);
		
		c.gridx=2;
		c.gridy=2;
		panelLeft.add(labelT1,c);
		
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
		//adding "Liczba odbiï¿½: n" label
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
		//adding "Odlegï¿½oï¿½ï¿½: s" label
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
		
		c.gridx=2;
		c.gridy=0;
		panelCenter.add(labelN2,c);
		
		c.gridx=2;
		c.gridy=1;
		panelCenter.add(labelS2,c);
		
		c.gridx=2;
		c.gridy=2;
		panelCenter.add(labelT2,c);
		
		//working on right panel
		panelRight.setBackground(Color.black);
		panelRight.setLayout(new GridBagLayout());
		c.gridx=0;
		c.gridy=0;
		c.weightx=0.5;
		c.weighty=0.5;
		c.gridheight=2;
		c.insets=new Insets(20,10,20,10);
		//adding music button
		button3.setBackground(Color.green);
		panelRight.add(button3,c);
		//adding language switch button
		c.gridx=1;
		c.gridy=0;
		c.gridheight=1;
		c.insets=new Insets(20,10,5,5);
		button4.setBackground(Color.green);
		button4.setForeground(Color.white);
		button4.setFont(new Font("Calibri", Font.PLAIN, 20));
		panelRight.add(button4,c);
		//adding history button
		c.gridx=2;
		c.gridy=0;
		c.insets=new Insets(20,5,5,10);
		button5.setBackground(Color.green);
		button5.setForeground(Color.white);
		button5.setFont(new Font("Calibri", Font.PLAIN, 20));
		panelRight.add(button5,c);
		
		//adding exit button
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=2;
		c.insets=new Insets(5,10,20,10);
		button7.setBackground(Color.green);
		button7.setForeground(Color.white);
		button7.setFont(new Font("Calibri", Font.PLAIN, 20));
		panelRight.add(button7,c);
		
		//adding listeners
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button1.setActionCommand("1");
		button2.setActionCommand("2");
		button3.setActionCommand("3");
		button4.setActionCommand("4");
		button5.setActionCommand("5");
		button6.setActionCommand("6");
		button7.setActionCommand("7");
		
		//reading best throw from file
		BufferedReader in;


		String[] words;
		try {
			in=new BufferedReader(new FileReader("readbest.txt"));
			String line;
			while((line=in.readLine())!=null){
				if(!line.isEmpty()){
					words=line.split("\\s+");
					dataPanel.bestThrow = new double[9];
					for(int i=0;i<3;i++)
						dataPanel.bestThrow[i]=Double.parseDouble(words[i]);
					}
				}
			labelN1.setText(new DecimalFormat("#").format(dataPanel.bestThrow[0]));
			labelS1.setText(new DecimalFormat("#.0#").format(dataPanel.bestThrow[1]));
			labelT1.setText(new DecimalFormat("#.0#").format(dataPanel.bestThrow[2]));
		} catch (FileNotFoundException e1) {
			//e1.printStackTrace();
			System.out.println("Brak pliku");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("1")) {
			int returnVal = chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File fileOut=chooser.getSelectedFile();
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter (fileOut));
					out.write(Main.stats.getString("Najlepszy rzut")+"\n");
					out.write(Main.stats.getString("Stats")+"\n");
					out.write(Main.stats.getString("Liczba odbić:")+" "+dataPanel.bestThrow[0]+"\n");
					out.write(Main.stats.getString("Odległość:")+" "+dataPanel.bestThrow[1]+"\n");
					out.write(Main.stats.getString("Czas lotu:")+" "+dataPanel.bestThrow[2]+"\n");
					out.write(Main.stats.getString("Par")+"\n");
					out.write(Main.stats.getString("Prędkość rzutu [m/s]")+": "+dataPanel.bestThrow[3]+"\n");
					out.write(Main.stats.getString("Kąt rzutu (do osi OX) [o]")+": "+dataPanel.bestThrow[4]+"\n");
					out.write(Main.stats.getString("Kąt kamienia (do osi OX) [o]")+": "+dataPanel.bestThrow[5]+"\n");
					out.write(Main.stats.getString("Masa kamienia [g]")+": "+dataPanel.bestThrow[6]+"\n");
					out.write(Main.stats.getString("Wysokość rzutu [m]")+": "+dataPanel.bestThrow[7]+"\n");
					out.write(Main.stats.getString("Współczynnik oporu powietrza [kg/s]")+": "+dataPanel.bestThrow[8]+"\n");
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
		
		if(e.getActionCommand().equals("2")) {
			int returnVal = chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File fileOut=chooser.getSelectedFile();
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter (fileOut));
					out.write(Main.stats.getString("Ostatni rzut")+"\n");
					out.write(Main.stats.getString("Stats")+"\n");
					out.write(Main.stats.getString("Liczba odbić:")+" "+dataPanel.lastThrow[0]+"\n");
					out.write(Main.stats.getString("Odległość:")+" "+dataPanel.lastThrow[1]+"\n");
					out.write(Main.stats.getString("Czas lotu:")+" "+dataPanel.lastThrow[2]+"\n");
					out.write(Main.stats.getString("Par")+"\n");
					out.write(Main.stats.getString("Prędkość rzutu [m/s]")+": "+dataPanel.lastThrow[3]+"\n");
					out.write(Main.stats.getString("Kąt rzutu (do osi OX) [o]")+": "+dataPanel.lastThrow[4]+"\n");
					out.write(Main.stats.getString("Kąt kamienia (do osi OX) [o]")+": "+dataPanel.lastThrow[5]+"\n");
					out.write(Main.stats.getString("Masa kamienia [g]")+": "+dataPanel.lastThrow[6]+"\n");
					out.write(Main.stats.getString("Wysokość rzutu [m]")+": "+dataPanel.lastThrow[7]+"\n");
					out.write(Main.stats.getString("Współczynnik oporu powietrza [kg/s]")+": "+dataPanel.lastThrow[8]+"\n");
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
		
		if(e.getActionCommand().equals("3")) {
			if(soundButtonMode==1) {
				button3.setIcon(icon2);
				soundButtonMode=0;
			}
			else {
				button3.setIcon(icon1);
				soundButtonMode=1;
			}
		}
		
		if(e.getActionCommand().equals("4")) {
			//switch languages after clicking PL/en button
			if(Main.currentLocale.equals(new Locale("pl","PL"))) {
				Main.currentLocale=new Locale("en","EN");
				Main.stats=ResourceBundle.getBundle("pl.edu.pw.fizyka.pojava.matmac.bundles.StatsBundle",Main.currentLocale);
				
			}
			else {
				Main.currentLocale=new Locale("pl","PL");
				Main.stats=ResourceBundle.getBundle("pl.edu.pw.fizyka.pojava.matmac.bundles.StatsBundle",Main.currentLocale);
			}
			Main.frame.setTitle(Main.stats.getString("Puszczanie kaczek"));
			dialogTitle=(Main.stats.getString("Historia"));
			label1.setText(Main.stats.getString("Najlepszy rzut"));
			label2.setText(Main.stats.getString("Liczba odbić:"));
			label3.setText(Main.stats.getString("Odległość:"));
			label4.setText(Main.stats.getString("Czas lotu:"));
			label5.setText(Main.stats.getString("Ostatni rzut"));
			label6.setText(Main.stats.getString("Liczba odbić:"));
			label7.setText(Main.stats.getString("Odległość:"));
			label8.setText(Main.stats.getString("Czas lotu:"));
			button1.setText(Main.stats.getString("Zapisz"));
			button2.setText(Main.stats.getString("Zapisz"));
			button6.setText(Main.stats.getString("Zapisz"));
			button5.setText(Main.stats.getString("Historia"));
			button7.setText(Main.stats.getString("Zamknij"));
			DataPanel.velocityLabel.setText(Main.stats.getString("Prędkość rzutu [m/s]"));
			DataPanel.throwAngleLabel.setText(Main.stats.getString("Kąt rzutu (do osi OX) [o]"));
			DataPanel.stoneAngleLabel.setText(Main.stats.getString("Kąt kamienia (do osi OX) [o]"));
			DataPanel.massLabel.setText(Main.stats.getString("Masa kamienia [g]"));
			DataPanel.heightLabel.setText(Main.stats.getString("Wysokość rzutu [m]"));
			DataPanel.coefficientLabel.setText(Main.stats.getString("Współczynnik oporu powietrza [kg/s]"));
			DataPanel.playButton.setText(Main.stats.getString("RZUĆ!"));
		}
		
		if(e.getActionCommand().equals("5")) {
			JDialog dialog=new JDialog(Main.frame);
			dialog.setSize(600, 400);
			dialog.setTitle(dialogTitle);
			dialog.setLayout(new BorderLayout());
			
			StringBuilder sb=new StringBuilder();
			
			pane.setEditable(false);
			pane.setBackground(Color.black);
			pane.setForeground(Color.white);
			pane.setFont(new Font("Calibri", Font.PLAIN,18));
			for(int i=0;i<history.size();i++) {
				sb.append(i+1+". "+"n= "+new DecimalFormat("#").format(history.get(i)[0])+"   s= "+
						new DecimalFormat("#.0#").format(history.get(i)[1])+"   t= "+new DecimalFormat("#.0#").format(history.get(i)[2])+"\n");
			}
			pane.setText(sb.toString());
			
			BufferedWriter out;
			try {
				out = new BufferedWriter(new FileWriter ("history.txt"));
				out.write(sb.toString());
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			dialog.add(pane,BorderLayout.CENTER);
			
			button6.setBackground(Color.green);
			button6.setForeground(Color.white);
			button6.setFont(new Font("Calibri", Font.PLAIN,24));
			
			dialog.add(button6,BorderLayout.SOUTH);
			
			dialog.setVisible(true);
		}
		
		if(e.getActionCommand().equals("6")) {
			int returnVal = chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File fileOut=chooser.getSelectedFile();
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter (fileOut));
					out.write(pane.getText());
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getActionCommand().equals("7")) {
			System.exit(0);
		}
	}
}
