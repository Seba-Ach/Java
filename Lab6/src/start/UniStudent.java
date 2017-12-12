package start;

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
	
	public Gender getGender() {
		return gender;
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
			this.graduationDay = null;
		}
		else{
			checkDates matr = new checkDates();
			matr.Dateformat(s);
			this.graduationDay = new GregorianCalendar(matr.getY(),matr.getM(),matr.getD());	
		}
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
			setYearOfStudy(Integer.parseInt(s.split(";")[6]));
			
			//SETTING ID
			setId(Integer.parseInt(s.split(";")[7]));
			
		}
		else {
			System.out.println("Wrong Format of entry.");
		}
	}
	
}
