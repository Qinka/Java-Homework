package pro.qinka.pim.collection.db;

import java.lang.*;
import java.lang.reflect.*;
import java.util.*;

import org.postgresql.*;
import java.sql.*;

import pro.qinka.pim.entity.*;
import pro.qinka.pim.collection.*;


/**
 * PIMDBCollection
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * The collection of the PIM
 * worked with database
 */

public class PIMDBCollection extends PIMCollection implements PIMCollectionStored {
    /**
     * The connect with db
     */
    protected Connection postgres;
    private   int __add_item_begin;
    protected ProvidePull pPull;
    protected ProvidePush pPush;


    public PIMDBCollection (String url,String user,String passwd){
	try {
	    Class.forName("org.postgresql.Driver").newInstance();
	    postgres = DriverManager.getConnection(url,user,passwd);
	    pPull = new ProvidePull();
	    pPush = new ProvidePush();
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
	    
    }
    protected void finalize() {
	try {
	postgres.close();
	}
	catch(Exception e) {
	    e.printStackTrace();
	}	  
    }
    
    public void pull() {
	pPull.fetch(this);
	__add_item_begin = this.size();
    }
    public void push() {
	pPush.update(this);
    }

    protected class ProvidePush {
	public PreparedStatement getStatement(PIMEntity item,Connection connect) throws SQLException {
	    if(item instanceof PIMAppointment) {
		PreparedStatement ps = connect.prepareStatement(SQLStatementProvider.INSERT_APPOINTMENT);
		PIMAppointment _i = (PIMAppointment)item;
		ps.setDate(1,(java.sql.Date)(_i.getDate()));
		ps.setString(2,_i.getDescription());
		ps.setString(3,_i.getOwner());
		ps.setString(4,_i.getPriority());
		return ps;
	    }
	    else if(item instanceof PIMContact) {
		PreparedStatement ps = connect.prepareStatement(SQLStatementProvider.INSERT_CONTACT);
		PIMContact _i = (PIMContact)item;
		ps.setString(1,_i.getFirstName());
		ps.setString(2,_i.getLastName());
		ps.setString(3,_i.getEmail());
		ps.setString(4,_i.getOwner());
		ps.setString(5,_i.getPriority());
		return ps;
	    }
	    else if(item instanceof PIMNote) {
		PreparedStatement ps = connect.prepareStatement(SQLStatementProvider.INSERT_NOTE);
		PIMNote _i = (PIMNote)item;
		ps.setString(1,_i.getContext());
		ps.setString(2,_i.getOwner());
		ps.setString(3,_i.getPriority());
		return ps;
	    }
	    else if(item instanceof PIMTodo) {
		PreparedStatement ps = connect.prepareStatement(SQLStatementProvider.INSERT_TODO);
		PIMTodo _i = (PIMTodo)item;
		ps.setDate(1,(java.sql.Date)(_i.getDate()));
		ps.setString(2,_i.getContext());
		ps.setString(3,_i.getOwner());
		ps.setString(4,_i.getPriority());
		return ps;
	    }
	    return null;
	}

	public void update(PIMDBCollection _collection){
	    for(int i = _collection.__add_item_begin;i<_collection.size();++i) {
		PreparedStatement ps =null;
		boolean fail = false;
		try {
		    ps = getStatement(_collection.get(i),postgres);
		    ps.executeUpdate();
		}
		catch(Exception e){
		    e.printStackTrace();
		    fail = true;
		}
		finally {
		    try {
			if(ps != null)
			    ps.close();
		    }
		    catch(Exception e) {
			e.printStackTrace();
			break;
		    }
		    if(fail) break;
		}
		__add_item_begin ++;
	    }
		
	}
    }
    
    protected class ProvidePull {
	public PIMEntity fetchItem(ResultSet rs,String type) {
	    try {
		if(rs.next()) {
		    String _o = rs.getString("own");
		    String _p = rs.getString("priority");
		    if(type.equals("appointment")) {
			String _c = rs.getString("context");
			java.util.Date   _d = rs.getDate("date");
			PIMAppointment rt =  new PIMAppointment(_c,_o,_p);
			rt.setDate(_d);
			return rt;
		    }
		    else if(type.equals("contact")) {
			String _e = rs.getString("email");
			String _f = rs.getString("fname");
			String _l = rs.getString("lname");
			return new PIMContact(_e,_f,_l,_o,_p);
		    }
		    else if(type.equals("note")) {
			String _c = rs.getString("context");
			return new PIMNote(_c,_o,_p);
		    }
		    else if(type.equals("todo")) {
			String _c = rs.getString("context");
			java.util.Date _d = rs.getDate("date");
			PIMTodo rt = new PIMTodo(_c,_o,_p);
			rt.setDate(_d);
			return rt;
		    }
		}
		return null;
	    }
	    catch(Exception e) {
		e.printStackTrace();
		return null;
	    }
		
	}

	public void fetch(PIMDBCollection _collection) {
	    Statement sAppointment = null;
	    Statement sContact = null;
	    Statement sNote = null;
	    Statement sTodo = null;
	    ResultSet rsAppointment = null;
	    ResultSet rsContact = null;
	    ResultSet rsNote = null;
	    ResultSet rsTodo = null;
	    _collection.clear();
	    PIMEntity item;
	    try {
		sAppointment  = postgres.createStatement();
		sContact      = postgres.createStatement();
		sNote         = postgres.createStatement();
		sTodo         = postgres.createStatement();
		rsAppointment = sAppointment.executeQuery(SQLStatementProvider.SELECT_APPOINTMENT);
		rsContact     = sContact.executeQuery(SQLStatementProvider.SELECT_CONTACT);
		rsNote        = sNote.executeQuery(SQLStatementProvider.SELECT_NOTE);
		rsTodo        = sTodo.executeQuery(SQLStatementProvider.SELECT_TODO);
		while((item = fetchItem(rsAppointment,"appointment")) != null)
		    _collection.add(item);
		while((item = fetchItem(rsContact,"contact")) != null)
		    _collection.add(item);
		while((item = fetchItem(rsNote,"note")) != null)
		    _collection.add(item);
		while((item = fetchItem(rsTodo,"todo")) != null)
		    _collection.add(item);
	    }
	    catch(Exception e) {
		e.printStackTrace();
	    }
	    finally {
		try {
		    if(sAppointment != null)
			sAppointment.close();
		    if(sContact != null)
			sContact.close();
		    if(sNote != null)
			sNote.close();
		    if(sTodo != null)
			sTodo.close();
		    if(rsAppointment != null)
			rsAppointment.close();
		    if(rsContact != null)
			rsContact.close();
		    if(rsNote != null)
			rsNote.close();
		    if(rsTodo != null)
			rsTodo.close();
		}
		catch(Exception e) {
		    e.printStackTrace();
		}
	    }
	}
	
    }

							      
}
