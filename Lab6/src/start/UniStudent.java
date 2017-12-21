package start;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class UniStudent {

	private Gender gender;
	private String firstName;
	private String lastName;
	protected GregorianCalendar birthDate; //GregorianCalendar Birthday = new GregorianCalendar(2012, Calendar.JANUARY, 1);
	protected GregorianCalendar graduationDay;// = new GregorianCalendar();
	private int yearOfAdmission;
	private int yearOfStudy;
	private int id;
	ArrayList<Integer> allID = new ArrayList<Integer>();
	
	
	public Gender getGender() {
		return gender;
	}
	
	public Date getBirthD() {
		return this.birthDate.getTime();
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public GregorianCalendar getGradDate() {
		return this.graduationDay;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearOfAdmission() {
		return yearOfAdmission;
	}

	public void setYearOfAdmission(int yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
	    		return this.getGender()+";"+this.getFirstName()+";"+this.getLastName()+";"+this.getYearOfStudy()+"\n";    		
	}
	
	public void birthDateSetter (String s) throws MyExcepts{
		//split the temp once more into 3 subparts to extract year,month and date from temp, then parse as int and
		//last i use .trim() function to trim all whitespace as parse wouldnt work with whitespace at the beginning or end.
		checkDates bday = new checkDates();
		bday.Dateformat(s);
		this.birthDate = new GregorianCalendar(bday.getY(),bday.getM(),bday.getD());	
	}
	
	public void gradDateSetter (String s) throws MyExcepts{
		//split the temp once more into 3 subparts to extract year,month and date from temp, then parse as int and
		//last i use .trim() function to trim all whitespace as parse wouldnt work with whitespace at the beginning or end.
		if(s.trim().equalsIgnoreCase("_")) {
			//this.graduationDay = new GregorianCalendar(0,0,0);
			this.graduationDay =null;
		}
		else{
			checkDates gradD = new checkDates();
			gradD.Dateformat(s);
			if((Integer.parseInt(s.split(";")[5])>gradD.getY())){
				throw new GradExcepts();
			}
			this.graduationDay = new GregorianCalendar(gradD.getY(),gradD.getM(),gradD.getD());	
		}
	}
	
	public void NegNumChecker(int x) throws MyExcepts{
		if(x<=0) {
			throw new NegNumExcepts();
		}
	}
	
	public void UniqueIDChecker(int i) {
		for(int id : allID) {
			if(id==i) {
				throw new IDExcepts();
			}
		}
		allID.add(i);
	}
	
	public UniStudent(String s) throws MyExcepts
	{
		if(s.split(";").length == 8) // checking if correct format
		{			
			//CHECKING FOR GENDER
			Gender.genderChecker(s.split(";")[0].trim());
			setGender(Gender.toEnum(s.split(";")[0].trim()));
			
			//SETTING FIRST NAME
			checkNames.fnameChecker(s.split(";")[1].trim());
			setFirstName(s.split(";")[1].trim());
			
			//SETTING LAST NAME
			checkNames.lnameChecker(s.split(";")[2].trim());
			setLastName(s.split(";")[2].trim());			
			
			//SETTING BIRTHDATE
			birthDateSetter(s.split(";")[3]);		
			
			//SETTING GRADUATION DATE
			gradDateSetter(s.split(";")[4]);	
			
			//SETTING YEAR OF ADMISSION
			setYearOfAdmission(Integer.parseInt(s.split(";")[5]));
			
			//SETTING YEAR OF STUDY
			NegNumChecker(Integer.parseInt(s.split(";")[6]));
			setYearOfStudy(Integer.parseInt(s.split(";")[6]));
			
			//SETTING ID
			UniqueIDChecker(Integer.parseInt(s.split(";")[7]));
			setId(Integer.parseInt(s.split(";")[7]));
			
		}
		else {
			System.out.println("Wrong Format of entry.");
		}
	}
	
}
