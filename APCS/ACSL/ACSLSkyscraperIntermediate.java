//NAME              :   Isabel Holtan
//School            :   Kalamazoo AMSC
//Division          :   Intermediate-5
//Contest           :   ACSL Round 4
//Problem           :   ACSL Skyscraper
//Date              :   March 2017
//Description       :   Completes a skyscraper puzzle

import java.util.*;
import java.text.*;
import java.lang.Character;

public class ACSLSkyscraperIntermediate
{
   //Declares data to be accesed by all methods
   final static int GRID  = 4;
   public static int [][] puzzle = new int [4][4];
   
   public static void main (String[] args)
   {
       //Signature
       System.out.println("Isabel Holtan\nIntermediate\nSkyscraper\n");

       //Inputs data and declares variables
       Scanner scan= new Scanner (System.in);
       System.out.print("\nInput the information about the puzzle (spaces):  ");
       String topClues = scan.next();
       
       for(int j=0; j<GRID; j++)
       {
           for(int x=0; x<GRID; x++)
           {
               puzzle[j][x] = 0;
           }
       }
       
       //Processes the top clue
       ACSLSkyscraperIntermediate.isFour(topClues , 1, -1);
       ACSLSkyscraperIntermediate.isOne(topClues , 1, -1);
       
       //Inputs the first clue, determines type, and proceses
       String clueOne = scan.next();
       clueOne = ACSLSkyscraperIntermediate.inputProcess(clueOne ,0);
       
       //Inputs the second clue, determines type, and proceses
       String clueTwo = scan.next();
       clueTwo = ACSLSkyscraperIntermediate.inputProcess(clueTwo ,1);
       
       //Inputs the third clue, determines type, and proceses
       String clueThree = scan.next();
       clueThree = ACSLSkyscraperIntermediate.inputProcess(clueThree ,2);

       //Inputs the fourth clue, determines type, and proceses
       String clueFour = scan.next();
       clueFour = ACSLSkyscraperIntermediate.inputProcess(clueFour ,3);
       
       //Processes the bottom clue
       String bottomClues = scan.next();
       ACSLSkyscraperIntermediate.isFour(bottomClues , 3, -1);
       ACSLSkyscraperIntermediate.isOne(bottomClues , 3, -1);
       
       int sumTotal = 0;
       int checker = 0;
       //Repeats until there are no empty spots in the grid
       while (sumTotal != 40)
       {
           sumTotal = 0;
           //If any rows or columns are only missing one, then it is filled in
           ACSLSkyscraperIntermediate.oneLeft();           
           ACSLSkyscraperIntermediate.twoLeft(clueOne, clueTwo, clueThree, clueFour, topClues, bottomClues);
           
           //Determines if all of the grid is filled
           for(int j=0; j<GRID; j++)
           {
               for(int x=0; x<GRID; x++)
               {
                   sumTotal += puzzle[j][x];
               }
           }
           checker++;
           
           if(checker == 50)
           {
               sumTotal = 40;
            }
       }
        System.out.println();
       
       //Retrieves the value at positions indicated by input
       for(int j=0; j<5; j++)
       {
           String coor = "";
           System.out.print("Input corrdinate number " + (j+1) + ":  ");
           coor = scan.next();
           System.out.println("\nThe number there is " + puzzle[Integer.parseInt("" + coor.charAt(0))-1][Integer.parseInt("" + coor.charAt(1))-1] + "\n");
       }
           
   }
   
