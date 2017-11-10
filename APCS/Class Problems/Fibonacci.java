//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   10 May 2017
//PROBLEM ID        :   Lewis 8.4 Fibonacci
//DESCRIPTION       :   Finds the number in  the nth spot
//                      of the fibonacci sequence
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.*;
import java.text.*;

public class Fibonacci
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nLewis 8.4 Fibonacci\n\n");
        
        //Declares Variables
        int n;
        Scanner in = new Scanner (System.in);
        
        for(int j=0; j< 3; j++)
        {
            //Prompts for nth postition
            System.out.print("Enter the numbers of fibonacci:  ");
            n = in.nextInt();
            System.out.println();
            
            //Outputs fibonacci number
            for(int k = 1; k<= n; k++)
            {
                System.out.print(Fibonacci.fibonacci(k) + " ");
            }
            System.out.println("\n");
        }
    }
    
    public static int fibonacci (int n)
    {
        //recusively finds the nth fibonacci number
        if(n == 2)
        {
            return 1;
        }
        else if(n == 1)
        {
            return 0;
        }
        else
        {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}