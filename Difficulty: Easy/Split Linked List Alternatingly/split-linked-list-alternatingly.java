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
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    public static Node create(ArrayList<Integer>ans){
    Node dummy = new Node(-1); 
    Node temp = dummy;         
    for (int i = 0; i < ans.size(); i++) {
        int data = ans.get(i);     
        Node newnode = new Node(data); 
        temp.next = newnode;       
        temp = temp.next;          
    }
    
    return dummy.next;  
    }
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        Node ans[] = new Node [2];
        Node temp1 = head;
        Node temp2 = head.next;
        ArrayList<Integer>arr1 = new ArrayList<Integer>();
        ArrayList<Integer>arr2 = new ArrayList<Integer>();
        ArrayList<Integer>arr =new ArrayList<Integer>();
        //temp1!=null && temp2!=null &&
        // while((temp1.next!=null||temp1!=null) && (temp2.next!=null||temp2!=null)){
        //     int data1 = temp1.data;
        //     int data2 = temp2.data;
        //     arr1.add(data1);
        //     arr2.add(data2);
        //     temp1 = temp1.next.next;
        //     temp2 = temp2.next.next;
        // }
        // while(temp1!=null){
        //     int data1 = temp1.data;
        //     arr1.add(data1);
        //     temp1 =temp1.next;
        //     int data2 = temp1.data;
        //     arr2.add(data2);
        //     temp1 = temp1.next;
        while(temp1!=null){
            int data =temp1.data;
            arr.add(data);
            temp1 = temp1.next;
        }
      int i = 0;
      while(i<arr.size()){
          if(i%2==0){
              arr1.add(arr.get(i));
          }else{
              arr2.add(arr.get(i));
          }
          i = i+1;
      }
        Node head1 = create(arr1);
        Node head2 = create(arr2);
        ans[0] = head1;
        ans[1] = head2;
        return ans;
    }
}
