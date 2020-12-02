import java.util.Scanner;
//Cormac Duggan
//Lab 6
//Test class
public class CondoSaleTest
{
   public static void main (String [] args)
   {
      CondoSales condo = new CondoSales ();
      Scanner sc = new Scanner(System.in);
      System.out.println ("Please choose a view type.");
      System.out.println ("Enter 1 for a Park View Condo. $150,000");
      System.out.println ("Enter 2 for a Golf Course View Condo. $170,000");
      System.out.println ("Enter 3 for a Lake View Condo. $210,000");
      int viewType = sc.nextInt();
      CondoSales.price (viewType);
   }
}