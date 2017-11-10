/*
 PROG: dualpal
 LANG: JAVA
 ID: 02isabe1
 */
//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   6 December 2016
//PROBLEM ID        :   Dual Palindromes
//DESCRIPTION       :   Determines the first N numbers that are 
//                  :   Palindromes in two bases after a given number
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class dualpal
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        
        //Inputs group
        int numNums = in.nextInt();
        int greaterThan = in.nextInt();
        
        //Initializes variables
        int counter = 1, left, right, palCounter;
        
        while (counter <= numNums)
        {
            //Initializes variables
            palCounter = 0;
            
            //Increments the number testing
            greaterThan++;
            
            for(int j=2; j<=10; j++)
            {
                
                //Initializes variables
                int baseConverter = j;
                String baseNum = "";
                
                while(baseConverter < greaterThan)
                {
                    //Converts j to the correct base
                    if(baseConverter < greaterThan)
                    {
                        baseConverter *= j;
                    }
                    else if (baseConverter == greaterThan)
                    {
                        continue;
                    }
                }
                
                //Goes back one place value
                baseConverter /= j;
                int convertNum = greaterThan;
                
                while(baseConverter > 0 )
                {
                    baseNum = baseNum.concat("" + (convertNum/baseConverter));
                    convertNum %= baseConverter;
                    baseConverter /= j;
                }
            
                //Initializes variables
                left = 0;
                right = baseNum.length() - 1;

                //Determines if the string is a plaindrome
                while (baseNum.charAt(left) == baseNum.charAt(right) && left < right)
                {
                    left++;
                    right--;
                }

                //Increments the palindrome counter if the number is a palindrome
                if (left < right)
                {
                    continue;
                }
                else
                {
                    palCounter++;
                }
            }
            
            //Outputs the number if it has multiple palindromes
            if( palCounter >= 2)
            {
                out.println(greaterThan);
                counter++;
            }
        }
        
        //Ensures program ends properly
        out.close();
    }    
}
        
        