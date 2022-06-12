package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;

public class ScoreLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	private static final int MIN_FONT_SIZE = 1;
    private static final int MAX_FONT_SIZE = 25;
    private Graphics g;
	
	
	public ScoreLabel(String text) {
		super(text);
		setHorizontalAlignment(JLabel.LEFT);
		setForeground(Color.white);
		setFont(new Font("Calibri", Font.PLAIN,18));
	}

	/*public ScoreLabel(String text) {
		super(text);
		addComponentListener(new LabelListener());
		//setHorizontalAlignment(JLabel.LEFT);
		setForeground(Color.white);
		//setFont(new Font("Calibri", Font.PLAIN,10));
	}*/
	
	private class LabelListener extends ComponentAdapter {

        public void componentResized(ComponentEvent e) {
            if (g == null) {
            	System.out.println("tutaj");
                return;
            }
            Rectangle r = ScoreLabel.this.getBounds();
            int fontSize = MIN_FONT_SIZE;
            Font f = ScoreLabel.this.getFont();
            //System.out.println("tutaj");
            Rectangle r1 = new Rectangle();
            Rectangle r2 = new Rectangle();
            while (fontSize < MAX_FONT_SIZE) {
                r1.setSize(getTextSize(ScoreLabel.this, f.deriveFont(f.getStyle(), fontSize)));
                r2.setSize(getTextSize(ScoreLabel.this, f.deriveFont(f.getStyle(), fontSize + 1)));
                System.out.println(r1.width+r1.height);
                if (r.contains(r1) && !r.contains(r2)) {
                    break;
                }
                fontSize++;
            }

            setFont(f.deriveFont(f.getStyle(), fontSize));
            repaint();
        }
    }

	private Dimension getTextSize(JLabel l, Font f) {
        Dimension size = new Dimension();
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        size.width = fm.stringWidth(l.getText());
        size.height = fm.getHeight();

        return size;
    }
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
    }
}
