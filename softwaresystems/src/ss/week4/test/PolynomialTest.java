package ss.week4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Polynomial;
import ss.week4.math.Constant;

public class PolynomialTest {
	static final Constant[] polycons0={new Constant(0.0),new Constant(0.0),new Constant(0.0),new Constant(0.0)};
	static final Constant[] polycons1={new Constant(1.0),new Constant(1.0),new Constant(1.0),new Constant(1.0)};
	static final Constant[] polycons2={new Constant(2.0),new Constant(2.0),new Constant(2.0),new Constant(2.0)};
	static final Constant[] polycons3={new Constant(1.0),new Constant(2.0),new Constant(3.0),new Constant(4.0)};
	static final Constant[] polycons4={new Constant(2.0)};
	static final Constant[] polycons5={new Constant(2.0), new Constant(6.0), new Constant(12.0)};
	Polynomial poly0,poly1,poly2,poly3,poly4,poly5;
	 private static final double DELTA = 1e-15;
	Constant cons;
	

	@Before
	public void setUp() throws Exception {
		poly0 = new Polynomial(polycons0);
		poly1 = new Polynomial(polycons1);
		poly2 = new Polynomial(polycons2);
		poly3 = new Polynomial(polycons3);
		poly4 = new Polynomial(polycons4);
		poly5 = new Polynomial(polycons5);
		
		 cons=new Constant(15);
		
	}
	//-----------------------------Instance Variables

	@Test
	public void testApply() {		
		assertEquals(0.0,poly0.apply(1.0),DELTA);
		assertEquals(1.0,poly1.apply(0.0),DELTA);
		assertEquals(4.0,poly1.apply(1.0),DELTA);
		assertEquals(8.0,poly2.apply(1.0),DELTA);
		assertEquals(142.0, poly3.apply(3.0),DELTA);
		assertEquals(2,poly4.apply(100.0),DELTA);
	}
	
	@Test
	public void testDerivative(){
		assertEquals(0.0,poly0.derivative().apply(1.0),DELTA);	
		assertEquals(1.0,poly1.apply(0.0),DELTA);
		
		assertEquals(62,(poly3.derivative()).apply(2.0),DELTA);
		assertEquals(62,poly5.apply(2.0),DELTA);
		
		assertEquals(poly3.derivative().apply(4),poly5.apply(4),DELTA);
		
		System.out.println(poly5.integrand().toString());
		System.out.println(poly3.toString());
		
	}
	
	@Test 
	public void testIntegrand(){
		assertEquals((25.0/12.0), poly1.integrand().apply(1),DELTA);	
		
		assertEquals(48,poly5.integrand().apply(2),DELTA);
	}
	
	

	
}
