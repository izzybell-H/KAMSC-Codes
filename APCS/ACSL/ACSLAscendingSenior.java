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

public class ACSLAscendingSenior
{
   public static void main (String[] args)
   {
       //Signature
       System.out.println("Isabel Holtan\nSenior\nAscending\n");
       
       for(int k=0; k<5; k++)
       {
           //Declares Variables
           String input, inputRev = "", output, noZero = "";
           Scanner scan= new Scanner (System.in);
           int g = 0, lastNum = 0, counter = 1, removeSize = 0, x = 0;
           boolean noZeroB = false, toOutput = true, first = true, check = true;
           
           //Inputs string of digits
           System.out.print("\nInput the string of digits:  ");
           input = scan.next();
           System.out.println();
           
           //Output first number and shortens string
           System.out.print(" " + input.charAt(0) + " ");
           lastNum = Integer.parseInt(String.valueOf(input.charAt(0)));
           input = input.substring(1); 
           
           //Reverses String
           for(int j=0; j< input.length(); j++)
           {
               inputRev += "" + input.charAt((input.length()-1)-j);
           }
           
           int j =0;
           //Goes throught the whole string
           while(j<2)
           {
              g = 0;
              //Skips any zeros on the first go through
              while(Integer.parseInt(String.valueOf(inputRev.charAt(g))) == 0)
              {
                  g++;
              }
              
              //Outputs the second number if it is bigger than the last number and single digit
              if(Integer.parseInt(String.valueOf(inputRev.charAt(g))) > lastNum)
              {
                   System.out.print(" " + inputRev.charAt(g) + " "); 
                   lastNum = Integer.parseInt(String.valueOf(inputRev.charAt(g)));
                   removeSize = g + 1;
              }
              //Generates a number larger than one digit
              else
              {
                  output = "" + inputRev.charAt(j);
                  while((Integer.parseInt(String.valueOf(output))) < lastNum || (Integer.parseInt(String.valueOf(output))) == lastNum)
                  {
                      //Checks if the next number is empty, otherwise adds it to output
                      if((j+counter) < inputRev.length() || (j+counter) == inputRev.length())
                      {
                          j++;
                          output = output + inputRev.charAt(j);
                          if((j+counter) == inputRev.length() ||(j+counter) > inputRev.length())
                          {
                              check = false;
                          }
                          //System.out.print("g " + output);
                      }
                      else if((j+counter) > inputRev.length())
                      {
                          toOutput = false;
                          j =2;
                          counter = 1;
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
                          System.out.print(" " +noZero + " ");
                          j = 0;
                          counter =1;
                      }
                      else
                      {
                          System.out.print(" " + output + " " );
                          j = 0;
                          counter = 1;
                      }
                      lastNum = (Integer.parseInt(String.valueOf(output)));
                  }
                  if(check == false)
                  {
                      break;
                  }
                  removeSize = output.length();
              }
              //End of second digit output
              
              //Reverses string and shortens it for next go through
              inputRev = ACSLAscendingSenior.reverseAndShort(inputRev, removeSize);
              //System.out.print(inputRev + "fdsa " + (counter));
           }
            System.out.println();
            System.out.println();
           //End of one go through
       }
   }
   
   //Method to reverse the string
   private static String reverseAndShort (String inputM, int removeSize)
   {
       String inputRevM = "";
       
       //Removes numbers
       inputM = inputM.substring(removeSize); 
        
       //Reverses String
       for(int j=0; j< inputM.length(); j++)
       {
           inputRevM += "" + inputM.charAt((inputM.length()-1)-j);
       }
       
       return inputRevM;
   }
}