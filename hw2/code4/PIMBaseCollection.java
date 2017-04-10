/**
 *
 * PIMTodo
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import java.util.*;

public interface PIMBaseCollection
{
    public PIMBaseCollection getNotes();
    public PIMBaseCollection getNotes(String owner);

    public PIMBaseCollection getTodos();
    public PIMBaseCollection getTodos(String owner);

    public PIMBaseCollection getAppointments();
    public PIMBaseCollection getAppointments(String owner);

    public PIMBaseCollection getContacts();
    public PIMBaseCollection getContacts(String owner);

    public PIMBaseCollection getItemsForDate(Date d);
    public PIMBaseCollection getItemsForDate(Date d, String owner);

    public PIMBaseCollection getAll();
    public PIMBaseCollection getAll(String owner);

    public boolean           add(PIMEntity item);
}
