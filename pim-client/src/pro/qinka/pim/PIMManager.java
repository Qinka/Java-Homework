package pro.qinka.pim;

import java.lang.*;
import java.util.*;
import java.util.function.*;
import javax.net.ssl.ExtendedSSLSession;
import java.io.*;

import pro.qinka.pim.entity.*;
import pro.qinka.pim.collection.*;
import pro.qinka.pim.collection.http.*;
import pro.qinka.pim.collection.io.*;

public class PIMManager
{

    /**
     * the Main method
     */
    public static void main(String [] args)
    {
		String collectionName;
		try
		{
			collectionName = args[0];
		}
		catch(Exception e)
		{
			collectionName = "io";
		}
		PIMBaseCollection bc;
		if(collectionName.equals("http"))
		{
			String url;
			try
			{
				url = args[1];
			}
			catch (Exception e)
			{
				url = "http://pim.qinka.pro";
			}
			bc = new PIMHTTPCollection(url);
		}
		else
		{
			String filepath;
			try
			{
				filepath = args[1];
			}
			catch(Exception e)
			{
				filepath = ".ignore/data";
			}
			bc = new PIMIOCollection(filepath);
		}
	System.out.println("With " + collectionName + "-collection");
	PIMManager m = new PIMManager(bc);
	m._opts.add(m.__quit);
	m._opts.add(m.__save);
	m._opts.add(m.__load);
	m._opts.add(m.__list);
	m._opts.add(m.__create);
	m.interaction();
    }

    
    

    /**
     * for quit
     */
    public final Opt __quit =
	new Opt("quit",null,
		_m ->
		{
		    System.out.println("Bye bye!");
		    throw new WExitException();
		});
    /**
     * for save
     */
    public final Opt __save =
	new Opt("save","using save to save or push datas to remote or files",
		_m ->
		{
		    if (_m._collection instanceof PIMCollectionStored)
			{
			    PIMBaseCollection _c = _m._collection;
			    ((PIMCollectionStored)_c).push();
			}
		    else
			{
			    System.err.println("WARRNING: Sorry the collection of PIMBasecollection is not an instance of PIMCollectionstored, and that means it is save will not do anything.");
			}
		    return true;
		});
    /**
     * for load
     */
    public final Opt __load = 
	new Opt("load","using load to load or pull datas from remote or files",
		_m ->
		{
		    if (_m._collection instanceof PIMCollectionStored)
			{
			    PIMBaseCollection _c = _m._collection;
			    ((PIMCollectionStored)_c).pull();
			}
		    else
			{
			    System.err.println("WARRNING: Sorry the collection of PIMBasecollection is not an instance of PIMCollectionstored, and that means it is save will not do anything.");
			}
		    return true;
		});
	
    /**
     * for list
     */
    public final Opt __list =
	new Opt("list","list all the items in the repo",
		_m -> 
		{
		    int size =  _m._collection.size();
		    System.out.println("There " + (size>1?"are ":"is ") + size + " item" + (size>1?"s":""));
		    int itemid = 0;
		    BiFunction<PIMEntity,Integer,Boolean> printItem = (_p,_i) ->
		    {
			if(_p.getClass().equals(PIMAppointment.class))
			    {
				PIMAppointment a = (PIMAppointment)_p;
				System.out.println("Item "+_i+": APPOINTMENT "+a.getPriority()+" "+ a.getDate("yyyy-MM-dd"));
				System.out.println("\t "+a.getDescription());
			    }
			else if(_p.getClass().equals(PIMContact.class))
			    {
				PIMContact a = (PIMContact) _p;				
				System.out.println("Item "+_i+": CONTACT "+a.getPriority());
				System.out.println("\t Name: "+a.getFirstName()+" "+a.getLastName());
				System.out.println("\t EMail: "+a.getEmail());
			    }
			else if(_p.getClass().equals(PIMNote.class))
			    {
				PIMNote a = (PIMNote) _p;
				System.out.println("Item "+_i+": NOTE "+a.getPriority());
				System.out.println("\t " + a.getContext());
			    }
			else if(_p.getClass().equals(PIMTodo.class))
			    {
				PIMTodo a = (PIMTodo) _p;
				System.out.println("Item "+_i+": TODO "+a.getPriority()+" "+ a.getDate("yyyy-MM-dd"));
				System.out.println("\t" + a.getContext());
			    }
			else
			    {
				System.err.println("WARRNING: This can not happen.");
			    }
			return true;
		    };
		    for(PIMEntity item:_m._collection)
			{
			    itemid ++;
			    printItem.apply(item,itemid);
			}
		    return true;
		});
		
