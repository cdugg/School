import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Suspicious
{
    public static void main(String [] args)
    {
    	try
    	{
    	Scanner students = new Scanner(new File(args[0]));
    	Scanner delinquents = new Scanner(new File(args[1]));
    	Set<String> student = new HashSet<String>();
    	Set<String> delinquent = new HashSet<String>();
    	while(students.hasNext())
    	{
    		String s = students.nextLine();
    		student.add(s);
    	}
    	while(delinquents.hasNext())
    	{
    		String s = delinquents.nextLine();
    		delinquent.add(s);
    	}
    	delinquent.retainAll(student);
    	String [] dels = delinquent.toArray(new String[delinquent.size()]);
    	for(int i = 1; i < delinquent.size() + 1; i ++)
        	System.out.println(i + ". " + dels[i - 1]);
    	}
    	catch(FileNotFoundException e)
    	{
    	}
    }
}
