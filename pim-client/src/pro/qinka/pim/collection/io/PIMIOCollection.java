package pro.qinka.pim.collection.io;

import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.annotations.*;

import pro.qinka.pim.collection.*;
import pro.qinka.pim.entity.*;

/**
 * PIMIOCollection
 * PIMDateable
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 * 
 * the class to fetch or update with IO(file)
 */
public class PIMIOCollection extends PIMCollection implements PIMCollectionStored
{
    /**
     * file name
     */
    protected String _file;
    /**
     * Gson Builder
     */
    protected GsonBuilder gb;

    /**
     * Constructor
     * @param _f the file path
     */
    public PIMIOCollection(String _f)
    {
	super();
	gb = new GsonBuilder();
	PIMDateable p = new PIMDateable(null,null);
	gb.registerTypeAdapter(Date.class, p.new DateSerializer());
	gb.registerTypeAdapter(Date.class, p.new DateDeserializer());
	gb.registerTypeAdapter(PIMEntity.class,new PIMEntityIC());
	_file = _f;
    }

    /**
     * the method to pull the datas from the remote backend
     */
    public void pull()
    {
	Gson g = gb.create();
	File file = new File(_file);
	Long ll = file.length();
	byte[] filecontent = new byte[ll.intValue()];
	try
	    {
		FileInputStream in = new FileInputStream(file);
		in.read(filecontent);
		in.close();
	    }
	catch(FileNotFoundException e)
	    {
		e.printStackTrace();
	    }
	catch(IOException e)
	    {
		e.printStackTrace();
	    }
	Type cT = new TypeToken<ArrayList<PIMEntity>>(){}.getType();
	ArrayList<PIMEntity> al = g.fromJson(new String(filecontent),cT);
	this.clear();
	this.addAll(al);
    }

    /**
     * the method to push  the datas which need to be update to remote backend
     */
    public void push()
    {
	ArrayList<PIMEntity> al = this;
	Gson g = gb.create();
	try
	    {
		FileWriter file = new FileWriter(_file);
		file.write(g.toJson(al));		
		file.close();
	    }
	catch(IOException e)
	    {
		e.printStackTrace();
	    }
	finally
	    {
	    }
    }

}
