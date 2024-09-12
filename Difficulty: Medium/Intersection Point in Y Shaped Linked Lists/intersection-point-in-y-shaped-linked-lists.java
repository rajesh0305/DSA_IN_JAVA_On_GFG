//{ Driver Code Starts
import java.io.*;


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

class Solution {
    public static int count(Node head){
        Node temp =head;
        int c = 0;
        while(temp!=null){
            c++;
            temp = temp.next;
        }
        return c;
    }
    public static Node check(int d,Node head1,Node head2){
        Node temp = head1;
        for(int i = 0;i<d;i++){
            temp = temp.next;
        }
        Node temp2 = head2;
        while(temp!=temp2){
            temp = temp.next;
            temp2 = temp2.next;
        }
        return temp;
    }
    Node intersectPoint(Node head1, Node head2) {
        // code here
        // int n1=count(head1);
        // int n2 =count(head2);
        // int diff =0;
        // Node ans = null;
        // if(n1>n2){
        //     diff = n1-n2;
        //     ans =check(diff,head1,head2);
        // }else if(n2>n1){
        //     diff = n2-n1;
        //     ans =check(diff,head2,head1);
        // }
        // return ans;
                 Node temp1=head1;
         Node temp2=head2;
         int c1=0;
         int c2=0;
         while(temp1!=null){
             c1++;
             temp1=temp1.next;
         }
         temp1=head1;
         while(temp2!=null){
             c2++;
             temp2=temp2.next;
         }
         temp2=head2;
         int val=-1;
           if(c1>c2){
             int k=c1-c2;
             for(int i=1;i<=k;i++){
                 temp1=temp1.next;
             }
         }else{
             int k=c2-c1;
             for(int i=1;i<=k;i++){
                 temp2=temp2.next;
             }
         }
         while(temp1!=temp2){
             temp1=temp1.next;
             temp2=temp2.next;
         }
         //val=temp1.data;
         return temp1;
    }
}


//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String input1 = br.readLine().trim();
            String input2 = br.readLine().trim();
            String input3 = br.readLine().trim();

            Node head1 = buildLinkedList(input1);
            Node head2 = buildLinkedList(input2);
            Node head3 = buildLinkedList(input3);

            // Connect the common linked list to both head1 and head2
            if (head1 != null) {
                Node tail1 = head1;
                while (tail1.next != null) {
                    tail1 = tail1.next;
                }
                tail1.next = head3;
            }

            if (head2 != null) {
                Node tail2 = head2;
                while (tail2.next != null) {
                    tail2 = tail2.next;
                }
                tail2.next = head3;
            }

            Solution ob = new Solution();
            Node intersection = ob.intersectPoint(head1, head2);
            if (intersection != null) {
                System.out.println(intersection.data);
            } else {
                System.out.println(-1); // Print -1 if no intersection
            }
        }
    }

    public static Node buildLinkedList(String input) {
        if (input.isEmpty()) {
            return null;
        }

        String[] values = input.split(" ");
        Node head = null, tail = null;

        for (String value : values) {
            int data = Integer.parseInt(value.trim());
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }
}

// } Driver Code Ends