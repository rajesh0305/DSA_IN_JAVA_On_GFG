//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
       public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String str = sc.nextLine();
            Solution ob = new Solution();
            if(ob.sentencePalindrome(str))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution { 
    public static boolean usingTrim(String s){
        s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]","").trim();
        int j=s.length()-1, i=0;
        while(j>=i){
            if(s.charAt(i)!=s.charAt(j)) return false;
            j--;i++;
        }
        return true;
    } 

    static boolean sentencePalindrome(String s) { 
        // code here
       int start = 0,end = s.length()-1;
        while(start<=end){
            char charStart = s.charAt(start);
            char charEnd = s.charAt(end);
            if(!Character.isLetter(charStart)){
               start++; 
            }
            else if(!Character.isLetter(charEnd)){
               end--;
            }
            else if(charStart != charEnd){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}