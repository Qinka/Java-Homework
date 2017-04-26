/**
 *
 * PIMTodo
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

public class PIMContact extends PIMEntity
{
    public final String __getType()
    {return "contact";}

    
    @SerializedName("email")
    protected String _email;
    public String getEmail()
    {
	return _email;
    }
    public void setEmail(String _e)
    {
	_email = _e;
    }

    @SerializedName("fname")
    protected String _first_name;
    public String getFirstName()
    {
	return _first_name;
    }
    public void setFirstName(String _f)
    {
	_first_name = _f;
    }

    @SerializedName("lname")
    protected String _last_name;
    public String getLastName()
    {
	return _last_name;
    }
    public void setLastName(String _l)
    {
	_last_name = _l;
    }

    public PIMContact(String _e, String _f, String _l, String _o)
    {
	super(_o);
	_email = _e;
	_first_name = _f;
	_last_name  = _l;
    }
    public PIMContact(String _e, String _f, String _l, String _o, String _p)
    {
	super(_o,_p);
	_email = _e;
	_first_name = _f;
	_last_name  = _l;
    }

    public void fromString(String s)
    {
	super.fromString(s);
	PIMContact tmp = new Gson().fromJson(s,PIMContact.class);
	this.setEmail(tmp.getEmail());
	this.setFirstName(tmp.getFirstName());
	this.setLastName(tmp.getLastName());
    }

}
