package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.*;

public class SafeTest {

	private Safe safe;

	@Before
	public void setUp() throws Exception {
		safe = new Safe();
	}

	@Test
	public void testIfActiveAndClosed() {
		assertFalse(safe.isOpen());
		safe.activate(Password.INITIAL);
		assertTrue(safe.isActive());
	}

	@Test
	public void testNewPass() {
		safe.getPassword().setWord(Password.INITIAL, "ICETEA");
		assertTrue(safe.getPassword().testWord("ICETEA"));
	}

	@Test
	public void testOpenandclose() {
		safe.activate(Password.INITIAL);
		assertTrue(safe.isActive());

		safe.open(Password.INITIAL);
		assertTrue(safe.isOpen());

		safe.close();
		assertFalse(safe.isOpen());
	}

	@Test
	public void testOpenWrongPass() {
		safe.activate(Password.INITIAL);
		assertTrue(safe.isActive());

		safe.open("ICETEA");
		assertFalse(safe.isOpen());
	}

	@Test
	public void testOpenWhenNotActive() {
		assertFalse(safe.isActive());
		safe.open(Password.INITIAL);
		assertFalse(safe.isOpen());
	}

	@Test
	public void testDeactivate() {
		safe.activate(Password.INITIAL);
		assertTrue(safe.isActive());

		safe.open(Password.INITIAL);
		assertTrue(safe.isOpen());

		safe.deActivate();
		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());

	}

}
