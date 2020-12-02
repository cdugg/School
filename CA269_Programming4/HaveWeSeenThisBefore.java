import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Previous
{
    public static void main(String [] args)
    {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Enter some numbers (-1 to end)");
    	int n;
    	n = in.nextInt();
    	List<Integer> seen = new ArrayList<Integer>();
    	Set<Integer> seenset = new HashSet<Integer>();
    	while(n != -1)
    	{
    		if(seenset.contains(n))
    			seen.add(n);
    		seenset.add(n);
    		n = in.nextInt();
    	}
    	System.out.println("Previous:");
    	for(int i = 0; i < seen.size(); i ++)
    		System.out.println(seen.get(i));
    }
}
