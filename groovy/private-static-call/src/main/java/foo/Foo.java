package foo;

public class Foo
{
	public static String toStringSpecial(Object object)
	{
		if(object instanceof String)
		{
			return "special: "+toStringSpecial((String)object);
		}
		return "special: "+object;
	}

	private static String toStringSpecial(String object)
	{
		return "private-static-special: "+object;
	}
}