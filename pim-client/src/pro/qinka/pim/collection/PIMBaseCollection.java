package pro.qinka.pim.collection;

import java.lang.*;
import java.util.*;
import pro.qinka.pim.entity.*;

/**
 *
 * PIMBaseCollection
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 * 
 * The basic collection interface
 *
 */
public interface PIMBaseCollection extends Collection<PIMEntity>
{
    /**
     * The method to get all the notes
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getNotes();
    /**
     * The method to get all the notes whose owner is someone
     * @param owner the owner of the items you want 
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getNotes(String owner);

    /**
     * The method to get all the todos
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getTodos();
    /**
     * The method to get all the todos whose owner is someone
     * @param owner the owner of the items you want 
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getTodos(String owner);

    /**
     * The method to get all the appointments
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getAppointments();
    /**
     * The method to get all the appointments whose owner is someone
     * @param owner the owner of the items you want 
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getAppointments(String owner);

    /**
     * The method to get all the contacts
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getContacts();
    /**
     * The method to get all the contacts whose owner is someone
     * @param owner the owner of the items you want 
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getContacts(String owner);

    /**
     * The method to get all the items whose date is same with what was given
     * @param d is the date
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getItemsForDate(Date d);
    /**
     * The method to get all the items whose date and owner is same with what was given
     * @param d is the date
     * @param owner is the owner of the item
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getItemsForDate(Date d, String owner);

    /**
     * The method to get all the items
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getAll();
    /**
     * The method to get all the items whose owner is same with what was given
     * @param owner is the owner of the item
     * @return the collection of what were gotten
     */
    public PIMBaseCollection getAll(String owner);

    /**
     * The method to add an new item to colllection
     * @param item the item which will be added to collection
     * @return the return is about whether the action is success.
     */
    public boolean           add(PIMEntity item);
}
