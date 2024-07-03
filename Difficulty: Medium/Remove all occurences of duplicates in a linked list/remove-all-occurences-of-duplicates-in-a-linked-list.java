//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GFG {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            GFG llist = new GFG();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
   HashMap<Integer,Integer>map= new HashMap<Integer,Integer>();
   
//   Node temp =head;
//   while(temp!=null){
//       int key = temp.data;
//       if(map.containsKey(key)){
//           map.put(key,map.get(key)+1);
//           }else{
//               map.put(key,1);
//           }
//           temp = temp.next;
//   }
//      head = temp;
//      Node dummy =new Node (0);
//      Node res = dummy;
//      while(temp!=null){
//          if(map.get(temp.data)==1){
//              res.next =new Node(temp.data);
//              res =res.next;
//          }
//          temp =temp.next;
//      }
//      return res.next;

 Node t = head;
       // HashMap<Integer,Integer> map = new HashMap<>();
        Node dummy = new Node(0);
        Node res = dummy;
        // Step-1
        while(t!= null){
             // ternary operator, can be done by simple if else statement also.
             map.put(t.data, map.containsKey(t.data) ? map.get(t.data) + 1 : 1);        
            t=t.next;
        }
        // Step-2
       t = head;
        while (t != null) {
            if (map.get(t.data) == 1) {
                res.next = new Node(t.data);
                res = res.next;
            }
            t = t.next;
        }
        return dummy.next;
    }
}