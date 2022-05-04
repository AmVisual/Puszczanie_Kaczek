package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.Color;
import java.awt.Graphics;

//stone class - stores parameters for simulation
public class Stone {
	
	//parameters inserted by user
	double velocity, throwAngle, stoneAngle, mass, height, coefficient;
	final double stoneSize = 0.04; //lenght of stone's side
	final double stoneDiagonal = 0.15; //diagonal of the stone
	
	public Stone() {
		this.velocity = 1;
		this.throwAngle = 45;
		this.stoneAngle = 20;
		this.mass = height;
		this.height = 0.5;
		this.coefficient = 0.2;
	}

	public Stone(double velocity, double throwAngle, double stoneAngle, double mass, double height,
			double coefficient) {
		this.velocity = velocity;
		this.throwAngle = throwAngle;
		this.stoneAngle = stoneAngle;
		this.mass = mass;
		this.height = height;
		this.coefficient = coefficient;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getThrowAngle() {
		return throwAngle;
	}

	public void setThrowAngle(double throwAngle) {
		this.throwAngle = throwAngle;
	}

	public double getStoneAngle() {
		return stoneAngle;
	}

	public void setStoneAngle(double stoneAngle) {
		this.stoneAngle = stoneAngle;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	public double getStoneSize() {
		return stoneSize;
	}

	public void paint(Graphics g, double x0, double y0, double scale) {
		int[] xVerticies = new int[4]; //verticies' x cords [4]
		int[] yVerticies = new int[4]; //verticies' y cords [4]
		
		double theta = Math.toRadians(stoneAngle); //stone angle
		double alpha = Math.acos(stoneSize/stoneDiagonal); //angle relative to stone angle
		double r = scale * 0.5 * stoneDiagonal;
		
		//x1,y1
		xVerticies[0] = (int) (x0 + r*Math.sin(theta + alpha));
		yVerticies[0] = (int) (y0 + r*Math.cos(theta + alpha));
		//x2,y2
		xVerticies[1] = (int) (x0 + r*Math.sin(theta - alpha));
		yVerticies[1] = (int) (y0 + r*Math.cos(theta - alpha));
		//x3,y3
		theta -= Math.PI;
		xVerticies[2] = (int) (x0 + r*Math.sin(theta + alpha));
		yVerticies[2] = (int) (y0 + r*Math.cos(theta + alpha));
		//x4,y4
		xVerticies[3] = (int) (x0 + r*Math.sin(theta - alpha));
		yVerticies[3] = (int) (y0 + r*Math.cos(theta - alpha));
		
		g.setColor(Color.GRAY);
		g.fillPolygon(xVerticies, yVerticies, 4);
	}
}
