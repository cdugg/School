import java.util.Scanner;
public class BillingTest
{
   public static void main (String [] args)
   {
      Billing bill = new Billing ();
      Scanner sc = new Scanner (System.in);
      System.out.println ("What is the price of the book? ");
      double bookPrice = sc.nextDouble ();
      System.out.println ("How many books are you buying? ");
      int numberOrdered = sc.nextInt ();
      
      if (numberOrdered > 1) //more than one book
      {
         System.out.println ("Do you have a coupon? (1 for yes and 2 for no)");
         int couponStatus = sc.nextInt ();
         //multiple books and has a coupons so runs 3rd method
         if (couponStatus == 1) 
         {
            System.out.println ("What is your coupon's value?");
            double couponValue = sc.nextDouble ();
            Billing.computeBill (bookPrice, numberOrdered, couponValue);
         } 
         // multiple books but no coupon so runs second method
         else
         {
            Billing.computeBill (bookPrice, numberOrdered);
         }
      }
     
      //only one book
      else if (numberOrdered == 1) 
      {
         System.out.println ("Do you have a coupon? (1 for yes and any other digit for no)");
         int couponStatus = sc.nextInt ();
         //has 1 book but also has coupon so runs 3rd method
         if (couponStatus == 1) 
         {
            System.out.println ("What is your coupon's value?");
            double couponValue = sc.nextDouble ();
            Billing.computeBill (bookPrice, numberOrdered, couponValue);
         }
        
         // no coupon and only 1 book so runs first method
         else 
         {
            Billing.computeBill (bookPrice);
         }
      }
      
      else // invalid number of books
      {
         System.out.println ("Invalid number of books.");
      }
   }
}