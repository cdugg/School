public class Date implements Comparable<Date>
{
   private int day, month, year, time;

   public Date(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.time = year * 365 + month * 30 + day;
   }
   
   public int compareTo(Date other)
   {
	   return Integer.compare(this.time, other.time);
   }

   public String toString()
   {
      return day + "/" + month + "/" + year;
   }
}
