/**
 *
 * PIM
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.annotations.*;


public class PIMEntityIC implements JsonDeserializer<PIMEntity>, JsonSerializer<PIMEntity>
{
    public PIMEntity deserialize(JsonElement json,Type t,JsonDeserializationContext context)
    {
	String type = json.getAsJsonObject().get("type").getAsString();
	if (type.equals("note"))
	    {
		PIMNote item = new PIMNote(null,null,null);
		item.fromString(json.toString());
		return item;
	    }
	else if(type.equals("todo"))
	    {
		PIMTodo item = new PIMTodo(null,null,null);
		item.fromString(json.toString());
		return item;
	    }
	else if(type.equals("contact"))
	    {
		PIMContact item = new PIMContact(null,null,null,null,null);
		item.fromString(json.toString());
		return item;
	    }
	
	else if(type.equals("appointment"))
	    {
		PIMAppointment item = new PIMAppointment(null,null,null);
		item.fromString(json.toString());
		return item;
	    }
	else return null;	    
    }

    public JsonElement serialize(PIMEntity e,Type t,JsonSerializationContext c)
    {
	return new Gson().fromJson(e.toString(),JsonElement.class);
    }
}
