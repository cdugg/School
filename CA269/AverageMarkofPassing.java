public class Test
{
   public static double getPassingAverage(Student [] student)
   {
	   double sum = 0;
	   int count = 0;
	   for(int i = 0; i < student.length; i++)
	   {
		   if(student[i].getMark() >= 40)
		   {
			   sum = sum + student[i].getMark();
			   count++;
		   }
	   }
	   return sum / count;
   }
}
