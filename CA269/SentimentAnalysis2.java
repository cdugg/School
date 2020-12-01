import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Senti2 {
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File(args[1]));
		String word = args[0];
		int count = 0;
		double counttotal = 0;
		int countcurrent;
		int countreviews = 0;
		while(in.hasNextLine())
		{
			String s = in.nextLine();
			String[] splited;
			if(s.substring(0, 1).equals(" "))
				splited = s.substring(1, s.length()).split("\\s+");
			else
				splited = s.split("\\s+");
			countcurrent = 0;
			for(int i = 0; i < splited.length; i ++)
			{
				if(splited[i].contains(args[0]))
				{
					countcurrent++;
					count++;
					counttotal = counttotal + Integer.parseInt(splited[0]);
				}
			}
			if(countcurrent > 0)
			{
				countreviews++;
			}
		}
		System.out.println(args[0] + " appears " + count + " times.");
		if(countreviews != 0)
		{
			DecimalFormat numberFormat = new DecimalFormat("#0.00"); 
		    double average = counttotal/countreviews;
		    System.out.println("The average score of the reviews containing " + word + " is " + numberFormat.format(average));
		}
		else
    		System.out.println("The average score of the reviews containing " + word + " is 0.00");
	}
}
