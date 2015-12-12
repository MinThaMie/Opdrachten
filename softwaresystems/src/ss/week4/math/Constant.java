package ss.week4.math;

public class Constant implements Function,Integrandable{

	private double c;

	public Constant(double c) {
		this.c = c;
	}

	@Override
	public double apply(double x) {
		return this.c;
}

	@Override
	public Function derivative(){
		return new Constant(0);
	}
	
	public String toString(){
		return Double.toString(this.c);
	}
	public Function integrand(){
		return new LinearProduct(new Constant(c),new Exponent(1));
	}

}
