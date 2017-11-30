package start;

public class MyExcepts extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MyExcepts() {
	//	System.out.print("ERROR: MyExcepts was called. \n");
	} 
	
	public MyExcepts(String s) {
	//	System.out.print("For Student data: " +s);
	}
}

class GenderExcepts extends MyExcepts {
	
	private static final long serialVersionUID = 1L;

	public GenderExcepts() {
	//	System.out.print("\nERROR: Something wrong with Gender. ");
	} 
	
}

class FNameExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	public FNameExcepts() {
	//	System.out.print("\nERROR: Something wrong with First Name. ");
	} 
}

class LNameExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	public LNameExcepts() {
		//System.out.print("\nERROR: Something wrong with Last Name. ");
	} 
}

class BDateExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	public BDateExcepts() {
	//	System.out.print("\nERROR: Something wrong with Birth Date. ");
	}
}

class MatricDateExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	public MatricDateExcepts() {
		//System.out.print("\nERROR: Something wrong with Matriculation Date. ");
	}
}

class MatricBoundsExcepts extends MyExcepts{

	private static final long serialVersionUID = 1L;

	public MatricBoundsExcepts() {
	//	System.out.print("\nERROR: Student not between 17 and 70 years of age. ");
	}
}


