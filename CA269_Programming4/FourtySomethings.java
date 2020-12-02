public class Test
{
   public static void print(Student [] student)
   {
      for(int i = 0; i < student.length; i++)
         System.out.println(student[i].getMark() + " (" + student[i].getName() + ")");
   }
   public static void printHonours(Student [] student)
   {
	  for(int i = 0; i < student.length; i++)
	     if(student[i].getMark() >= 55)
	     {
		    System.out.println(student[i].getMark() + " (" + student[i].getName() + ")");
	     }
   }
   public static void printForties(Student [] student)
   {
	  for(int i = 0; i < student.length; i++)
	     if(student[i].getMark() >= 40 && student[i].getMark() <= 49)
	     {
		    System.out.println(student[i].getMark() + " (" + student[i].getName() + ")");
	     }
   }
}
