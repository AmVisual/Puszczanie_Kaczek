package po.matmac;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class WindowFrame extends JFrame {
	
	public void setWindowFrame() {
		//this function sets how the window looks like
		
		this.setSize(1000,650);
		this.setLayout(new BorderLayout());
		//top panel
		TopPanel topPanel = new TopPanel();
		//right panel
		RightPanel rightPanel = new RightPanel();
		//center panel
		CenterPanel centerPanel = new CenterPanel();
		//add panels
		this.add(topPanel, BorderLayout.NORTH);
		this.add(rightPanel, BorderLayout.EAST);
		this.add(topPanel, BorderLayout.CENTER);
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
