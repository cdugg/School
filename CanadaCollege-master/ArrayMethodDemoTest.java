//Cormac Duggan
//Lab 9
//Array method test class
public class ArrayMethodDemoTest
{
   public static void main (String [] args)
   {
      ArrayMethodDemo array = new ArrayMethodDemo();
      int numbers [] = {87, 98, 56, 30, 89, 97, 44, 14, 74, 100};
      ArrayMethodDemo.displayAll (numbers);
      System.out.println ();
      ArrayMethodDemo.displayBackward (numbers);
      System.out.println ();
      ArrayMethodDemo.displaySum (numbers);
      System.out.println ();
      ArrayMethodDemo.displayLimit (numbers);
      System.out.println ();
      ArrayMethodDemo.displayHigherAverage (numbers);
   }
}