/** 
 * 
 * Book
 * @author Qinka qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.20
 *
 */

class Book
{
    // book name
    private String _book_name;
    public String getBookName()
    {
	refreshitem();
	return _book_name;
    }
    public void setBookName(String n)
    {
	_book_name = new String(n); // might cause NullPointException
	refreshitem(true);
    }

    // ISBN
    private String _isbn;
    public String getISBN()
    {
	refreshitem();
	return _isbn;
    }
    public void setISBN(String i)
    {
	_isbn = new String(i);
	refreshitem(true);
    }

    public Book(String name,String isbn)
    {
	_book_name = name;
	_isbn = isbn;
	refreshitem();
    }
    public Book(String name)
    {
	_book_name = name;
	// _isbn = isbn load via refreshitem()
	refreshitem();
    }
    
    /**
     * To load/save data from/to somewhere
     * But do nothing
     */
    protected void refreshitem() // = refreshitem(false)
    {
	refreshitem(false);
    }
    protected void refreshitem(boolean is)
    {
	 // do nothing
    }
}
