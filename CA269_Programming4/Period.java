public class Period
{
   private Time Time1;
   private Time Time2;
   public Period(Time t1, Time t2)
   {
	   Time1 = t1;
	   Time2 = t2;
   }
   public boolean overlaps(Period p2)
   {
	   if(p2.Time1.isLater(Time1) && Time2.isLater(p2.Time1))
		   return true;
	   if(Time1.isLater(p2.Time1) && p2.Time2.isLater(Time1))
		   return true;
	   return false;
   }
   public String toString()
   {
      return Time1 + " -> " + Time2;
   }
}
