package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	//static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	AnimationPanel AnimationPanel;
	DataPanel DataPanel;
	ScorePanel ScorePanel;
	
	public void setWindowFrame() {
		//this function sets how the window looks like
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setSize(1000,650);
		this.setLayout(new GridBagLayout());
		//animation panel
		AnimationPanel = new AnimationPanel();
		//right panel - data panel
		DataPanel = new DataPanel();
		//score panel
		ScorePanel = new ScorePanel(DataPanel);
		//references between data and animation panels
		AnimationPanel.setDataPanel(DataPanel);
		DataPanel.setAnimationPanel(AnimationPanel);
		//center panel - contains score panel and animation panel
		JPanel CenterPanel=new JPanel(new GridBagLayout());
		//setting the GridBagLayout
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.weightx=0.5;
		c.weighty=0.01;
		c.gridx=0;
		c.gridy=0;
		CenterPanel.add(ScorePanel,c);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=5;
		c.weighty=1;
		CenterPanel.add(AnimationPanel,c);
		//adding panels
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill=GridBagConstraints.BOTH;
		c2.weightx = 0.5;
		c2.weighty = 0.5;
		c2.gridx = 0;
		c2.gridy = 0;
		this.add(CenterPanel, c2);
		c2.weightx = 0.2;
		c2.gridx = 1;
		c2.gridy = 0;
		this.add(DataPanel, c2);
		
		this.addComponentListener(new WindowAdapter());
	}
	
	public WindowFrame() throws HeadlessException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setWindowFrame();
	}

	public WindowFrame(GraphicsConfiguration gc) {
		super(gc);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setWindowFrame();
	}

	public WindowFrame(String title) throws HeadlessException {
		super(title);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setWindowFrame();
	}

	public WindowFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setWindowFrame();
	}
	
	public class WindowAdapter implements ComponentListener {

		@Override
		public void componentResized(ComponentEvent e) {
			//resizing fonts
			int x = 1550; //relative width
			int y = 838; //relative height
			float[] defaultDataPanel = {24,28}; //font size for DataPanel
			//{insert fieds and labels, play button}
			float[] defaultScorePanel = {24,20,18}; //font sizes for ScorePanel
			//{save buttons, settings' buttons, labels}
			
			int currentWidth = WindowFrame.this.getWidth();
			int currentHeight = WindowFrame.this.getHeight();
			
			//calculating new font size
			float ratio;
			
			//setting font size for Data Panel
			ratio = defaultDataPanel[0] / y;
			int newDataPanel = (int) (ratio * currentHeight);
			Font DataPanelFont = new Font("Calibri", Font.PLAIN, newDataPanel);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.velocityField.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.throwAngleField.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.stoneAngleField.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.massField.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.heightField.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.coefficientField.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.velocityLabel.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.throwAngleLabel.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.stoneAngleLabel.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.massLabel.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.heightLabel.setFont(DataPanelFont);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.coefficientLabel.setFont(DataPanelFont);
			ratio = defaultDataPanel[1] / y;
			newDataPanel = (int) (ratio * currentHeight);
			DataPanelFont = new Font("Calibri", Font.PLAIN, newDataPanel);
			pl.edu.pw.fizyka.pojava.matmac.DataPanel.playButton.setFont(DataPanelFont);
			
			//setting font size for Score Panel
			ratio = defaultScorePanel[0] / x;
			int newScorePanel = (int) (ratio * currentWidth);
			Font ScorePanelFont = new Font("Calibri", Font.PLAIN, newScorePanel);
			ScorePanel.button1.setFont(ScorePanelFont);
			ScorePanel.button2.setFont(ScorePanelFont);
			
			ratio = defaultScorePanel[1] / x;
			newScorePanel = (int) (ratio * currentWidth);
			ScorePanelFont = new Font("Calibri", Font.PLAIN, newScorePanel);
			ScorePanel.button3.setFont(ScorePanelFont);
			ScorePanel.button4.setFont(ScorePanelFont);
			ScorePanel.button5.setFont(ScorePanelFont);
			ScorePanel.button6.setFont(ScorePanelFont);
			ScorePanel.button7.setFont(ScorePanelFont);
			
			ratio = defaultScorePanel[2] / x;
			newScorePanel = (int) (ratio * currentWidth);
			ScorePanelFont = new Font("Calibri", Font.PLAIN, newScorePanel);
			ScorePanel.label1.setFont(ScorePanelFont);
			ScorePanel.label2.setFont(ScorePanelFont);
			ScorePanel.label3.setFont(ScorePanelFont);
			ScorePanel.label4.setFont(ScorePanelFont);
			ScorePanel.label5.setFont(ScorePanelFont);
			ScorePanel.label6.setFont(ScorePanelFont);
			ScorePanel.label7.setFont(ScorePanelFont);
			ScorePanel.label8.setFont(ScorePanelFont);
			
			pl.edu.pw.fizyka.pojava.matmac.ScorePanel.labelN1.setFont(ScorePanelFont);
			pl.edu.pw.fizyka.pojava.matmac.ScorePanel.labelN2.setFont(ScorePanelFont);
			pl.edu.pw.fizyka.pojava.matmac.ScorePanel.labelS1.setFont(ScorePanelFont);
			pl.edu.pw.fizyka.pojava.matmac.ScorePanel.labelS2.setFont(ScorePanelFont);
			pl.edu.pw.fizyka.pojava.matmac.ScorePanel.labelT1.setFont(ScorePanelFont);
			pl.edu.pw.fizyka.pojava.matmac.ScorePanel.labelT2.setFont(ScorePanelFont);
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentShown(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentHidden(ComponentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
