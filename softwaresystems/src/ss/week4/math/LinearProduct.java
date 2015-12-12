package ss.week4.math;

public class LinearProduct extends Product implements Function, Integrandable {

	Constant cons;
	Function func;

	public LinearProduct(Constant cons, Function func) {
		super(cons, func);
		this.cons = cons;
		this.func = func;
	}

	@Override
	public double apply(double x) {
		return super.apply(x);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(cons, func.derivative());
	}

	public String toString() {
		String string = new String();
		if ((func.toString()).equals("x^0.0"))
			string += cons.toString();
		else
			string += cons.toString() + " * " + func.toString();
		return string;
	}

	public Function integrand() {
		if (func instanceof Integrandable){
		
			return new LinearProduct(cons, ((Integrandable) func).integrand());}
		else
			return null;
	}
}
