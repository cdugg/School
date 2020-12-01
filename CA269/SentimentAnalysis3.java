import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Senti3
{
    public static void main(String [] args)
    {
        try
        {
            Scanner names = new Scanner(new File(args[0]));
            String longname = "";
            while(names.hasNext())
            {
                longname = longname + names.next() + " ";
                
            }
            String[] name= longname.split(" ");
            int num = 0;
            double counter = 0;
            int marker = 0;
            double score;
            String s;
            int temp;
            double[] final_counter= new double[name.length];
            double[] final_marker= new double[name.length];
            int[] markers= new int[name.length];
            Scanner in = new Scanner(new File(args[1]));
            while(in.hasNext())
            {
                
                if(in.hasNextInt())
                {
                    temp = num;
                    num = in.nextInt();
                    if(num<10)
                    {
                        markers = new int[name.length];
                    }
                    else
                    {
                        num = temp;    
                    }
                }
                s = in.next()   ; 
                for(int i = 0; i != name.length; i++)
                {                    
                    if(s.equals(name[i]) && markers[i] != 1)
                    {                           
                        markers[i] = 1;
                        final_marker[i] = final_marker[i] + num;
                        final_counter[i] = final_counter[i] + 1;                
                    }
                }
            }
            for(int i = 0; i != name.length; i++)
            {
                System.out.print("The score of "+ name[i] + " is ");
                System.out.printf("%.2f", (final_marker[i] / final_counter[i]));
                System.out.println(".");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("dud");
        }
    }
}
