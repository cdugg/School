import static java.nio.file.StandardOpenOption.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class WriteStudents
{
   public static void main(String [] args)
   {
	  Scanner in = null;
	  try
	  {
		in = new Scanner(new File(args[0]));
      	String len = in.next();
      	Student [] group;
      	group = new Student [Integer.parseInt(len)];
      	for(int i = 0; i < group.length; i++)
      	{
      		String name = in.next();
      		int grade = in.nextInt();
      		Student person = new Student(name, grade + 1);
      		group[i] = person;
      	}
      	try 
      	{
      		Path p = Paths.get(args[1]);
      		Charset charset = Charset.forName("US-ASCII");
      		BufferedWriter writer = Files.newBufferedWriter(p, charset);
      		List<String> list1 = Arrays.asList(len);
      		Files.write(p, list1, charset, APPEND);
      		for(int i = 0; i < group.length; i ++)
      		{
      			  String line = group[i].name + " " + group[i].mark;  
      			  List<String> list = Arrays.asList(line);
       			  Files.write(p, list, charset, APPEND);
      		}
      	}
      	catch(IOException x)
      	{
      		System.out.println("FUCK");
      	}
	  }
	  catch(FileNotFoundException e)
	  {
		  System.out.println("The file does not exist");
	  }
	  finally
	  {
		  in.close();
	  }
   }
}
