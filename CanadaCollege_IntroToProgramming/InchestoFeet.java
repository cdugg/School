import java.util.Scanner;
//Cormac Duggan
//Monday June 19 2017
//Lab 3
//This lab converts from a number of inches to a number of feet and inches.
public class InchestoFeet
{
   public static void main (String [] args)
   {
      //sets conversion rate constant
      final int CONVERSION = 12;
      
      //creates scanner and first line requesting information
      Scanner sc = new Scanner(System.in);
      System.out.print ("How many inches do you have? ");
      int initial = sc.nextInt();
      
      //converts inches to feet and inches
      int feet = initial / CONVERSION;
      int inches = initial - feet * CONVERSION;
      
      //returns information
      System.out.print ("You have " + feet + " feet and ");
      System.out.print (inches + " inch(es).");
   }
}