    /**
     * For add
     */
    public final Opt __create =
	new Opt("create","add the item with the introductions",
		_m -> 
		{
		    try
			{
			    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			    System.out.println("Enter an item type (todo, note, contact or appointment)");
			    String type = bf.readLine();
			    PIMEntity item;
			    if (type.equals("todo"))
				item = new PIMTodo(null,null,null);
			    else if(type.equals("note"))
				item = new PIMNote(null,null,null);
			    else if(type.equals("appointment"))
				item = new PIMAppointment(null,null,null);
			    else if(type.equals("contact"))
				item = new PIMContact(null,null,null,null,null);
			    else
				{
				    System.err.println("Error TYPE!");
				    return false;
				}
			    if(item instanceof IPIMDateable)
				{
				    System.out.println("Enter date for item(yyyy-MM-dd):");
				    ((IPIMDateable)(item)).setDate("yyyy-MM-dd",bf.readLine());
				}
			    System.out.println("Enter priority for item:");
			    item.setPriority(bf.readLine());
			    if(item.getClass().equals(PIMNote.class))
				{
				    System.out.println("Enter the note for item:");
				    ((PIMNote)item).setContext(bf.readLine());
				}
			    else if(item.getClass().equals(PIMTodo.class))
				{
				    System.out.println("Enter the things to do for item:");
				    ((PIMTodo)item).setContext(bf.readLine());
				}
			    else if(item.getClass().equals(PIMAppointment.class))
				{
				    System.out.println("Enter the your appointment for the item:");
				    ((PIMAppointment)item).setDescription(bf.readLine());
				}
			    else if(item.getClass().equals(PIMContact.class))
				{
				    System.out.println("Enter the fisrt name for item:");
				    ((PIMContact)item).setFirstName(bf.readLine());
				    System.out.println("Enter the last name for item:");
				    ((PIMContact)item).setLastName(bf.readLine());
				    System.out.println("Enter the email for item:");
				    ((PIMContact)item).setEmail(bf.readLine());
				}
			    System.out.println("Enter your name:");
			    item.setOwner(bf.readLine());
		    
			    _m._collection.add(item);
			}
		    catch(Exception e)
			{
			    e.printStackTrace();
			    return false;
			}
		    return true;
		});
    
    
    /**
     * Constructor
     * @param the collection
     */
    public PIMManager(PIMBaseCollection _bc)
    {
	_collection = _bc;
	_opts = new ArrayList();
    }
      
    /**
     * field: _bc
     * For Collection
     */
    protected PIMBaseCollection _collection;
    public PIMBaseCollection getCollection()
    {
	return _collection;
    }

    /**
     * For operators
     */
    public ArrayList<Opt> _opts;

    /**
     * the interaction
     */
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
	catch(IOException e)
	    {
		e.printStackTrace();
	    }
    }

    /**
     * the runInteraction
     */
    public void runInteraction() throws WExitException, IOException
    {
	if(printCmds())
	    throw new WExitException();
	runCmd(readCommand());
    }

    /**
     * the runCmd
     */
    public void runCmd(String _c) throws WExitException, IOException
    {
	int i = _opts.lastIndexOf(new Opt(_c,null,null));
	if (i == -1)
	    {
		System.out.println("Error command");
		return;
	    }
	Opt opt = _opts.get(i);
	if(! runCmd(opt))
	    System.err.println(opt._help);
    }

    /**
     * the runCmd
     */
    public boolean runCmd(Opt _o) throws WExitException, IOException
    {
	return _o._func.apply(this);
    }			    

    /**
     * read command
     */
    public static String readCommand()
    {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str = null;
	try
	    {
		str = br.readLine();
	    }
	catch(IOException e)
	    {
		e.printStackTrace();
	    }
	return str;
    }

    /**
     * print cmds
     */
    public boolean printCmds()
    {
	String be;
	if (_opts.size() <= 1)
	    be = "is";
	else
	    be = "are";
	System.out.print("--- Enter a command (supported commands " + be);
	if (_opts.size() == 0)
	    System.out.print(" nothing");
	else
	    for (Opt item:_opts)
		{
		    System.out.print(" "+item._cmd);
		}
	System.out.println(") ---");
	return _opts.size() == 0;
    }

    /**
     * sub-class
     * opt the opt of the system
     */
    public class Opt
    {
	private String _cmd;
	private String _help;
	private OptFunction<PIMManager,Boolean> _func;
	public Opt(String _c,String _h,OptFunction<PIMManager,Boolean> _f)
	{
	    _cmd = _c;
	    _help = _h;
	    _func = _f;
	}
	public boolean equals(Object _o)
	{
	    return _cmd.equals(((Opt)_o)._cmd);
	}
    }

    /**
     * sub-class
     * interface when exception
     */
    @FunctionalInterface
    public interface OptFunction<T,R>
    {
	R apply(T t) throws WExitException, IOException;
    }

    /**
     * sub-class 
     * the exception
     */
    private class WExitException extends Exception
    {
	public WExitException()
	    {
		super();
	    }
    }
}
