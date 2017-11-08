package start;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class JTests {

	@Test
	public void testParameterLess() {
		MyCarEx mce1 = new MyCarEx(); /// mce1 is using default constructor so values will default so 0
		assertEquals(0,mce1.getTankCapacity()); //check if by passing no variables mce1 tank capacity is 0
		assertEquals(0,mce1.getFuelCons());
		assertEquals(0,mce1.getLastTripDist());
		assertEquals(0,mce1.getFuelLevel());
		///////////////////////Above tests basically check for values equal to 0 because no values were passed into constructor
	} 
	
	MyCarEx mce2 =new MyCarEx("25;6;Fiat"); //will basically call proper values into constructor
	@Test
	public void testFuncts() {
		MyCarEx mcx =new MyCarEx("35;5;GM"); 
		//we have a car with tank capacity 35, burns 5 units per 100 and is of carmaker GM
		//checking if constructor worked properly
		assertEquals(35,mcx.getTankCapacity());
		assertEquals(5,mcx.getFuelCons());
		assertEquals("GM",mcx.getMaker().toString());
		assertEquals(0,mcx.getFuelLevel());
		
		mcx.tankIt(30);
		assertEquals(30,mcx.getFuelLevel());
		
		mcx.startTrip(200);//200km so uses 5 units per 100 so should use 10 units in tank
		assertEquals(200,mcx.getLastTripDist()); //last trip 200km
		assertEquals(200,mcx.getMileage()); //mileage is now 200
		assertEquals(20,mcx.getFuelLevel()); //tank should have 20 now
		
		mcx.startTrip(100); //another trip uses 10units in tank, mileage expected 300, last trip 100
		assertEquals(100,mcx.getLastTripDist()); //last trip 200km
		assertEquals(300,mcx.getMileage());
		assertEquals(15,mcx.getFuelLevel());
		
		//lets use up all fuel in the tank
		mcx.startTrip(300); //all fuel used so 0, last trip dist 150 and mileage 450
		assertEquals(300,mcx.getLastTripDist()); //last trip 150km
		assertEquals(600,mcx.getMileage());
		assertEquals(0,mcx.getFuelLevel());
		
	
	}
	
	
	@Test (expected=IllegalArgumentException.class)
	public void tankItOverflow() throws Exception {
		mce2.tankIt(15);
		mce2.tankIt(25);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void tankNeg() throws Exception {
		mce2.tankIt(-5);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void longTrip() throws Exception{
		mce2.tankIt(10); //put 10 units of fuel into tank just so it isnt empty
		mce2.startTrip(200);
	}
	
	@Test (expected=IllegalArgumentException.class) //not double value inserted for first par
	public void constructNumFormExcept() throws Exception{
		MyCarEx mce3=new MyCarEx("asd;7;Fiat");
	}
	@Test (expected=IllegalArgumentException.class) //low value inserted for first par
	public void constructNumFormExcept2() throws Exception{
		MyCarEx mce3=new MyCarEx("5;7;Fiat");
	}
	@Test (expected=IllegalArgumentException.class) //high value inserted for first par
	public void constructNumFormExcept3() throws Exception{
		MyCarEx mce3=new MyCarEx("90;7;Fiat");
	}
	
	@Test (expected=IllegalArgumentException.class) //not double value inserted for first par
	public void constructNumFormExcept4() throws Exception{
		MyCarEx mce3=new MyCarEx("25;asd;Fiat");
	}
	@Test (expected=IllegalArgumentException.class) //low value inserted for first par
	public void constructNumFormExcept5() throws Exception{
		MyCarEx mce3=new MyCarEx("25_2;Fiat");
	}
	@Test (expected=IllegalArgumentException.class) //high value inserted for first par
	public void constructNumFormExcept6() throws Exception{
		MyCarEx mce3=new MyCarEx("25_90;Fiat");
	}
	
	@Test (expected=IllegalArgumentException.class) //high value inserted for first par
	public void constructNumFormExcept7() throws Exception{
		MyCarEx mce3=new MyCarEx("25_5_s");
	}

}
