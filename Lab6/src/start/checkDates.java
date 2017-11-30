package start;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class checkDates {
	
	private int y=0,m=0,d=0;
	
	public static int yearChanger(int y){
		if(y<18) {
			y=y+2000;				
		}
		else if(y>=18 && y<100) {
			y=y+1900;
		}
		return y;
	}

	public static boolean negDate (int y,int m, int d) {
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
	
	public static void matricChecker(GregorianCalendar birth, GregorianCalendar matr)throws MyExcepts {
		
		int y,m,d, y0,m0,d0;
		y=birth.get(Calendar.YEAR);
		m=birth.get(Calendar.MONTH)+1;
		d=birth.get(Calendar.DAY_OF_MONTH);
		
		y0=matr.get(Calendar.YEAR);
		m0=matr.get(Calendar.MONTH)+1;
		d0=matr.get(Calendar.DAY_OF_MONTH);
		
		
		
		if(y0-y>=17 && y0-y<=70 ) {  //checking if student isnt 17-70 then i throw exception
			if(y0-y==17 && m0-m<=0) {
				if(d0-d<0 || m0-m<0) {
					throw new MatricBoundsExcepts();	
				}
			}
		}
		else if(y0-y < 17 || y0-y > 70) {
			throw new MatricBoundsExcepts();				
		}
	}

	
	public void Dateformat(String s){
		this.y=Integer.parseInt(s.split("/")[0].trim());
		this.m=Integer.parseInt(s.split("/")[1].trim());
		this.d=Integer.parseInt(s.split("/")[2].trim());
		if(checkDates.negDate(y,m,d)) {
			throw new BDateExcepts();
		}
		this.y=checkDates.yearChanger(y);
	}
	

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public int getM() {
		return m;
	}
	

	public void setM(int m) {
		this.m = m;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

}
