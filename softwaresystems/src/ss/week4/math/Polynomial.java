package ss.week4.math;

public class Polynomial implements Function, Integrandable {
	LinearProduct[] products;
	Constant[] cons;

	public Polynomial(Constant[] cons) {
		this.products = new LinearProduct[cons.length];
		this.cons = new Constant[cons.length];
		for (int i = 0; i < cons.length; i++) {
			this.products[i] = new LinearProduct(cons[i], new Exponent(i));
			this.cons[i] = cons[i];
		}
	}

	@Override
	public double apply(double x) {
		double result = 0;
		for (int i = 0; i < this.products.length; i++) {
			result += this.products[i].apply(x);
		}
		return result;
	}

	@Override
	public Function derivative() {
		/*Constant tempCons[] = new Constant[this.cons.length - 1];
		
		for (int i = 0; i < this.cons.length-1; i++) {
			tempCons[i] = new Constant((this.cons[i+1].apply(1)) * (i+1));
		}
		return new Polynomial(tempCons);*/

		Function result = null;
		for (int i = 0; i < this.products.length; i++) {
			if (result == null) {
				result = products[i].derivative();
			} else
				result = new Sum(result, products[i].derivative());
		}
		return result;

	}

	public String toString() {
		String string = new String();
		for (int i = 0; i < this.products.length; i++) {
			string += ("(" + this.products[i].toString() + ")" + " + ");
		}
		if (string.length() > 3)
			string = string.substring(0, string.length() - 3);

		return string;
	}

	public Function integrand() {
		/*Constant tempCons[] = new Constant[this.cons.length + 1];
		tempCons[0] = new Constant(0);

		for (int i = 0; i < this.cons.length; i++) {
			tempCons[i + 1] = new Constant((this.cons[i].apply(1)) / (i + 1));
		}
		return new Polynomial(tempCons);*/
		
		Function result = null;
		for (int i = 0; i < this.products.length; i++) {
			if (result == null) {
				result = products[i].integrand();
			} else
				result = new Sum(result, products[i].integrand());
			
		}
		
		return result;
		
	}

}
