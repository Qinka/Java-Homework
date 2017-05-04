package pro.qinka.pim.entity;

import java.lang.*;
import java.util.*;
import java.text.*;
import java.lang.reflect.*;
import com.google.gson.*;
import com.google.gson.annotations.*;

/**
 *
 * PIMDateable
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * The class of the entity 
 * to be an item with date
 *
 */
public class PIMDateable extends PIMEntity implements IPIMDateable
{    
    /**
     * field: date
     * for a "Dateable" entity or item, this field is about the date
     */
    @SerializedName("date")
    public Date _date;
    /**
     * the method to get the date of the item
     * @return return a date
     */
    public Date getDate()
    {
	return _date;
    }
    /**
     * the method to get the date of the item
     * @param _f the format of the "timestamp"
     * @return the timestamp with given format
     */
    public String getDate(String _f)
    {
	SimpleDateFormat sdf = new SimpleDateFormat(_f);
	return sdf.format(_date);
    }
    /**
     * the method to set the date field with the string and the given format
     * @param _f the format of the string
     * @param _t the string of the date in the format of _f
     */
    public void setDate(String _f,String _t) throws ParseException
    {
	SimpleDateFormat sdf = new SimpleDateFormat(_f);
	_date = sdf.parse(_t);
    }
    /**
     * the method to set the date field 
     * @return the return is the field itself, when it need to be change, call the method in the date, just ok.
     */
    public Date setDate()
    {
	return _date;
    }
    /**
     * the method to set the date field
     * @param _d a date item to replace the one in the entity.
     */
    public void setDate(Date _d)
    {
	_date = _d;
    }

    /**
     * Constructor
     * @param _o is the owner of the item
     */
    public PIMDateable(String _o)
    {
	super(_o);
	_date = new Date();
    }
    /**
     * Constructor
     * @param _o is the owner of the item
     * @param _p is the priority of the item
     */
    public PIMDateable(String _o,String _p)
    {
	super(_o,_p);
	_date = new Date();
    }

    /**
     * the method transform the item from the json(string)
     * @param s the string of the json
     */
    public void fromString(String s)
    {
	GsonBuilder gb = new GsonBuilder();
	gb.registerTypeAdapter(Date.class, new DateDeserializer());
	Gson g = gb.create();
	super.fromString(s);
	this.setDate(g.fromJson(s,this.getClass()).getDate());
	
    }
    /**
     * the method to transform the item to string in a json format
     * @return thre return is a string of the item in the format of the json
     */
    public String toString()
    {
	GsonBuilder gb = new GsonBuilder();
	gb.registerTypeAdapter(Date.class, new DateSerializer());
	return gb.create().toJson(this);
    }

    /**
     * sub-class
     * DateSerializer
     * the class for json serialization
     */
    public  class DateSerializer implements JsonSerializer<Date>
    {
	/**
	 * the method to serialize a date variable to a json element
	 * @param src the variable which will be serialized
	 * @param typeOfSrc, advanced param, more details are available on the gson's official API documents
	 * @param context, advanced param, more details are available on the gson's official API documents
	 * @return the serialized datas
	 */
	public JsonElement serialize(Date src,Type typeOfSrc, JsonSerializationContext context)
	{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return new JsonPrimitive(sdf.format(src));
	}
    }
    /**
     * sub-class
     * DateDeserializer
     * the class for json deserialization
     */
    public  class DateDeserializer implements JsonDeserializer<Date>
    {
	/**
	 * the method to deserialize the json item to date variable
	 * @param json the json source
	 * @param typeOfT, advanced param, more details are available on the gson's official API documents
	 * @param context, advanced param, more details are available on the gson's official API documents
	 * @return return a new date variable
	 */
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

