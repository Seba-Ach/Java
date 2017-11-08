package Lab5parts;

import static org.junit.Assert.*;

import org.junit.Test;

public class JTestCircle {

	Circle c1=new Circle(5,5,5);	

	@Test
	public void testFuncts() {
		Circle c2 = new Circle(5,5,2);
		//we have circle c2 with radius 2 and coordinates(5,5)
		assertEquals(2,c2.getRadius());
		assertEquals(5,c2.x_coordinate);
		assertEquals(5,c2.y_coordinate);
		//everything should work as expected
		c2.moveNorthSouth(10);
		assertEquals(5,c2.x_coordinate);
		assertEquals(15,c2.y_coordinate);
		assertEquals(2,c2.getRadius());
		assertEquals(12.57,c2.getArea(),0.01);
		assertEquals(12.57,c2.getCircumference(),0.01);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMoveSouth() throws Exception{
		c1.moveNorthSouth(-5);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testMoveWestEast() throws Exception{
		c1.moveWestEast(1);
	}
	
	@Test (expected=IllegalArgumentException.class)
		public void testNegRadius() throws Exception{
			Circle c2 = new Circle(5,5,-5);
		}
	
	

	
}
