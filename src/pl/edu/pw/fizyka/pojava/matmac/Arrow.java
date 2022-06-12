package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Arrow {
	public static void paint(Graphics g, double x0, double y0, double angle, double velocity, int scale) {
		Graphics2D g2d = (Graphics2D) g;
		double scale1 = (double)scale / 75;
		int x1,y1; // end of the arrow
		double angleRadians = Math.toRadians(angle);
		x1 = (int)(x0 + scale1*velocity*Math.cos(-angleRadians));
		y1 = (int)(y0 + scale1*velocity*Math.sin(-angleRadians));
		
		//drawing a line
		g2d.setColor(new Color(255, 0, 0));
		g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
		g2d.drawLine((int)x0, (int)y0, x1, y1);
		
		//drawing a dart
		int dartLenght = 10;
		int x2,y2; //position of the end of dart
		double offsetAngle = Math.toRadians(135);
		x2 = (int)(x1 + dartLenght*Math.cos(-angleRadians-offsetAngle));
		y2 = (int)(y1 + dartLenght*Math.sin(-angleRadians-offsetAngle));
		g2d.drawLine(x1, y1, x2, y2);
		x2 = (int)(x1 + dartLenght*Math.cos(-angleRadians+offsetAngle));
		y2 = (int)(y1 + dartLenght*Math.sin(-angleRadians+offsetAngle));
		g2d.drawLine(x1, y1, x2, y2);
	}
}
