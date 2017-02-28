
/**
 *
 * @author 李约瀚 14130140331
 * Qinka<qinka@live>
 * Copyleft 2017 Qinka
 *
**/



class Hello
{
    public static void main(String []args)
    {
	if(args.length == 0)
	    System.out.println("Hello, World!");
	else if(args.length == 1)
	    System.out.println("Hello, " + args[0] + "!");
	else
	    {
		System.out.print("Hello, ");
		for (int i = 0; i<args.length-1; i++)
		    System.out.print(args[i]+", ");
		System.out.println("and "+args[args.length-1]+"!");
	    }
	return;
    }
}


