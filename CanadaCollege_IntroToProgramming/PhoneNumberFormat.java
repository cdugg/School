import java.util.Scanner;
//Cormac Duggan
//Lab 8
//Changes an input string to the proper phone number format.
public class PhoneNumberFormat
{
   public static void formatNumber () //Program class that changes phone number to proper format.
   {
      Scanner sc = new Scanner (System.in);
      String number;
      String formatNumber = "";
      while (true) // Creates loop so program will repeat indefinitely.
      {
         System.out.println ("Please enter a 10 digit phone number.");
         System.out.println ("Enter 999 to quit.");
         number = sc.next();
         if (number.equalsIgnoreCase ("999")) // Quits program if user enters 999.
         {
            System.exit(0);
         }
         else //Properly formats the Phone Number.
         {
            formatNumber = formatNumber + "(" + number.substring (0, 3) + ") " + number.substring (3, 6) + "-" + number.substring (6, 10);
            System.out.println (formatNumber  + "\n");
         }
      }
   }
}