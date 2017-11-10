/*
PROG: namenum
ID: 02isabe1
LANG: JAVA
 */

// NAME             :   Isabel Holtan
// GROUP            :   APCS
// LAST MODIFIED    :   December 9, 2016
// PROBLEM ID       :   Name that Number
// DESCRIPTION      :   Determines acceptabel names
//                  :   For the cow hands to call cows 
//                  :   Based on their serial number
// SOURCES/HELPERS  :   Mr. H, Lewis

import java.io.*;
import java.util.*;
import java.lang.*;

public class namenum
{
    public static void main(String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner scan1= new Scanner(new File("dict.txt"));
        Scanner scan = new Scanner(new File("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("namenum.out")));
        
        //Intializes varaibles
        String num="", dictionary="", serialNum="";
        int tally=0;
        
        //Reads in the number
        serialNum=scan.nextLine();
        
        //Repeats until there is no more input
        while(scan1.hasNext())
        {
            //Reads in the dictionaryionary           
            dictionary=scan1.nextLine();
            
            //Declares variables
            boolean check=true;
            num="";
            
            //Determines if word and serial number are the same lenght
            if(dictionary.length() != serialNum.length())
            {
                continue;
            }

            //Repeats for the lenght of the word
            for (int j=0; j<dictionary.length(); j++)
            {
                //Skips Z and Q
                if (dictionary.charAt(j) == 'Z'  ||  dictionary.charAt(j)=='Q')
                {    
                    check = false;
                    break;
                }  
                
                //Checks to see is Z or Q made check false
                if (!check)
                {
                    break;
                }
                
                //Determines the number that corresponds to a number  
                switch(dictionary.charAt(j))
                {
                    case 'A': num += "2";
                    break;
                    case 'B': num += "2";
                    break;
                    case 'C': num += "2";
                    break;
                    case 'D': num += "3";
                    break;
                    case 'E': num += "3";
                    break;
                    case 'F': num += "3";
                    break;
                    case 'G': num += "4";
                    break;
                    case 'H': num += "4";
                    break;
                    case 'I': num += "4";
                    break;
                    case 'J': num += "5";
                    break;
                    case 'K': num += "5";
                    break;
                    case 'L': num += "5";
                    break;
                    case 'M': num += "6";
                    break;
                    case 'N': num += "6";
                    break;
                    case 'O': num += "6";
                    break;
                    case 'P': num += "7";
                    break;
                    case 'R': num += "7";
                    break;
                    case 'S': num += "7";
                    break;
                    case 'T': num += "8";
                    break;
                    case 'U': num += "8";
                    break;
                    case 'V': num += "8";
                    break;
                    case 'W': num += "9";
                    break;
                    case 'X': num += "9";
                    break;
                    case 'Y': num += "9";
                    break;
                }
            }  
             
            // Outputs any valid names
            if (num.equals(serialNum))
            { 
                out.println(dictionary);
                tally++;
            }
        }
        
        //Outputs none if there are no valid names
        if(tally==0)
        {
            out.println("NONE");
        }
        
        //Ensures program ends correctly
        out.close();
        System.exit(0);
    }
}