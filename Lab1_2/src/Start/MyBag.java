package Start;

public class MyBag {
    
	
	protected Item bag[];
	
	public MyBag() {
		bag = new Item [10];
	}
	
	public MyBag(int length) {
		if(length > 0 & length <25) {
			bag = new Item [length];
		} else {
			bag = new Item [10];
		}
	}
	
	public String toStringl() {
		String resultString = "";
		
		for(int i=0; i<bag.length; i++) {
			resultString += " " + bag[i].name + " " + bag[i].weight;
		}
		return resultString; 
	}
	
	public boolean putItem(Item item) {
		
		for(int i=0; i<bag.length; i++) {
			if(bag[i]==null) {
				bag[i] = item;
				return true;
			}
		}
		return false;
	}
	
	public void removeAll() {
		for(int i=0; i<bag.length; i++) {
			bag[i] = null;
		}
	}
		
	
	/*void testMe() {
		//assign different values to items
		Item myI1 = new Item("\nBanana", 5); // \n is to add newline to make it more aesthetically pleasing to the eye.
		Item myI2 = new Item("\nBag of Apples", 14);
		Item myI3 = new Item("\nChicken", 10); 
		Item myI4 = new Item("\nRice", 18);
		Item myI5 = new Item("\nPasta",3);
		Item myI6 = new Item("\nEggs",8);
		Item myI7 = new Item("\nCheese",4);
		
		MyBag myB = new MyBag(5);
	
		//checks if i can put item, returns false if not
		System.out.print(myB.putItem(myI1));
		System.out.print(myB.putItem(myI2));		
		System.out.print(myB.putItem(myI3));
		System.out.print(myB.putItem(myI4));
		System.out.print(myB.putItem(myI5));
		System.out.print(myB.putItem(myI6));
		System.out.print(myB.putItem(myI7));
		
		
		System.out.print(myB.toStringl());

		myB.removeAll();
	} */
	public static void main(String[] args) {
		
		myBagPlus.testMe();
	}
}

