package pl.edu.pw.fizyka.pojava.matmac;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MotionTrack implements Runnable {
	//initial parameters
	double startingPoint[]; //a point where the movement starts [m]
	double initVelocity; //value of initial velocity [m/s]
	double initThrowAngle; //value of initial throw angle [rad]
	//constants
	double mass; //stone's mass [kg]
	double airResCoefficient; //air resistance coefficient [kg/s]
	double stoneAngle; //angle at which the stone is tilted to the x axis [rad]
	double stoneSize;
	
	double gravAcceleration = 9.81;//gravitational acceleration [m/s^2]
	double waterDensity = 1000; //water density [kg/m^3]
	double coefficient = 2.7209; //a certain coefficient which includes boyancy ceofficient
						//and proportion coefficient
	
	//track info
	int numberOfSkips; //how many times the stone skipped
	double distance; //distance made by stone
	double flightTime; //how long the stone was in motion
	
	//the entire track consists of smaller tracks - segments
	public class TrackSegment {
		double x0, y0; //segment's starting point
		double v0; //segment's initial velocity
		double angle; //angle at which the velocity vector is tilted
		double time; //time between the beginning of motion in [x0,y0] and collision with water
		
		//points
		ArrayList<double[]> points; //list of points
		
		//constatnts
		double a, b, c, d, e;
		
		public TrackSegment(double x0, double y0, double v0, double angle) {
			this.x0 = x0;
			this.y0 = y0;
			this.v0 = v0;
			this.angle = angle;
			
			points = new ArrayList<double[]>();
			
			a = this.y0;
			b = (mass * this.v0 * Math.sin(this.angle))/airResCoefficient
					+ (mass*mass*gravAcceleration)/(airResCoefficient*airResCoefficient);
			c = airResCoefficient/mass;
			d = mass * gravAcceleration / airResCoefficient;
			e = (mass * this.v0 * Math.cos(this.angle))/airResCoefficient;
		}

		public double getX0() {
			return x0;
		}

		public double getY0() {
			return y0;
		}

		public double getV0() {
			return v0;
		}

		public double getAngle() {
			return angle;
		}
		
		public double getTime() {
			return time;
		}
		
		//function for generating a point in given time
		public void generatePoint(double t) {
			double[] p = new double[2];
			p[0] = x0 + e*(1-Math.exp(-c*t));
			p[1] = y0 + b*(1-Math.exp(-c*t)) - d * t;
			points.add(p);
		}
	}
	
	ArrayList<MotionTrack.TrackSegment> segments; //list of track's segments
	
	//for animation
	int pointID; //current point's id
	int segmentID; //curent segment's id
	AnimationPanel animationPanel; //pointer on animation panel
	DataPanel dataPanel;
	
	public MotionTrack(Stone stone, AnimationPanel animationPanel, DataPanel dataPanel) {
		//setting up parameters
		this.startingPoint = new double[2];
		startingPoint[0] = 0;
		startingPoint[1] = stone.getHeight();
		initVelocity = stone.getVelocity();
		initThrowAngle = Math.toRadians(stone.getThrowAngle());
		mass = stone.getMass() / 1000; //mass is in kg
		airResCoefficient = stone.getCoefficient();
		stoneAngle = Math.toRadians(stone.getStoneAngle());
		stoneSize = stone.getStoneSize();
		this.animationPanel = animationPanel;
		this.dataPanel = dataPanel;
		
		//initialising info about the track
		numberOfSkips = 0;
		distance = 0;
		flightTime = 0;
		
		//initialising list of segments
		segments = new ArrayList<MotionTrack.TrackSegment>();
	}
	
	//getters and setters
	public int getNumberOfSkips() {
		return numberOfSkips;
	}

	public void setNumberOfSkips(int numberOfSkips) {
		this.numberOfSkips = numberOfSkips;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(double flightTime) {
		this.flightTime = flightTime;
	}
	
	public void generateTrack() {
		//adding first segment
		segments.add(new TrackSegment(startingPoint[0], startingPoint[1], initVelocity, initThrowAngle));
		TrackSegment segmentPtr = segments.get(0); //segment pointer
		
		double timer = 0.01; //timer for each segment
		boolean inMotion = true; //true as long as the stone is in motion
		int pointID = 0;
		
		while(inMotion) {
			//add first point
			double[] point = {segmentPtr.getX0(), segmentPtr.getY0()};
			segmentPtr.points.add(point);
			
			//generate points above water level
			while(segmentPtr.points.get(pointID)[1] >= 0) {
				segmentPtr.generatePoint(timer);
				timer += 0.01;
				pointID++;
			}
			double timerTmp = timer;
			
			//remove last point below water level
			segmentPtr.points.remove(pointID);
			pointID--;
			timer -= 0.01;
			
			//setting point closest to water level
			double dtPower = 2;
			double dt = Math.pow(0.1, dtPower);
			double yy = segmentPtr.points.get(pointID)[1];
			
			while(yy > 0.0001) {
				double yprev = yy;
				yy = segmentPtr.y0 + segmentPtr.b*(1-Math.exp(-segmentPtr.c*timer)) - segmentPtr.d * timer;
				if(yy < 0) {
					yy = yprev;
					dtPower++;
					timer -= dt;
					dt = Math.pow(0.1, dtPower);
				}
				timer += dt;
			}
			timer -= dt;
			segmentPtr.generatePoint(timer);
			segmentPtr.time = timer;
			
			//checking velocities
			double beta = airResCoefficient/mass;
			double vx0 = segmentPtr.getV0() * Math.cos(segmentPtr.getAngle());
			double vy0 = segmentPtr.getV0() * Math.sin(segmentPtr.getAngle());
			double vx = vx0 * Math.exp(-beta*timer);
			double vy = (vy0 + gravAcceleration / beta) * Math.exp(-beta*timer) - gravAcceleration / beta;
			
			if(stoneAngle != 0 && stoneAngle <= Math.toRadians(60)) {
				if(Math.abs(vy) <= 0.2 * vx) {
					System.out.println("Vx=" + vx + ", Vy=" + vy);
					double sqrt = Math.sqrt(2*mass*Math.sin(stoneAngle)/(waterDensity*stoneSize));
					double vxSqr = vx*vx - 4*Math.PI*gravAcceleration*sqrt/coefficient;
					if(vxSqr > 0) {
						vx = Math.sqrt(vxSqr);
						vy = -vy;
						double v = Math.sqrt(vx*vx + vy*vy);
						double angle = Math.asin(vy/v);
						
						//increment the number of skips
						numberOfSkips++;
						
						//adding new segment to the track
						double x = segmentPtr.points.get(segmentPtr.points.size()-1)[0];
						double y = segmentPtr.points.get(segmentPtr.points.size()-1)[1];
						segments.add(new TrackSegment(x,y,v,angle));
						segmentPtr = segments.get(segments.size()-1);
					}
					else {
						inMotion = false;
					}
				}
				else {
					inMotion = false;
				}
			}
			else {
				inMotion = false;
			}
			
			flightTime += timer;
			timer = timerTmp - timer;
			pointID = 0;
		}
		distance = segmentPtr.points.get(segmentPtr.points.size()-1)[0];
		
		System.out.println("Number of skips: " + numberOfSkips);
		System.out.println("Time: " + flightTime);
		System.out.println("Distance: " + distance);
	}
	

	//for animating a track
	@Override
	public void run() {
		TrackSegment segmentPtr = segments.get(segmentID);
		
		boolean endOfTrack = false;
		while(!endOfTrack) {
			if(pointID < segmentPtr.points.size() - 1) {
				pointID++;
			}
			else {
				if(segmentID < segments.size() - 1) {
					System.out.println("Segment " + segmentID + ": " + (segmentPtr.points.size() - 1));
					segmentID++;
					segmentPtr = segments.get(segmentID);
					pointID = 1;
					//water splash
					if(ScorePanel.soundButtonMode == 1) {
						Thread thread = new Thread(new SplashAudioRunnable(true));
						thread.start();
					}
				}
				else {
					endOfTrack = true;
					if(ScorePanel.soundButtonMode == 1) {
						Thread thread = new Thread(new SplashAudioRunnable(false));
						thread.start();
					}
				}
			}
			animationPanel.repaint();
			animationPanel.getToolkit().sync();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//wait for 2 seconds
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//repaint animation panel
		animationPanel.animation = false;
		animationPanel.repaint();
		
		//rescale
		while(animationPanel.scale < animationPanel.initialScale) {
			animationPanel.scale += 5;
			if(animationPanel.scale > animationPanel.initialScale)
				animationPanel.scale = animationPanel.initialScale;
			animationPanel.repaint();
					
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//enable data panel
		DataPanel.velocityField.setEnabled(true);
		DataPanel.throwAngleField.setEnabled(true);
		DataPanel.stoneAngleField.setEnabled(true);
		DataPanel.massField.setEnabled(true);
		DataPanel.heightField.setEnabled(true);
		DataPanel.coefficientField.setEnabled(true);
		DataPanel.playButton.setEnabled(true);
		
		dataPanel.lastThrow = new double[]{(double)numberOfSkips, distance, flightTime, 
				initVelocity, Math.toDegrees(initThrowAngle), Math.toDegrees(stoneAngle), 
				mass*1000, startingPoint[1], airResCoefficient};
		
		if(dataPanel.bestThrow == null) {
			dataPanel.bestThrow = new double[9];
			System.arraycopy(dataPanel.lastThrow, 0, dataPanel.bestThrow, 0, 9);
			System.out.println("Zadeklarowano tablice");
		}
		else {
			if(numberOfSkips >= dataPanel.bestThrow[0]) {
				System.arraycopy(dataPanel.lastThrow, 0, dataPanel.bestThrow, 0, 9);
				System.out.println("Ostatni rzut jest najlepszym rzutem");
			}
		}
		
		System.out.println("Best throw: " + dataPanel.bestThrow[0]);
		
		ScorePanel.history.add(0, dataPanel.lastThrow);
		for(double[] i: ScorePanel.history) {
			System.out.println("n = " + i[0] + ", s = " + i[1] + ", t = " + i[2]);
		}
		
		ScorePanel.labelN1.setText(new DecimalFormat("#").format(dataPanel.bestThrow[0]));
		ScorePanel.labelS1.setText(new DecimalFormat("#.0#").format(dataPanel.bestThrow[1]));
		ScorePanel.labelT1.setText(new DecimalFormat("#.0#").format(dataPanel.bestThrow[2]));
		ScorePanel.labelN2.setText(new DecimalFormat("#").format(dataPanel.lastThrow[0]));
		ScorePanel.labelS2.setText(new DecimalFormat("#.0#").format(dataPanel.lastThrow[1]));
		ScorePanel.labelT2.setText(new DecimalFormat("#.0#").format(dataPanel.lastThrow[2]));
		
			
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter ("readbest.txt"));
			for(int i=0;i<9;i++)
				out.write(dataPanel.bestThrow[i]+" ");
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//paint method
	public void paint(Graphics g, int scale, int waterLevel, int bankPosition, int width, int height, Stone stone) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255, 0, 0));
		float[] dashPattern = {4.0f, 8.0f};
		Stroke stroke = new BasicStroke(4f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 
				1f, dashPattern, 2f);
		g2d.setStroke(stroke);
		
		//setting scale
		int scaley = (int) ((waterLevel - 50) / segments.get(segmentID).points.get(pointID)[1]);
		int scalex = (int) ((width - bankPosition - 100) / segments.get(segmentID).points.get(pointID)[0]);
		if(scalex < scale || scaley < scale)
		{
			if(scalex < Math.abs(scaley))
				animationPanel.scale = scalex;
			else
				animationPanel.scale = Math.abs(scaley);
		}
		
		//draw previous segments
		TrackSegment segment;
		for(int i = 0; i < segmentID; i++) {
			segment = segments.get(i);
			for(int j = 1; j <= segment.points.size() - 1; j++) {
				int x1 = bankPosition + (int)(scale * segment.points.get(j-1)[0]);
				int y1 = waterLevel - (int)(scale * segment.points.get(j-1)[1]);
				int x2 = bankPosition + (int)(scale * segment.points.get(j)[0]);
				int y2 = waterLevel - (int)(scale * segment.points.get(j)[1]);
				
				g2d.drawLine(x1, y1, x2, y2);
			}
		}
		//draw current segment
		segment = segments.get(segmentID);
		for(int i = 1; i <= pointID; i++) {
			int x1 = bankPosition + (int)(scale * segment.points.get(i-1)[0]);
			int y1 = waterLevel - (int)(scale * segment.points.get(i-1)[1]);
			int x2 = bankPosition + (int)(scale * segment.points.get(i)[0]);
			int y2 = waterLevel - (int)(scale * segment.points.get(i)[1]);
			
			g2d.drawLine(x1, y1, x2, y2);
		}
		//draw stone
		if(segmentID != segments.size() - 1 || pointID < segment.points.size() - 1) {
			double stoneX = bankPosition + (scale * segment.points.get(pointID)[0]);
			double stoneY = waterLevel - (int)(scale * segment.points.get(pointID)[1]);
			stone.paint(g, stoneX, stoneY, scale);
		}
	}
}
