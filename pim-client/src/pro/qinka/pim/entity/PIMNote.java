package pro.qinka.pim.entity;

import java.lang.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

/**
 * PIMNote
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * the entity of the note
 */
public class PIMNote extends PIMEntity
{
    /**
     * the method get the real type in a string form for reflect
     * @return the string of the type of the entity
     */
    public final String __getType()
    {return "note";}
    
    /** 
     * field: context
     * for context
     */
    @SerializedName("context")
    protected String _context;
    /**
     * the method to get the context of the items
     * @return the context of the items
     */
    public String getContext()
    {
	return _context;
    }
    /**
     * the method to set up the context of the items
     * @param c the context
     */
    public void setContext(String c)
    {
	_context = c;
    }

    /**
     * Constructor
     * @param _c the context
     * @param _o the owner
     */
    public PIMNote(String _c,String _o)
    {
	super(_o);
	_context = _c;
    }
    /**
     * Constructor
     * @param _c the context
     * @param _o the owner
     * @param _p the priority
     */
    public PIMNote(String _c ,String _o ,String _p)
    {
	super(_o,_p);
	_context = _c;
    }
    /**
     * the method transform the data from a string to binary data
     * the string in a json form
     * @param s the json string which will be transformed to data
     */
    public void fromString(String s)
    {
	Gson g = new Gson();
	super.fromString(s);
	this.setContext(g.fromJson(s,this.getClass()).getContext());
    }
}
