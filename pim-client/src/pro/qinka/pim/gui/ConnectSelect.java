package pro.qinka.pim.gui;

import java.lang.*;

import pro.qinka.pim.collection.*;
import pro.qinka.pim.collection.db.*;
import pro.qinka.pim.collection.io.*;
import pro.qinka.pim.collection.http.*;

/**
 * ConnectSelect
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * Select the connector of the Manager
 */

class ConnectSelect implements Connector {
    /**
     * The method to return a new or connected collection.
     */
    public PIMBaseCollection getCollection() {
	return new PIMCollection();
    }
	
    /**
     * The sub-class for connecting with database.
     */
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
    /**
     * The sub-class for connecting with backend.
     */
    public static class BackendConnect implements Connector {
	private final String _url;
	public BackendConnect(String u) {
	    _url = u;
	}
	public PIMBaseCollection getCollection() {
	    return new PIMHTTPCollection(_url);
	}
    }
    /**
     * The sub-class for connecting with file.
     */
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
