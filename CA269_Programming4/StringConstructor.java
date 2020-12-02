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
   public Date()
   {
	   day = 1;
	   month = 1;
	   year = 2000;
   }
   public Date(String s)
   {
	   String[] date = s.split(" ");
	   day = Integer.parseInt(date[0]);
	   month = Integer.parseInt(date[1]);
	   year = Integer.parseInt(date[2]);
   }
   public String toString()
   {
      return day + "/" + month + "/" + year;
   }
}
