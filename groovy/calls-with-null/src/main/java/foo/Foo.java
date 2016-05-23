package foo;

import java.util.*;

public class Foo
{
	public static String toStringSpecial(Object object)
	{
		return "Object: "+object;
	}

	public static String toStringSpecial(Set object)
	{
		return "Set: "+object;
	}

	public static String toStringSpecial(String object)
	{
		return "String: "+object;
	}
}