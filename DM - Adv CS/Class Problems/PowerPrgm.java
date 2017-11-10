//NAME              :   Isabel Holtan
//GROUP             :   DM
//LAST MODIFIED     :   1 October 2017
//PROBLEM ID        :   Power Program
//DESCRIPTION       :   Given a number (x) and a power (n) to raise 
//                      it to, it computes the P=x^n
//SOURCES/HELPERS   :   Mr. H, Dossey

import java.util.*;
import java.text.*;
import java.lang.*;

public class PowerPrgm
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nDM\nPower Program\n");
        
        //Declares Variables
        int base, exponent,total, numRuns;
        Scanner in = new Scanner (System.in);
        
        //Prompts user for the number of runs
        System.out.print ("Input number of runs:  ");
        numRuns = in.nextInt();
        
        //Repeats for the number or runs 
        for (int k=0; k< numRuns; k++)
        {
           System.out.print("Input the base:  ");
           base=in.nextInt();
           System.out.print("Input the exponent:  ");
           exponent=in.nextInt();
           
           total=base;
           
           for(int j=1; j<exponent; j++)
           {
               total*=base;
           }
           if(exponent == 0 )
           {
               total = 1;
           }
           
           System.out.println("The result is: " + total);
    
        }
    }
}