   //When a clue has a four, we know that the numbers must increase 1,2,3,4 so fills accordingly
   public static void isFour(String clue, int local, int clueNum)
   {
       //If top (1) or bottom (3) input
       if(local == 1 || local == 3)
       {
           //Repeat for size of grid
           for(int k=0; k<GRID; k++)
           {
               //If spot in grid is equal to four
               if(clue.charAt(k) == '4')
               {
                   //If clue is for top
                   if(local == 1)
                   {
                       int num = 1;
                       //Fills in all of the boxes bellow in assending order
                       for(int d=0; d<GRID; d++)
                       {   
                           puzzle[d][k] = num;
                           num++;
                       }                       
                   }
                   //If clue is for bottom
                   if (local == 3)
                   {
                       int num = 4;
                       //Fills in all of the boxes bellow in assending order
                       for(int d=0; d<GRID; d++)
                       {   
                           puzzle[d][k] = num;
                           num--;
                       }           
                   }
               }
           }
       }
       else if (local == 2)
       {
           
           if(clue.charAt(0) == '4')
           {
               int num = 1;
               //Fills in all of the boxes bellow in assending order
               for(int d=0; d<GRID; d++)
               {   
                   puzzle[clueNum][d] = num;
                   num++;
               }            
           }
           if(clue.charAt(1) == '4')
           {
               int num = 4;
               for(int d=0; d<GRID; d++)
               {
                   puzzle[clueNum][d] = num;
                   num--;
               }
           } 
       }
   }
   
   //When  a clue is one, we know a 4 must be infront because you can only see the tallest building
   public static void isOne(String clue, int local, int clueNum)
   {
       //If top (1) or bottom (3) input
       if(local == 1 || local == 3)
       {
           //Repeat for size of grid
           for(int k=0; k<GRID; k++)
           {
               //If spot in grid is equal to four
               if(clue.charAt(k) == '1')
               {
                   //If clue is for top
                   if(local == 1)
                   {
                       puzzle [0][k] = 4;
                   }
                   //If clue is for bottom
                   if (local == 3)
                   {
                      puzzle [3][k] = 4; 
                   }
               }
           }
       }
       else if (local == 2)
       {
           if(clue.charAt(0) == '1')
           {
               puzzle[clueNum][0] = 4;
           }
           if(clue.charAt(1) == '1')
           {
               puzzle[clueNum][3] = 4;
           }
       }
   }
   
   //Processes the input
   public static String inputProcess (String clue, int clueNum)
   {
       //When clue is the full data, it fills the grid 
       if(clue.length() == 6)
       {
           String fillGrid = clue.substring(1,5);
           for(int j=0; j<GRID; j++)
           {
              puzzle[clueNum][j] = Integer.parseInt("" + fillGrid.charAt(j)); 
           }
           return (""+clue.charAt(0)+clue.charAt(5));
       }
       
       //When the clue is 2, checks for 4 and 1
       if(clue.length() == 2)
       {
           ACSLSkyscraperIntermediate.isFour(clue , 2, clueNum);
           ACSLSkyscraperIntermediate.isOne(clue , 2, clueNum);
           return clue;
       }
       return "0";
   }
   
   public static void oneLeft ()
   {
       //Columns
       for(int j=0; j<GRID; j++)
       {
           int counter=0, index = 0, sum =0;
           for(int x=0; x<GRID; x++)
           {
               if(puzzle[x][j] != 0)
               {
                   counter++;
                   sum += puzzle[x][j];
               }
               else
               {
                   index = x;
               }
           }
           if(counter == 3)
           {
               if(sum == 6)
               {
                   puzzle[index][j] = 4;
               }
               else if (sum == 7)
               {
                   puzzle[index][j] = 3;
               }
               else if (sum == 8)
               {
                   puzzle[index][j] = 2;
               }
               else if(sum == 9)
               {
                   puzzle[index][j] = 1;
               }
           }
       }
       
       //Rows
       for(int j=0; j<GRID; j++)
       {
           int counter=0, index = 0, sum =0;
           for(int x=0; x<GRID; x++)
           {
               if(puzzle[j][x] != 0)
               {
                   counter++;
                   sum += puzzle[j][x];
               }
               else
               {
                   index = x;
               }
           }
           if(counter == 3)
           {
               if(sum == 6)
               {
                   puzzle[j][index] = 4;
               }
               else if (sum == 7)
               {
                   puzzle[j][index] = 3;
               }
               else if (sum == 8)
               {
                   puzzle[j][index] = 2;
               }
               else if(sum == 9)
               {
                   puzzle[j][index] = 1;
               }
           }
       }
   }
   
