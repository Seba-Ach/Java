package start;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Vector;

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
		new StudentData("g;john;Brown;90/03/01;2009/01/01");
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongfName() throws Exception {
		new StudentData("m;johnasd;Brown;90/03/01;2009/01/01");
	}
	
	@Test (expected=MyExcepts.class)
	public void wronglName() throws Exception {
		new StudentData("f;john;Brown-sas-d;90/03/01;2009/01/01");
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongYear() throws Exception {
		new StudentData("f;john;Brown-sas-d;0/03/01;2009/01/01");
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongMonth() throws Exception {
		new StudentData("f;john;Brown-sas-d;90/14/01;2009/01/01");
	}
	
	@Test (expected=MyExcepts.class)
	public void wrongDate() throws Exception {
		new StudentData("f;john;Brown-sas-d;90/03/01;2009/01/87");
	}
	
	@Test 
	public void UniStuds() {
		UniStudent first = new UniStudent("F;Mary;Brown;85/03/20;_;2009;1;111");
		assertEquals("Female",first.getGender().toString());
		assertEquals("Mary",first.getFirstName());
		assertEquals("Brown",first.getLastName());
		assertEquals(2009,first.getYearOfAdmission());
		assertEquals(1,first.getYearOfStudy());
		assertEquals(111,first.getId());
	}
	
	@Test (expected=MyExcepts.class)
	public void UniStudsIDFAILVect() throws Exception {
		UniStudent juan = new UniStudent("F;Mary;Brown;85/03/20;_;2009;1;111");
		UniStudent dos = new UniStudent("F;Mary;Brown;85/03/20;_;2009;1;111");
		
		UniVector.add(juan);
		UniVector.add(dos);
	}
	
	@Test (expected=MyExcepts.class)
	public void UniStudsIDFAILHash() throws Exception {
		UniStudent juan = new UniStudent("F;Mary;Brown;85/03/20;_;2009;1;111");
		UniStudent dos = new UniStudent("F;Mary;Brown;85/03/20;_;2009;1;111");
		
		UniHashSet.add(juan);
		UniHashSet.add(dos);
	}
	
	@Test (expected=MyExcepts.class)
	public void UniStudsIDFAILTreeMap() throws Exception {
		UniStudent juan = new UniStudent("F;Mary;Brown;85/03/20;_;2009;1;111");
		UniStudent dos = new UniStudent("F;Mary;Brown;85/03/20;_;2009;1;111");
		
		UniTreeMap.add(juan);
		UniTreeMap.add(dos);
	}
	
	@Test 
	public void HashSetSorts() {
		UniStudent one = new UniStudent("F;AAron;Strongman;95/02/1;_;2016;3;567");
        UniStudent two = new UniStudent("M;David;Zird;93/09/15;_;2014;2;321");
        UniStudent three = new UniStudent("F;Jude;Smith;92/04/20;_;2012;1;123");

        
        UniHashSet.add(one);
        UniHashSet.add(two);
        UniHashSet.add(three);
        Vector<UniStudent> nameSort = UniHashSet.orderByName();
        assertEquals("AAron",nameSort.elementAt(0).getFirstName());
        assertEquals("David",nameSort.elementAt(1).getFirstName());
        assertEquals("Jude",nameSort.elementAt(2).getFirstName());
        
        nameSort = UniHashSet.orderByNameAndYearOfStudy();
        assertEquals("Jude",nameSort.elementAt(0).getFirstName());
        assertEquals("David",nameSort.elementAt(1).getFirstName());
        assertEquals("AAron",nameSort.elementAt(2).getFirstName());
        
        nameSort = UniHashSet.orderByGenderAndMatriculation();
        assertEquals("David",nameSort.elementAt(0).getFirstName());
        assertEquals("AAron",nameSort.elementAt(1).getFirstName());
        assertEquals("Jude",nameSort.elementAt(2).getFirstName());
	}
	
	@Test 
	public void TreeMapSorts() {
		UniStudent one = new UniStudent("F;AAron;Strongman;95/02/1;_;2016;3;567");
        UniStudent two = new UniStudent("M;David;Zird;93/09/15;_;2014;1;321");
        UniStudent three = new UniStudent("F;Jude;Smith;92/04/20;_;2012;3;123");

        UniTreeMap.add(one);
        UniTreeMap.add(two);
        UniTreeMap.add(three);
        Vector<UniStudent> nameSort = UniTreeMap.orderByName();
        assertEquals("AAron",nameSort.elementAt(0).getFirstName());
        assertEquals("David",nameSort.elementAt(1).getFirstName());
        assertEquals("Jude",nameSort.elementAt(2).getFirstName());
        
        nameSort = UniTreeMap.orderByNameAndYearOfStudy();
        assertEquals("David",nameSort.elementAt(0).getFirstName());
        assertEquals("AAron",nameSort.elementAt(1).getFirstName());
        assertEquals("Jude",nameSort.elementAt(2).getFirstName());
        
        nameSort = UniTreeMap.orderByGenderAndMatriculation();
        assertEquals("David",nameSort.elementAt(0).getFirstName());
        assertEquals("Jude",nameSort.elementAt(1).getFirstName());
        assertEquals("AAron",nameSort.elementAt(2).getFirstName());
	}
	
	@Test 
	public void VectorSorts() {
		UniStudent one = new UniStudent("F;AAron;Strongman;95/02/1;_;2013;3;567");
        UniStudent two = new UniStudent("M;David;Zird;93/09/15;_;2014;1;321");
        UniStudent three = new UniStudent("F;Jude;Smith;92/04/20;_;2016;4;123");

        UniVector.add(one);
        UniVector.add(two);
        UniVector.add(three);
        Vector<UniStudent> nameSort = UniVector.orderByName();
        assertEquals("AAron",nameSort.elementAt(0).getFirstName());
        assertEquals("David",nameSort.elementAt(1).getFirstName());
        assertEquals("Jude",nameSort.elementAt(2).getFirstName());
        
        nameSort = UniVector.orderByNameAndYearOfStudy();
        assertEquals("David",nameSort.elementAt(0).getFirstName());
        assertEquals("AAron",nameSort.elementAt(1).getFirstName());
        assertEquals("Jude",nameSort.elementAt(2).getFirstName());
        
        nameSort = UniVector.orderByGenderAndMatriculation();
        assertEquals("David",nameSort.elementAt(0).getFirstName());
        assertEquals("Jude",nameSort.elementAt(2).getFirstName());
        assertEquals("AAron",nameSort.elementAt(1).getFirstName());
	}

}
