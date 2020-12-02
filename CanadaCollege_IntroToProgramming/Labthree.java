import java.util.Scanner;
//Cormac Duggan
//Monday June 19 2017
//Lab 3
//This lab does...
public class Labthree
{
   public static void main (String [] args)
   {
      final int CONVERSION = 12;
      
      Scanner sc = new Scanner(System.in);
      System.out.print ("How many inches do you have? ");
      int initial = sc.nextInt();
      
      int feet = initial / CONVERSION;
      int inches = initial - feet * CONVERSION;
      
      System.out.print ("You have " + feet + " feet and ");
      System.out.print (inches + " inche(s).");
   }
}