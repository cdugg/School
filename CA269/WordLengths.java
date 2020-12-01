import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
//import java.util.Arrays;

public class WordLength
{
    public static void main(String [] args)
    {
    	Scanner in = new Scanner(System.in);
    	Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    	while(in.hasNextLine())
    	{
    		String line = in.nextLine();
        	String [] words = line.split(" ");
        	//System.out.println(Arrays.toString(words));
        	if(line.length() > 0)
        	{
            	for(int i = 0; i < words.length; i ++)
            	{
            		if(count.containsKey(words[i].length()))        		
            			count.put(words[i].length(), count.get(words[i].length()) + 1); 
            		else
            			count.put(words[i].length(), 1);
            	}
        	}
    	}
    	for(Map.Entry<Integer, Integer> entry : count.entrySet())
    		System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
