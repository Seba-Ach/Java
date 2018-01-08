package start;

import java.io.*;
import java.util.*;

public class StudentData  {

	private Gender gender;
	private String firstName;
	private String lastName;
	protected GregorianCalendar birthDate; //GregorianCalendar Birthday = new GregorianCalendar(2012, Calendar.JANUARY, 1);
	protected GregorianCalendar matriculationDate;// = new GregorianCalendar();
	
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
		String s;
		s = Character.toUpperCase(firstName.charAt(0)) 
				+ firstName.substring(1);
		this.firstName = s;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	} 

	
	public StudentData(String s) throws MyExcepts
	{
		if(s.split(";").length == 5) // checking if correct format
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
			
			//SETTING MATRIC DATE
			matricDateSetter(s.split(";")[4]);	
			
			//CHECKING IF STUDENT IS ABOVE OR EQUAL 17 AND BELOW OR EQUAL 70
			checkDates.matricChecker(this.birthDate,this.matriculationDate);
		}
		else if(s.split(";").length != 5) {
			System.out.println("Wrong Format of entry.");
		}
	}
		
	public void birthDateSetter (String s) throws MyExcepts{
		//split the temp once more into 3 subparts to extract year,month and date from temp, then parse as int and
		//last i use .trim() function to trim all whitespace as parse wouldnt work with whitespace at the beginning or end.
		checkDates bday = new checkDates();
		bday.Dateformat(s);
		this.birthDate = new GregorianCalendar(bday.getY(),bday.getM(),bday.getD());	
	}
	
	public void matricDateSetter (String s) throws MyExcepts{
		//split the temp once more into 3 subparts to extract year,month and date from temp, then parse as int and
		//last i use .trim() function to trim all whitespace as parse wouldnt work with whitespace at the beginning or end.
		checkDates matr = new checkDates();
		matr.Dateformat(s);
		this.matriculationDate = new GregorianCalendar(matr.getY(),matr.getM(),matr.getD());	
	}
	
	public static void showLines(String file_name,StudSelection sel) throws MyExcepts{
		String filename = file_name;
		File file = new File(filename);	
		ArrayList<String> studentInfo = new ArrayList<String>();
		BufferedReader br;
		String type=sel.toString();
		try {
			br = new BufferedReader(new FileReader(file));			
			String line = br.readLine();
		//	int i=0;
		    while(line != null){
		     //   System.out.println("Adding " + line + " to ArrayList. " + i);
		   //     i++;
		       studentInfo.add(line);
		        line = br.readLine();
		    }
			br.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found exception, please change.");
		} 
		catch (IOException e) {
			System.out.println("ERROR: Couldnt not read file.");
		}
		
		for(String data : studentInfo) {
			try {
				new StudentData(data);
			}
			catch(GenderExcepts e) {
				if(type.equalsIgnoreCase("gender")|| type.equalsIgnoreCase("aerror")) {
					System.out.print("ERROR: Check gender for student data: "+data + "\n");
				}
			}  
			catch(FNameExcepts e) {
				if(type.equalsIgnoreCase("fname")|| type.equalsIgnoreCase("aerror") || type.equalsIgnoreCase("name")) {
					System.out.print("ERROR: Either first name or last name is wrong for student data: "+data+ "\n");
				}
			}
			catch(LNameExcepts e) {
				if(type.equalsIgnoreCase("lname")|| type.equalsIgnoreCase("aerror") || type.equalsIgnoreCase("name")) {
					System.out.print("ERROR: Either first name or last name is wrong for student data: "+data+ "\n");
				}
			}
			catch(BDateExcepts e) {
				if(type.equalsIgnoreCase("bdate")|| type.equalsIgnoreCase("aerror")) {
					System.out.print("ERROR: Please check BirthDate for student data: "+data+ "\n");
				}
			}
			catch(MatricDateExcepts e) {
				if(type.equalsIgnoreCase("mdate")|| type.equalsIgnoreCase("aerror")) {
					System.out.print("ERROR: Please check Matriculation date for student data: "+data+ "\n");
				}
			}
			catch(MatricBoundsExcepts e) {
				if(type.equalsIgnoreCase("aerror")|| type.equalsIgnoreCase("mdate")) {
					System.out.print("ERROR: Please check Matriculation date for student data: "+data+ "\n");
				}
			}
		}
	}
	
	public static String showLinesForGUI(String file_name,StudSelection sel) throws MyExcepts{
		String filename = file_name;
		String ret="";
		File file = new File(filename);	
		ArrayList<String> studentInfo = new ArrayList<String>();
		BufferedReader br;
		String type=sel.toString();
		try {
			br = new BufferedReader(new FileReader(file));			
			String line = br.readLine();
		//	int i=0;
		    while(line != null){
		     //   System.out.println("Adding " + line + " to ArrayList. " + i);
		   //     i++;
		       studentInfo.add(line);
		        line = br.readLine();
		    }
			br.close();
		}
		catch(FileNotFoundException e) {
			ret="ERROR: File not found exception, please change.";
			return ret;
		} 
		catch (IOException e) {
			ret="ERROR: Couldnt not read file.";
			return ret;
		}
		
		for(String data : studentInfo) {
			try {
				new StudentData(data);
			}
		/*	catch(MyExcepts e) {
				new MyExcepts(data);
			} */
			catch(GenderExcepts e) {
				if(type.equalsIgnoreCase("gender")|| type.equalsIgnoreCase("aerror")) {
					ret=ret+"ERROR: Gender Error for: "+data + "\n";
					
				}
			}  
			catch(FNameExcepts e) {
				if(type.equalsIgnoreCase("fname")|| type.equalsIgnoreCase("aerror") || type.equalsIgnoreCase("name")) {
					ret=ret+"ERROR: Name Error for: "+data+ "\n";
					
				}
			}
			catch(LNameExcepts e) {
				if(type.equalsIgnoreCase("lname")|| type.equalsIgnoreCase("aerror") || type.equalsIgnoreCase("name")) {
					ret=ret+"ERROR: Name Error for: "+data+ "\n";
					
				}
			}
			catch(BDateExcepts e) {
				if(type.equalsIgnoreCase("bdate")|| type.equalsIgnoreCase("aerror")) {
					ret=ret+"ERROR: Birthdate Error for: "+data+ "\n";
					
				}
			}
			catch(MatricDateExcepts e) {
				if(type.equalsIgnoreCase("mdate")|| type.equalsIgnoreCase("aerror")) {
					ret=ret+"ERROR: Matriculation Error for: "+data+ "\n";
					
				}
			}
			catch(MatricBoundsExcepts e) {
				if(type.equalsIgnoreCase("aerror") || type.equalsIgnoreCase("mdate")) {
					ret=ret+"ERROR: Matriculation Bounds Error for: "+data+ "\n";
					
				}
			}
		}
		return ret;
	}
	
	public static void main (String[] args) throws MyExcepts{
		
	//	String a = "M;john; Brown; 90/03/20;2010/01/2";
	//	StudentData john = new StudentData(a);
	//	StudSelection asel = StudSelection.GENDER;
		showLines("testme.txt",StudSelection.ANY_ERROR);
	}
	
}
