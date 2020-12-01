import java.util.*;
public class MakeMap
{
    public static Map<String, Integer> makeMap(Scanner in)
    {
    	Map<String,Integer> newmap = new HashMap<String,Integer>();
    	while(in.hasNext())
    	{
    		String name = in.next();
    		int mark = in.nextInt();
    		newmap.put(name, mark);
    	}
    	return newmap;
    }
}
