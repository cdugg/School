//Cormac Duggan
//Lab 15
//Creates a file and allows user to enter as many records as they choose.
import java.io.*;
import java.lang.*;
import java.util.*;

public class WriteCustomerList 
{
	private Formatter f;
	
	public void openFile ()
	{
		try
		{
			f = new Formatter ("CustomerDatabase.txt");
		}
		catch (Exception e)
		{
			System.out.println("Could not create file.");
		}
	}
	public void addRecords (int numRecords)
	{
		Scanner sca = new Scanner(System.in);
		
		int [] customerID = new int [numRecords + 1];
		String [] firstName = new String [numRecords + 1];
		String [] lastName = new String [numRecords + 1];
		int [] balance = new int [numRecords + 1];
		
		for (int i = 1; i < numRecords + 1; i++)
		{
			System.out.println ("Enter a customer ID:");
			customerID[i] = sca.nextInt();
			f.format("%s", customerID[i] + " ");
			System.out.println("What is the customer's first name?");
			firstName[i] = sca.next();	
			f.format("%s", firstName[i] + " ");
			System.out.println("What is the customer's last name?");
			lastName[i] = sca.next();
			f.format("%s", lastName[i] + " ");
			System.out.println("What is the customer's balance?");
			balance[i] = sca.nextInt();
			f.format("%s", balance[i] + " ");
		}
	}
	public void closeFile ()
	{
		f.close();
	}
}
