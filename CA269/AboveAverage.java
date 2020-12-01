import java.util.Scanner;

public class AboveAverage {
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("How many numbers: ");
        int num = in.nextInt();        
        System.out.print("Enter " + num + " numbers: ");
        double total = 0;
        double [] numbers;
        numbers = new double [num];
        for(int i = 0; i < num; i++)
        {
        	double next = in.nextDouble();
        	numbers[i] = next;
        	total = total + next;
        }
        double average = total/num;
        System.out.println("The above average numbers are:");        
        for(int i = 0; i < num; i ++)
        {
            if (numbers[i] > average)
            {
            	System.out.print(" " + numbers[i]);
            }
        }
        System.out.println();
	}
}
