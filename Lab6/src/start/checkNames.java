package start;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class checkNames {
	
	 static public boolean lnameChecker(String s) throws MyExcepts {
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
	 
	 public static boolean fnameChecker(String s) throws MyExcepts {
			
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

}
