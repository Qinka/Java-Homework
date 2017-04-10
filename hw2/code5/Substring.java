

/**
 * @author 李约瀚 14130140331
 * Qinka <qinka@live.com>
 * Copyleft 2017 Qinka
 *
 **/

import java.lang.*;

class Substring
{
    public static void main(String[] args)
    {
	int beg,len;
	String output;
	try
	    {
		beg = Integer.parseInt(args[1]);
		len = Integer.parseInt(args[2]);
		output = args[0].substring(beg,len);
		System.out.println(output);
	    }
	catch(NumberFormatException e)
	    {
		System.err.println("Fail to parse integer" + e);
	    System.out.println("Useage:");
	    System.out.println("\t $THIS \"string\" index length");
	    System.exit(1);
	    }
	catch(ArrayIndexOutOfBoundsException e)
	    {
		System.err.println("Fail to get all args" + e);
	    System.out.println("Useage:");
	    System.out.println("\t $THIS \"string\" index length");
	    System.exit(1);
	    }
	catch(Exception e)
	    {
		System.out.println("\t"+e);
		System.out.println("Useage:");
		System.out.println("\t $THIS \"string\" index length");
		System.exit(1);
	    }
    }
}
