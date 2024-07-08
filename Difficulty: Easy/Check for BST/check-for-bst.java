//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            if (g.isBST(root))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   public static ArrayList<Integer> inorderTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.data);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
   }
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
    //   if(root==null){
    //       return true;
    //   }
    //   if(root.left!=null && root.left.data>=root.data){
    //       return false;
    //   }
    //   if(root.right!=null && root.right.data<=root.data){
    //       return false;
    //   }
    
    // return ((isBST(root.left))&&(isBST(root.right)));
      if (root == null) {
            return true; 
        }
        ArrayList<Integer> inorder = inorderTraversal(root);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }

   return true;

    }
}
