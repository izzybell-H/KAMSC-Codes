//NAME              :   Isabel Holtan
//GROUP             :   DM
//LAST MODIFIED     :   1 October 2017
//PROBLEM ID        :   Polnomial Evaluation Algorithm Program
//DESCRIPTION       :   Evaluates a polynomial given certain inputs
//                      Uses the polynomial evaluation method
//SOURCES/HELPERS   :   Mr. H, Dossey

import java.util.*;
import java.text.*;
import java.lang.*;

public class PolyEval
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nDM\nPolynomial Evaluation Algorithm\n");
        
        //Declares Variables
        int degree, x, numRuns;
        Scanner in = new Scanner (System.in);
                
        //Prompts user for the number of runs
        System.out.print ("Input number of runs:  ");
        numRuns = in.nextInt();
        
        //Repeats for the number or runs 
        for (int z=0; z< numRuns; z++)
        {
            //Prompts for input
            System.out.print ("Degree of the Polynomial:  ");
            degree = in.nextInt();
            int [] coefficient = new int[degree+1];
            System.out.print ("\nValue of x:  ");
            x = in.nextInt();
            System.out.print ("\nValue of constant term:  ");
            coefficient[0] = in.nextInt();
            
            //Inputs coefficents into an array
            for (int l=1; l <= degree; l++)
            {
                System.out.print ("\nCoefficient of the x^" + (l) + " term:  ");
                coefficient[l] = in.nextInt();
            }
            
            //Initiialization
            int s = coefficient[0], k = 1;
            System.out.println();
            
            //Add Next Term
            while(k <= degree)
            {
                System.out.println("S"  + k + " = " + s);
                s += Math.pow(x,k)*coefficient[k];
                k++;
            }
            
            //Output P(x) = S
            System.out.println("S" + k + " = " + s);
            System.out.println("P(x) = " + s);
            System.out.println("\n");
        }
    }
}