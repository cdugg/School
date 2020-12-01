//Cormac Duggan
//Lab 9
//This is a set of 5 methods that effect an array in various ways.
public class ArrayMethodDemo
{
   public static void displayAll (int numbers[]) //Prints all array values
   {
      for (int i = 0; i < 10; i++)
         {
            System.out.print (numbers[i] + ", ");
         }
   }
   public static void displayBackward (int numbers[]) // Prints all array values backward.
   {
      System.out.print (numbers[9] + ", ");
      System.out.print (numbers[8] + ", ");
      System.out.print (numbers[7] + ", ");
      System.out.print (numbers[6] + ", ");
      System.out.print (numbers[5] + ", ");
      System.out.print (numbers[4] + ", ");
      System.out.print (numbers[3] + ", ");
      System.out.print (numbers[2] + ", ");
      System.out.print (numbers[1] + ", ");
      System.out.print (numbers[0] + ", ");
   }
   public static void displaySum (int numbers[]) //Prints sum of all array values
   {
      int sum = 0;
      for (int i = 0; i < 10; i++)
         {
            sum = sum + numbers[i];
         }
      System.out.print (sum);   
   }
   public static void displayLimit (int numbers[]) // Prints all values in array that are less than or equal to 50
   {
      for (int i = 0; i < 10; i++)
         {
            if (numbers[i] <= 50)
            {
               System.out.print (numbers[i] + ", ");
            }
         }
   }
   public static void displayHigherAverage (int numbers[]) // Prints all array values that are greater than the average of all values
   {
      int sumTwo = 0;
      for (int i = 0; i < 10; i++)
         {
            sumTwo = sumTwo + numbers[i];
         }
      int average = sumTwo / 10;
      
      for (int i = 0; i < 10; i++) 
         {
            if (numbers[i] > average)
               {
                  System.out.print (numbers[i] + ", ");
               }
         } 
   }
}