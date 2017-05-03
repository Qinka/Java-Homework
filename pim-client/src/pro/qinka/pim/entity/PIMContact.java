package pro.qinka.pim.entity;

import java.lang.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

/**
 * 
 * PIMContact
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3 
 * @version 0.2.0.0
 *
 * The entity of the contact 
 *
 */
public class PIMContact extends PIMEntity
{
    /**
     * the method get the real type in a string form for reflect
     * @return the string of the type of the entity
     */
    public final String __getType()
    {return "contact";}

    /**
     * field: email
     * hold the email of a contact
     */
    @SerializedName("email")
    protected String _email;
    /**
     * the method to get the email of the contact
     * @return the string of the email
     */
    public String getEmail()
    {
	return _email;
    }
    /**
     * the method to set the field(email)
     * @param the email which will be set up
     */
    public void setEmail(String _e)
    {
	_email = _e;
    }

    /**
     * field: fname
     * hold the first name of a person in contact
     */
    @SerializedName("fname")
    protected String _first_name;
    /**
     * the mehod to get the first name
     * @return the string of the first name
     */
    public String getFirstName()
    {
	return _first_name;
    }
    /**
     * the method to set up the first name
     * @param _f the first name which will be set up
     */
    public void setFirstName(String _f)
    {
	_first_name = _f;
    }

    /**
     * field: lname
     * hold the last(family) name of the person of the contact
     */
    @SerializedName("lname")
    protected String _last_name;
    /**
     * the method to get the last name
     * @return the string of the last name
     */
    public String getLastName()
    {
	return _last_name;
    }
    /**
     * the method to set up the last name
     * @param _l the last name which will be set up
     */
    public void setLastName(String _l)
    {
	_last_name = _l;
    }

    /**
     * the constructor of the class
     * @param _e the email of the person in contact
     * @param _f the first name of the person in contact
     * @param _l the last name of the person in contact
     * @param _o the ownership of the contact
     */ 
    public PIMContact(String _e, String _f, String _l, String _o)
    {
	super(_o);
	_email = _e;
	_first_name = _f;
	_last_name  = _l;
    }
    /**
     * the constructor of the class
     * @param _e the email of the person in contact
     * @param _f the first name of the person in contact
     * @param _l the last name of the person in contact
     * @param _o the ownership of the contact
     * @param _p the priority of the contact
     */ 
    public PIMContact(String _e, String _f, String _l, String _o, String _p)
    {
	super(_o,_p);
	_email = _e;
	_first_name = _f;
	_last_name  = _l;
    }
    /**
     * the method transform the data from a string to binary data(PIMConact)
     * the string in a json form
     * @param s the json string which will be transformed to data
     */
    public void fromString(String s)
    {
	super.fromString(s);
	PIMContact tmp = new Gson().fromJson(s,PIMContact.class);
	this.setEmail(tmp.getEmail());
	this.setFirstName(tmp.getFirstName());
	this.setLastName(tmp.getLastName());
    }

}
