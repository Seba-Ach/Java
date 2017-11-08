package Lab5parts;

import static org.junit.Assert.*;

import org.junit.Test;

public class jRectangle {

	Rectangle r2 = new Rectangle(0,0,5,2);
	@Test
	public void testFuncts() {
		Rectangle r1 = new Rectangle(5,5,2,4);
		assertEquals(5,r1.x_coordinate);
		assertEquals(5,r1.y_coordinate);
		assertEquals(2,r1.getxSideSize());
		assertEquals(4,r1.getySideSize());
		assertEquals(8,r1.getArea(),0);
		assertEquals(12,r1.getCircumference(),0);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testMoveNorth() throws Exception{
		r2.moveNorthSouth(2);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testMoveSouth() throws Exception{
		r2.moveNorthSouth(-5);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testMoveEast() throws Exception{
		r2.moveWestEast(2);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testMoveWest() throws Exception{
		r2.moveWestEast(-3);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testSetxNegSide() throws Exception{
		r2.setxSideSize(-4);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testSetyNegSide() throws Exception{
		r2.setySideSize(-1);
	}
}
