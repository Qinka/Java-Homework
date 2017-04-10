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

public class PIMAppointment extends PIMDateable
{
    // for context
    @SerializedName("context")
    protected String _context;
    public String getDescription()
    {
	return _context;
    }
    public void setDescription(String c)
    {
	_context = c;
    }

    public PIMAppointment(String _c,String _o)
    {
	super(_o);
	_context = _c;
    }
    public PIMAppointment(String _c,String _o,String _p)
    {
	super(_o,_p);
	_context = _c;
    }

    public void fromString(String s)
    {
	super.fromString(s);
	this.setDescription(new Gson().fromJson(s,this.getClass()).getDescription());
    }



    
}
