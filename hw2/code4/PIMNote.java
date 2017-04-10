/**
 *
 * PIMNote
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import com.google.gson.*;
import com.google.gson.annotations.*;



public class PIMNote extends PIMEntity
{
    // for context
    @SerializedName("context")
    protected String _context;
    public String getContext()
    {
	return _context;
    }
    public void setContext(String c)
    {
	_context = c;
    }


    public PIMNote(String _c,String _o)
    {
	super(_o);
	_context = _c;
    }

    public PIMNote(String _c ,String _o ,String _p)
    {
	super(_o,_p);
	_context = _c;
    }

    public void fromString(String s)
    {
	Gson g = new Gson();
	super.fromString(s);
	this.setContext(g.fromJson(s,this.getClass()).getContext());
    }
}
