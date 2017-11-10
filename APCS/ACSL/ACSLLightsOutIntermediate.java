//NAME              :   Isabel Holtan
//School            :   Kalamazoo AMSC
//Division          :   Intermediate-5
//Contest           :   ACSL Round 3
//Problem           :   ACSL Lights Out
//Date              :   March 2017
//Description       :   Determines how many lights are on

import java.util.*;
import java.text.*;
import java.lang.Character;

public class ACSLLightsOutIntermediate
{
   public static void main (String[] args)
   {
       //Signature
       System.out.println("Isabel Holtan\nIntermediate\nLights Out\n");
       
       for(int k=0; k<5; k++)
       {
           //Inputs data and declares variables
           Scanner scan= new Scanner (System.in);
           System.out.print("\nInput the information about the grid:  ");
           int tally = 0;
           int [][] grid = new int [8][8];
           int r = scan.nextInt();
           String [] tileLoc = new String[r];
           for(int j=0; j<r; j++)
           {
               tileLoc[j] = scan.next();
           }
           int n = scan.nextInt();
           String [] on = new String [n];
           for(int j=0; j<n; j++)
           {
               on[j] = scan.next();
           }
           //fills grid with off lights
           for(int j=0; j<8; j++)
           {
               for(int l=0; l<8; l++)
               {
                   grid[j][l] = 0;
               }
           }
           
           //turns on the indicated lights
           for(int j=0; j<r; j++)
           {
               //determines what row
               int row = Integer.parseInt("" + tileLoc[j].charAt(0)) - 1;
               int num = tileLoc[j].length();
               //fills in the correct columns
               for(int x=1; x<num; x++)
               {
                   grid[row][Integer.parseInt(""+ tileLoc[j].charAt(x))-1] = 1;
               }           
           }
           
           
           //Adjusts the corrdinates of the turn on, for array, start at zero, counting
           String [] onAdj = new String [n];
           for(int j=0; j<n; j++)
           {
               onAdj[j] = "";
               for(int x=0; x<on[j].length(); x++)
               {
                   onAdj[j] += "" + (Integer.parseInt("" + on[j].charAt(x))-1);
               }
           }
           
           //Turns everything either on or off
           for(int j=0; j<n; j++)
           {
               for(int x=0; x<1; x++)
               {
                   //Swithches the pushed button
                   grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))] );
                   
                   //Swithches the button above
                   if((Integer.parseInt("" + onAdj[j].charAt(x))-1) > -1)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))-1][Integer.parseInt("" + onAdj[j].charAt(x+1))] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))-1][Integer.parseInt("" + onAdj[j].charAt(x+1))] );
                   }
                    
                   //Switchers the button two above
                   if((Integer.parseInt("" + onAdj[j].charAt(x))-2) > -1)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))-2][Integer.parseInt("" + onAdj[j].charAt(x+1))] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))-2][Integer.parseInt("" + onAdj[j].charAt(x+1))] );
                   }
                    
                   //Switches the button below
                   if((Integer.parseInt("" + onAdj[j].charAt(x))+1) < 8)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))+1][Integer.parseInt("" + onAdj[j].charAt(x+1))] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))+1][Integer.parseInt("" + onAdj[j].charAt(x+1))] );
                   }
                    
                   //Switches the button two below
                   if ((Integer.parseInt("" + onAdj[j].charAt(x))+2) < 8)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))+2][Integer.parseInt("" + onAdj[j].charAt(x+1))] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))+2][Integer.parseInt("" + onAdj[j].charAt(x+1))] );
                   }
                    
                   //Swithches the left button
                   if((Integer.parseInt("" + onAdj[j].charAt(x+1))-1) > -1)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))-1] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))-1] );
                   }
                    
                   //Swithches the right button
                   if((Integer.parseInt("" + onAdj[j].charAt(x+1))+1) < 8)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))+1] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))+1] );
                   }
                    
                   //Swithes the two right button
                   if((Integer.parseInt("" + onAdj[j].charAt(x+1))+2) < 8)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))+2] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))+2] );
                   }
                    
                   //Switches the two left button
                   if((Integer.parseInt("" + onAdj[j].charAt(x+1))-2) > -1)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))-2] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))][Integer.parseInt("" + onAdj[j].charAt(x+1))-2] );
                   }
                    
                   //Switches NE button
                   if((Integer.parseInt("" + onAdj[j].charAt(x))-1 > -1) && (Integer.parseInt("" + onAdj[j].charAt(x+1))+1) <8)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))-1][Integer.parseInt("" + onAdj[j].charAt(x+1))+1] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))-1][Integer.parseInt("" + onAdj[j].charAt(x+1))+1] );
                   }
                    
                   //Switches NW button
                   if((Integer.parseInt("" + onAdj[j].charAt(x))-1 >-1) && (Integer.parseInt("" + onAdj[j].charAt(x+1))-1) > -1)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))-1][Integer.parseInt("" + onAdj[j].charAt(x+1))-1] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))-1][Integer.parseInt("" + onAdj[j].charAt(x+1))-1]);
                   }
                   //Switches SE button
                   if((Integer.parseInt("" + onAdj[j].charAt(x))+1 < 8) && (Integer.parseInt("" + onAdj[j].charAt(x+1))+1)<8)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))+1][Integer.parseInt("" + onAdj[j].charAt(x+1))+1] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))+1][Integer.parseInt("" + onAdj[j].charAt(x+1))+1]);
                   }
                    
                   //Switches SW button
                   if((Integer.parseInt("" + onAdj[j].charAt(x))+1 < 8) && (Integer.parseInt("" + onAdj[j].charAt(x+1))-1 ) >-1)
                   {
                       grid[Integer.parseInt("" + onAdj[j].charAt(x))+1][Integer.parseInt("" + onAdj[j].charAt(x+1))-1] = ACSLLightsOutIntermediate.switcher(grid[Integer.parseInt("" + onAdj[j].charAt(x))+1][Integer.parseInt("" + onAdj[j].charAt(x+1))-1]);
                   }   
               }
           }
           
           //Tallies the ones in  the grid
           for(int j=0; j<8; j++)
           {
               for(int l=0; l<8; l++)
               {
                   if(grid[j][l] == 1)
                   {
                       tally++;
                   }
               }
           }                  
           
           System.out.println("\nThe number of lights on is " + tally + "\n");
        }
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