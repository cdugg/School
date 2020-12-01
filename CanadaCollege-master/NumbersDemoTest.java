import java.util.Scanner;
//Cormac Duggan
//Lab 4
//Test class for lab 4.
public class NumbersDemoTest
{
   public static void main (String []args)
   {
      NumbersDemo numbers = new NumbersDemo ();
      Scanner sc = new Scanner(System.in);
      System.out.println ("Please choose a first variable: ");
      int variableOne = sc.nextInt();
      System.out.println ("Please choose a second variable: ");
      int variableTwo = sc.nextInt ();
      NumbersDemo.displayTwiceTheNumber (variableOne, variableTwo);
      NumbersDemo.displayNumberPlusFive (variableOne, variableTwo);
      NumbersDemo.displayNumberSquared (variableOne, variableTwo);
   }
}