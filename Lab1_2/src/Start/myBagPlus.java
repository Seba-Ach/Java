package Start;

public class myBagPlus extends MyBag {
	protected double maxWeight;
	private double spareWt;

	public myBagPlus(int size,double maxWeight){
		super(size);
		if(this.maxWeight<=0){
			this.maxWeight=1.0;
		}
		this.maxWeight=maxWeight;
		this.spareWt=maxWeight;
	}

	public boolean putItem(Item item) {
		spareWt=spareWt-item.weight;
		if(spareWt>=0) {
			if (super.putItem(item))
				return true;
		}
		spareWt=spareWt+item.weight;
		return false;
	}

	static void testMe() {
		//assign different values to items
		Item myI1 = new Item("\nBanana", 5); // \n is to add newline to make it more aesthetically pleasing to the eye.
		Item myI2 = new Item("\nBag of Apples",6);
		Item myI3 = new Item("\nChicken", 8); 
		Item myI4 = new Item("\nRice", 3);
		Item myI5 = new Item("\nPasta",5);
		Item myI6 = new Item("\nEggs",1);
		Item myI7 = new Item("\nCheese",1);

		System.out.print("Test for Task1 : \n");
		FruitName frt=FruitName.PLUM;
		System.out.print("Display enum value as string: ");
		System.out.print(frt.toString());
		System.out.print("\n");
		System.out.print("Return enum value from string: ");
		System.out.print(FruitName.getFruitName("Apple"));
		System.out.print("\n");
		System.out.print("-----------------------------------------------------------------------------------");
		System.out.print("\n");

		System.out.print("Test for Task2: ");
		ItemPlus ip1 = new ItemPlus("item1","BANANA",3);
		ItemPlus ip2 = new ItemPlus("item2");
		ItemPlus ip3 = new ItemPlus("item3",frt,5);

		System.out.print("\n");
		System.out.print(ip1.toStringl());
		System.out.print("\n");
		System.out.print(ip2.toStringl());
		System.out.print("\n");
		System.out.print(ip3.toStringl());
		System.out.print("\n");
		System.out.print("-----------------------------------------------------------------------------------");
		System.out.print("\n");

		System.out.print("Test for Task3: \n");
		myBagPlus mP = new myBagPlus(6,14);
		System.out.print(mP.putItem(myI1));
		System.out.print(" When adding Item 1, called Banana with weight " + myI1.weight + "\n" );
		System.out.print(mP.putItem(myI2));	
		System.out.print(" When adding Item 2, called Bag of Apples with weight " + myI2.weight + "\n" );
		System.out.print(mP.putItem(myI3));
		System.out.print(" When adding Item 3, called Chicken with weight " + myI3.weight + "\n" );
		System.out.print(mP.putItem(myI4));
		System.out.print(" When adding Item 4, called Rice with weight " + myI4.weight + "\n" );
		System.out.print(mP.putItem(myI5));
		System.out.print(" When adding Item 5, called Pasta with weight " + myI5.weight + "\n" );
		System.out.print(mP.putItem(myI6));
		System.out.print(" When adding Item 6, called Eggs with weight " + myI6.weight + "\n" );
		System.out.print(mP.putItem(myI7));
		System.out.print(" When adding Item 7, called Cheese with weight " + myI7.weight + "\n" );
		System.out.print("---------------------------------------------------------------------------------");
		System.out.print("\n");


		smallBag sb = new smallBag();
		System.out.print("Test for SmallBag weight restrictions: \n");
		System.out.print(" Attempting to add myI1 of weight 5.0, will fail as bag can hold max weight 2.0 ");
		System.out.print(sb.putItem(myI1));
		System.out.print("\n");
		System.out.print(" Attempting to add myI4 of weight 3.0, will fail as bag can hold max weight 2.0 ");
		System.out.print(sb.putItem(myI4));
		System.out.print("\n");
		System.out.print(" Attempting to add myI6 of weight 1.0, will be true as bag can hold max weight 2.0 ");
		System.out.print(sb.putItem(myI6));
		System.out.print("\n");
		System.out.print(" Attempting to add myI7 of weight 1.0, will be true as bag can hold max weight 2.0 ");
		System.out.print(sb.putItem(myI7));
		System.out.print("\n");
		System.out.print(" Attempting to add myI7 AGAIN of weight 1.0, will fail as bag can hold max weight 2.0 ");
		System.out.print(sb.putItem(myI7));
		System.out.print("\n");
		System.out.print("-----------------------------------------------------------------------------------");
		System.out.print("\n");

		mediumBag mb = new mediumBag();
		System.out.print("Test for Mediumbag weight restrictions: \n");
		System.out.print(" Attempting to add myI2 of weight 6.0, will fail as bag can hold max weight 5.0 ");
		System.out.print(mb.putItem(myI2));
		System.out.print("\n");
		System.out.print(" Attempting to add myI4 of weight 3.0, will be true as bag can hold max weight 5.0 ");
		System.out.print(mb.putItem(myI4));
		System.out.print("\n");
		System.out.print(" Attempting to add myI6 of weight 1.0, will be true as bag can hold max weight 5.0 ");
		System.out.print(mb.putItem(myI6));
		System.out.print("\n");
		System.out.print(" Attempting to add myI7 of weight 1.0, will be true as bag can hold max weight 5.0 ");
		System.out.print(mb.putItem(myI7));
		System.out.print("\n");
		System.out.print(" Attempting to add myI7 AGAIN of weight 1.0, will be false as bag can hold max weight 5.0 ");
		System.out.print(mb.putItem(myI7));
		System.out.print("\n");
		System.out.print("-----------------------------------------------------------------------------------");
		System.out.print("\n");

		bigBag bb = new bigBag();
		System.out.print("Test for BigBag weight restrictions: \n");
		System.out.print(" Attempting to add myI2 of weight 6.0, will be true as bag can hold max weight 15.0 ");
		System.out.print(bb.putItem(myI2));
		System.out.print("\n");
		System.out.print(" Attempting to add myI3 of weight 8.0, will be true as bag can hold max weight 15.0 ");
		System.out.print(bb.putItem(myI3));
		System.out.print("\n");
		System.out.print(" Attempting to add myI6 of weight 1.0, will be true as bag can hold max weight 15.0 ");
		System.out.print(bb.putItem(myI6));
		System.out.print("\n");
		System.out.print(" Attempting to add myI7 of weight 1.0, will be false as bag can hold max weight 15.0 ");
		System.out.print(bb.putItem(myI7));
		System.out.print("\n");
		System.out.print("-----------------------------------------------------------------------------------");
		System.out.print("\n");



		mP.removeAll();
	}

}