 /*
 PROG: sprime
 LANG: JAVA
 ID: 02isabe1
 */
//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   26 January 2017
//PROBLEM ID        :   Prime Palindromes
//DESCRIPTION       :   Determines all of the  super 
//                      primes of a given  length
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class sprime
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("README.TXT"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        
        //Inputs length of super primes
        int length = in.nextInt();
        int num = 1, divideByTen, result = 1;
        boolean prime = true;
        
        for(int j=0; j<length-1; j++)
        {
            num *= 10;
        }

        while(num < num*10)
        {
            while (num > 0 && prime == true)
            {
                //checks if it is a prime
                for(int i=3;i*i<=pal;i+=2) 
                {
                    if(pal%i==0)
                    {
                        result = 1;
                    }
                }
                //If it is a prime, move in one
                if (result == 0)
                {
                    num/=10;
                    tally++;
                }
                //If not a tally, multiply back out to size and continue
                else
                {
                    prime = false;
                    for(int j=0; j<tally; j++)
                    {
                        num*=10;
                    }
                }   
            }
            /*while (num > 0)
            {
                divideByTen-=(divideByTen%10);
                divideByTen /=10;

                if (divideByTen == 0)
                {
                    break;
                }
            }
            //Creates the next number in the sequence
            divideByTen = num++;*/

               
        }
    }     
}
