//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class LeafNodes
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            Node root = null;
            while(n-- > 0)
            {
                	int n1 = sc.nextInt();
                int n2 = sc.nextInt();
	        	char lr= sc.next().charAt(0);
				
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
            }
            
            GfG gfg = new GfG();
            System.out.println(gfg.SumofLeafNodes(root));
        }
    }
}
// } Driver Code Ends


class GfG
{
       public void postOrder(Node root, ArrayList<Integer> al){
        if(root == null)
            return;
        postOrder(root.left, al);
        postOrder(root.right, al);
        if(root.left == null && root.right == null)
            al.add(root.data);
    }
    public int SumofLeafNodes(Node root)
    {
        // your code here
                ArrayList<Integer> al = new ArrayList<Integer>();
        postOrder(root, al);
        int sum = 0;
        for(Integer a : al)
            sum+=a;
        return sum;
    }
}