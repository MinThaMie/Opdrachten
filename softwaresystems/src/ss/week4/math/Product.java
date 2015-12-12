package ss.week4.math;

public class Product implements Function {

	Function func1;
	Function func2;

	public Product(Function func1, Function func2) {
		this.func1 = func1;
		this.func2 = func2;
	}

	@Override
	public double apply(double x) {
		return (this.func1.apply(x) * this.func2.apply(x));
	}

	@Override
	public Function derivative() {
		Product prod1 = new Product(this.func1.derivative(), this.func2);
		Product prod2 = new Product(this.func1, this.func2.derivative());
		
		return new Sum(prod1,prod2);
				}
	public String toString(){
		return (this.func1.toString()+" * "+this.func2.toString());
	}

}
