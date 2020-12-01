import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class GroupStudents
{
   public static void main(String [] args)
   {
	  Scanner in = null;
	  try
	  {
		in  = new Scanner(new File(args[0]));
      	Student [] group;
      	group = new Student [in.nextInt()];
      	for(int i = 0; i < group.length; i++)
      	{
      		String name = in.next();
      		int grade = in.nextInt();
      		Student person = new Student(name, grade);
      		group[i] = person;
      	}
      	Student.print(group);
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
