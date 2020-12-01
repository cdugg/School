import java.util.Scanner;
//Cormac Duggan
//Lab 6
//Calculates the price of a condo depending on the users choice of condo.
public class CondoSales
{
   public static void price(int viewType)
   {
   final int PARK_SIDE_VIEW = 150000; //Set constant for all prices
   final int GOLF_SIDE_VIEW = 170000;
   final int LAKE_SIDE_VIEW = 210000;
   final int PARKING_PRICE = 5000;
   int price;
   Scanner s = new Scanner(System.in);
  
   if (viewType == 1) //Prints park side view with or without garage space based on user input
         {
            System.out.println ("Please choose a parking option.");
            System.out.println ("Enter 1 for a garage space.");
            System.out.println ("Enter 2 for a parking space.");
            int parking = s.nextInt ();
            if (parking == 1)
               {
               price = PARK_SIDE_VIEW + PARKING_PRICE;
               System.out.print ("$" + price);
               }
            else if (parking == 2)
               {
               System.out.print ("$" + PARK_SIDE_VIEW);
               }
            else
               {
               System.out.println ("Inavalid parking choice. Parking set to parking space.");
               System.out.print ("$" + PARK_SIDE_VIEW);
               }
         }
   else if (viewType == 2) //Prints golf side view with or without garage space based on user input
         {
            System.out.println ("Please choose a parking option.");
            System.out.println ("Enter 1 for a garage space.");
            System.out.println ("Enter 2 for a parking space.");
            int parking = s.nextInt ();
            if (parking == 1)
               {
               price = GOLF_SIDE_VIEW + PARKING_PRICE;
               System.out.print ("$" + price);
               }
            else if (parking == 2)
               {
               System.out.print ("$" + GOLF_SIDE_VIEW);
               }
            else
               {
               System.out.println ("Inavalid parking choice. Parking set to parking space.");
               System.out.print ("$" + GOLF_SIDE_VIEW);
               }
         }   
   else if (viewType == 3) //Prints Lake side view with or without garage space based on user input
         {
            System.out.println ("Please choose a parking option.");
            System.out.println ("Enter 1 for a garage space.");
            System.out.println ("Enter 2 for a parking space.");
            int parking = s.nextInt ();
            if (parking == 1)
               {
               price = LAKE_SIDE_VIEW + PARKING_PRICE;
               System.out.print ("$" + price);
               }
            else if (parking == 2)
               {
               System.out.print ("$" + LAKE_SIDE_VIEW);
               }
            else
               {
               System.out.println ("Inavalid parking choice. Parking set to parking space.");
               System.out.print ("$" + LAKE_SIDE_VIEW);
               }
         }        
   else //checks to make sure the view choice is valid
      {
      System.out.print ("Invalid view choice");
      }   
   }
}