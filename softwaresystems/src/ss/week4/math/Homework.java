package ss.week4.math;

public class Homework {

	public static void main(String args[]){
	double[] x;
	Function[] func;
	int numberHomework=5;
	x=new double[numberHomework];
	func= new Function[numberHomework];
	
	 func[0] = new LinearProduct(new Constant(5), new Exponent(4));
	 x[0]=2.0;
	 
	 
	 func[1] = new Polynomial(new Constant[] {new Constant(0), new Constant(7)} );
	x[1]=8;
	
	func[2] = new Sum(new Constant(6),new Exponent(5));
	x[2]=3;
	
	func[3] = new Constant(7);
	x[3]=9;
	
	func[4]= new Product(new Constant(9),new Polynomial(new Constant[]{new Constant(4),new Constant(6)}));
	x[4]=8;
	for (int i=0;i<numberHomework;i++)
	System.out.println("f(x) = (" + func[i].toString()+"),  f("+x[i]+") = " +(func[i]).apply(x[i])) ;
	
}
}
