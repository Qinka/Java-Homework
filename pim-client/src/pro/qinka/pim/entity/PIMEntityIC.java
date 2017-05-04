package pro.qinka.pim.entity;

import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.annotations.*;

/**
 * PIMEntityIC
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * the deserialization and serialization for PIMEntity
 */
public class PIMEntityIC implements JsonDeserializer<PIMEntity>, JsonSerializer<PIMEntity>
{
    /**
     * the method to serialize a entity variable to a json element
     * @param src the variable which will be serialized
     * @param typeOfSrc, advanced param, more details are available on the gson's official API documents
     * @param context, advanced param, more details are available on the gson's official API documents
     * @return the serialized datas
     */
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

    /**
     * the method to serialize a entity variable to a json element
     * @param src the variable which will be serialized
     * @param typeOfSrc, advanced param, more details are available on the gson's official API documents
     * @param context, advanced param, more details are available on the gson's official API documents
     * @return the serialized datas
     */
    public JsonElement serialize(PIMEntity e,Type t,JsonSerializationContext c)
    {
	return new Gson().fromJson(e.toString(),JsonElement.class);
    }
}
