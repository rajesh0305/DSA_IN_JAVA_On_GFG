//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }
class nodeValue{
    public int maxvalue,minvalue,maxsize;
    
    nodeValue(int minvalue,int maxvalue,int maxsize){
        this.maxvalue  = maxvalue;
        this.minvalue = minvalue;
        this.maxsize = maxsize;
    }
};

class Solution{
    // public static nodeValue helper(Node root){
    //     if(root==null){
    //         return new nodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
    //     }
    //     nodeValue left = helper(root.left);
    //     nodeValue right = helper(root.right);
        
    //     if(left.maxvalue<root.data && right.minvalue>root.data){
    //         return new nodeValue(Math.min(root.data,left.minvalue),Math.max(root.data,roght.maxvalue),(left.maxsize+right.maxsize+1));
    //     }
    //     return new nodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxsize,right.maxsize));
    // }
     static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    static class nodeInfo {
        int size; // Size of subtree
        int max; // Min value in subtree
        int min; // Max value in subtree
        boolean isBST; // If subtree is BST

        nodeInfo() {}

        nodeInfo(int size, int max, int min, boolean isBST)
        {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    static nodeInfo largestBST(Node root)
    {

        // Base case : When the current subtree is empty or
        // the node corresponds to a null.
        if (root == null) {
            return new nodeInfo(0, Integer.MIN_VALUE,
                                Integer.MAX_VALUE, true);
        }
        // We will here do the postorder traversal since we
        // want our left and right subtrees to be computed
        // first.

        // Recur for left subtree and right subtrees
        nodeInfo left = largestBST(root.left);
        nodeInfo right = largestBST(root.right);

        // Create a new nodeInfo variable to store info
        // about the current node.
        nodeInfo returnInfo = new nodeInfo();

        returnInfo.min = Math.min(left.min, root.data);
        returnInfo.max = Math.max(right.max, root.data);
        returnInfo.isBST = left.isBST && right.isBST
                           && root.data > left.max
                           && root.data < right.min;

        /*
        If suppose the left and right subtrees of the
        current node are BST and the current node value is
        greater than the maximum value in the left subtree
        and also the current node value is smaller that the
        minimum value in the right subtree (Basic conditions
        for the formation of BST) then our whole subtree
        with the root as current root can be consider as a
        BST. Hence the size of the BST will become size of
        left BST subtree + size of right BST subtree +
        1(adding current node).

        Else we will consider the largest of the left BST or
        the  right BST.
        */

        /*We need to find maximum height BST subtree then
        adding the height of left an right subtree will not
        give the maximum height, we need to find max.
        */
        if (returnInfo.isBST)

            // Calculate the size of subtree if
            // this is a BST
            returnInfo.size = left.size + right.size + 1;
        else
            returnInfo.size
                = Math.max(left.size, right.size);

        return returnInfo;
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
    return largestBST(root).size;
    }
    
}