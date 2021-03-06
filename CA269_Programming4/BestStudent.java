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
   public static int numberPasses(Student [] student)
   {
	   int numpassed = 0;
	   for(int i = 0; i < student.length; i++)
	   {
		   if(student[i].getMark() >= 40)
		   {
			   numpassed++;
		   }
	   }
	   return numpassed;
   }
   public static Student getBestStudent(Student [] student)
   {
	   int bestGrade = 0;
	   int bestStudentPosition = 0;
	   for(int i = 0; i < student.length; i++)
	   {
		   if(student[i].getMark() > bestGrade)
		   {
			   bestStudentPosition = i;
			   bestGrade = student[i].getMark();
		   }
	   }
	   return student[bestStudentPosition];
   }
}
