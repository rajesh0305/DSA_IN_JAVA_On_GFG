//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline character after the integer input

        while (T-- > 0) {
            Node head1 = null, tail1 = null;
            Node head2 = null, tail2 = null;

            // Reading input for the first linked list
            String input1 = sc.nextLine();
            String[] elems1 = input1.split(" ");
            for (String elem : elems1) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head1 == null) {
                    head1 = newNode;
                    tail1 = newNode;
                } else {
                    tail1.next = newNode;
                    tail1 = newNode;
                }
            }

            // Reading input for the second linked list
            String input2 = sc.nextLine();
            String[] elems2 = input2.split(" ");
            for (String elem : elems2) {
                Node newNode = new Node(Integer.parseInt(elem));
                if (head2 == null) {
                    head2 = newNode;
                    tail2 = newNode;
                } else {
                    tail2.next = newNode;
                    tail2 = newNode;
                }
            }

            int x = sc.nextInt();
            sc.nextLine(); // Consume the newline character after the integer input

            Solution obj = new Solution();
            int count = obj.countPairs(head1, head2, x);
            System.out.println(count);
        }
        sc.close();
    }
}

// } Driver Code Ends


// your task is to complete this function

/*class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Pairs{
    int first;
    int second;
    Pairs(int first,int second){
        this.first = first;
        this.second=second;
        
    }
}
class Solution {
    // Function to count pairs in two linked lists whose sum is equal to x
    public int countPairs(Node head1, Node head2, int x) {
        // add your code here
    //   Set<Pairs> s = new HashSet<Pairs>(); 
    //     Node temp1 = head1; 
        
    //     while (temp1 != null) { 
    //         int ele = temp1.data; 
    //         Node temp2 = head2;  
    //         while (temp2 != null) { 
    //             if (temp2.data + ele == x) { 
    //                 s.add(new Pairs(temp2.data, ele)); 
    //             } 
    //             temp2 = temp2.next; 
    //         } 
    //         temp1 = temp1.next; 
    //     } 
        
    //     return s.size();
     if(head1==null || head2==null) return 0;
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        while(head1!=null){
            set.add(head1.data);
            head1=head1.next;
        }
        while (head2!=null){
            if(set.contains(x-head2.data))count++;
            head2=head2.next;
        }
        return count;
    }
}
