package Start;

public enum FruitName {
		APPLE, 
		BANANA, 
		PLUM, 
		PEACH, 
		UNKNOWN;
		
		public static FruitName getFruitName(String S){
			if(S.equalsIgnoreCase("Apple")){
				return APPLE;
			}
			if(S.equalsIgnoreCase("banana")){
				return BANANA;
			}
			if(S.equalsIgnoreCase("plum")){
				return PLUM;
			}
			if(S.equalsIgnoreCase("Peach")){
				return PEACH;
			}
			else{
				return UNKNOWN;
			}
		}
		
		public String toString (){
			String name="";
			if(APPLE.equals(this)){
				name="Apple";
				return name;
			} 
			if(BANANA.equals(this)){
				name="Banana";
				return name;
			}
			if(PLUM.equals(this)){
				name="Plum";
				return name;
			}
			if(PEACH.equals(this)){
				name="Peach";
				return name;
			}
			else{
				name="Unknown";
				return name;
			}
		}
		
		
}

