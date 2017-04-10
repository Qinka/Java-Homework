

import java.lang.*;
import java.util.*;
import java.text.*;
import com.google.gson.*;


class Main
{
    public static void main(String[] args)
    {
	Gson g = new Gson();
	PIMEntity todo = new PIMContact("asdasd","my","asdas","my");
	System.out.println(todo.getClass() == PIMEntity.class);
	String a = new String("asd");
	String b = new String("asd");
	System.out.println(a.equals( b));
    }
}

