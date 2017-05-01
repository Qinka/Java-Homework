package pro.qinka.pim.entity;


import java.lang.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

/**
 *
 * PIMAppointment
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 * 
 * The entity of the appointment
 *
 */

public class PIMAppointment extends PIMDateable
{
    // for reflect
    public final String __getType()
    {return "appointment";}

    
    /**
     * The field of the context where stored the things about appointment
     */
    @SerializedName("context")
    /**
     * The method to get the field -- context
     * @return return the description of the appointment
     */
    protected String _context;
    public String getDescription()
    {
	return _context;
    }
    /**
     * The method to set the field -- context
     * @param the string to be set up
     */
    public void setDescription(String c)
    {
	_context = c;
    }
    /**
     * The constructor of the class
     * @param _c the context of the item
     * @param _o the owner of the item -- onwership
     */
    public PIMAppointment(String _c,String _o)
    {
	super(_o);
	_context = _c;
    }
    /**
     * The constructor of the class
     * @param _c the context of the item
     * @param _o the owner of the item -- onwership
     * @param _p the priority of the appointment
     */
    public PIMAppointment(String _c,String _o,String _p)
    {
	super(_o,_p);
	_context = _c;
    }

    /**
     * transform from JSON to object
     * @param s the json string
     */
    public void fromString(String s)
    {
	super.fromString(s);
	this.setDescription(new Gson().fromJson(s,this.getClass()).getDescription());
    }  
}
