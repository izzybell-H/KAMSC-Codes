//NAME              :   Isabel Holtan
//GROUP             :   APCS
//LAST MODIFIED     :   21 May 2017
//PROBLEM ID        :   2007-2008 ACSL Senior Trees
//DESCRIPTION       :   Constructs a binary search tree and then calculates 
//                      the depth, number of internal and external nodes, 
//                      and the internal and external path length
//SOURCES/HELPERS   :   Mr. H., Lewis and Loftus

import java.util.Scanner;

//BSTNodes make up BST
class BSTNode
{
    //Instance data
    BSTNode left, right;
    int data;

    //Constructor for no known information
    public BSTNode()
    {
        left = null;
        right = null;
        data = 0;
    }

    //Constructor for when 'root' is known
    public BSTNode(int n)
    {
        left = null;
        right = null;
        data = n;
    }

    //Sets left node 
    public void setLeft(BSTNode n)
    {
        left = n;
    }

    //Sets right node
    public void setRight(BSTNode n)
    {
        right = n;
    }

    //Gets left node
    public BSTNode getLeft()
    {
        return left;
    }

    //Gets right node
    public BSTNode getRight()
    {
        return right;
    }

    //Sets data in node
    public void setData(int d)
    {
        data = d;
    }
    
    //Gets the data in this node
    public int getData()
    {
        return data;
    }     
}

//BinarySearchTree Class BST
class BST
{
    private BSTNode root;

    //Constructor
    public BST()
    {
        root = null;
    }

    //Inserts data using recusion
    public void insert(int data)
    {
        root = insert(root, data);
    }
    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null)
        {
            node = new BSTNode(data);
            
        }
        else
        {
            if (data <= node.getData())
            {
                node.left = insert(node.left, data);
            }
            else
            {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }
    
    // Prints  reverse row order for a tree
    public void reverseLevelOrder()
    {
        reverseLevelOrder(root);
    }
    public void reverseLevelOrder(BSTNode node) 
    {
        int h = maxDepth(node);
        for (int i = h; i >= 1; i--) 
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
        {
            printGivenLevel(node, i);
        }
    }
    //Prints nodes at a given level
    public void printGivenLevel(BSTNode node, int level) 
    {
        if (node == null)
        {
            return;
        }
        if (level == 1)
        {
            System.out.print((char)node.getData() + " ");
        }
        else if (level > 1) 
        {
            printGivenLevel(node.getLeft(), level - 1);
            printGivenLevel(node.getRight(), level - 1);
        }
    }
    
    //Finds the depth of the binary search tree
    public int maxDepth()
    {
        return maxDepth(root)-1;
    }
    public int maxDepth(BSTNode node) 
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            //compute the depth of each subtree (right, left)
            int leftDepth = maxDepth(node.getLeft());
            int rightDepth = maxDepth(node.getRight());
  
            //Uses the larger one
            if (leftDepth > rightDepth)
            {
                return (leftDepth + 1); 
            }
            else
            {
                return (rightDepth + 1);
            }
        }
    }
}

public class SeniorTrees20072008
{
    public static void main(String[] args)
    { 
        //Signature
        System.out.println("Isabel Holtan\nSenior\nACSL Trees 2007 2008\n");
        //Decalares variables
        Scanner scan = new Scanner(System.in);
      
        //Generates Tree from string by converting to integers
        for(int j=0; j<5; j++)
        { 
            BST bst = new BST(); 
            System.out.print("Input String:  ");
            String choice = scan.next();            
            for(int k=0; k<choice.length(); k++)
            {
                char current = choice.charAt(k);
                int ACSLLValue = current;
                bst.insert(ACSLLValue);                     
            }

            //Outputs the reverse row order
            bst.reverseLevelOrder();
            System.out.println();
            System.out.println();
        }              
    }
}