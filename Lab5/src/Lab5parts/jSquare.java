package Lab5parts;

import static org.junit.Assert.*;

import org.junit.Test;

public class jSquare {
	Square s2 = new Square(10,10,5);

	@Test
	public void testFuncts() {
		Square s1 = new Square(5,5,2);
		assertEquals(5,s1.x_coordinate);
		assertEquals(5,s1.y_coordinate);
		assertEquals(2,s1.getSideSize());
		s1.moveWestEast(-4);
		assertEquals(1,s1.x_coordinate);
		assertEquals(5,s1.y_coordinate);
		assertEquals(2,s1.getSideSize());
		assertEquals(4,s1.getArea(),0);
		assertEquals(8,s1.getCircumference(),0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNorthSouth() throws Exception{
		s2.moveNorthSouth(5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEast() throws Exception{
		s2.moveWestEast(5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSideNeg() throws Exception{
		s2.setSideSize(-5);
	}
	

}
