//Cormac Duggan
//Lab 15
//Writing file test class
import java.util.Scanner;
public class WriteCustomerListTest 
{
	public static void main (String [] args)
	{
	
		WriteCustomerList create = new WriteCustomerList();
		create.openFile();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many records would you like to add?");
		int numRecords;
		numRecords = sc.nextInt();
		
		create.addRecords(numRecords);
      
      create.closeFile();
	
	}
}