//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Solution obj = new Solution();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
    public static Node helper(Node head1,Node head2){
        Node t1=head1;
        Node t2=head2; 
        Node dummyhead = new Node(-1);
        Node current = dummyhead;
        while(t1 != null && t2!= null){
            if(t1.data<t2.data){
                t1=t1.next;
            } else if(t2.data<t1.data){
                t2=t2.next;
            }else{
                current.next = new Node(t1.data);
                current = current.next;
                 t1=t1.next;
                t2=t2.next;
            
            }
        }
        return dummyhead.next;
    }
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        // HashMap<Integer,Integer>hm = new HashMap<Integer,Integer>();
        // Node temp= head1;
        // while(temp!=null){
        //     if(!hm.containsKey(temp.data)){
        //         hm.put(temp.data,1);
        //         temp =temp.next;
        //     }else{
        //         hm.put(temp.data,hm.get(temp.data)+1);
        //         temp = temp.next;
        //     }
        // }
        // ArrayList<Integer>ans = new ArrayList<Integer>();
        // Node temp2= head2;
        // while(temp2!=null){
        //     if(hm.containsKey(temp2.data)){
        //         ans.add(temp2.data);
        //         temp2 = temp2.next;
        //     }
        // }
        // Node dummy = new Node(-1);
        // Node root = dummy;
        // for(int i = 0;i<ans.size();i++){
        //     Node newnode = new Node(ans.get(i));
        //     root.next = newnode;
        //     root = newnode;
        // }
        // return dummy.next;
        return helper(head1,head2);
    }
}