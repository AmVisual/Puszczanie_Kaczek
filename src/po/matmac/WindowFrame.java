package po.matmac;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFrame extends JFrame {
	
	public void setWindowFrame() {
		//this function sets how the window looks like
		
		this.setSize(1000,650);
		this.setLayout(new GridBagLayout());
		//score panel
		ScorePanel ScorePanel = new ScorePanel();
		//right panel - data panel
		DataPanel DataPanel = new DataPanel();
		//animation panel
		AnimationPanel AnimationPanel = new AnimationPanel();
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
	}
	
	public WindowFrame() throws HeadlessException {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setWindowFrame();
	}

	public WindowFrame(GraphicsConfiguration gc) {
		super(gc);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setWindowFrame();
	}

	public WindowFrame(String title) throws HeadlessException {
		super(title);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setWindowFrame();
	}

	public WindowFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setWindowFrame();
	}

}
