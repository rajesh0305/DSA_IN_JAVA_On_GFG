//{ Driver Code Starts
// driver

import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
      public static Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
    //     Node dummy = new Node(0);
    //     Node result = dummy;
    //     int c = 0;
       
    //     num1 = reverse(num1);
    //     num2= reverse(num2);
        
    //     // if(num1.next==null && num2==null){
    //     //     return num1;
    //     // }
    //     // if(num1==null && num2.next==null){
    //     //     return num2;
    //     // }
    // while(num1!=null || num2!=null || c == 1){
    //      int sum = 0;
    //           if(num1!=null){
    //               sum = sum+num1.data;
    //               num1 = num1.next;
    //           }
    //           if(num2!=null){
    //               sum = sum+num2.data;
    //               num2 = num2.next;
    //           }
    //           sum = sum+c;
    //           c = sum/10;
    //          Node newnode = new Node(sum%10);
    //          result.next =newnode;
    //          result = result.next;
    // }
    //   Node ans=reverse(result.next);
    //     while(ans.data==0 && ans.next!=null){
    //         ans=ans.next;
    //     }
    // return ans;
    Node l1=reverse(num1);
        Node l2=reverse(num2);
        
        Node temp=new Node(0);
        Node temp2=temp;
        
        int carry =0;
        int sum=0;
        while(l1!=null || l2!=null|| carry==1)
        {
            sum=0;
            if(l1!=null)
            {
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.data;
                l2=l2.next;       
            }
            sum+=carry;
            carry=sum/10;
            Node n=new Node(sum%10);
            temp2.next=n;
            temp2=temp2.next;
        }
        Node ans=reverse(temp.next);
        while(ans.data==0 && ans.next!=null){
            ans=ans.next;
        }
        return ans;
 }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node num1 = new Node(val);
            Node tail = num1;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node num2 = new Node(val);
            tail = num2;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends