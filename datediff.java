package sample1;
import java.util.*;

public class datediff {
	
	private static final int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};//days in the month
    
    public int diff(int year1,int month1, int day1,int year2, int month2,int day2){
    	
    	int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
    	String[] week=new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    	String[] month=new String[]{"Jan", "Feb", "March", "April", "May", "June", "July", "August",
    								"Sept", "Oct", "Nov", "Dec"};//This to store the months
    	
        int days1 = year1*365 + day1;//adding the year difference and getting the days.
        int days2 = year2*365 + day2;
        
        for(int i=0; i < month1-1; i++){//getting the number of days in month.
            days1 = days1 + days[i];
        }
    
        for(int i=0; i < month2-1; i++){
            days2 = days2 + days[i];
        }
        
        days1 = days1 + (year1-1)/4  - (year1 -1)/100 + (year1 -1 )/400; //calculation for number of days 
        days2 = days2 + (year2-1)/4  - (year2 -1)/100 + (year2 -1 )/400; 
        
        if(isLeapYear(year1) && month1 > 2){//checking for the leap year conditions.
            days1++;
        }
        if(isLeapYear(year2) && month2 > 2){
            days2++;
        }
        
        System.out.print(week[(( year1 + year1/4 - year1/100 + year1/400 + t[month1-1] + day1) % 7)]+","
        					+" "+month[month1-1]+" "+day1+ " " + year1 + " to " );
        System.out.println(week[(( year2 + year2/4 - year2/100 + year2/400 + t[month2-1] + day2) % 7)]+","
							+" "+month[month2-1]+" "+day2+ " " + year2 + " is " +Math.abs(days2 - days1 + 1) + " Days");
        
        return Math.abs(days2 - days1);
        
    }
    
    public boolean isLeapYear(int year){
        if(year % 400 == 0){
            return true;
        }
        if(year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }
    
    public static void main(String args[]){
    	datediff dd = new datediff();
    	Scanner kbd = new Scanner(System.in);
    	System.out.println(dd.diff(2014, 8, 11, 2015, 05, 31));//sample input
    	boolean loop = true;
    	System.out.println("Enter 'q' to exit");
    	String a;
    	while(loop){ //input taken inside this loop until explicitly “q” by user.
    		System.out.println("Enter the two dates");
    		a = kbd.nextLine();
    		if(a.equals("q")){
    			System.out.println("Thank you :) ");
    			break;
    			}
    		dd.diff(Integer.parseInt(a.substring(0,4)), Integer.parseInt(a.substring(4,6)), Integer.parseInt(a.substring(6,8)), 
    				Integer.parseInt(a.substring(9,13)), Integer.parseInt(a.substring(13,15)), Integer.parseInt(a.substring(15,17)));
    	}
    }
}
