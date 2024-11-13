//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList_Intersection {
    Node head = null;
    Node tail = null;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            // Node temp = head;
            // while (temp.next != null)
            // temp = temp.next;

            // temp.next = node;
            tail.next = node;
            tail = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) throws IOException {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {

            LinkedList_Intersection llist1 = new LinkedList_Intersection();
            LinkedList_Intersection llist2 = new LinkedList_Intersection();
            LinkedList_Intersection llist3 = new LinkedList_Intersection();

            String str[] = read.readLine().trim().split(" ");
            int n1 = str.length;
            Node head1 = new Node(Integer.parseInt(str[0]));

            Node tail1 = head1;

            for (int i = 1; i < n1; i++) {
                int a = Integer.parseInt(str[i]);
                tail1.next = (new Node(a));
                tail1 = tail1.next;
            }

            str = read.readLine().trim().split(" ");
            Node head2 = new Node(Integer.parseInt(str[0]));
            Node tail2 = head2;
            int n2 = str.length;
            for (int i = 1; i < n2; i++) {
                int b = Integer.parseInt(str[i]);
                tail2.next = (new Node(b));
                tail2 = tail2.next;
            }

            str = read.readLine().trim().split(" ");
            int n3 = str.length;
            if (n3 > 0) {

                Node head3 = new Node(Integer.parseInt(str[0]));
                tail1.next = head3;
                tail2.next = head3;
                Node tail3 = head3;
                for (int i = 1; i < n3; i++) {
                    int c = Integer.parseInt(str[i]);
                    tail3.next = (new Node(c));
                    tail3 = tail3.next;
                }
            }
            Intersect obj = new Intersect();
            System.out.println(obj.intersectPoint(head1, head2));
            t--;
        
System.out.println("~");
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
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    public static int findlength(Node head){
        Node temp =head;
        int count = 0;
        while(temp!=null){
            count = count+1;
            temp = temp.next;
        }
        return count;
    }
    public static int optimal(Node h1,Node h2){
        int n1 = findlength(h1);
        int n2 = findlength(h2);
        int rem = 0;
        Node temp1 = h1;
        Node temp2 = h2;
        
        if(n1>n2){
            rem =Math.abs(n1-n2);
             while(rem>0){
                 temp1 =temp1.next;
                 rem--;
             }    
        }else{
            rem = Math.abs(n2-n1);
            while(rem>0){
                temp2 = temp2.next;
                rem--;
                
            }
        }
        while(temp1!=temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
    return temp1.data;
    }
    public static int better(Node head1,Node head2){
      ArrayList<Node>ans1 =new ArrayList<Node>();
        ArrayList<Node>ans2 = new ArrayList<Node>();
       Node temp= head1;
       Node temp1= head2;
       while(temp!=null){
           ans1.add(temp);
           temp= temp.next;
       }
      while(temp1!=null){
          ans2.add(temp1);
          temp1 = temp1.next;
      }
      for(int i = 0;i<ans1.size();i++){
          if(ans2.contains(ans1.get(i))){
              return (ans1.get(i)).data;
          }
      }
      return -1;   
    }
    int intersectPoint(Node head1, Node head2) {
        // code here
       return optimal(head1,head2);
    }
}
