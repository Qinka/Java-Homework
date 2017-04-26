

import java.lang.*;
import java.util.*;
import java.text.*;
import com.google.gson.*;


class Main
{
    public static void main(String[] args)
    {
	Gson g = new Gson();
	String f = "{\"context\":\"asd\",\"type\":\"notes\",\"priority\":\"asd\",\"own\":\"asd\"}";
	PIMNote n = new PIMNote(null,null,null);
	n.fromString(f);
	System.out.println(n);
    }
}

