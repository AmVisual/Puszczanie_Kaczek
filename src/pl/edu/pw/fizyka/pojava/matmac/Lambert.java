package pl.edu.pw.fizyka.pojava.matmac;

public class Lambert {
	
	static int factorial(int n) {
		int f = 1;
		for(int i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
	}
	
	public static double polynomial(double x, int n) {
		double w = 0;
		
		for(int i = 1; i <= n; i++) {
			int factorial = 1;
			for(int j = 2; j <= i; j++) {
				factorial*=j;
			}
			w += Math.pow(-1, i-1) * Math.pow(i, i-2) / factorial(i-1) * Math.pow(x, i);
		}
		return w;
	}
}
