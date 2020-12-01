import java.io.*;
import java.util.*;

public class Senti1 {
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(args[1]));
		int count = 0;
		while(in.hasNext())
		{
			String next = in.next();
			if(next.contains(args[0]))
			{
				count++;
			}
		}
		System.out.println(args[0] + " appears " + count + " times.");
	}
}
