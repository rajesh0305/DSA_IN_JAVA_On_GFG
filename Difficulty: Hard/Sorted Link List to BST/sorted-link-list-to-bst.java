//{ Driver Code Starts
import java.util.*;

class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}


class ListToBST
{
    
  /* Function to print linked list */
   public static void preOrder(TNode root)
    {
        
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			LNode head = new LNode(sc.nextInt());
            LNode tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new LNode(sc.nextInt());
                tail = tail.next;
            }
		
			Solution obj = new Solution();
			TNode root = obj.sortedListToBST(head);
			preOrder(root);
			
			System.out.println();
			
			t--;
			
         }
    }
}

// } Driver Code Ends


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
//     // public static LNode findMidNode(LNode head){
//     //     LNode slow = head;
//     //     LNode fast = head;
//     //     while(fast.next!=null && fast.next.next!=null){
//     //         slow = slow.next;
//     //         fast = fast.next.next;
//     //     }
//     //     return slow;
//     // }
//     public static int Count(LNode head){
//         // if(head==null)return 0;
//         // return 1+Count(head.next);
//         int count = 0;
//         LNode temp = head;
//         while (temp != null)
//         {
//             temp = temp.next;
//             count++;
//         }
//         return count;
//     }
//     // public static TNode Help(LNode head,int n){
//     //     if(n==0)return null;
//     //     TNode left = Help(head,n/2);
//     //     TNode root = new TNode(head.data);
//     //     root.left = left;
//     //     head = head.next;
//     //     root.right = Help(head,n/2-1);
//     //     return root;
//     // }
//     public TNode sortedListToBST(LNode head)
//     {
//         //code here
//         //Step1 firstly counting the number of element/node 
//         //present in the linked list
        
//         //Step2 Call the help function to build the binary search tree
//         int n = Count(head);
//         return sortedListToBSTRecur(n);
        
//  TNode sortedListToBSTRecur(int n) 
//     {
//         /* Base Case */
//         if (n <= 0) 
//             return null;
 
//         /* Recursively construct the left subtree */
//         TNode left = sortedListToBSTRecur(n / 2);
 
//         /* head_ref now refers to middle node, 
//           make middle node as root of BST*/
//         TNode root = new TNode(head.data);
 
//         // Set pointer to left subtree
//         root.left = left;
 
//         /* Change head pointer of Linked List for parent 
//           recursive calls */
//         head = head.next;
 
//         /* Recursively construct the right subtree and link it 
//           with root. The number of nodes in right subtree  is 
//           total nodes - nodes in left subtree - 1 (for root) */
//         root.right = sortedListToBSTRecur(n - n / 2 - 1);
 
//         return root;

 static void preOrder(TNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }
 
  static TNode sortedListToBSTRecur(List<Integer> vec, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    if ((end - start) % 2 != 0) {
      mid = mid + 1;
    }
    TNode root = new TNode(vec.get(mid));
    root.left = sortedListToBSTRecur(vec, start, mid - 1);
    root.right = sortedListToBSTRecur(vec, mid + 1, end);
    return root;
  }
 
  static TNode sortedListToBST(LNode head) {
    List<Integer> vec = new ArrayList<Integer>();
    LNode temp = head;
    while (temp != null) {
      vec.add(temp.data);
      temp = temp.next;
    }
    return sortedListToBSTRecur(vec, 0, vec.size() - 1);
  }
}