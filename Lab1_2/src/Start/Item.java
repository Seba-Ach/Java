package Start;

public class Item {
	
	protected String name;
	protected double weight;
	
	public Item(){
		name="noname";
		weight=1.0;
	}
	
	public Item (String n,double w){
		if (w>10 || w<0){
			w=1.0;
		}
		this.weight=w;
		this.name=n;
	}
	
	public String toStringl() {
		return "Your items name: " + name + " and your items weight: " + weight +".";
	}

}

