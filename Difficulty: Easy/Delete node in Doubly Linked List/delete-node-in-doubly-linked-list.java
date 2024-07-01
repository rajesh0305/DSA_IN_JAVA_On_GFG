//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = null;
            Node tail = head;

            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (head == null) {
                    head = new Node(temp);
                    tail = head;
                } else {
                    Node newNode = new Node(temp);
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
            }
            int x = sc.nextInt();

            Solution obj = new Solution();
            Node res = obj.deleteNode(head, x);

            Node.printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
    //   Node temp = head;
    //   int i =1;
    //   while(temp.next!=null && i!=x){
    //       temp = temp.next;
    //       i++;
    //   }
    //   if(temp.next==null){
    //       temp = temp.prev;
    //       temp.next = null;
    //   }else{
    //   Node t1 = temp.next;
    //   Node t2 = temp.prev;
    //   t2.next = t1;
    //   t1.prev =t2;
      
    // }
    //   return head;
    
    if(x==1){
        return head.next;
    }
    Node temp = head;
    while(x-2>0){
        temp = temp.next;
        x--;
    }
    temp.next = temp.next.next;
    if(temp.next!=null){
        temp.next.prev = temp;
    }
    return head;
    }
}
