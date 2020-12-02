public class Date
{
   private int day;
   private int month;
   private int year;
   public Date(int day1, int month1, int year1)
   {
	   day = day1;
	   month = month1;
	   year = year1;
   }
   public String toString()
   {
      return day + "/" + month + "/" + year;
   }
}
