package start;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Vector;

public class UniHashSet {
    private UniHashSet(){}
    private static HashSet<UniStudent> students = new HashSet<UniStudent>();
    
    public static void add(UniStudent r) throws MyExcepts
    {
        for (UniStudent currentStudent : students)
        {
            if(r.getId() == currentStudent.getId())
                throw new IDExcepts();
        }
        students.add(r);
    }

    private static void sort(String field, Vector<UniStudent> itemLocationList) {
        Collections.sort(itemLocationList, new Comparator<UniStudent>() {
            @Override
            public int compare(UniStudent o1, UniStudent o2) {
                if (field.equals("name")) {
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }else if(field.equals("gender")) {
                    return o1.getGender().compareTo(o2.getGender());
                } else if(field.equals("gradDate")) {
                	if(o1.getGradDate()==null||o2.getGradDate()==null) {
                		return 0;
                	}
                    return o1.getGradDate().compareTo(o2.getGradDate());
                }
                else if(field.equals("yearOfStudy")) {
                    return o1.getYearOfStudy() - o2.getYearOfStudy();
                }
                else
                {
                    return 0;
                }
            }
        });
    }

    public static Vector<UniStudent> orderByName()
    {
        Vector<UniStudent> vector_students = new Vector<>(students);
        sort("name", vector_students);
        return vector_students;
    }

    public static Vector<UniStudent> orderByGenderAndMatriculation()
    {
        Vector<UniStudent> vector_students = new Vector<>(students);
        sort("gender", vector_students);
        sort("gradDate", vector_students);
        return vector_students;
    }

    public static Vector<UniStudent> orderByNameAndYearOfStudy()
    {
        Vector<UniStudent> vector_students = new Vector<>(students);
        sort("name", vector_students);
        sort("yearOfStudy", vector_students);
        return vector_students;
    }
    
    public static void main(String args[])
    {
    	UniStudent student = new UniStudent("F;Jude;Smith;92/04/20;_;2012;3;123");
        UniStudent student2 = new UniStudent("M;David;Bird;93/09/15;_;2014;2;321");
        UniStudent student3 = new UniStudent("M;AAron;Smith;89/11/2;_;2015;1;345");
        UniStudent student4 = new UniStudent("F;Lily;Goodman;77/06/27;_;2001;5;453");
        UniStudent student5 = new UniStudent("F;AAron;Strongman;95/02/1;_;2016;1;567");
        try {
            UniHashSet.add(student);
            UniHashSet.add(student2);
            UniHashSet.add(student3);
            UniHashSet.add(student4);
            UniHashSet.add(student5);
        }catch(IDExcepts e)
        {
            System.out.println("ID must be unique for every student.");
            e.printStackTrace();
        }
        System.out.println(UniHashSet.orderByName());
        System.out.println(UniHashSet.orderByGenderAndMatriculation());


    }
}