//Cormac Duggan
//Lab 15
//Reading file test class
import java.io.*;
import java.util.*;
public class ReadCustomerListTest
{
   public static void main (String [] args)
   {
      ReadCustomerList read = new ReadCustomerList();
      
      read.openFile();
      
      int customerID;
      Scanner sc = new Scanner (System.in);
      System.out.println ("Enter the customer ID of the customer you are searching for.");
      customerID = sc.nextInt();
      
      read.readFile(customerID);
      read.closeFile();
   }
}