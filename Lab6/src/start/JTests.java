package start;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class JTests {

	@Test
	public void testWorking() {
		String a = "M;john;Brown;90/03/01;07/03/02";
		StudentData john = new StudentData(a);
		assertEquals("Male",john.getGender().toString());
		assertEquals("John",john.getFirstName());
		assertEquals("Brown",john.getLastName());
		assertEquals(1990,john.birthDate.get(Calendar.YEAR));
		assertEquals(3,john.birthDate.get(Calendar.MONTH));
		assertEquals(1,john.birthDate.get(Calendar.DATE));
		assertEquals(2007,john.matriculationDate.get(Calendar.YEAR));
		assertEquals(3,john.matriculationDate.get(Calendar.MONTH));
		assertEquals(2,john.matriculationDate.get(Calendar.DATE));
	}

	@Test
	public void testgends() {
		String a = "m;john;Brown;90/03/01;07/03/02";
		String b = "maLe;john;Brown;90/03/01;07/03/02";
		String c = "f;naomi;Brown;90/03/01;07/03/02";
		String d = "feMaLE;naomi;Brown;90/03/01;07/03/02";
		
		StudentData john = new StudentData(a);
		assertEquals("Male",john.getGender().toString());
		StudentData john2 = new StudentData(b);
		assertEquals("Male",john2.getGender().toString());
		
		StudentData naomi2 = new StudentData(c);
		assertEquals("Female",naomi2.getGender().toString());
		StudentData naomi3 = new StudentData(d);
		assertEquals("Female",naomi3.getGender().toString());
		
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongGend() throws Exception {
		String a = "g;john;Brown;90/03/01;2009/01/01";
		new StudentData(a);
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongfName() throws Exception {
		String a = "m;johnasd;Brown;90/03/01;2009/01/01";
		new StudentData(a);
	}
	
	@Test (expected=MyExcepts.class)
	public void wronglName() throws Exception {
		String a = "f;john;Brown-sas-d;90/03/01;2009/01/01";
		new StudentData(a);
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongYear() throws Exception {
		String a = "f;john;Brown-sas-d;0/03/01;2009/01/01";
		new StudentData(a);
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongMonth() throws Exception {
		String a = "f;john;Brown-sas-d;90/14/01;2009/01/01";
		new StudentData(a);
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongDate() throws Exception {
		String a = "f;john;Brown-sas-d;90/03/01;2009/01/87";
		new StudentData(a);
	}

}
