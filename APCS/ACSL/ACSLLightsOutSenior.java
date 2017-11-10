//NAME              :   Isabel Holtan
//School            :   Kalamazoo AMSC
//Division          :   Senior -3
//Contest           :   ACSL Round 3
//Problem           :   ACSL Lights Out
//Date              :   March 2017
//Description       :   Determines what button was pressed

import java.util.*;
import java.text.*;
import java.lang.Character;
import java.util.Arrays;

public class ACSLLightsOutSenior
{
   public static void main (String[] args)
   {
       //Signature
       System.out.println("Isabel Holtan\nSenior\nLights Out\n");
       //Inputs data and declares variables
       Scanner scan= new Scanner (System.in);
       System.out.print("\nInput the initial configuration:  ");
       String hexadecimal = "", binary = "";
       Integer decimal = new Integer(0);
       int tally = 0, rowCounter = 0;
       int [][] startGrd = new int [8][8];
           
       //Input the board configuration encoded in hex, converts to binary, and puts in grid
       for(int j=0; j<4; j++)
       {
           //Develops the binary
           binary = "";
           hexadecimal = scan.next();
           decimal = Integer.parseInt(hexadecimal,16);
           binary = Integer.toBinaryString(Integer.parseInt("" + decimal));
           while(binary.length() < 16)
           {
               binary = "0" + binary;
           }
             
           //Fills the start grid
           for(int x=rowCounter; x<rowCounter+2; x++)
           {
               for(int z=0; z<8; z++)
               {
                   startGrd[x][z] = Integer.parseInt("" + binary.charAt(tally));
                   tally++;
               }  
           }
           rowCounter+=2;
           tally = 0;
       }
       
       /*//Outputs Grid
       for(int j=0; j<8; j++)
       {
           for(int l=0; l<8; l++)
           {
               System.out.print(startGrd[j][l]);
           }
           System.out.println();
       } */
       
       //Repeats for the four grid changes
       for(int k=0;k<5; k++)
       {
           int[][] chngGrd = new int [8][8];
           System.out.print("\nInput the next configuration:  ");
           String hexadecimalN = "", binaryN = "";
           Integer decimalN = new Integer(0);
           int tallyN = 0, rowCounterN = 0;           
           
           //Fills new grid
           for(int j=0; j<4; j++)
           {
               //Develops the binary
               binaryN = "";
               hexadecimalN = scan.next();
               decimalN = Integer.parseInt(hexadecimalN,16);
               binaryN = Integer.toBinaryString(Integer.parseInt("" + decimalN));
               while(binaryN.length() < 16)
               {
                   binaryN = "0" + binaryN;
                }
             
               //Fills the start grid
               for(int x=rowCounterN; x<rowCounterN+2; x++)
               {
                    for(int z=0; z<8; z++)
                    {
                        chngGrd[x][z] = Integer.parseInt("" + binaryN.charAt(tallyN));
                        tallyN++;
                    }  
               }
               rowCounterN+=2;
               tallyN = 0;
           }
           
           //Hits every button, and determines if it maches the next grid
           int [][] pass = new int[8][8];
           for(int q=0; q<8; q++)
           {
               for(int d=0; d<8; d++)
               {
                   pass[q][d] = startGrd[q][d];
               }
           }
           for(int g=0; g<8; g++)
           {
               for(int q=0; q<8; q++)
               {
                   for(int d=0; d<8; d++)
                   {
                       pass[q][d] = startGrd[q][d];
                    }
                }
               for(int a =0; a<8; a++)
               {
                   for(int q=0; q<8; q++)
                   {
                       for(int d=0; d<8; d++)
                       {
                           pass[q][d] = startGrd[q][d];
                        }
                   }
                   if(ACSLLightsOutSenior.press(pass, g, a, chngGrd))
                   {
                       System.out.println("\nThe button pressed was " + (g+1) + (a+1) + "\n");
                   }
               }
           }
           
           //Makes the changed grid the  start grid to identify next change
           startGrd = chngGrd.clone();
                    
       }
    }
   private static boolean press (int[][] grid, int g, int a, int[][] chngGrd1)
   {
        //Swithches the pushed button
        grid[g][a] = ACSLLightsOutSenior.switcher(grid[g][a] );
                   
        //Swithches the button above
        if((g-1) > -1)
        {
            grid[g-1][a] = ACSLLightsOutSenior.switcher(grid[g-1][a] );
                   }
                    
        //Switchers the button two above
        if((g-2) > -1)
        {
            grid[g-2][a] = ACSLLightsOutSenior.switcher(grid[g-2][a] );
        }
                    
        //Switches the button below
        if((g+1) < 8)
        {
            grid[g+1][a] = ACSLLightsOutSenior.switcher(grid[g+1][a] );
        }
                    
        //Switches the button two below
        if ((g+2) < 8)
        {
            grid[g+2][a] = ACSLLightsOutSenior.switcher(grid[g+2][a] );
        }
                    
        //Swithches the left button
        if((a-1) > -1)
        {
            grid[g][a-1] = ACSLLightsOutSenior.switcher(grid[g][a-1] );
        }
                    
        //Swithches the right button
        if((a+1) < 8)
        {
           grid[g][a+1] = ACSLLightsOutSenior.switcher(grid[g][a+1] );
        }
                    
        //Swithes the two right button
        if((a+2) < 8)
        {
           grid[g][a+2] = ACSLLightsOutSenior.switcher(grid[g][a+2] );
        }
                    
        //Switches the two left button
        if((a-2) > -1)
        {
           grid[g][a-2] = ACSLLightsOutSenior.switcher(grid[g][a-2] );
        }
                    
        //Switches NE button
        if((g-1 > -1) && (a+1 <8))
        {
           grid[g-1][a+1] = ACSLLightsOutSenior.switcher(grid[g-1][a+1] );
        }
                    
        //Switches NW button
        if((g-1 >-1) && (a-1) > -1)
        {
           grid[g-1][a-1] = ACSLLightsOutSenior.switcher(grid[g-1][a-1]);
        }
       
        //Switches SE button
        if(g+1 < 8 && (a+1)<8)
        {
           grid[g+1][a+1] = ACSLLightsOutSenior.switcher(grid[g+1][a+1]);
        }
                    
        //Switches SW button
        if((g+1 < 8) && (a-1 ) >-1)
        {
           grid[g+1][a-1] = ACSLLightsOutSenior.switcher(grid[g+1][a-1]);
        }
        int counter = 0;
        for(int j=0; j<8; j++)
        {
            for(int l=0; l<8; l++)
            {
                if(grid[j][l] != chngGrd1[j][l])
                {
                    counter++;
                }
            }
        }
        if(counter ==0)
        {
           return true;
        }
        return false;
   }
   
   //Determines what the tile state switches to
   public static int switcher (int oneOrTwo)
   {
       if(oneOrTwo == 0)
       {
           return 1;
       }
       else
       {
           return 0;
       }
   }           
}