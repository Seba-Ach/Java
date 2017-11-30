package start;

import java.io.*;
import java.util.*;

public class StudentData {

	private Gender gender;
	private String firstName;
	private String lastName;
	protected GregorianCalendar birthDate; //GregorianCalendar Birthday = new GregorianCalendar(2012, Calendar.JANUARY, 1);
	protected GregorianCalendar matriculationDate = new GregorianCalendar();
	
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
			String temp;  			 //string called temp that will hold values of the split strings
			
			
			temp = s.split(";")[0].trim();  // zeroth value, the gender
			if(Gender.genderChecker(temp)){  // call a function genderChecker, to check format
				setGender(Gender.toEnum(temp)); //change from string to enum and then assign it 
			//	System.out.print("Setting "+temp+" as an enum of Gender and it probably succeeded. " + gender.toString() +"\n");				
				}
			else {
			//	System.out.print("Throwing exception in gender checker.\n"); // if genderChecker returns false this will be called and a exception will be thrown
				throw new GenderExcepts();
			}
			
			//next two arguments are passed with no problem as they are simple string to string
			temp = s.split(";")[1].trim();
			fnameChecker(temp);
			setFirstName(temp);
		//	System.out.print("Setting first name to " + temp+ ". \n");
			
			
			temp = s.split(";")[2].trim();
			lnameChecker(temp);
			setLastName(temp);
		//	System.out.print("Setting last name to "+temp+". \n");
			
			
			temp = s.split(";")[3];
			int y,m,d;
			//split the temp once more into 3 subparts to extract year,month and date from temp, then parse as int and
			//last i use .trim() function to trim all whitespace as parse wouldnt work with whitespace at the beginning or end.
			y=Integer.parseInt(temp.split("/")[0].trim());
			m=Integer.parseInt(temp.split("/")[1].trim());
			d=Integer.parseInt(temp.split("/")[2].trim());
			if(negDate(y,m,d)) {
				throw new BDateExcepts();
			}
			y=yearChanger(y);
			this.birthDate = new GregorianCalendar(y,m,d);			
			
			
			temp = s.split(";")[4];
			int y0,m0,d0;
			y0=Integer.parseInt(temp.split("/")[0].trim());
			m0=Integer.parseInt(temp.split("/")[1].trim());
			d0=Integer.parseInt(temp.split("/")[2].trim());
			if(negDate(y0,m0,d0)) {
				throw new MatricDateExcepts();
			}
			y0=yearChanger(y0);
			this.matriculationDate = new GregorianCalendar(y0,m0,d0);
			
			
			if(y0-y>=17 && y0-y<=70 ) {  //checking if student isnt 17-70 then i throw exception
				if(y0-y==17 && m0-m<=0) {
					if(d0-d<0 || m0-m<0) {
						throw new MatricBoundsExcepts();	
					}
				}
			}
			else if(y0-y < 17 || y0-y > 70) {
				throw new MatricBoundsExcepts();				}
		} 
		else if(s.split(";").length != 5) {
			System.out.println("Wrong Format of entry.");
		}
	}
	
	public int yearChanger(int y){
		if(y<18) {
			y=y+2000;				
		}
		else if(y>=18 && y<100) {
			y=y+1900;
		}
		return y;
	}
	
	public boolean lnameChecker(String s) throws MyExcepts {
		int line=0;
		if(!Character.isUpperCase(s.charAt(0))) {
			throw new LNameExcepts();			}
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i)=='-') {
				if(!Character.isUpperCase(s.charAt(i+1))){
					throw new LNameExcepts();					}
				line++;
				if(line>1) {
					throw new LNameExcepts();					}
			}
		}
		return true;
	}
	
	public boolean negDate (int y,int m, int d) {
		if(y<=0||m<=0||d<=0) {
			return true;
		}
		if(m>12) {
			return true;
		}
		if(d>31) {
			return true;
		}
		return false;
	}
	
	public boolean fnameChecker(String s) throws MyExcepts {
		
		String filename = "names.txt";
		File file = new File(filename);	
		ArrayList<String> names = new ArrayList<String>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));			
			String line = br.readLine();
		//	int i=0;
		    while(line != null){
		     //   System.out.println("Adding " + line + " to ArrayList. " + i);
		   //     i++;
		       names.add(line);
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
		
		for(String n : names) {
			if(n.equalsIgnoreCase(s)) {
				return true;
			}
		}
		throw new FNameExcepts();
		
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
		/*	catch(MyExcepts e) {
				new MyExcepts(data);
			} */
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
				if(type.equalsIgnoreCase("aerror")) {
					System.out.print("ERROR: Student can not have matriculation date because students age isnt between 17-70 for student data: "+data+ "\n");
				}
			}
		}
	}
	
	public static void main (String[] args) throws MyExcepts{
		
	//	String a = "M;john; Brown; 90/03/20;2010/01/2";
	//	StudentData john = new StudentData(a);
	//	StudSelection asel = StudSelection.GENDER;
		showLines("testme.txt",StudSelection.FIRST_NAME);
	}
	
}
