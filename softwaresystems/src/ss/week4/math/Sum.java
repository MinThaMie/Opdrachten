package ss.week4.math;

public class Sum implements Function, Integrandable {

	Function func1;
	Function func2;

	public Sum(Function func1, Function func2) {
		this.func1 = func1;
		this.func2 = func2;
	}

	@Override
	public double apply(double x) {
		return (this.func1.apply(x) + this.func2.apply(x));
	}

	@Override
	public Function derivative() {
		return new Sum(this.func1.derivative(), this.func2.derivative());
	}
	public String toString(){
		return (this.func1.toString()  + " + " + this.func2.toString());
	}

	public Function integrand() {
		if ((this.func1 instanceof Integrandable) && (this.func2 instanceof Integrandable))
			return new Sum(((Integrandable) this.func1).integrand(), ((Integrandable) this.func2).integrand());
		else
			return null;
	}

}
