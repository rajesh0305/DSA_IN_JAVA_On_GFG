//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Driverclass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }

    public static void printList(Node head, PrintWriter out) {
        if (head == null) return;

        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // public static void sort(ArrayList<Integer>arr){
    //     ArrayList<Integer>zero = new ArrayList<Integer>();
    //     ArrayList<Integer>one  = new ArrayList<Integer>();
    //     ArrayList<Integer>two = new ArrayList<Integer>();
    //     ArrayList<Integer>ans = new ArrayList<Integer>();
    //     for(int i = 0;i<arr.size();i++){
    //         if(arr.get(i)==0){
    //             zero.add(arr.get(i));
    //         }else if(arr.get(i)==1){
    //             one.add(arr.get(i));
    //         }else{
    //             two.add(arr.get(i));
    //         }
    //     }
    //     for(int i = 0;i<zero.size();i++){
    //         ans.add(zero.get(i));
    //     }
    //     for(int i = zero.size();i<zero.size()+one.size();i++){
    //         ans.add(one.get(i));
    //     }
    //     for(int i =zero.size()+one.size();i<zero.size()+one.size()+two.size();i++){
    //         ans.add(two.)
    //     }
    //     }
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
    //     // add your code here
    //     ArrayList<Integer>arr = new ArrayList<Integer>();
    //     Node temp = head;
    //     while(temp!=null){
    //         arr.add(temp.data);
    //         temp = temp.next;
    //     }
    //   sort(arr);
     if(head==null || head.next == null) return head;
        Node zhead=null,ztail=null,ohead=null,otail=null,thead=null,ttail=null;
        Node temp = head;
        while(temp!=null){
            if(temp.data==0){
                if(zhead==null) zhead=temp;
                else{
                    ztail.next=temp;
                }
                ztail=temp;
            }
            if(temp.data==1){
                if(ohead==null) ohead=temp;
                else{
                    otail.next=temp;
                }
                otail=temp;
            }
            if(temp.data==2){
                if(thead==null) thead=temp;
                else{
                    ttail.next=temp;
                }
                ttail=temp;
            }
            temp=temp.next;
        }
        if(zhead!=null){
            if(ohead!=null){
                ztail.next=ohead;
            }
            else{
                ztail.next=thead;
            }
        }
        if(ohead!=null){
            if(thead!=null) otail.next=thead;
            else otail.next=null;
        }
        if(thead!=null) ttail.next=null;
        if(zhead!=null) return zhead;
        if(ohead!=null) return ohead;
        return thead;
    }
}
