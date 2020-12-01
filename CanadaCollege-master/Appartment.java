//Cormac Duggan
//Lab 14
//Checks if input values for apartment details are valid
import java.util.*;
public class Appartment
{
   public static void appartment()
   {
      Scanner sc = new Scanner (System.in);
      System.out.println ("Enter an address:");
      String address = sc.next();
      System.out.println("Enter an appartment number:");
      String number = sc.next();
      System.out.println("Enter a number of bedrooms:");
      int beds = sc.nextInt();
      System.out.println("Enter a rent cost:");
      double rent = sc.nextDouble();
      
      try
      {
         int a = 1;
         int b = 0;
         int c;
         if (number.matches("[100-]+[a-zA-Z]")) 
         {
            if (beds > 0 && beds < 5)
            {
               if (rent > 500 && rent < 2500)
               {
                  System.out.print ("Appartment successful");
               }
            }
         }      
         else
         {
            c = a/b;
         }
      }
      catch(Exception e)
      {
         System.out.print("Appartment failed");
         System.exit(0);
      }
   }
}