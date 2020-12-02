import java.util.Scanner;
public class Temp {
	public static void main(String [] args) 
	{
	Scanner in = new Scanner(System.in);
	System.out.print("Give me a Fahrenheit temperature: ");
	double temp = in.nextDouble();
	temp = Convert.fahr2cels(temp);
	System.out.println("In Celsius that would be: " + temp);
	}
}
