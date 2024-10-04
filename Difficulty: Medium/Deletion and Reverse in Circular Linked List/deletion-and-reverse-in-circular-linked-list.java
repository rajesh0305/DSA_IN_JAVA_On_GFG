//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // code here
        // ArrayList<Integer>ans = new ArrayList<Integer>();
        // Node temp =head;
        // while(temp!=null){
        //     int data = temp.data;
        //     ans.add(data);
        //     temp = temp.next;
        // }
        // Node dummy =new Node(0);
        // Node ref = dummy;
        // for(int i =ans.size()-1;i>=0;i--){
        //     int data = ans.get(i);
        //     Node newnode =new Node(data);
        //     ref.next = newnode;
        //     ref =ref.next;
        // }
        // return dummy.next;
        // if list is empty
    Node head_ref =head;
        if (head_ref == null)
            return null;
 
        // reverse procedure same as reversing a
        // singly linked list
        Node prev = null;
        Node current = head_ref;
        Node next;
        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != (head_ref));
        (head_ref).next = prev;
        head_ref = prev;
        return head_ref;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        // code here
//         Node temp1 =head.next;
//         Node temp2 =head;
//         while(temp1!=null){
//             if(temp1.data==key){
//                 temp2.next =temp1.next;
//                 break;
//             }
//             temp1 =temp1.next;
//             temp2 = temp2.next;
//         }
//             Node curr = head;
//         do {
//             if (curr.next.data == key) {
//                 curr.next = curr.next.next;
//                 break;
//             }
//             curr = curr.next;
//         } while (curr != head);
//         return head;
    
//   return head;
 if (head == null || (head.next == head && head.data == key)) return null;
        if (head.data == key) {
            Node temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = head.next;
            return head.next;
        }
        Node curr = head;
        do {
            if (curr.next.data == key) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        } while (curr != head);
        return head;
    }
}