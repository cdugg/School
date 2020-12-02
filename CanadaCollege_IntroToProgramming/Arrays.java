public class Arrays
{
   public static void array ()
   {
      //create and set customer array
      String custName [] = {"The Bakery", "The Butcher Shop", "The Grocery Store", "The Restaurant", "The Snack Shop", "The Deli"}; 
      //create and set number of orders array
      int numOrders [] = {5, 2, 3, 1, 5, 4};
      //create and set price array
      double orderAmount [] = {80000, 60000, 90000, 70000, 75000, 85000};
      
      //Set up heade for each column
      System.out.println ("Customer           Order Amount    Discount    Invoice Amount");
      //11 spaces between customer and Order Amount, 4 spaces between all others to properly line up the columns
      
      //for loop to set discount for each customer based on the number of orders
      for (int i = 0; i < 6; i++)
      {  
         double discount; 
         if (numOrders[i] <= 2)
         {
            discount = 0;
         }
         else if (numOrders[i] == 3)
         {
            discount = .05 * orderAmount[i];
         }
         else if (numOrders[i] == 4)
         {
            discount = .05 * orderAmount[i];
         }
         else
         {
            discount = .1 * orderAmount[i];
         }
         //set the invoice amount after the discount is calculated
         double invoiceAmount = orderAmount[i] - discount;
         //print everything in order
         System.out.printf("%-18s $%-14.2f $%-10.2f $%.2f%n",  custName[i], orderAmount[i], discount, invoiceAmount);
      }   
   }
}