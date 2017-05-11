package pro.qinka.pim.collection;
    
import java.lang.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

import pro.qinka.pim.entity.*;

/**
 *
 * PIMCollection
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * The collection of the PIM
 * 
 */
public class PIMCollection extends ArrayList<PIMEntity> implements PIMBaseCollection
{
    /**
     * The filter to pick out
     * @param p the predicate of the PIMEntity
     */
    protected PIMBaseCollection _filter(Predicate<PIMEntity> p)
    {
	return this.stream().filter(p).collect(Collectors.toCollection(PIMCollection::new));

    }

    /**
     * The method to get the notes items
     * @return the collection of the items you want
     */
    public PIMBaseCollection getNotes()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMNote.class);
    }
    /**
     * the method to get the notes whose owner is given one
     * @param the owner of the item
     * @return the collection of the item you want
     */
    public PIMBaseCollection getNotes(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMNote.class && p.getOwner().equals(_o));
    }

    /**
     * The method to get the todos items
     * @return the collection of the item you want
     */
    public PIMBaseCollection getTodos()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMTodo.class);
    }
    /**
     * the method to get the todos whose owner is given
     * @param the owner of the item
     * @return the collection of the item you want
     */
    public PIMBaseCollection getTodos(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMTodo.class && p.getOwner().equals(_o));
    }

    /**
     * the method to get the appointment items
     * @return the collection of the item you want
     */
    public PIMBaseCollection getAppointments()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMAppointment.class);
    }
    /**
     * the method to get the appointment whose owner is given
     * @param the owner of the item
     * @return the collection of the item you want
     */
    public PIMBaseCollection getAppointments(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMAppointment.class && p.getOwner().equals(_o));
    }

    /**
     * the method to get the contact items
     * @return the collection of the item you want
     */
    public PIMBaseCollection getContacts()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMContact.class);
    }
    /**
     * the method to get the contact whose owner is given
     * @param the owner of the item
     * @return the collection of the item you want
     */
    public PIMBaseCollection getContacts(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMContact.class && p.getOwner().equals(_o));
    }

    /**
     * the method to get the all items 
     * @return the collection of the item you want
     */
    public PIMBaseCollection getAll()
    {
        return this;
    }
    /**
     * the method to get the all items whose owner is given
     * @param the owner of the item
     * @return the collection of the item you want
     */
    public PIMBaseCollection getAll(String _o)
    {
	return _filter((PIMEntity p) -> p.getOwner().equals(_o));
    }

    /**
     * the method to get the all item whose timestamp is given
     * @param the date of the timestamp
     * @return the collection of the item you want
     */
    public PIMBaseCollection getItemsForDate(Date _d)
    {
	return _filter((PIMEntity p) ->
		      {
			  boolean isDateble = p.getClass() == PIMTodo.class
			      || p.getClass() == PIMAppointment.class;
			  if(isDateble)
			      {
				  PIMDateable d = (PIMDateable)p;
				  Date dd = d.getDate(); // _d
				  return dd.getDate() == _d.getDate()
				      && dd.getMonth() == _d.getMonth()
				      && dd.getYear() == _d.getYear()
				      ;
			      }
			  return false;
		      });
    }
    /**
     * the method to get the all item whose timestamp is given
     * @param the date of the timestamp
     * @param the owner of the item
     * @return the collection of the item you want
     */
    public PIMBaseCollection getItemsForDate(Date _d,String _o)
    {
	return _filter((PIMEntity p) ->
		      {
			  boolean isDateble = p.getClass() == PIMTodo.class
			      || p.getClass() == PIMAppointment.class;
			  if(isDateble && p.getOwner().equals(_o))
			      {
				  PIMDateable d = (PIMDateable)p;
				  return d.getDate().equals(_d);
			      }
			  return false;
		      });
    }
    
}
