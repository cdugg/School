import java.util.Scanner;
//Cormac Duggan
//Lab 4
//This program does multiple operations to a pair of input variables.
public class NumbersDemo
{
   //sets variable value after being doubled then prints value
   public static void displayTwiceTheNumber (int variableOne, int variableTwo)
   {
      variableOne = variableOne * 2;
      variableTwo = variableTwo * 2;
      System.out.println ("When multiplied by 2:");
      System.out.println ("Variable 1 = " + variableOne);
      System.out.println ("Variable 2 = " + variableTwo);
   } 
   
   //sets variable value after adding 5 to it then prints value
   public static void displayNumberPlusFive (int variableOne, int variableTwo) 
   {
      variableOne = variableOne + 5;
      variableTwo = variableTwo + 5;
      System.out.println ("When 5 is added to:");
      System.out.println ("Variable 1 = " + variableOne);
      System.out.println ("Variable 2 = " + variableTwo);
   } 
   
   //sets variable value after being squared then prints value
   public static void displayNumberSquared (int variableOne, int variableTwo)
   {
      variableOne = variableOne * variableOne;
      variableTwo = variableTwo * variableTwo;
      System.out.println ("When sqared:");
      System.out.println ("Variable 1 = " + variableOne);
      System.out.println ("Variable 2 = " + variableTwo);
   }
   
}