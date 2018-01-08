package start;

public class MyExcepts extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString(){
		return "Something went wrong.";
	}
	
	public MyExcepts() {
	//	System.out.print("ERROR: MyExcepts was called. \n");
	} 
	
	public MyExcepts(String s) {
	//	System.out.print("For Student data: " +s);
	}
}

class GenderExcepts extends MyExcepts {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check Gender.";
	}
	
	public GenderExcepts() {
	//	System.out.print("\nERROR: Something wrong with Gender. ");
	} 
	
}

class FNameExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check First Name.";
	}
	
	public FNameExcepts() {
	//	System.out.print("\nERROR: Something wrong with First Name. ");
	} 
}

class LNameExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check Last Name.";
	}
	
	public LNameExcepts() {
		//System.out.print("\nERROR: Something wrong with Last Name. ");
	} 
}

class BDateExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check BirthDay.";
	}
	
	public BDateExcepts() {
	//	System.out.print("\nERROR: Something wrong with Birth Date. ");
	}
}

class MatricDateExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check Graduation Date.";
	}
	
	public MatricDateExcepts() {
		//System.out.print("\nERROR: Something wrong with Matriculation Date. ");
	}
}

class MatricBoundsExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check Graduation Date.";
	}
	
	public MatricBoundsExcepts() {
	//	System.out.print("\nERROR: Student not between 17 and 70 years of age. ");
	}
}

class GradExcepts extends MyExcepts {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check Graduation Date.";
	}
	
	public GradExcepts() {
		
	}
}

class NegNumExcepts extends MyExcepts {
	
	private static final long serialVersionUID = 1L;

	public NegNumExcepts() {
		
	}
}

class DuplicateExcepts extends MyExcepts {
	
	private static final long serialVersionUID = 1L;

	public DuplicateExcepts() {
		
	}
}

class IDExcepts extends MyExcepts {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String toString(){
		return "Error: please check ID.";
	}
	
	public IDExcepts() {
		
	}
}
