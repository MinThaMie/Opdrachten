package ss.week2;

import org.junit.Before;
import org.junit.Test;
import ss.week2.Rectangle;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Testprogram for Rectangle Lab excersise software systems
 * 
 * @author Jasper Gerth
 *
 */
public class RectangleTest {

	/** Testvariable for a <tt>Rectantle</tt> object */
	private Rectangle vierkantje1;
	/** Testvariable for a <tt>Rectangle</tt> object */
	private Rectangle vierkantje2;
	/** Testvariable for a <tt>Rectangle</tt> object */
	private Rectangle vierkantje3;

	/** Testvariable for a <tt>Rectangle</tt> object */

	@Before
	public void setUp() {
		vierkantje1 = new Rectangle(0, 1);
		vierkantje2 = new Rectangle(0, 0);
		vierkantje3 = new Rectangle(3, 10);
	}

	@Test(expected = AssertionError.class)
	public void checkConstructor() {
		new Rectangle(-1, 1);
		new Rectangle(-1, 1);
		new Rectangle(-0, 0);

		assertEquals(vierkantje1.length(), 0);

	}

	@Test
	public void testPerimeter() {
		assertEquals(vierkantje2.perimeter(), 0);
		assertEquals(vierkantje3.perimeter(), 26);
	}

	@Test
	public void testArea() {
		assertEquals(vierkantje1.area(), 0);
		assertEquals(vierkantje3.area(), 30);
	}

}
