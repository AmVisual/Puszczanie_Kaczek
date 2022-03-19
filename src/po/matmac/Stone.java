package po.matmac;

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

}
