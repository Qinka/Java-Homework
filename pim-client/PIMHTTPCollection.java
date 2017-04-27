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
    // The holder of the push action
    protected PIMHTTPPushHolder pushholder;
    // Non-update one
    protected int non_update_begin_index;
    
    public PIMHTTPCollection(String url)
    {
	super();
	rp = new PIMHTTPRequestProvider(url);
	pullholder = new PIMHTTPPullHolder();
	pushholder = new PIMHTTPPushHolder(this);
    }

    public void pull()
    {
	try
	    {
		pullholder.fetch();
		pullholder.getCollection(this);
	    }
	catch(Exception e)
	    {
		e.printStackTrace();
	    }

    }

    public void push()
    {
	try
	    {
		System.out.println(pushholder.count());
		pushholder.commit();
	    }
	catch(Exception e)
	    {
		e.printStackTrace();
	    }
	finally
	    {
		System.out.println(this.size() - non_update_begin_index);
	    }
    }
    
    protected class PIMHTTPPullItem
    {
	// id
	public final int id;
	public final PIMEntity item;
	protected PIMHTTPPullItem(int _i,PIMEntity _c)
	{
	    id = _i;
	    item = _c;
	}
    }
    public class PIMEDeserializer implements JsonDeserializer<PIMHTTPPullItem>
    {
	public PIMHTTPPullItem deserialize(JsonElement json, Type typeOfT,JsonDeserializationContext context) throws JsonParseException
	{
	    try
		{
		    GsonBuilder gb = new GsonBuilder();
		    PIMDateable p = new PIMDateable(null,null);
		    gb.registerTypeAdapter(Date.class,p.new DateDeserializer());
		    int _id = json.getAsJsonObject().get("id").getAsInt();
		    PIMEntity _entity;
		    if (json.getAsJsonObject().has("appointment"))
			{
			    PIMAppointment item = new PIMAppointment(null,null);
			    item.fromString(json.getAsJsonObject().get("appointment").toString());
			    _entity = item;
			}
		    else if(json.getAsJsonObject().has("contact"))
			{
			    PIMContact item = new PIMContact(null,null,null,null);
			    item.fromString(json.getAsJsonObject().get("contact").toString());
			    _entity = item;
			}
		    else if(json.getAsJsonObject().has("note"))
			{
			    PIMNote item = new PIMNote(null,null);
			    item.fromString(json.getAsJsonObject().get("note").toString());
			    _entity = item;
			}
		    else if(json.getAsJsonObject().has("todo"))
			{
			    PIMTodo item = new PIMTodo(null,null);
			    item.fromString(json.getAsJsonObject().get("todo").toString());
			    _entity = item;
			}
		    else
			{
			    System.out.println("asd");
			    throw new JsonParseException("invailed context");
			}
		    return new PIMHTTPPullItem(_id,_entity);
		}
	    catch (Exception e)
		{
		    throw new JsonParseException(e);
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
	private ArrayList<PIMHTTPPullItem> __context;

	public PIMHTTPPullHolder()
	{
	    __status = -1;
	    __context = null;
	}

	// fetch
	public void fetch() throws PIMHTTPCollectionPullException,PIMHTTPCollectionPullUnfetchException
	{
	    String text = "";
	    BufferedReader in = null;
	    try
		{
		    URLConnection c = rp.getListRequest(null,null,null,null);
		    c.connect();
		    in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		    String line;
		    while ((line = in.readLine()) != null)
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
	    PIMDateable p = new PIMDateable(null,null);
	    gb.registerTypeAdapter(Date.class, p.new DateDeserializer());
	    gb.registerTypeAdapter(PIMEntity.class,new PIMEntityIC());
	    gb.registerTypeAdapter(PIMHTTPPullItem.class,new PIMEDeserializer());
	    PIMHTTPPullHolder tmp;
	    try
		{
		    tmp = gb.create().fromJson(text,PIMHTTPPullHolder.class);
		}
	    catch(Exception e)
		{
		    e.printStackTrace();
		    this.__status = gb.create().fromJson(text,JsonElement.class).getAsJsonObject().get("status").getAsInt();
		    this.__context = null;
		    throw new PIMHTTPCollectionPullUnfetchException("status: " + __status,__status);
		}
	    this.__status  = tmp.__status;
	    this.__context = tmp.__context;
	}
	
	public void getCollection(PIMHTTPCollection _hc) throws PIMHTTPCollectionPullUnfetchException
	{
	    if(__status != 0)
		{
		    throw new PIMHTTPCollectionPullUnfetchException("Error unfetched", __status);
		}
	    _hc.clear();
	    for(PIMHTTPPullItem item : __context)
		_hc.add(item.item);
	    _hc.non_update_begin_index = _hc.size();
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

	public void addRequest(PIMEntity item) throws IOException,PIMHTTPCollectionPushException
	{
	    String sub = "/add";
	    String type = item.__getType();
	    String params = "?type="+type;
	    String post = "";
	    if(type.equals("appointment"))
		{
		    post = "context=" + URLEncoder.encode(((PIMAppointment)item).getDescription());
		}
	    else if(type.equals("contact"))
		{
		    post = "email=" + URLEncoder.encode(((PIMContact)item).getEmail())
			+ "&fname=" + URLEncoder.encode(((PIMContact)item).getFirstName())
			+ "&lname=" + URLEncoder.encode(((PIMContact)item).getLastName())
			;
		    
		}
	    else if(type.equals("note"))
		{
		    post = "context=" + URLEncoder.encode(((PIMNote)item).getContext());
		    
		}
	    else if(type.equals("todo"))
		{
		    post = "context=" + URLEncoder.encode(((PIMTodo)item).getContext());
		    
		}
	    else
		{
		    throw new PIMHTTPCollectionPushException("invalid type");
		}
	    if(item instanceof PIMDateable)
		{
		    post += "&date=" + URLEncoder.encode(((PIMDateable)item).getDate("yyyy-MM-dd"));
		}	    
	    post += "&priority=" + item.getPriority()
		+        "&own=" + URLEncoder.encode(item.getOwner())
		;	    
	    URL real = new URL(_url+sub+params);
	    URLConnection rc = null;
	    PrintWriter out = null;
	    BufferedReader in = null;
	    try
		{
		    rc = real.openConnection();
		    rc.setRequestProperty("user-agent","push;PIMHTTPRequestProvider with PIMHTTPcollection;");
		    rc.setDoOutput(true);
		    rc.setDoInput(true);
		    out = new PrintWriter(rc.getOutputStream());
		    out.print(post);
		    out.flush();
		    in = new BufferedReader(new InputStreamReader(rc.getInputStream()));
		    while (in.readLine() != null);
		}
	    catch(Exception e)
		{
		    throw new PIMHTTPCollectionPushException(e);
		}
	    finally
		{
		    try
			{
			    if(out!=null)
				out.close();
		    
			    if(in!=null)
				in.close();
		    
			}
		    catch(IOException ex)
			{
			    ex.printStackTrace();
			}
		}
	}
	
	// get list request
	public URLConnection getListRequest(String _sub, Date _begin, Date _end, String _own) throws IOException
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
		    begin = "begin=" + URLEncoder.encode(sdf.format(_begin),"utf8");
		}
	    
	    if (_end == null)
		end = "";
	    else
		{
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    end = "end=" + URLEncoder.encode(sdf.format(_end),"utf8");
		}
	    if(_own == null)
		own = "";
	    else
		own = "own=" + URLEncoder.encode(_own,"utf8");
	    String param = "";
	    String[] items = {begin,end,own};
	    for (String item : items)
		{
		    char pre;
		    if (param.isEmpty())
			pre = '?';
		    else
			pre = '&';
		    if (item.isEmpty())
			continue;
		    else
			param += pre + item;
		}
	    URL real = new URL(_url+sub+param);
	    URLConnection rc = real.openConnection();
	    rc.setRequestProperty("user-agent","pull;PIMHTTPRequestProvider with PIMHTTPcollection;");
	    
	    return rc;
	}
    }

    // When HTTP request failed
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


    // When Parsing failed -- that means status is not 0.
    public class PIMHTTPCollectionPullUnfetchException extends Exception
    {
	public int status_code;
	public PIMHTTPCollectionPullUnfetchException(String msg,int c)
	{
	    super(msg);
	    status_code = c;
	}	
	public PIMHTTPCollectionPullUnfetchException(Throwable cause,int c)
	{
	    super(cause);
	    status_code = c;
	}
    }

    protected class PIMHTTPPushHolder
    {
	// a collection needed to push
	protected ArrayList<PIMEntity> _to_push;
	protected PIMHTTPCollection _hc;
	public PIMHTTPPushHolder(PIMHTTPCollection hc)
	{
	    _hc = hc;	
	}
	public int count()
	{	    
	    _to_push = new ArrayList();	
	    int co = 0;
	    for(int i = _hc.non_update_begin_index;i<_hc.size();++i)
		{
		    _to_push.add(_hc.get(i));
		    co++;
		}
	    return co;
	}

	public void commit() throws PIMHTTPCollectionPushException
	{
	    try
		{
		    for(PIMEntity item:_to_push)
			{
			    rp.addRequest(item);
			    non_update_begin_index++;
			}
		}
	    catch(Exception e)
		{
		    throw new PIMHTTPCollectionPushException(e);
		}
	    
	}
	
    }


    // When HTTP request failed
    public class PIMHTTPCollectionPushException extends Exception
    {
	public PIMHTTPCollectionPushException(String msg)
	{
	    super(msg);
	}
	public PIMHTTPCollectionPushException(Throwable cause)
	{
	    super(cause);
	}
    }

}
