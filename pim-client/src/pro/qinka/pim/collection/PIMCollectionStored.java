package pro.qinka.pim.collection;

import java.lang.*;
import java.util.*;

/**
 * 
 * PIMCollectionStored
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 */
public interface PIMCollectionStored
{
    /**
     * the method to fetch the items from repo, remote ,file, backend etc.
     * this function will be called by the standard command -- load
     */
    public void pull();
    /**
     * the method to update the items to repo, remote, file, backend etc.
     * this function will be called by the standard command -- save
     */
    public void push();
}
