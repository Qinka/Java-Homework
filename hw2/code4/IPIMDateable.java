/**
 *
 * PIMDatebale
 * @author Qinka qinka@live.com qinka@qinka.pw 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 *
 */


import java.lang.*;
import java.util.*;
import java.text.*;



public interface IPIMDateable
{
    public Date getDate();
    public String getDate(String _f);
    public Date setDate();
    public void setDate(String _f,String _t) throws ParseException;
}
