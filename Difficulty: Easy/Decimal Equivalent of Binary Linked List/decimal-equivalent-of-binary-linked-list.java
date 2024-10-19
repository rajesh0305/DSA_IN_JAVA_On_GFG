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

class LinkedList1 {
    Node head; // head of lisl

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;

            temp.next = node;
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

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;

            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            System.out.println(new Solution().DecimalValue(head));
            t--;
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
}
This is method only submission.  You only need to complete the method. */

class Solution {
    int mod = 100000007;  // Change mod to correct value 1000000007 if that's needed

    public static int findlen(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    long DecimalValue(Node head) {
        // int len = findlen(head) - 1;
        // long ans = 0;
        // Node temp = head;

        // while (temp != null) {
        //     int ele = temp.data;

        //     // Instead of Math.pow, use bitwise shift to calculate powers of 2
        //     ans = (ans + (ele * (1L << len)) % mod) % mod;  // Efficient modulo handling
        //     len = len - 1;
        //     temp = temp.next;
        // }

        // return ans % mod;
          long ans = 0;
       while(head != null)
       {
           ans = (ans * 2 + head.data) % 1000000007;
           head = head.next;
       }
       
       return (ans) % 1000000007;
    }
}
