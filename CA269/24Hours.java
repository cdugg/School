public class Time
{
   private int hour;
   private int minute;
   public Time(String time)
   {
	   hour = Integer.parseInt(time.substring(0, 2));
	   minute = Integer.parseInt(time.substring(2, 4));
   }
   public boolean isLater(Time t2)
   {
	   if(hour > t2.hour)
	   {
		   return true;
	   }
	   if(hour == t2.hour && minute > t2.minute)
	   {
		   return true;
	   }
	   return false;
   }
   public String toString()
   {
	  if(hour < 10 && minute < 10)
		  return "0" + hour + ":0" + minute;
	  if(minute < 10)
		  return hour + ":0" + minute;
	  if(hour < 10)
		  return "0" + hour + ":" + minute;
      return hour + ":" + minute;
   }
}
