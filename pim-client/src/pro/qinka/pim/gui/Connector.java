package pro.qinka.pim.gui;

import pro.qinka.pim.collection.PIMBaseCollection;

/**
 * Connector
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * The connector where will return `PIMBaseCollection'.
 */

public interface Connector {
    /**
     * The method which will pull the collection from the remote or the file.
     * @return This method will return the collection of the remote.
     */
    public PIMBaseCollection getCollection();
}
