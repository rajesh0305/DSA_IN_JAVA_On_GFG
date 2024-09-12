//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
class BT_To_DLL
{
    
    static Node buildTree(String str)throws IOException{
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    

	void inorder(Node node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
	}
	public static void printList(Node head) 
    {
		Node prev = head;
        while (head != null) 
        {
            System.out.print(head.data + " ");
			prev = head;
            head = head.right;
        }
		
		System.out.println();
		while(prev != null)
		{
			System.out.print(prev.data+" ");
			prev = prev.left;
		}
    }
	public static void main(String args[])  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			    
			    Node ans = g.bToDLL(root);
			    printList(ans);
                t--;
                System.out.println();
	        }
			
		
	}
}

// } Driver Code Ends


//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution
{
    public static int countNodes(Node root){
        int count = 0;
        countNodes(root.left);
        count++;
        countNodes(root.right);
        return count;
    }
    public static void getInorder(Node root,ArrayList<Integer>arr){
        Node temp = root;
        if(root==null){
            return ;
        }
        getInorder(temp.left,arr);
        arr.add(temp.data);
        getInorder(temp.right,arr);
    }
    public static void print(ArrayList<Integer>arr){
        for(int i = 0;i<arr.size();i++){
            System.out.print(arr.get(i));
        }
    }
    public static Node BuildDLL(ArrayList<Integer>arr){
        Node curr = new Node(arr.get(0));
         Node prev = curr;
        for(int i = 1;i<arr.size();i++){
            int ele = arr.get(i);
              Node newnode = new Node(ele); 
            prev.right =newnode;
            newnode.left = prev;
            prev = newnode;
        }
        return curr;
    }
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	   //  int n = countNodes(root);
	   //ArrayList<Integer>ans =new ArrayList<Integer>();
	   ////int ans[] = new int [n];
	   //getInorder(root,ans);
	   //Node head =BuildDLL(ans);
	   //return head;
	  ArrayList<Integer> list=inorder(root);
     Node cur=new Node(list.get(0));
     Node prev=cur;
 
    for(int i=1;i<list.size();i++) {
    Node newNode=new Node(list.get(i));
    prev.right=newNode;
    newNode.left=prev;
    prev=newNode;
}
 
return cur;
    }
    
    ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;
        
        list.addAll(inorder(root.left));
        list.add(root.data);
        list.addAll(inorder(root.right));
        
        return list;
    }
}