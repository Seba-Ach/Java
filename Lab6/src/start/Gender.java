package start;

public enum Gender {
	MALE,FEMALE;

	public static Gender toEnum(String S){
		if(S.equalsIgnoreCase("male")){
			return MALE;
		}
		if(S.equalsIgnoreCase("female")) {
			return FEMALE;
		}
		if(S.equalsIgnoreCase("m")){
			return MALE;
		}
		if(S.equalsIgnoreCase("f")) {
			return FEMALE;
		}
		return null; //not really needed just so eclipse doesnt show errors as returns are in ifstatements
	}
	
	@Override
	public String toString (){
		String name="";
		if(MALE.equals(this)){
			name="Male";
			return name;
		} 
		if(FEMALE.equals(this)){
			name="Female";
			return name;
		}
		return null; // same as above, eclipse error
	}
	
	static boolean genderChecker(String S) {
		if(S.equalsIgnoreCase("male")){
			return true;
		}
		if(S.equalsIgnoreCase("m")){
			return true;
		}
		if(S.equalsIgnoreCase("female")){
			return true;
		}
		if(S.equalsIgnoreCase("f")){
			return true;
		}
		return false;
	}
}


