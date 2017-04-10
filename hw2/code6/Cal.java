/** 
 *
 * Sum Of Args
 * @author Qinka qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import java.util.*;

class Cal
{
    public static void main(String[] args)
    {
	GregorianCalendar gcl = new GregorianCalendar();
	if(args.length >= 2)
	    {
		gcl.set(Calendar.YEAR, Integer.parseInt(args[1]));
		gcl.set(Calendar.MONTH, Integer.parseInt(args[0]) - 1);
		gcl.set(Calendar.DAY_OF_MONTH, 1);
	    }
	else
	    {
		gcl.set(Calendar.DAY_OF_MONTH, 1);
	    }
	int m = gcl.get(Calendar.MONTH);
	System.out.println(disMonth(gcl.get(Calendar.MONTH))+" "+gcl.get(Calendar.YEAR));
	System.out.println(" Su Mo Tu We Th Fr Sa");    
	int weekday = gcl.get(Calendar.DAY_OF_WEEK);   
	int totalDay = -(weekday-2);
	while(m == gcl.get(Calendar.MONTH))
	    {
		if (totalDay <= 0)
		    System.out.print("   ");
		else
		    {
			int day = gcl.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			weekday = gcl.get(Calendar.DAY_OF_WEEK);
			if(weekday == Calendar.SATURDAY)
			    {
				System.out.println();
			    }
			gcl.add(Calendar.DAY_OF_MONTH, 1);
		    }
		totalDay++;
	    }
	System.out.println();
					    
    }
    public static String disMonth(int i)
    {
	switch(i+1)
	    {
	    case 1: return "January";
	    case 2: return "February";
	    case 3: return "March";
	    case 4: return "April";
	    case 5: return "May";
	    case 6: return "June";
	    case 7: return "July";
	    case 8: return "August";
	    case 9: return "September";
	    case 10: return "October";
	    case 11: return "November";
	    case 12: return "December";
	    default: return "undecimber";
	    }
    }
	
}
