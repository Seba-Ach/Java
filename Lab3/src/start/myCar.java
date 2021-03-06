package start;

import start.carMaker;
import start.myCar;

public class myCar {
	private double tankCapacity=40;
	private double fuelConsumption=5.0;
	private carMaker maker=carMaker.convertString("s");
	private double mileage=0.0;
	private double lastTrip;
	private double fuelInTank=0.0;
	
	public myCar(){
		//empty construct
	}
	
	public myCar(String s)
	{
		try {
		if(s.split(";|_|\t").length == 3)
		{
			if(20<Double.parseDouble(s.split(";|_|\t")[0]) && Double.parseDouble(s.split(";|_|\t")[0])<80)
			{
				this.tankCapacity = Double.parseDouble(s.split(";|_|\t")[0]);
			}
			
			if(3<Double.parseDouble(s.split(";|_|\t")[1]) && Double.parseDouble(s.split(";|_|\t")[1])<20){
				this.fuelConsumption = Double.parseDouble(s.split(";|_|\t")[1]); 
			}
			this.maker = carMaker.convertString(s.split(";|_|\t")[2]);	
		} }
		catch (NumberFormatException e) {}
	}
	
	boolean tankIt(double howMuch){
		this.fuelInTank+=howMuch;
		if(this.fuelInTank>this.tankCapacity){ //if fuel in tank is greater than tank capacity, set to full.
			this.fuelInTank=this.tankCapacity;
		}
		return true;
	}
	
	boolean startTrip(double distance){
		double cons=fuelConsumption/100; //the amount of fuel it consumes per 1 km
		double willuse=cons*distance;    //the amount of fuel it will consume to travel the trip distance
		boolean r=false;
		if(willuse>this.fuelInTank){ 		// if it will use more than it has returns false
			r=false;
		}
		else if(willuse<=this.fuelInTank){ //if it will use less or equal than it has returns true
			r=true;
			this.mileage+=distance;		//adds distance traveled to existing mileage
			this.lastTrip=distance;		// lastTrip is distance traveled in this trip.	
			this.fuelInTank-=willuse;		// update fuel in tank
		}
		return r;
	}
	
	double getTankCapacity(){
		return this.tankCapacity;
	}
	
	double getFuelCons(){
		return this.fuelConsumption;
		
	}
	
	carMaker getMaker(){
		return this.maker;
	}
	
	double getMileage(){
		return this.mileage;
	}
	
	double getLastTripDist(){
		return this.lastTrip;
	}
	
	double getFuelLevel(){
		return this.fuelInTank;
	}
	
	String carToString(){
		String desc="";
		desc="The info for this car is as follows: \nCurrent fuel in tank: "+ this.getFuelLevel() +
				"/"+  this.getTankCapacity() +"\nFuel Consumption per 100km: " + this.getFuelCons() +"\nCar maker: "+this.maker+ 
				"\nCurrent mileage: "+this.getMileage()+"\nLast Trip Distance: "+this.getLastTripDist() + "\n\n";
		return desc;
	}
	
	public static void testMe(){
		myCar carOne = new myCar();
		System.out.print("Current state of Car is: \n");
		System.out.print(carOne.carToString());
		System.out.print("Adding 25 to fuel tank. \n");
		carOne.tankIt(25);
		System.out.print("Current state of Car after adding 25 to the fuel tank is: \n");
		System.out.print(carOne.carToString());
		System.out.print("Adding another 25 to fuel tank, it should not overflow and it should be equal to tank capacity\n");
		carOne.tankIt(25);
		System.out.print("Current state of Car after adding 25 to the fuel tank is: \n");
		System.out.print(carOne.carToString());
		System.out.print("Going for a trip for 200km, car should use 5 per 100 so it should use 10 units in the tank\n");
		carOne.startTrip(200);
		System.out.print("Current state of Car after driving 200km: \n");
		System.out.print(carOne.carToString());
		System.out.print("Going for a trip for 400km, car should use 5 per 100 so it should use 20 units in the tank\n");
		carOne.startTrip(400);
		System.out.print("Current state of Car after driving 400km: \n");
		System.out.print(carOne.carToString());
		System.out.print("Going for a trip for 400km, car should use 5 per 100 so it should use 20 units in the tank"
				+ ", but because there is not enough fuel in the tank the function should return false.\n");
		System.out.print("Function returned: "+ carOne.startTrip(400)+"\n");
		System.out.print("Current state of Car after driving 400km: \n");
		System.out.print(carOne.carToString());
		
		System.out.print("Creating new car and using constructor with string method using _ and proper values. \n");
		myCar carTwo=new myCar("70_8_gm");
		System.out.print(carTwo.carToString());
		System.out.print("Creating new car and using constructor with string method using ; and values too big \n");
		myCar carThree=new myCar("asd;25;skjasdjaksd");
		System.out.print(carThree.carToString());
		System.out.print("Creating new car and using constructor with string method using ; and values too small \n");
		myCar carFour=new myCar("10\t0\th");
		System.out.print(carFour.carToString());
		
	}
	
	public static void main (String[] args){
		testMe();
	}
	
}

