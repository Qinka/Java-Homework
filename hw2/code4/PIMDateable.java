/**
 *
 * PIMDatebale
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import java.util.*;
import java.text.*;
import java.lang.reflect.*;
import com.google.gson.*;
import com.google.gson.annotations.*;


public class PIMDateable extends PIMEntity implements IPIMDateable
{    
    // for date
    @SerializedName("date")
    public Date _date;
    public Date getDate()
    {
	return _date;
    }
    public String getDate(String _f)
    {
	SimpleDateFormat sdf = new SimpleDateFormat(_f);
	return sdf.format(_date);
    }
    public void setDate(String _f,String _t) throws ParseException
    {
	SimpleDateFormat sdf = new SimpleDateFormat(_f);
	_date = sdf.parse(_t);
    }
    public Date setDate()
    {
	return _date;
    }
    public void setDate(Date _d)
    {
	_date = _d;
    }

    public PIMDateable(String _o)
    {
	super(_o);
	_date = new Date();
	//gb.registerTypeAdapter(Date.class,new DefaultDateTypeAdapter());
	//gb.registerTypeAdapter(Date.class, new DateSerializer());
	//gb.registerTypeAdapter(Date.class, new DateDeserializer());
    }    
    public PIMDateable(String _o,String _p)
    {
	super(_o,_p);
	_date = new Date();
	//gb.registerTypeAdapter(Date.class, new DefaultDateTypeAdapter());
	//gb.registerTypeAdapter(Date.class, new DateSerializer());
	//gb.registerTypeAdapter(Date.class, new DateDeserializer());
    }


    public void fromString(String s)
    {
	GsonBuilder gb = new GsonBuilder();
	gb.registerTypeAdapter(Date.class, new DateDeserializer());
	Gson g = gb.create();
	super.fromString(s);
	this.setDate(g.fromJson(s,this.getClass()).getDate());
	
    }
    public String toString()
    {
	GsonBuilder gb = new GsonBuilder();
	gb.registerTypeAdapter(Date.class, new DateSerializer());
	return gb.create().toJson(this);
    }
    
    public  class DateSerializer implements JsonSerializer<Date>
    {
	public JsonElement serialize(Date src,Type typeOfSrc, JsonSerializationContext context)
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return new JsonPrimitive(sdf.format(src));
	}
    }
    public  class DateDeserializer implements JsonDeserializer<Date>
    {
	public Date deserialize(JsonElement json, Type typeOfT,JsonDeserializationContext context) throws JsonParseException
	{
	    try
		{
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    return sdf.parse(json.getAsJsonPrimitive().getAsString());
		}
	    catch(ParseException e)
		{
		    throw new JsonParseException(e);
		}
	}
    }

}

