//Cormac Duggan
//Lab 5
//Overloaded methods to deterimine billing price for a given set of books.
public class Billing
{
   ;
   public static void computeBill (double bookPrice)
   {
      double taxValue = 1.08;
      double newBookPrice;
      newBookPrice = bookPrice * taxValue;
      System.out.format ("The book will total cost will be $" + newBookPrice);
      
   }
   public static void computeBill (double bookPrice, int numberOrdered)
   {
      double taxValue = 1.08;
      double newBookPrice;
      newBookPrice = (bookPrice * numberOrdered) * taxValue;
      System.out.format ("The book will total cost will be $" + newBookPrice);
      
   }
   public static void computeBill (double bookPrice, int numberOrdered, double couponValue)
   {
      double taxValue = 1.08;
      double newBookPrice;
      newBookPrice = (((bookPrice * numberOrdered) -couponValue) * taxValue);
      System.out.format ("The book will total cost will be $" + newBookPrice);
      
   }
}