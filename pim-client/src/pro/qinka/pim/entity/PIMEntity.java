package pro.qinka.pim.entity;

import java.lang.*;
import java.lang.reflect.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

/**
 *
 * PIMEntity
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * The abstract class of the pim's entity
 *
 */
public abstract class PIMEntity
{
    // for reflect
    public String __getType()
    {return "entity";}

    /**
     * field: type
     * the type of the item
     */
    @SerializedName("type")
    public final String __t = this.__getType(); 

    /**
     * Constructor
     * @param _o the owner of the item
     */
    public PIMEntity(String _o)
    {
	_own = _o;
	_priority = "normal";
    }
    /**
     * Constructor
     * @param _o the owner of the item
     * @param _p the priority of the item
     */
    public PIMEntity(String _o,String _p)
    {
       	_own = _o;
	_priority = _p;
    }
    
    /**
     * field: priority
     * the level of the priority
     */
    @SerializedName("priority")
    protected String _priority;
    /**
     * the method to get the priority of the item
     * @return the string of the priority
     */
    public String getPriority()
    {
	return _priority;
    }
    /**
     * the method to set up the priority of the item 
     * @param p the priority which will be set up
     */
    public void setPriority(String p)
    {
	_priority = p;
    }

    /**
     * field: own
     * the ownership of the item
     */
    @SerializedName("own")
    protected String _own;
    /**
     * the method to get the owner of the item
     * @return return the string of the owner
     */
    public String getOwner()
    {
	return _own;
    }
    /**
     * the method to set up the owner of the item
     * @param o the onwer of the item
     */
    public void setOwner(String o)
    {
	_own = o;
    }

    /**
     * the method to transform the item from the json string to data
     * Each PIMEntity needs to be able to set all state information
     * (fields) from a single text string.
     * @param s the string of the json
     */
    public void fromString(String s)
    {
	Gson g = new Gson();
	this.setPriority(g.fromJson(s,this.getClass()).getPriority());
	this.setOwner(g.fromJson(s,this.getClass()).getOwner());
    }
    /**
     * the method to transform the data to json
     * This is actually already defined by the super class
     * Object, but redefined here as abstract to make sure
     * that derived classes actually implement it
     * @return the string of the json
     */
    public String toString()
    {
	return new Gson().toJson(this);
    }
}
