//NAME              :   Isabel Holtan
//School            :   Kalamazoo AMSC
//Division          :   Senior-3
//Contest           :   ACSL Round 1
//Problem           :   ACSL Agram
//Date              :   December 2016
//Description       :   One player leads a card, then the program 
//                  :   Chooses the correct card for the dealer to 
//                  :   Lay depending on the rules of the game Agram

import java.util.*;
import java.text.*;

public class IHACSLAgramSenior
{
   public static void main (String[] args)
   {
       //Signature
       System.out.println("Isabel Holtan\nIntermeiate\n\n");
       
       for(int k=0; k<5; k++)
       {
           
           //Initializes variables
           String leadCard = "", cardToPlay = "", dealerHand = "", dealersTrump = "";
           char suit = ' ';
           int greatestTrump = 0, minCard=0, highCard = 12, lowCard = 12, tie=0;
           Scanner scan= new Scanner (System.in);
           String[] input = new String [6];
           char[] deck = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
           
           //Inputs the data
           System.out.print("Input the lead card and the dealers five cards using spaces between cards:  ");
           for(int j=0; j<6; j++)
           {
               input[j] = scan.next().toUpperCase();
           }
           
           //Manipulates data into its respective catagories
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
           
           if(leadCard.charAt(0) == dealerHand.charAt(0) && leadCard.charAt(1) == dealerHand.charAt(1))
           {
               System.out.println(leadCard);
               break;
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
               System.out.println("\nThe card the dealer must play is " + cardToPlay + "\n\n");
           }
           else if (dealersTrump == "")
           {
              for (int j=0; j<13; j++)
              {
                  for (int m=0; m<10; m+=2)
                  {
                      if(deck[j] == dealerHand.charAt(m))
                      {
                          if (j <= lowCard)
                          {
                              if(j == lowCard && tie >= 1)
                              {
                                  if (suit < dealerHand.charAt(m+1))
                                  {
                                      cardToPlay = "" + dealerHand.charAt(m) + suit;
                                  }
                                  else
                                  {
                                      cardToPlay = "" + dealerHand.charAt(m) + dealerHand.charAt(m+1);
                                  }
                              }
                              else
                              {
                                  lowCard = j;
                                  cardToPlay = "";
                                  suit = dealerHand.charAt(m+1);
                                  tie ++;
                                  cardToPlay = "" + dealerHand.charAt(m) + dealerHand.charAt(m+1);
                              }
                          }
                       }
                  }
              }
              System.out.println("\nThe card the dealer must play is " + cardToPlay + "\n\n");
           } 
       }
   }
}
      