package start;

public enum StudSelection {
	GENDER, FIRST_NAME, LAST_NAME, BIRTH_DATE, MATRICULATION_DATE, 
	ANY_ERROR, PROPER, NAME;

	@Override
	public String toString() {
		String name="";
		
		if(GENDER.equals(this)) {
			name="Gender";
			return name;
		}
		if(FIRST_NAME.equals(this)) {
			name="FName";
			return name;
		}
		if(LAST_NAME.equals(this)) {
			name="LName";
			return name;
		}
		if(BIRTH_DATE.equals(this)) {
			name="BDate";
			return name;
		}
		if(MATRICULATION_DATE.equals(this)) {
			name="MDate";
			return name;
		}
		if(ANY_ERROR.equals(this)) {
			name="AError";
			return name;
		}
		if(PROPER.equals(this)) {
			name="Proper";
			return name;
		}
		if(NAME.equals(this)) {
			name="Name";
			return name;
		}
		name="Null";
		return name;
	}
}
