/**
 *
 * Student
 * @author Qinka qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.20
 *
 */

import java.lang.*;
import java.util.*;

class Student
{
    private ArrayList<Book> _books;
    public void addBook(Book book)
    {
	_books.add(book);
    }
    public void delBook(Book book)
    {
	_books.remove(book);
    }
    
    private ArrayList<Course> _courses;
    public void addCourse(Course c)
    {
	_courses.add(c);
    }
    public void delCourse(Course c)
    {
	_courses.remove(c);
    }

    private String _name;
    public String getName()
    {
	return _name;
    }
    public void setName(String name)
    {
	_name = name;
    }

    private String _id_num;
    public String getIdNum()
    {
	return _id_num;
    }
    public void setIdNum(String id)
    {
	_id_num = id;
    }

    public Student (String name, String id, ArrayList<Book> bs, ArrayList<Course> cs)
    {
	_name = name;
	_id_num = id;
	_books = bs;
	_courses = cs;
    }
    public Student(String name, String id)
    {
	_name = name;
	_id_num = id;
	_books = new ArrayList<Book>();
	_courses = new ArrayList<Course>();
    }
    public Student(String name, String id, ArrayList<Course> cs)
    {
	_name = name;
	_id_num = id;
	_books = new ArrayList<Book>();
	_courses = cs;
    }
    public String toString()
    {
	String courses = "";
	if      (_courses.size() == 0)
	    courses = " do not choose anything";
	else if (_courses.size() == 1)
	    courses = " choose " + _courses.get(0).getName();
	else
	    {
		courses = " choose ";
		for (int i = 0;i < _courses.size()-1;i++)
		    {
			courses += _courses.get(i).getName() + ", ";
		    }
		courses += "and " + _courses.get(_courses.size()-1).getName();
	    }
	return _id_num + courses;
    }
}
