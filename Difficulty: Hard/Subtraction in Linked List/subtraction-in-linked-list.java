//{ Driver Code Starts
import java.util.Scanner;
import java.math.*;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/
// import java.util.Collections;
class Solution {
 
    public Node subLinkedList(Node head1, Node head2) {
        // code here
    //     StringBuilder num1 = new StringBuilder();
    //     Node current1 = head1;
    //     while (current1 != null) {
    //         num1.append(current1.data);
    //         current1 = current1.next;
    //     }
        
    //   StringBuilder num2 = new StringBuilder();
    //     Node current2 = head2;
    //     while (current2 != null) {
    //         num2.append(current2.data);
    //         current2 = current2.next;
    //     }
        
    //     BigInteger bigIntNum1 = new BigInteger(num1.toString());
    //     BigInteger bigIntNum2 = new BigInteger(num2.toString());
        
    //     BigInteger result = bigIntNum1.subtract(bigIntNum2).abs();
    
    //     String resultStr = result.toString();
    //     Node resultHead = new Node(Character.getNumericValue(resultStr.charAt(0)));
    //     Node currentResult = resultHead;

    //     for (int i = 1; i < resultStr.length(); i++) {
    //         currentResult.next = new Node(Character.getNumericValue(resultStr.charAt(i)));
    //         currentResult = currentResult.next;
    //     }

    //     return resultHead;
    
        Node h1 = head1;
        Node h2 = head2;
        Node hh1 = head1;
        Node hh2 = head2;
        while(h1 != null && h1.data == 0){
            hh1 = h1;
            h1 = h1.next;
        }
        while(h2 != null && h2.data == 0){
            hh2 = h2;
            h2 = h2.next;
        }
        if(hh1.data == 0 && h1 == null && hh2.data == 0 && h2 == null){
            return new Node(0);
        }
        head1 = h1;
        head2 = h2;
        Node hl1 = head1;
        Node hl2 = head2;
        int count1 = 0;
        int count2 = 0;
        while(hl1 != null){
            hl1 = hl1.next;
            count1++;
        }
        while(hl2 != null){
            hl2 = hl2.next;
            count2++;
        }
        if(count1 < count2){
            Node head1c = head1;
            head1 = head2;
            head2 = head1c;
        } else if(count1 == count2){
            Node ch1 = head1;
            Node ch2 = head2;
            
            while(ch1 != null && ch1.data == ch2.data){
                ch1 = ch1.next;
                ch2 = ch2.next;
            }
            if(ch1 != null && ch1.data < ch2.data){
                Node head1c = head1;
                head1 = head2;
                head2 = head1c;
            }
        }
        Node ans = new Node(0);
        Node ac = ans;
        boolean flag = false;
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node h1c = head1;
        Node h2c = head2;
        while(h1c != null && h2c != null){
            if(!flag){
                int dig1 = h1c.data;
                int dig2 = h2c.data;
                if(dig1 > dig2){
                    int dig = dig1 - dig2;
                    Node node = new Node(dig);
                    ac.next = node;
                    ac = ac.next;
                } else if(dig1 < dig2){
                    flag = true;
                    dig1 = 10 + dig1;
                    int dig = dig1 - dig2;
                    Node node = new Node(dig);
                    ac.next = node;
                    ac = ac.next;
                } else{
                    int dig = 0;
                    Node node = new Node(0);
                    ac.next = node;
                    ac = ac.next;
                }
            } else{
                int dig1 = h1c.data;
                int dig2 = h2c.data + 1;
                if(dig1 > dig2){
                    flag = false;
                    int dig = dig1 - dig2;
                    Node node = new Node(dig);
                    ac.next = node;
                    ac = ac.next;
                } else if(dig1 < dig2){
                    flag = true;
                    dig1 = 10 + dig1;
                    int dig = dig1 - dig2;
                    Node node = new Node(dig);
                    ac.next = node;
                    ac = ac.next;
                } else{
                    flag = false;
                    int dig = 0;
                    Node node = new Node(0);
                    ac.next = node;
                    ac = ac.next;
                }
            }

            h1c = h1c.next;
            h2c = h2c.next;
        }
        while(h1c != null){
            if(flag){
               int dig1 = h1c.data - 1;
               if(dig1 < 0){
                   dig1 += 10;
               } else{
                   flag = false;
               }
               Node node = new Node(dig1);
               ac.next = node;
               ac = ac.next;
            } else{
                int dig1 = h1c.data;
                Node node = new Node(dig1);
                ac.next = node;
                ac = ac.next;
            }
            h1c = h1c.next;
        }
        ans = ans.next;
        ans = reverse(ans);
        while(ans != null && ans.data == 0){
            ans = ans.next;
        }
        if(ans == null){
            return new Node(0);
        }
        return ans;
    }
    public Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node rh = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rh;
    }
}
        
