//NAME              :   Isabel Holtan
//School            :   Kalamazoo AMSC
//Division          :   Intermediate-5
//Contest           :   ACSL Round 1
//Problem           :   ACSL Agram
//Date              :   December 2016
//Description       :   One player leads a card, then the program 
//                  :   Chooses the correct card for the dealer to 
//                  :   Lay depending on the rules of the game Agram

import java.util.*;
import java.text.*;

public class ACSLAgramIntermediate
{
   public static void main (String[] args)
   {
       //Signature
       System.out.println("Isabel Holtan\nIntermeiate\n\n");
       
       for(int k=0; k<5; k++)
       {
           //Initializes variables
           String leadCard = "", cardToPlay = "", dealerHand = "", dealersTrump = "";
           int greatestTrump = 0, minCard=0, highCard = 12, lowCard = 12, tieCounter=0;
           Scanner scan= new Scanner (System.in);
           String[] input = new String [6];
           char[] deck = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
           
           //Inputs the data
           System.out.print("Input the lead card and the dealers hand using spaces to seperate the cards:  ");
           for(int j=0; j<6; j++)
           {
               input[j] = scan.next().toUpperCase();
           }
           
           //Manipulates data into its respecti
           for(int j=0; j<6; j++)
           {
               if(j==0)
               {
                   leadCard = input[j];
               }
               else
               {
                   dealerHand = dealerHand.concat(input[j]);
               }
           }
           
           //Checks if any cards are the same suit as the opponent and adds it to a string of the dealers trump
           for(int j=1; j<10; j+=2)
           {
               if(dealerHand.charAt(j) == (leadCard.charAt(1)))
               {
                  dealersTrump = dealersTrump.concat("" + dealerHand.charAt(j-1) + dealerHand.charAt(j));
               }
           }
           
           //Determinde the value of the card the opponent laid down
           for(int j=0; j<13; j++)
           {
               if(leadCard.charAt(0) == deck[j])
               {
                   minCard = j;
               }
           }
           
           for(int j=0; j<6; j++)
           {
                if(leadCard.charAt(0) == dealerHand.charAt(j) && leadCard.charAt(1) == dealerHand.charAt(j+1))
                {
                    tieCounter++;
                }
           }
           if(tieCounter == 3)
           {
               cardToPlay = leadCard;
               System.out.println("The card the dealer should play is " + leadCard + "\n\nt");
               continue;
           }
           
           //Determines what card is to be played
           if(dealersTrump != "")
           {
               for(int j=0; j<13; j++)
               {
                   for(int m=0; m<dealersTrump.length()-1; m+=2)
                   {
                       if(deck[j] == dealersTrump.charAt(m))
                       {
                           if(j > minCard)
                           {
                               cardToPlay = "" + dealersTrump.charAt(m) + dealersTrump.charAt(m+1);
                               minCard= 100;
                           }
                           else if( minCard != 100 && j < minCard)
                           {
                               if (j < highCard)
                               {
                                    highCard = j;
                                    cardToPlay = "" + dealersTrump.charAt(m) + dealersTrump.charAt(m+1);
                               }
                           }
                       }
                   }
               }
               System.out.println("The card the dealer should play is " + cardToPlay + "\n\n");
           }
           else if (dealersTrump == "")
           {
              for (int j=0; j<13; j++)
              {
                  for (int m=0; m<10; m+=2)
                  {
                      if(deck[j] == dealerHand.charAt(m))
                      {
                          if (j < lowCard)
                          {
                              lowCard = j;
                              cardToPlay = "";
                              cardToPlay = "" + dealerHand.charAt(m) + dealerHand.charAt(m+1);
                          }
                      }
                  }
              }
              System.out.println("The card the dealer should play is " + cardToPlay + "\n\n");
           } 
       }
   }
}
      
