package pro.qinka.pim.collection.db;

import java.lang.*;

/**
 * To provider the sql statements
 */
class SQLStatementProvider {
    public static final String SELECT_APPOINTMENT = "SELECT id,date,context,own,priority FROM appointment";
    public static final String SELECT_CONTACT     = "SELECT id,fname,lname,email,own,priority FROM contact";
    public static final String SELECT_NOTE        = "SELECT id,context,own,priority FROM note";
    public static final String SELECT_TODO        = "SELECT id,date,context,own,priority FROM todo";
    public static final String INSERT_APPOINTMENT = "INSERT INTO appointment(date,context,own,priority) VALUES (?,?,?,?)";
    public static final String INSERT_CONTACT     = "INSERT INTO contact(fname,lname,email,own,priority) VALUES (?,?,?,?,?)";
    public static final String INSERT_NOTE        = "INSERT INTO note(context,own,priority) VALUES (?,?,?)";
    public static final String INSERT_TODO        = "INSERT INTO todo(date,context,own,priority) VALUES (?,?,?,?)";
}

