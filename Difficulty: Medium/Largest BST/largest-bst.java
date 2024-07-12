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


class Solution{
        static class Info {
        public int maxi;
        public int mini;
        public boolean isBST;
        public int size;
        
        public Info(int maxi, int mini, boolean isBST, int size) {
            this.maxi = maxi;
            this.mini = mini;
            this.isBST = isBST;
            this.size = size;
        }
             public Info() {
            this.maxi = Integer.MIN_VALUE;
            this.mini = Integer.MAX_VALUE;
            this.isBST = true;
            this.size = 0;
        }
        }
        private static Info solve(Node root, int[] ans) {
        if(root == null) {
            return new Info();
        }
        
        Info left = solve(root.left, ans);
        Info right = solve(root.right, ans);
        
        int mini = Math.min(root.data, Math.min(left.mini, right.mini));
        int maxi = Math.max(root.data, Math.max(left.maxi, right.maxi));
        
        boolean isBST = (left.isBST && right.isBST && root.data > left.maxi && root.data < right.mini);
        
        int size = isBST ? left.size + right.size + 1 : 0;
        
        ans[0] = Math.max(ans[0], size);
        
        return new Info(maxi, mini, isBST, size);
    }
    // Return the size of the largest sub-tree which is also a BST
    // public static int findHeight(Node root){
    //     if(root==null){
    //         return 0;
    //     }
    //     if(root.left==null && root.right==null)return 1;
    //     return (1+Math.max(findHeight(root.left),findHeight(root.right)));
    // }
    // public static boolean isBST(Node root,int min,int max){
    //     if(root==null){
    //         return true;
    //     }
    //     if(root.data>min || root.data<max){
    //         return false;
    //     }else
    //     return (isBST(root.right,root.data+1,max)&&isBST(root.left,min,root.data-1));
    // }
    static int largestBst(Node root)
    {
        // Write your code here
        
        // if(root==null){
        //     return 0;
        // }
        // if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
        //     return findHeight(root);
        //     else
        //         return Math.max(largestBst(root.left),largestBst(root.right));
        if (root == null) return 0;
        
        int[] maxSize = new int[1];
        solve(root, maxSize);
        return maxSize[0];    
    }
    
}