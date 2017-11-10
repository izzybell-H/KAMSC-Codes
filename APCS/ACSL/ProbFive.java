//Maddie Hinkley, Autumn Guffey, Isabel Holtan, Alex Vonhof, Sabrina Welch
//ACSL 2008
//Program #5 Bin Packing
 
import java.util.*;
import java.io.*;

public class ProbFive
{
    public static void main (String[] args)
    {
        System.out.print("Maddie Hinkley, Autumn Guffey, Isabel Holtan, Alex Vonhof, Sabrina Welch\nACSL \nProblem 5: Bin Packing\n");

        Scanner scan = new Scanner(System.in);

        int[] weights1 = new int[100];
        for(int j = 0; j < 2; j++)
        {
            int z=0;
            int checker=0;
            int counter=0;
            int binCounter=0;
            System.out.print("\n\nInput the weights separated by spaces: ");
            do
            {
                checker = scan.nextInt();   
                if(checker != 0)
                {
                    weights1[z] = checker;
                }
                z++;
                counter++; 
            } while(checker != 0);
            int[] weights = new int[counter];
            for(int d=0; d < counter; d++)
            {
                weights[d] = weights1[d]; 
            }
            int[] bins = new int[counter];

            for(int d=0; d < counter; d++)
            {
                bins[d] =0; 
            }

            for(int i=0; i < counter; i++)
            {
                for(int d=0; d < counter; d++)
                {
                    if (weights[i] + bins[d] <= 10)
                    {
                        bins[d] += weights[i]; 
                        break;
                    }
                }
            }        
            int f=0;
            System.out.print("\n1. ");
            while(bins[f] != 0)
            {
                System.out.print(bins[f] + " ");
                f++;
            }
            for(int d=0; d < counter; d++)
            {
                bins[d] =0; 
            }

            Arrays.sort(weights);
            for(int i=0; i < counter; i++)
            {
                for(int d=0; d < counter; d++)
                {
                    if (weights[i] + bins[d] <= 10)
                    {
                        bins[d] += weights[i]; 
                        break;
                    }
                }
            }        
            f=0;
            System.out.print("\n2. ");
            while(bins[f] != 0)
            {
                System.out.print(bins[f] + " ");
                f++;
            }
            for(int d=0; d < counter; d++)
            {
                bins[d] = 0; 
            }

            int[] revWeights = new int[counter];
            int l = 0;
            for(int k=counter - 1; k > 0; k--)
            {
                revWeights[l] = weights[k];
                l++;   
            }

            for(int i=0; i < counter ; i++)
            {
                for(int d=0; d < counter; d++)
                {
                    if (revWeights[i] + bins[d] <= 10)
                    {
                        bins[d] += revWeights[i]; 
                        break;
                    }
                }
            }        
            f=0;
            System.out.print("\n3. ");
            while(bins[f] != 0)
            {
                System.out.print(bins[f] + " ");
                f++;
            }

            int[] weights2 = new int[counter];
            for(int d=0; d < counter; d++)
            {
                weights2[d] = weights1[d]; 
            }

            for(int d=0; d < counter; d++)
            {
                bins[d] =0; 
            }

            for(int i=0; i < counter; i++)
            {
                for(int d=0; d < counter; d++)
                {
                    if (weights2[i] + bins[d] <= 10)
                    {
                        bins[d] += weights2[i]; 
                        break;
                    }
                }
            }        
            f=0;
            System.out.print("\n4. ");
            while(bins[f] != 0)
            {
                System.out.print(bins[f] + " ");
                f++;
            }
            for(int d=0; d < counter; d++)
            {
                bins[d] =0; 
            }

            for(int i=0; i < counter; i++)
            {
                for(int d=0; d < counter; d++)
                {
                    if (weights2[i] + bins[d] <= 10)
                    {
                        bins[d] += weights2[i]; 
                        break;
                    }
                }
            }        
            f=0;
            System.out.print("\n5. ");
            while(bins[f] != 0)
            {
                System.out.print(bins[f] + " ");
                f++;
            }
        }   
    }    
}