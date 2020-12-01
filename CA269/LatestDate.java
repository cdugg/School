import java.util.Scanner;

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
	   if(s.length() > 1 && s.substring(0, 1).equals(" "))
	   {
		   s = s.substring(1, s.length() - 1);
		   //System.out.print(s);
	   }
	   String[] date = s.split(" ");
	   if(s.length() > 0)
	   {
	   day = Integer.parseInt(date[0]);
	   month = Integer.parseInt(date[1]);
	   year = Integer.parseInt(date[2]);
       }
   }
   public boolean isOnOrAfter(Date d1)
   {
	   if(year < d1.year)
	   {
		   return true;
	   }
	   if (year == d1.year && month < d1.month)
	   {
		   return true;
	   }
	   if (year == d1.year && month == d1.month && day <= d1.day)
	   {
		   return true;
	   }
	   return false;
   }
   public String toString()
   {
      return day + "/" + month + "/" + year;
   }
   public static void main(String [] args)
   {
       Scanner in = new Scanner(System.in);
       String line;
       Date maxdate = new Date("0 0 0");
       //System.out.println(maxdate);
       while(in.hasNextLine())
       {
          line = in.nextLine();
          Date date = new Date(line);
          if (maxdate.isOnOrAfter(date))
          {
        	  maxdate = date;
          }
       }
       System.out.println(maxdate);
   }
}
