//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(n, inorder, postorder);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/

class GfG {
    public static Node buildTreeHelper(int post[],int postStart,int postEnd,int in[],int inStart,int inEnd){
        if(postStart>postEnd || inStart>inEnd){
            return null;
        }
        int rootval = post[postStart];
        Node root  = new Node (rootval);
        
        int k = 0;
        for(int i = inStart;i<inEnd;i++){
            if(rootval==in[i]){
                k = i;
                break;
            }
        }
        root.left = buildTreeHelper(post,postStart,postStart+k-inStart-1,in,inStart,k-1);
        root.right = buildTreeHelper(post,postStart+k-inStart,postEnd-1,in,k+1,inEnd);
        return root;
    }
        Node find(int[]in,int post[],int left,int right,ArrayList<Integer> list){
        if(list.get(0) == -1 || left > right)return null;
        int mid = 0;
        for(int i = left ; i <= right ; i++){
            if(in[i] == post[list.get(0)]){
                mid = i;
                break;
            }
        }
        int t = list.get(0);
        list.remove(0);
        list.add(t-1);
        Node rootN = new Node(in[mid]);
        rootN.right = find(in,post,mid+1,right,list);
        rootN.left = find(in,post,left,mid-1,list);
        return rootN;
    }
    // Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int n, int in[], int post[]) {
        // Your code here
        
        //   int postStart = 0;
        //   int postEnd = n-1;
        //   int inStart = 0;
        //   int inEnd = n-1;
        //   return buildTreeHelper(post,postStart,postEnd,in,inStart,inEnd);
          
         ArrayList<Integer> list = new ArrayList<>();
        list.add(n-1);
        return find(in,post,0,n-1,list);
    }
}
