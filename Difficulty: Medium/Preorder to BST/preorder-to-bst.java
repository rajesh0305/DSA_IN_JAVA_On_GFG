//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution obj = new Solution();
            Node res = obj.Bst(arr, n);
            printPostorder(res);
            System.out.println();
        }
    }

    
// } Driver Code Ends
// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

static class Solution {
      public static  Node bst(int pre[], int bound, int[]i){
        if (i[0] == pre.length || pre[i[0]] > bound) {
            return null;
        }
        Node root = new Node(pre[i[0]++]);
        root.left = bst(pre, root.data, i);
        root.right = bst(pre, bound, i);
        return root;
      }
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        // int prenew[] = new int [pre.length];
        // int inorder[] =new int [pre.length];
        // for(int i = 0;<pre.length;i++){
        //     prenew[i]=  pre[i];
        // }
        // Arrays.sort(pre);
        // for(int i = 0;i<pre.length;i++){
        //     inorder[i] = pre[i];
        // }
       return bst(pre, Integer.MAX_VALUE, new int[]{0});
        
        
    }
}

//{ Driver Code Starts.

    public static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
// } Driver Code Ends