   public static void twoLeft (String clueOne, String clueTwo, String clueThree, String clueFour, String topClue, String bottomClue)
   {
       //Columns
       for(int j=0; j<GRID; j++)
       {
           int counter=0;
           int check1 =0;
           String currentClue, index = "", column = "";
           int spotOne = 0, spotTwo = 0;
           for(int x=0; x<GRID; x++)
           {
               if(puzzle[x][j] != 0)
               {
                   counter++;
               }
               else
               {
                   index += x;
               }
               column += puzzle[x][j];
           }
           if(counter == 2)
           {
               currentClue = "" + topClue.charAt(j) + bottomClue.charAt(j);
               String option1 = "", option2 = "";
               
               for(int s=0; s<GRID; s++)
               {
                   option1 += puzzle[s][j];
                   option2 += puzzle[s][j];
               }
               //No 1's
               if(column.charAt(0) != '1' && column.charAt(1) != '1' && column.charAt(2) != '1' && column.charAt(3) != '1' ) 
               {    
                  if(check1 ==0)
                  {
                      spotOne = index.charAt(0);
                      spotTwo = index.charAt(1);
                  }
                  else
                  {
                      spotOne = index.charAt(1);
                      spotTwo = index.charAt(0);
                  }
                  if(spotOne == '0')
                  {
                      option1 = 1 + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '1' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '1' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '1';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = 1 + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '1' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '1' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '1';
                  }
                  check1++;
               }
               //No 2's
               if (column.charAt(0) != '2' && column.charAt(1) != '2' && column.charAt(2) != '2' && column.charAt(3) != '2' ) 
               {
                  if(check1 ==0)
                  {
                      spotOne = index.charAt(0);
                      spotTwo = index.charAt(1);
                  }
                  else
                  {
                      spotOne = index.charAt(1);
                      spotTwo = index.charAt(0);
                  }
                  if(spotOne == '0')
                  {
                      option1 = '2' + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '2' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '2' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '2';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = '2' + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '2' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '2' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '2';
                  }
                  check1++;
               }
               //No 3's
               if (column.charAt(0) != '3' && column.charAt(1) != '3' && column.charAt(2) != '3' && column.charAt(3) != '3' ) 
               {
                  if(check1 ==0)
                  {
                      spotOne = index.charAt(0);
                      spotTwo = index.charAt(1);
                  }
                  else
                  {
                      spotOne = index.charAt(1);
                      spotTwo = index.charAt(0);
                  }
                  if(spotOne == '0')
                  {
                      option1 = '3' + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '3' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '3' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '3';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = '3' + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '3' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '3' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '3';
                  }
                  check1++;
               }
               //No 4's
               if (column.charAt(0) != '4' && column.charAt(1) != '4' && column.charAt(2) != '4' && column.charAt(3) != '4' ) 
               {
                  if(check1 ==0)
                  {
                      spotOne = index.charAt(0);
                      spotTwo = index.charAt(1);
                  }
                  else
                  {
                      spotOne = index.charAt(1);
                      spotTwo = index.charAt(0);
                  }
                  if(spotOne == '0')
                  {
                      option1 = '4' + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '4' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '4' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '4';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = '4' + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '4' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '4' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '4';
                  }
                  check1++;
               }
               
               //option 1
               boolean bool = true;
               int nums = 1, checker =0, lastBig = Integer.parseInt("" +option1.charAt(0));
               while(bool)
               {
                   if(lastBig < Integer.parseInt(""+option1.charAt(nums)))
                   {
                       checker++;
                       lastBig = Integer.parseInt(""+option1.charAt(nums));
                   }
                   if(nums == option1.length()-1)
                   {
                       bool = false;
                   }
                   nums++;
               } //checker is 1
               
               boolean bool2 = true;
               int nums2 = 2, checker2 =0, lastBig2 = Integer.parseInt("" +option1.charAt(3));
               while(bool2)
               {
                   if(lastBig2 < Integer.parseInt(""+option1.charAt(nums2)))
                   {
                       checker2++;
                       lastBig2 = Integer.parseInt(""+option1.charAt(nums2));
                   }
                   if(nums2 == 0)
                   {
                       bool2 = false;
                   }
                   nums2--;
               }//0 = checker2
               
               if((checker == Integer.parseInt("" + currentClue.charAt(0))-1) && (checker2 == Integer.parseInt("" + currentClue.charAt(1))-1))
               {
                   for(int s=0; s<GRID; s++)
                   {
                       puzzle[s][j] = Integer.parseInt("" +option1.charAt(s));
                   }
                   break;
               }
               
               //option2
               boolean bool3 = true;
               int nums3 = 1, checker3 =0, lastBig3 = Integer.parseInt("" +option2.charAt(0));
               while(bool3)
               {
                   if(lastBig3 < Integer.parseInt(""+option2.charAt(nums3)))
                   {
                       checker3++;
                       lastBig3 = Integer.parseInt(""+option2.charAt(nums3));
                   }
                   if(nums3 == option2.length()-1)
                   {
                       bool3 = false;
                   }
                   nums3++;
               } //checker is 1
               
               boolean bool4 = true;
               int nums4 = 2, checker4 =0, lastBig4 = Integer.parseInt("" +option2.charAt(3));
               while(bool4)
               {
                   if(lastBig4 < Integer.parseInt(""+option2.charAt(nums4)))
                   {
                       checker4++;
                       lastBig4 = Integer.parseInt(""+option2.charAt(nums4));
                   }
                   if(nums4 == 0)
                   {
                       bool4 = false;
                   }
                   nums4--;
               }//0 = checker2
               
               if((checker3 == Integer.parseInt("" + currentClue.charAt(0))-1) && (checker4 == Integer.parseInt("" + currentClue.charAt(1))-1))
               {
                   for(int s=0; s<GRID; s++)
                   {
                       puzzle[s][j] = Integer.parseInt("" +option2.charAt(s));
                   }
                   break;
               }
               
           }
           
       }
       
       //Rows
       for(int j=0; j<GRID; j++)
       {
           int counter=0;
           String currentClue, index = "", column = "";
           for(int x=0; x<GRID; x++)
           {
               if(puzzle[j][x] != 0)
               {
                   counter++;
               }
               else
               {
                   index += x;
               }
               column += puzzle[x][j];
           }
           if(counter == 2)
           {
               currentClue = "";
               if(j==0)
               { 
                   currentClue = "" + clueOne;
               }
               if(j==1)
               {
                   currentClue = "" + clueTwo;
               }
               if(j==2)
               {
                   currentClue = "" + clueThree;
               }
               if(j==3)
               {
                   currentClue = "" + clueFour;
               }
               String option1 = "", option2 = "";
               
               for(int s=0; s<GRID; s++)
               {
                   option1 += puzzle[j][s];
                   option2 += puzzle[j][s];
               }
               //No 1's
               if(column.charAt(0) != '1' && column.charAt(1) != '1' && column.charAt(2) != '1' && column.charAt(3) != '1' ) 
               {    
                  int spotOne = index.charAt(0);
                  int spotTwo = index.charAt(1);
                  if(spotOne == '0')
                  {
                      option1 = 1 + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '1' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '1' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '1';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = 1 + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '1' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '1' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '1';
                  }
               }
               //No 2's
               if (column.charAt(0) != '2' && column.charAt(1) != '2' && column.charAt(2) != '2' && column.charAt(3) != '2' ) 
               {
                  int spotOne = index.charAt(0);
                  int spotTwo = index.charAt(1);
                  if(spotOne == '0')
                  {
                      option1 = '2' + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '2' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '2' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '2';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = '2' + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '2' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '2' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '2';
                  }
               }
               //No 3's
               if (column.charAt(0) != '3' && column.charAt(1) != '3' && column.charAt(2) != '3' && column.charAt(3) != '3' ) 
               {
                  int spotOne = index.charAt(0);
                  int spotTwo = index.charAt(1);
                  if(spotOne == '0')
                  {
                      option1 = '3' + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '3' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '3' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '3';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = '3' + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '3' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '3' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '3';
                  }
               }
               //No 4's
               if (column.charAt(0) != '4' && column.charAt(1) != '4' && column.charAt(2) != '4' && column.charAt(3) != '4' ) 
               {
                  int spotOne = index.charAt(0);
                  int spotTwo = index.charAt(1);
                  if(spotOne == '0')
                  {
                      option1 = '4' + option1.substring(1);
                  }
                  if(spotOne == '1')
                  {
                      option1 = option1.substring(0,1) + '4' + option1.substring(2,4);
                  }
                  if(spotOne == '2')
                  {
                      option1 = option1.substring(0,2) + '4' + option1.substring(3,4);
                  }
                  if(spotOne == '3')
                  {
                      option1 = option1.substring(0,3) + '4';
                  }
                  if(spotTwo == '0')
                  {
                      option2 = '4' + option2.substring(1);
                  }
                  if(spotTwo == '1')
                  {
                      option2 = option2.substring(0,1) + '4' + option2.substring(2, 4);
                  }
                  if(spotTwo == '2')
                  {
                      option2 = option2.substring(0,2) + '4' + option2.substring(3,4);
                  }
                  if(spotTwo == '3')
                  {
                      option2 = option2.substring(0,3)+ '4';
                  }
               }
               
               //option 1
               boolean bool = true;
               int nums = 1, checker =0, lastBig = Integer.parseInt("" +option1.charAt(0));
               while(bool)
               {
                   if(lastBig < Integer.parseInt(""+option1.charAt(nums)))
                   {
                       checker++;
                       lastBig = Integer.parseInt(""+option1.charAt(nums));
                   }
                   if(nums == option1.length()-1)
                   {
                       bool = false;
                   }
                   nums++;
               } //checker is 1
               
               boolean bool2 = true;
               int nums2 = 2, checker2 =0, lastBig2 = Integer.parseInt("" +option1.charAt(3));
               while(bool2)
               {
                   if(lastBig2 < Integer.parseInt(""+option1.charAt(nums2)))
                   {
                       checker2++;
                       lastBig2 = Integer.parseInt(""+option1.charAt(nums2));
                   }
                   if(nums2 == 0)
                   {
                       bool2 = false;
                   }
                   nums2--;
               }//0 = checker2
               
               if((checker == Integer.parseInt("" + currentClue.charAt(0))-1) && (checker2 == Integer.parseInt("" + currentClue.charAt(1))-1))
               {
                   for(int s=0; s<GRID; s++)
                   {
                       puzzle[j][s] = Integer.parseInt("" +option1.charAt(s));
                   }
               }
               
               //option2
               boolean bool3 = true;
               int nums3 = 1, checker3 =0, lastBig3 = Integer.parseInt("" +option2.charAt(0));
               while(bool3)
               {
                   if(lastBig3 < Integer.parseInt(""+option2.charAt(nums3)))
                   {
                       checker3++;
                       lastBig3 = Integer.parseInt(""+option2.charAt(nums3));
                   }
                   if(nums3 == option2.length()-1)
                   {
                       bool3 = false;
                   }
                   nums3++;
               } //checker is 1
               
               boolean bool4 = true;
               int nums4 = 2, checker4 =0, lastBig4 = Integer.parseInt("" +option2.charAt(3));
               while(bool4)
               {
                   if(lastBig4 < Integer.parseInt(""+option2.charAt(nums4)))
                   {
                       checker4++;
                       lastBig4 = Integer.parseInt(""+option2.charAt(nums4));
                   }
                   if(nums4 == 0)
                   {
                       bool4 = false;
                   }
                   nums4--;
               }//0 = checker2
               
               if((checker3 == Integer.parseInt("" + currentClue.charAt(0))-1) && (checker4 == Integer.parseInt("" + currentClue.charAt(1))-1))
               {
                   for(int s=0; s<GRID; s++)
                   {
                       puzzle[j][s] = Integer.parseInt("" +option2.charAt(s));
                   }
               }
           }
       }
   }
}