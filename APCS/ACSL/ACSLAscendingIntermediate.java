//NAME              :   Isabel Holtan
//School            :   Kalamazoo AMSC
//Division          :   Intermediate-5
//Contest           :   ACSL Round 2
//Problem           :   ACSL Ascending
//Date              :   January 2016
//Description       :   Prints numbers in ascending
//                      order form a list of numbers

import java.util.*;
import java.text.*;
import java.lang.Character;

public class ACSLAscendingIntermediate
{
   public static void main (String[] args)
   {
       //Signature
       System.out.println("Isabel Holtan\nIntermediate\nAscending\n");
       
       for(int k=0; k<5; k++)
       {
           //Declares Variables
           String input, digit = "", inputSecond, inputRev="", output, noZero = "";
           Scanner scan= new Scanner (System.in);
           char d;
           int numD, lastNum, outputNum, counter =1, x=0;
           boolean toOutput = true, noZeroB = false, zeroCheck = false;
           
           //Inputs string of digits
           System.out.print("\nInput the string of digits:  ");
           input = scan.next();
           System.out.println();
           
           //Determines the lenght of the first digit
           d = input.charAt(0);
           numD = Integer.parseInt(String.valueOf(d));
           
           //Outputs first digit
           for(int j=1; j < Integer.parseInt(String.valueOf(d))+1; j++)
           {
               digit += "" + input.charAt(j);
           }
           if( Integer.parseInt(String.valueOf(d)) == 0)
           {
               digit = "0";
           }
           for(int j=0; j< input.length(); j++)
           {
               if( Integer.parseInt(String.valueOf(input.charAt(j)))==0)
               {
                   continue;
               }
               else
               {
                   zeroCheck = true;
               }
           }
           if(zeroCheck == false)
           {
               System.out.print("0");
               continue;
           }
           
           //System.out.print (input.charAt(1)  +" d" + d + " " + digit);
           if(/*Integer.parseInt(String.valueOf(input.charAt(1))) == 0 &&*/ Integer.parseInt(String.valueOf(d)) != 0)
           {
                //Outputs first number
                System.out.print(digit + " ");
           }
           lastNum =  Integer.parseInt(String.valueOf(digit));
           
           //Removes first number and number length
           inputSecond = input.substring(numD+1);
           
           //Reverses String
           for(int j=0; j< inputSecond.length(); j++)
           {
               inputRev += "" + inputSecond.charAt((inputSecond.length()-1)-j);
           }
           
           //Outputs next numbers
           for(int j=0; j< inputRev.length(); j++)
           {
               counter = 1;
               if(Integer.parseInt(String.valueOf(inputRev.charAt(j))) > lastNum)
               {
                   System.out.print(inputRev.charAt(j) + " "); 
                   lastNum = Integer.parseInt(String.valueOf(inputRev.charAt(j)));
               }
               else 
               {
                   output = "" + inputRev.charAt(j);
                   while((Integer.parseInt(String.valueOf(output))) < lastNum || (Integer.parseInt(String.valueOf(output))) == lastNum)
                   {
                       if((j+counter) < inputRev.length())
                       {
                           output = output + inputRev.charAt(j + counter);   
                       }
                       if((j+counter) > inputRev.length())
                       {
                           toOutput = false;
                           break;
                       }
                       counter++;
                   } 
                   if(toOutput== true)
                   {
                       noZeroB = false;
                       while(Integer.parseInt(String.valueOf(output.charAt(x))) == 0)
                       {
                           noZero = output.substring(x+1);
                           x++;
                           noZeroB = true;
                       }
                       if(noZeroB == true)
                       {
                           System.out.print(noZero + " ");
                       }
                       else
                       {
                           System.out.print(output + " " );
                       }
                       lastNum = (Integer.parseInt(String.valueOf(output)));
                       j= j + (counter-1);
                   }
               }
               if(toOutput == false)
               {
                   System.out.println();
                   break;
               } 
           }
           System.out.println();
       }
   }
}