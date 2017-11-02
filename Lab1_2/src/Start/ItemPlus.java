package Start;

class ItemPlus extends Item {
	protected FruitName fn;
	
	public ItemPlus(String name, String fruitName, double weight){
		this.name=name;
		this.fn=FruitName.getFruitName(fruitName);
		if(this.weight<=0){
			this.weight=1.0;
		}
		this.weight=weight;
	}
	public ItemPlus(String s){
		this.name=s;
	}
	public ItemPlus(String name, FruitName fruitName,double weight){
		this.name=name;
		this.fn=fruitName;
		if(this.weight<=0){
			this.weight=1.0;
		}
		this.weight=weight;
	}
}