/**
 *
 * PIM
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */



import java.lang.*;
import java.util.*;
import java.util.function.*;
import java.io.*;


public class PIMManager
{


    // for quit
    public static Opt __quit =
	new Opt("quit",null,(_m -> throw new WExitException();));
    // for save
    public static Opt __save =
	new Opt("save","using save to save or push datas to remote or files",
		_m ->
		{
		    if (_m instanceof PIMCollectionStored)
			{
			    ((PIMCollectionStored)_collection).push();
			}
		    else
			{
			    System.err.println("WARRNING: Sorry the collection of PIMBasecollection is not an instance of PIMCollectionstored, and that means it is save will not do anything.");
			}
		});
    // for load
    public static Opt __load =
	new Opt("save","using save to save or push datas to remote or files",
		_m ->
		{
		    if (_m instanceof PIMCollectionStored)
			{
			    ((PIMCollectionStored)_collection).push();
			}
		    else
			{
			    System.err.println("WARRNING: Sorry the collection of PIMBasecollection is not an instance of PIMCollectionstored, and that means it is save will not do anything.");
			}
		});
	
    // for list
    public static Opt __list =
	new Opt("list","list all the items in the repo",
		_m ->
		{
		    int size =  _m._collection.size();
		    System.out.println("There " + size>1?"are ":"is " + size + " item" + size>1?"s":"");
		    int itemid = 0;
		    Function<PIMEntity,void> printItem = _p ->
		    {
			if(_p.getClass().equals(PIMAppointment.class))
			    {
				PIMAppointment a = (PIMAppointment)_p;
				System.out.println("Item "+itemid+": APPOINTMENT "+a.getPriority()+" "+ a.getDate());
				System.out.println("\t "+a.getContext());
			    }
			else if(_p.getClass().equals(PIMContact.class))
			    {
				PIMContact a = (PIMContact) _p;				
				System.out.println("Item "+itemid+": CONTACT "+a.getPriority());
				System.out.println("\t Name: "+a.getFirstName()+" "+a.getLastName());
				System.out.println("\t EMail: "+a.getEmail());
			    }
			else if(_p.getClass().equals(PIMNote.class))
			    {
				PIMNote a = (PIMNote) _p;
				System.out.println("Item "+itemid+": NOTE "+a.getPriority());
				System.out.println("\t " + a.getContext());
			    }
			else if(_p.getClass().equals(PIMTodo.class))
			    {
				PIMTodo a = (PIMTodo) _p;
				System.out.println("Item "+itemid+": TODO "+a.getPriority()+" "+ a.getDate());
				System.out.println("\t" + a.getContext());
			    }
			else
			    {
				System.err.println("WARRNING: This can not happen.");
			    }
		    }
		    
		}
		
	// For add
	public static Opt __add =
	new Opt("add","add the item with the introductions",
		_m ->
		{
			
		}
	)
		
  


	


    
    // For Collection
    protected PIMBaseCollection _collection;
    public PIMBaseCollection getCollection()
    {
	return _collection;
    }

    // For operators
    public ArrayList<Opt> _opts;

    public void interaction()
    {
	try
	    {
		while(true)
		    {
			runInteraction();
		    }
	    }
	catch(WExitException e)
	    {
		System.exit(0);
	    }
    }

    public void runInteraction() throw WExitException
    {
	printCmds();
	string cmd = readCommand();
	if(!runCmd(cmd))
	    {
		System.err.println(opt._help);
	    }
    }

    public boolean runCmd(String _c)
    {	
	return runCmd(_opts.get(lastIndexOf(new Opt(_c,null,null))));
    }

    public boolean runCmd(Opt _o)
    {
	return _o._func(this);
    }

			    

    public static string readCommand()
    {
	BufferReader br = new BufferReader(new InputStreamReader(System.in));
	String str = null;
	try
	    {
		str = bl.readLine();
	    }
	catch(IOException e)
	    {
		e.printStackTrace();
	    }
	return str;
    }

    public void printCmds()
    {
	String be;
	if (_opts.length <= 1)
	    be = "is";
	else
	    be = "are";
	System.out.print("--- Enter a command (supported commands " + be);
	if (_opts.length == 0)
	    System.out.print(" nothing");
	else
	    for (Opt item:_opts)
		{
		    System.out.print(" "+item._cmd);
		}
	System.out.println(") ---");
    }
    
    public class Opt
    {
	private String _cmd;
	private String _help;
	private Function<PIMManager,boolean> _func;
	public Opt(String _c,String _h,Function<PIMManager,boolean> _g)
	{
	    _cmd = _c;
	    _help = _h;
	    _func = _f;
	}
	@Overloaded
	public boolean equals(Opt _o)
	{
	    return _cmd.equals(_o._cmd);
	}
    }

    private WExitException extends Exception
    {
    }
}
