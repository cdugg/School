//Cormac Duggan
//Lab 7
//Loop counting to 300 by 3's.
public class CountByThree
{
   public static void counting ()
   {
      int i = 3;
      while (i <= 300)
      {
         if (i % 30 == 0)
         {
            System.out.println (i);
         }
         else
         {
            System.out.print (i + ", ");
         }
         i = i+3;
      }
   }
}