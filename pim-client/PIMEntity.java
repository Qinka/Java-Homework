/**
 *
 * PIMEntity
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */

import java.lang.*;
import java.lang.reflect.*;
import com.google.gson.*;
import com.google.gson.annotations.*;


public abstract class PIMEntity
{

    public String __getType()
    {return "entity";}
    
    @SerializedName("type")
    public final String __t = this.__getType(); 

    public PIMEntity(String _o)
    {
	_own = _o;
	_priority = "normal";
    }

    public PIMEntity(String _o,String _p)
    {
       	_own = _o;
	_priority = _p;
    }
    
    // for priority
    @SerializedName("priority")
    protected String _priority;
    public String getPriority()
    {
	return _priority;
    }
    public void setPriority(String p)
    {
	_priority = p;
    }

    // for owner
    @SerializedName("own")
    protected String _own;
    public String getOwner()
    {
	return _own;
    }
    public void setOwner(String o)
    {
	_own = o;
    }

    // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    public void fromString(String s)
    {
	Gson g = new Gson();
	this.setPriority(g.fromJson(s,this.getClass()).getPriority());
	this.setOwner(g.fromJson(s,this.getClass()).getOwner());
    }
    // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    public String toString()
    {
	return new Gson().toJson(this);
    }
}
