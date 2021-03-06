package start;

import start.carMaker;

public class MyCarEx {
	private double tankCapacity;
	private double fuelConsumption;
	private carMaker maker;//=carMaker.convertString("s");
	private double mileage=0.0;
	private double lastTrip;
	private double fuelInTank;
	
	public MyCarEx(){
		//empty construct
	}
	
	public MyCarEx(String s)
	{
	//	try {
			if(s.split(";|_|\t").length == 3)
			{
				if(20<Double.parseDouble(s.split(";|_|\t")[0]) && Double.parseDouble(s.split(";|_|\t")[0])<80)
				{
					this.tankCapacity = Double.parseDouble(s.split(";|_|\t")[0]);
				}
				else{
					System.out.print("ERROR: Value not between 20 and 80.\n");
					throw new IllegalArgumentException();
				}
				
				if(3<Double.parseDouble(s.split(";|_|\t")[1]) && Double.parseDouble(s.split(";|_|\t")[1])<20){
					this.fuelConsumption = Double.parseDouble(s.split(";|_|\t")[1]); 
				}
				else {
					System.out.print("ERROR: Value not between 3 and 20.\n");
					throw new IllegalArgumentException();
				}
				this.maker = carMaker.convertString(s.split(";|_|\t")[2]);
				if(!(this.maker.ourCarMaker())) {  ///////////// function ourCarMaker itself will return true if maker is proper, so ! will make it false
					System.out.print("ERROR: Car maker value not proper.\n");
					throw new IllegalArgumentException();
				}
			} 
//		}
	//	finally {}
		/*catch (NumberFormatException e) {}
		catch (IllegalArgumentException e) {
			System.out.print("ERROR: Wrong car maker name inserted.");
		}*/
	}
	
	void tankIt(double howMuch){
		double temp=this.fuelInTank;
	//	try {
			this.fuelInTank+=howMuch;
			if(this.fuelInTank>this.tankCapacity){ //if fuel in tank is greater than tank capacity, set to full.
				System.out.print("ERROR: Cannot put "+howMuch+" fuel in the tank.\n");
				this.fuelInTank=temp;
				throw new IllegalArgumentException();
			}
			if(howMuch<0) {
				System.out.print("ERROR: Cannot put "+howMuch+" fuel in the tank.\n");
				this.fuelInTank=temp;
				throw new IllegalArgumentException();
			}
	/*	}catch(IllegalArgumentException e) {
			System.out.print("ERROR: Cannot put "+howMuch+" fuel in the tank.\n");
			this.fuelInTank=temp;
			return false;
			
		}finally{}*/
	}
	
	void startTrip(double distance){
		double cons=fuelConsumption/100; //the amount of fuel it consumes per 1 km
		double willuse=cons*distance;    //the amount of fuel it will consume to travel the trip distance
	//	boolean r=false;
	//	try {
			if(willuse>this.fuelInTank){ 		// if it will use more than it has returns false
				System.out.print("ERROR: Cannot go on this trip, not enough fuel.\n");
				throw new IllegalArgumentException();
				//r=false;
			}
			if(willuse<=this.fuelInTank){ //if it will use less or equal than it has returns true
				//r=true;
				this.mileage+=distance;		//adds distance traveled to existing mileage
				this.lastTrip=distance;		// lastTrip is distance traveled in this trip.	
				this.fuelInTank-=willuse;		// update fuel in tank
			}
		/*}catch(IllegalArgumentException e) {
			System.out.print("Cannot go on a trip of distance:"+distance+" as there is not enough fuel.\n");
		}finally {}*/
	//	return r;
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

	
}

