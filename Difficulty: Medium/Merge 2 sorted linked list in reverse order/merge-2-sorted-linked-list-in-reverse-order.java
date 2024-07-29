//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    public static Node Createlist(ArrayList<Integer>ans){
        Collections.sort(ans);
        Node dummy = new Node(-1);
       Node head  = dummy;
        for(int i =ans.size()-1;i>=0;i--){
           Node newnode = new Node(ans.get(i));
           head.next = newnode;
           head = head.next;
        }
        return dummy.next;
    }
    Node mergeResult(Node node1, Node node2)
    {
	// Your code here
	ArrayList<Integer>alldata = new ArrayList<Integer>();
	Node temp1 = node1;
	Node temp2 = node2;
	while(temp1!=null){
	    alldata.add(temp1.data);
	    temp1 = temp1.next;
	}
	while(temp2!=null){
	    alldata.add(temp2.data);
	    temp2 = temp2.next;
	}
    return Createlist(alldata);
	
    }
}
