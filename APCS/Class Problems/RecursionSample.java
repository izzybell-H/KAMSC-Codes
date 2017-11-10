//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   24 April 2017
//PROBLEM ID        :   Recursive Algebraic FunctionsProgram
//DESCRIPTION       :   Recursively solves all problems on the recursive Functions 
//                      Worksheet #1
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.*;
import java.text.*;

public class RecursionSample
{
    public static void main (String [] args)
    {
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nRecursive Algebraic FunctionsProgram\n\n");
        
        //Declares Variables
        int x,y;
        
        //Problem #1
        x=20;
        System.out.println("f(" + x + ") = " + prob1(x));
        
        //Problem #2
        x = 10;
        System.out.println("f(" + x + ") = " + prob2(x));
        
        //Problem #3
        x= 16;
        System.out.println("f(" + x + ") = " + prob3(x));
        
        //Problem #4
        x = 6;
        System.out.println("f(" + x + ") = " + prob4(x));
        
        //Problem #5
        x = 9;
        System.out.println("f(" + x + ") = " + prob5(x));
        
        //Problem #6
        x = 10;
        y = 4;
        System.out.println("f(" + x + "," + y + ") = " + prob6(x,y));
    }
    
    static int prob1 (int x)
    {
        int result;
        if(x>12)
        {
            result = prob1(x-5)+6;
        }
        else if (x>1)
        {
            result = prob1(x-3) +4;
        }
        else
        {
            result =-1;
        }
        return result;
    }
    
    static int prob2 (int x)
    {
        int result;
        if(x>=7)
        {
            result = prob2(1+ prob2(x-3))-2;
        }
        else if (x> -1 && x <7)
        {
            result = 1 + prob2(x-4);
        }
        else
        {
            result = 2*x+3;
        }
        return result;
    }
    
    static int prob3 (int x)
    {
        int result;
        if(x>=10)
        {
            result = prob3(x-4)+1;
        }
        else if (x>2 && x<10)
        {
            result = prob3(x-3)-3;
        }
        else
        {
            result = x*x-1;
        }
        return result;
    }
    
    static int prob4 (int x)
    {
        int result;
        if( x%2 == 0 && x > 0)
        {
            result = prob4(x-2)-2*prob4((x-1)%3)+1;
        }
        else if (x%2 != 0 )
        {
            result = x+1;
        }
        else
        {
            result = 0;
        }
        return result;
    }
    static int prob5 (int x)
    {
        int result;
        if(x%2!=0 && x>0)
        {
            result = 3 + prob5(x-3);
        }
        else if (x%2 == 0 && x>0)
        {
            result = 2 - prob5(x+1);
        }
        else
        {
            result = 5;
        }
        return result;
    }
    static int prob6 (int x , int y)
    {
        int result = 0;
        if (x>y)
        {
            result = prob6(x-2, y+1) -1;
        }
        else if ( x==y)
        {
            result =  3 + prob6(2*x + 1 , y +2);
        }
        else if (x< y)
        {
            result = y + (x*x);
        }
        return result;
    }
    
}