/*
 PROG: pprime
 LANG: JAVA
 ID: 02isabe1
 */
//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   22 December 2016
//PROBLEM ID        :   Prime Palindromes
//DESCRIPTION       :   Determines all of the prime 
//                      palindromes in a given range
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.io.*;
import java.util.*;

public class pprime
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner (new File("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        
        //Inputs group
        int lowBound = in.nextInt();
        int upBound = in.nextInt();
        int pal = lowBound;

        //Onedigit
        if ((1 <= pal && pal <= 9) && (lowBound <= pal && pal <= upBound))
        {
            //Generates palindrome
            for (int d1 = lowBound; d1 <= 9; d1+=2) 
            { 
                //Determines if the palindrome is prime
                int j = 2, result = 0;
                while (j <= d1 / 2)
                {
                    if (d1 % j == 0)
                    {
                        result = 1;
                    }
                    j++;
                }
                if (result == 0)
                {
                    out.println(d1);
                }
                pal = d1 + 1;
            } 
        }
        //Two digit
        if ((10 <= pal && pal <=99 ) && (lowBound <= pal && pal <= upBound))
        {
            for (int d1 = 1; d1 <= 9; d1+=2) 
            { 
                pal = 10*d1 + d1;
                
                int result = 0;
                for(int i=3;i*i<=pal;i+=2) 
                {
                    if(pal%i==0)
                    {
                        result =1;
                    }
                }

                if (result == 0)
                {
                    if (lowBound <= pal && pal <= upBound)
                    {
                        out.println(pal);
                    }
                }
                if(pal > upBound)
                {
                    break;
                }
            }
            pal++;
        }
        
        //Three digit
        if ((100 <= pal && pal <= 999 ) && (lowBound <= pal && pal <= upBound))
        {
            for (int d1 = 1; d1 <= 9; d1+=2) 
            { 
                for(int d2 = 0; d2<=9; d2++)
                {
                    pal = 100*d1 + 10*d2 + d1;
                   
                    int result = 0;
                    for(int i=3;i*i<=pal;i+=2) 
                    {
                        if(pal%i==0)
                        {
                            result =1;
                        }
                    }
                    
                    if (result == 0)
                    {
                        if(lowBound <= pal && pal <= upBound)
                        {
                            out.println(pal);
                        }
                    }
                    if(pal > upBound)
                    {
                        break;
                    }
                }
                if(pal > upBound)
                {
                    break;
                }
            }
            pal++;   
        }
        
        //Four digit pals
        
        if ((1000 <= pal  && pal <= 9999 ) && (lowBound <= pal && pal <= upBound))
        {
            pal = 10000;
        }
 
        //Five digit
        if ((10000 <= pal && pal <99999 ) && (lowBound <= pal && pal <= upBound))
        {
            for (int d1 = 1; d1 <= 9; d1+=2) 
            { 
                for(int d2 =0; d2<=9; d2++)
                {
                    for(int d3 =0; d3 <= 9; d3 ++)
                    {
                        pal = 10000*d1 + 1000*d2 + 100*d3 + 10*d2 + d1;
                        
                        int result = 0;
                        for(int i=3;i*i<=pal;i+=2) 
                        {
                            if(pal%i==0)
                            {
                                result =1;
                            }
                        }
                        if (result == 0)
                        {
                            if (lowBound <= pal && pal <= upBound)
                            {
                                out.println(pal);
                            }
                        }
                        
                        if(pal > upBound)
                        {
                            break;
                        }
                    }
                    if(pal > upBound)
                    {
                        break;
                    }
                }
                pal++;
            }
        }
        
        //Six digits
        if ((100000 <= pal && pal <=999999 ) && (lowBound <= pal && pal <= upBound))
        {
            pal = 1000000;
        }

        //Seven digit
        if ((1000000 <= pal && pal  <=9999999 ) && (lowBound <= pal && pal <= upBound))
        {
            for (int d1 = 1; d1 <= 9; d1+=2) 
            { 
                for( int d2 = 0; d2 <= 9; d2++)
                {
                    for(int d3 = 0; d3 <= 9; d3 ++)
                    {
                        for (int d4 = 0; d4 <= 9; d4 ++)
                        {
                            pal = 1000000*d1 + 100000*d2 + 10000*d3 + 1000*d4 + 100*d3 + 10*d2 + d1;
                            
                            int result = 0;
                            for(int i=3;i*i<=pal;i+=2) 
                            {
                                if(pal%i==0)
                                {
                                    result =1;
                                }
                            }
                            if (result == 0)
                            {
                                if(lowBound <= pal && pal <= upBound)
                                {
                                    out.println(pal);
                                }
                            } 
                            
                            if(pal > upBound)
                            {
                                break;
                            }
                        }
                        if(pal > upBound)
                        {
                            break;
                        }
                    }
                    if(pal > upBound)
                    {
                        break;
                    }
                }
                if(pal > upBound)
                {
                    break;
                }
            }    
            pal++;
        }
        
        if ((100000000 <= pal && pal <=99999999 ) && (lowBound <= pal && pal <= upBound))
        {
            for (int d1 = 1; d1 <= 9; d1+=2) 
            { 
                for( int d2 = 1; d2 <= 9; d2 += 2)
                {
                    for(int d3 =1; d3 <= 9; d3 +=2)
                    {
                        for (int d4 =1; d4 <= 9; d4 += 2)
                        {
                            pal = 10000000*d1 + 1000000*d2 + 100000*d3 + 10000*d4 + 1000*d4 + 100*d3 + 10*d2 + d1;
                            
                            int result = 0;
                            for(int i=3;i*i<=pal;i+=2) 
                            {
                                if(pal%i==0)
                                {
                                    result =1;
                                }
                            }
                            
                            if (result == 0)
                            {
                                if (lowBound <= pal && pal <= upBound)
                                {
                                    out.println(pal);
                                }
                            }
                            if(pal > upBound)
                            {
                                break;
                            }
                        }
                        if(pal > upBound)
                        {
                            break;
                        }
                    }
                    if(pal > upBound)
                    {
                        break;
                    }
                }
                if(pal > upBound)
                {
                    break;
                }
            }
            pal++;
        }  
                
        //Ensures program ends properly
        out.close();
    }
}
