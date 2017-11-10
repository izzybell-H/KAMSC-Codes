//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   31 October 2016
//PROBLEM ID        :   Lewis 3.14 Rock Paper Scissors
//DESCRIPTION       :   User play rock paper scissors against the computer
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.Scanner; 
import java.util.Random; 


public class RPS
{ 
    public static void main(String[] args) 
    { 
        //Signture
        System.out.println ("Isabel Holtan\nAPSC\nLewis 3.14 Rock Paper Scissors\n");
      
        //Declares Variables
        String personPlay; 
        String computerPlay = "";  
        int computerInt, win = 0, tie=0, loose = 0; 
        String response = "y"; 
        Scanner scan = new Scanner(System.in); 
        Random generator = new Random(); 
        
        do
        {
            //Generate computer's play (0,1,2) 
            computerInt = generator.nextInt(3)+1; 

            //Translate computer's randomly generated play to a string
            if (computerInt == 1) 
            {
                computerPlay = "ROCK"; 
            }
            else if (computerInt == 2) 
            {
                computerPlay = "PAPER"; 
            }
            else if (computerInt == 3)
            {
                computerPlay = "SCISSORS"; 
            }

            //Inputs user choice 
            System.out.print("\nEnter your play (Rock, Paper, Scissors): "); 
            personPlay = scan.next();

            //Make users choice uppercase 
            personPlay = personPlay.toUpperCase(); 

            //Print computer's Choice
            System.out.println("\nComputer play is: " + computerPlay); 

            //Outputs winner
            if (personPlay.equals(computerPlay)) 
            {
                System.out.println("It's a tie!"); 
                tie++;
            }
            else if (personPlay.equals("ROCK")) 
            {
                if (computerPlay.equals("SCISSORS")) 
                {
                    System.out.println("Rock crushes scissors, You win!");
                    win++;
                }
                else if (computerPlay.equals("PAPER")) 
                {
                    System.out.println("Paper eats rock, You lose!");
                    loose++;
                }
            }
            else if (personPlay.equals("PAPER")) 
            {
                if (computerPlay.equals("SCISSORS")) 
                {
                    System.out.println("Scissor cuts paper, You lose!");
                    loose++;
                }
                else if (computerPlay.equals("ROCK"))
                {
                    System.out.println("Paper eats rock, You win!"); 
                    win++;
                }
            }
            else if (personPlay.equals("SCISSORS")) 
            {
                if (computerPlay.equals("PAPER"))
                {
                    System.out.println("Scissor cuts paper, You win!"); 
                    win++;
                }
                else if (computerPlay.equals("ROCK")) 
                {
                    System.out.println("Rock breaks scissors, You lose!");
                    loose++;
                }
            }
            
            //Asks the user if they would like to play again
            System.out.print ("\nWould you like to play again (yes/no):  ");
            response = scan.next(); 
            System.out.println();
            
        } while (response.equals("yes"));
        System.out.print("You won " + win + " game(s), you lost " + loose + " game(s), and you tied " + tie + " game(s)");
    }
}