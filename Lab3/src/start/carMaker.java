package start;

import start.carMaker;

public enum carMaker {
	FIAT, FORD, VOLVO, BMW, CHRYSLER, GM, NOTKNOWN;


	
	public static carMaker convertString(String S){
		if(S.equalsIgnoreCase("fiat")){
			return FIAT;
		}
		if(S.equalsIgnoreCase("ford")){
			return FORD;
		}
		if(S.equalsIgnoreCase("volvo")){
			return VOLVO;
		}
		if(S.equalsIgnoreCase("bmw")){
			return BMW;
		}
		if(S.equalsIgnoreCase("chrysler")){
			return CHRYSLER;
		}
		if(S.equalsIgnoreCase("gm")){
			return GM;
		}
		else{
			return NOTKNOWN;
		}
	}
		
	public String toString (){
		String name="";
		if(FIAT.equals(this)){
			name="Fiat";
			return name;
		} 
		if(FORD.equals(this)){
			name="Ford";
			return name;
		}
		if(VOLVO.equals(this)){
			name="Volvo";
			return name;
		}
		if(BMW.equals(this)){
			name="BMW";
			return name;
		}
		if(CHRYSLER.equals(this)){
			name="Chrysler";
			return name;
		}
		if(GM.equals(this)){
			name="GM";
			return name;
		}
		else{
			name="NotKnown";
			return name;
		}
	}
}
	
	
