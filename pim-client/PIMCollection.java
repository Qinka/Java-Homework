/**
 *
 * PIM
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;


public class PIMCollection extends ArrayList<PIMEntity> implements PIMBaseCollection
{
    protected PIMBaseCollection _filter(Predicate<PIMEntity> p)
    {
	return this.stream().filter(p).collect(Collectors.toCollection(PIMCollection::new));

    }
    
    public PIMBaseCollection getNotes()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMNote.class);
    }
    public PIMBaseCollection getNotes(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMNote.class && p.getOwner().equals(_o));
    }

    public PIMBaseCollection getTodos()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMTodo.class);
    }
    public PIMBaseCollection getTodos(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMTodo.class && p.getOwner().equals(_o));
    }

    public PIMBaseCollection getAppointments()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMAppointment.class);
    }
    public PIMBaseCollection getAppointments(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMAppointment.class && p.getOwner().equals(_o));
    }

    public PIMBaseCollection getContacts()
    {
        return _filter((PIMEntity p) -> p.getClass() == PIMContact.class);
    }
    public PIMBaseCollection getContacts(String _o)
    {
	return _filter((PIMEntity p) -> p.getClass() == PIMContact.class && p.getOwner().equals(_o));
    }

    public PIMBaseCollection getAll()
    {
        return this;
    }

    public PIMBaseCollection getAll(String _o)
    {
	return _filter((PIMEntity p) -> p.getOwner().equals(_o));
    }

    public PIMBaseCollection getItemsForDate(Date _d)
    {
	return _filter((PIMEntity p) ->
		      {
			  boolean isDateble = p.getClass() == PIMTodo.class
			      || p.getClass() == PIMAppointment.class;
			  if(isDateble)
			      {
				  PIMDateable d = (PIMDateable)p;
				  return d.getDate().equals(_d);
			      }
			  return false;
		      });
    }

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
