package pl.edu.pw.fizyka.pojava.matmac;

//stone class - stores parameters for simulation
public class Stone {
	
	//parameters inserted by user
	double velocity, throwAngle, stoneAngle, mass, height, coefficient;
	
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

}
