/** 
 *
 * Sum Of Args
 * @author Qinka qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */

import java.lang.*;

class SumOfArgs
{
    public static void main(String[] args)
    {
	int sum = 0;
	int tmp = 0;
	for (String item:args)
	    {
		try
		    {
			sum += Integer.parseInt(item);
		    }
		catch(NumberFormatException e)
		    {
			continue;
		    }
	    }
	System.out.println(sum);
    }
}
