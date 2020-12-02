//Cormac Duggan
//Lab 15
//Reas file and searches for info based on input customer id
import java.util.*;
import java.io.*;

public class ReadCustomerList
{
   private Scanner s;
   public void openFile ()
   {
      try
      {
         s = new Scanner(new File("CustomerDatabase.txt"));
      }
      catch (Exception e)
      {
         System.out.print ("Could not locate file");
      }
   }
   public void readFile(int customerID)
   {
      while(s.hasNext())
      {
         String a = s.next();
         String b = s.next();
         String c = s.next();
         String d = s.next();
         int iD = Integer.parseInt(a);
         if(iD == customerID)
         {
            System.out.printf ("%s %s %s %s", a, b, c, d);
         }
      }   
   }
   public void closeFile()
   {
      s.close();
   }
}