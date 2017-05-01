package pro.qinka.pim.entity;

import java.lang.*;
import java.util.*;
import java.text.*;

/**
 *
 * PIMDatebale
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * The inferface of a entity, with the interface of setting and getting the date.
 * 
 */
public interface IPIMDateable
{
    /**
     * The method to get the Date of the item
     * @return return the Date
     */
    public Date getDate();
    /**
     * The method to get the Date in thr form of string in a speical format
     * @return a string of the date
     */
    public String getDate(String _f);
    /**
     * The method to set the Date of the item
     * @return the return is date which you can change
     */
    public Date setDate();
    /**
     * The method is used to set the date with a string and a speical format
     * @param _f the format of the time
     * @parma _t the time string
     */
    public void setDate(String _f,String _t) throws ParseException;
}
