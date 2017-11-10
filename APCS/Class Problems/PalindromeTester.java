//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   17 October 2016
//PROBLEM ID        :   Lewis 3.11 Palindrome Tester
//DESCRIPTION       :   Test if a string is a plaindrome while 
//                  :   Ignoring spaces, punctuation, and case
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.*;
import java.text.*;

public class PalindromeTester
{
   public static void main (String[] args)
   {
      //Signture
      System.out.println ("Isabel Holtan\nAPSC\nLewis 3.11 PalindromeTester\n\n");
      
      //Declares variables
      String potentialPal, casePal;
      int left, right;
      Scanner scan = new Scanner (System.in);
      
      for(int j=0; j<4 ; j++)
      {
         //Prompts user for the potential palindrome
         System.out.print("Enter a potential palindrome:  ");
         potentialPal = scan.nextLine();
         
         //Declares Variable
         String lettersOnlyPal = " ";
         
         //Makes the entire string lowercase
         casePal = potentialPal.toLowerCase();
         
         //Creates a string that only contains letters, no punctuation or spaces
         for(int k=0; k<casePal.length(); k++)
         {
             for (char c = 'a'; c <= 'z'; c++)
             {
                 if(casePal.charAt(k) == c)
                 {
                     lettersOnlyPal += casePal.charAt(k);
                    }
             }
         }

         //Initializes variables
         left = 1;
         right = lettersOnlyPal.length() - 1;

         //Determines if the string is a plaindrome
         while (lettersOnlyPal.charAt(left) == lettersOnlyPal.charAt(right) && left < right)
         {
            left++;
            right--;
         }

         System.out.println();

         //Tells the user if the string is or is not a palindrome
         if (left < right)
            System.out.println ("That string is NOT a palindrome.\n\n");
         else
            System.out.println ("That string IS a palindrome.\n\n");
      }
   }
}

