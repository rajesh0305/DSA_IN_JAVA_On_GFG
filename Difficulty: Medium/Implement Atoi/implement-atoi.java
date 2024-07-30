//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	// Your code here
	char ch[] = s.toCharArray();
	String ans ="";
	for(int i = 0;i<ch.length;i++){
	    if((ch[i]>='a' && ch[i]<='z')||(ch[i]>='A' && ch[i]<='Z')){
	        return -1;
	    }else{
	        ans = ans+ch[i];
	    }
	}
	if(ans.charAt(ans.length()-1)=='-'){
	    return -1;
	}
	int res = Integer.parseInt(s);
	return res;
    }
}
