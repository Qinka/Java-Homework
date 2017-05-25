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
    public PIMBaseCollection getCollection();
}
