package pro.qinka.pim.gui;

import java.lang.*;

import pro.qinka.pim.collection.*;
import pro.qinka.pim.collection.db.*;
import pro.qinka.pim.collection.io.*;
import pro.qinka.pim.collection.http.*;

class ConnectSelect implements Connector {
    public PIMBaseCollection getCollection() {
	return new PIMCollection();
    }
	
    
    public static class DatabaseConnect implements Connector {
	private final String _url;
	private final String _user;
	private final String _passwd;
	public DatabaseConnect(String ur,String us,String p) {
	    _url = ur;
	    _user = us;
	    _passwd = p;
	}
	public PIMBaseCollection getCollection() {
	    return new PIMDBCollection(_url,_user,_passwd);
	}
    }
    public static class BackendConnect implements Connector {
	private final String _url;
	public BackendConnect(String u) {
	    _url = u;
	}
	public PIMBaseCollection getCollection() {
	    return new PIMHTTPCollection(_url);
	}
    }
    public static class FileConnect implements Connector {
	private final String _file_path;
	public FileConnect(String fp) {
	    _file_path = fp;
	}
	public PIMBaseCollection getCollection() {
	    return new PIMIOCollection(_file_path);
	}	
    }
}
