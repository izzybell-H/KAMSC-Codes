/*
 PROG: palsquare
 LANG: JAVA
 ID: 02isabe1
 */
//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   28 November 2016
//PROBLEM ID        :   Palindromic Squares
//DESCRIPTION       :   Converts all of the numbers between 1 and 300 
//                  :   To a given base and then checks if that number
//                  :   Is a palendrome
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class palsquare
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        
        //Inputs group
        int base = in.nextInt();
        int square, left, right;
        
        for(int j=1; j<=300; j++)
        {
            
            //Squares the number
            square= j * j;
            
            //Converts J to the correct base
            String jBase = Integer.toString(j, base);
            
            //Converts the number to the correct base
            String baseNum = Integer.toString(square, base);
            
            //Initializes variables
            left = 0;
            right = baseNum.length() - 1;

            //Determines if the string is a plaindrome
            while (baseNum.charAt(left) == baseNum.charAt(right) && left < right)
            {
                left++;
                right--;
            }

            //Outputs the number if it is a palindrome
            if (left < right)
            {
                continue;
            }
            else
            {
                out.println (jBase.toUpperCase() + " " + baseNum.toUpperCase());
            }
        }
        
        //Ensures program ends properly
        out.close();
    }    
}
        
        