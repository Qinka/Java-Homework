/**
 *
 * PIMHTTPCollection
 * @author Qinka qinka@live.com me@qinka.pro 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.1.0
 *
 */

import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import java.net.*;
import java.text.*;
import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.annotations.*;

public class PIMHTTPCollection extends PIMCollection implements PIMCollectionStored
{
    // request provider
    protected PIMHTTPRequestProvider rp;
    // The latest of id
    protected int[] latest_id = {0,0,0,0};
    // The holder of the pull action
    protected PIMHTTPPullHolder pullholder;
    
    
    public PIMHTTPCollection(String url)
    {
	super();
	rp = new PIMHTTPRequestProvider(url);
    }

    public void pull

    protected class PIMHTTPPullItem
    {
	// id
	public final int id;
	public final PIMEntity item;
	protected PIMEntity(int _i,PIMEntity _c)
	{
	    id = _i;
	    item = _c;
	}
	protected class PIMEDeserializer implements JsonDeserializer<PIMHTTPPullItem>
	{
	    public PIMHTTPPullItem deserialize(JsonElement json, Type typeOfT,JsonDeserializationContext context) throws JsonParseException
	    {
		try
		    {
			GsonBuilder gb = new GsonBuilder();
			PIMDateable p = new PIMDateable(null,null);
			gb.registerTypeAdapter(Date.class,p.new DataDeserializer());
  			int _id = json.getAsJsonObject().get("id").getAsInt();
			PIMEntity _entity;
			if (json.getAsJsonObject.has("appointment"))
			    {
				PIMAppointment item = new PIMAppointment(null);
				item.fromString(json.getAsJsonObject.get("appointment").getAsString());
				_entity = item;
			    }
			else if(json.getAsJsonObject.has("context"))
			    {
				PIMContact item = new PIMContact(null,null,null,null);
				item.fromString(json.getAsJsonObject.get("context").getAsString());
				_entity = item;
			    }
		        else if(json.getAsJsonObject.has("note"))
			    {
				PIMNote item = new PIMNote(null);
				item.fromString(json.getAsJsonObject.get("note").getAsString());
				_entity = item;
			    }
			else if(json.getAsJsonObject.has("todo"))
			    {
				PIMTodo item = new PIMTodo(null);
				item.fromString(json.getAsJsonObject.get("todo").getAsString());
				_entity = item;
			    }
			else
			    {
				throw new JsonParseException("invailed context");
			    }
			return new PIMHTTPItem(_id,_entity);
		    }
		catch (Exception e)
		    {
			throw new JsonParseException(e);
		    }
	    }
	    
	}
    }

    protected class PIMHTTPPullHolder
    {
	// status
	@SerializedName("status")
	private int __status;
	// contexts
	@SerializedName("context")
	private ArrayList<PIMHTTPItem> __context;

	public PIMHTTPPullHolder()
	{
	    __status = -1;
	    __context = new ArrayList();
	}

	// fetch
	public void fetch() throws  PIMHTTPCollectionPullException
	{
	    String text = "";
	    BufferedReader in;
	    try
		{
		    URLConnection c = rp.getListRequest(null,null,null,null);
		    c.connect();
		    in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		    String line;
		    while (line = in.readLine() != null)
			{
			    text += line;
			}
		    
		}
	    catch (Exception e)
		{
		    throw new PIMHTTPCollectionPullException(e);
		}
	    finally
		{
		    try
			{
			    if (in != null)
				in.close();
			}
		    catch(Exception e)
			{
			    e.printStackTrace();
			}
		}
	    GsonBuilder gb = new GsonBuilder();
	    gb.registerTypeAdapter(Date.class, p.new DateDeserializer());
	    gb.registerTypeAdapter(PIMEntity.class,new PIMEntityIC());
	    PIMHTTPPullHolder tmp =
	    
	}
	
	public void getCollection(PIMHTTPCollection _hc)
	{
	    _hc.clear();
	    for(PIMHTTPItem item : __context)
		_hc.add(item.item);
	}
	
    }

    protected class PIMHTTPRequestProvider
    {
        // url
	private String _url;
	public PIMHTTPRequestProvider(String _base_url)
	{
	    _url = _base_url;
	}
	// get list request
	public URLConnection getListRequest(String _sub, Date _begin, Date _end, String _own)
	{
	    String sub,begin,end,own;
	    if (_sub == null)
		sub = "/list";
	    else
		sub = "/list" + _sub;
	    if (_begin == null)
		begin = "";
	    else
		{
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    begin = "begin=" + URLDecoder.encode(sdf.format(_begin),"utf8");
		}
	    
	    if (_end == null)
		end = "";
	    else
		{
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    end = "end=" + URLDecoder.encode(sdf.format(_end),"utf8");
		}
	    if(_own == null)
		own = "";
	    else
		own = "own=" + URLDecoder.encode(_own,"utf8");
	    String param = "";
	    for (String item : {begin,end,own})
		{
		    char pre;
		    if (param.isEmpty())
			pre = "?";
		    else
			pre = "&";
		    if (item.isEmpty())
			continue;
		    else
			param += pre + item;
		}
	    URL real = new URL(_url+sub+param);
	    URLConnection rc = real.openConnection();
	    rc.setRequestProperty("user-agent","PIMHTTPRequestProvider with PIMHTTPcollection");
	    return rc;
	}
	
	
    }
    public class PIMHTTPCollectionPullException extends Exception
    {
	public PIMHTTPCollectionPullException(String msg)
	{
	    super(msg);
	}
	public PIMHTTPCollectionPullException(Throwable cause)
	{
	    super(cause);
	}
    }
    public class PIMHTTPCollectionPullUnfetchException extends Exception
    {
	public PIMHTTPCollectionPullUnfetchException(String msg)
	{
	    super(msg);
	}	
	public PIMHTTPCollectionPullUnfetchException(Throwable cause)
	{
	    super(cause);
	}
    }

}
