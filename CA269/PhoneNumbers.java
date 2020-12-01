import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class PhoneNumbers
{
    public static void main(String [] args)
    {
    	Scanner in = new Scanner(System.in);
    	Map<String, String> numbers = new HashMap <String, String>();
    	System.out.println("Enter a name and number, or a name and ? to query (!! to exit)");
    	String s = in.nextLine();
    	while(! s.equals("!!"))
    	{
    		if(s.substring(s.length() - 2, s.length()).equals(" ?"))
    		{
    			String [] name = s.split(" ");
    			if(numbers.containsKey(name[0]))
    				System.out.println(name[0] + " has number " + numbers.get(name[0]));
    			else
    				System.out.println("Sorry, there is no " + name[0]);
    		}
    		else
    		{
    			String [] namenum = s.split(" ");
    			numbers.put(namenum[0], namenum[1]);
    		}
    		s = in.nextLine();
    	}
    	System.out.println("Bye");
    }
}
