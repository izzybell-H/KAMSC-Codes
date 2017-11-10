//NAME              :   Isabel Holtan
//GROUP             :   DM
//LAST MODIFIED     :   5 October 2017
//PROBLEM ID        :   Next Subset Program
//DESCRIPTION       :   Given  a possitive integer n and a string of 1s and 0s 
//                  :   corresponding to  a set of n elements, the algorithms
//                      computed the next subset
//SOURCES/HELPERS   :   Mr. H, Dossey

import java.util.*;
import java.text.*;
import java.lang.*;

public class NextSubSet
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nDM\nNext Subset\n");
        
        //Declares Variables
        int n, numRuns;
        Scanner in = new Scanner (System.in);
                
        //Prompts user for the number of runs
        System.out.print ("Input number of runs:  ");
        numRuns = in.nextInt();
        
        //Repeats for the number or runs 
        for (int z=0; z< numRuns; z++)
        {
            //Prompts for input
            System.out.print ("\nInput n:  ");
            n = in.nextInt();
            String subset = "";
            String nextSubSet = "";
            System.out.print ("\nInput the string of 0s and 1s:  ");
            subset = in.next();

            //Initialization
            int k = n-1;
            
            //Look for rightmost 0
            while(k >=0 && (subset.charAt(k)) == '1')
            {
                k = k-1;
            }
            
            //If there is a zero, form the next string
            if(k <= n-1 && k>=0)
            {
                nextSubSet = subset.substring(0,k) + "1";
                //Change succeeding 1s to 0s
                //if(nextSubSet.length()<n)
                //{
                    for(int j = k+1; j<n; j++)
                    {
                        nextSubSet += "0";
                    }
                //}
                System.out.print("\nThe next subset is: " + nextSubSet + "\n\n");
            }
            //If the string is only ones
            else
            {
                System.out.print("\nThe string contains all 1's\n\n");
            }
        }
    }
}