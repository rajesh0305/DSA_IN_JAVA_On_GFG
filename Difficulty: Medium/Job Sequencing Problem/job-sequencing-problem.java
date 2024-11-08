//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            // adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            // function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
*/

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job jobs[], int n) {
        // Your code here
        //Step1 sort jobs according to profit with the help of comparator
        // Arrays.sort(jobs,(a,b)->((b.profit)-(a.profit)));
        
        // //Step2 find maximum deadline 
        // int mdeadline =Integer.MIN_VALUE;
        // for(int i = 0;i<n;i++){
        //     mdeadline = Math.max(mdeadline,jobs[i].deadline);
        // }
        
        // //Step3 creating the jobs container array and initialize it 
        // int result[] = new int[mdeadline+1];
        // for(int i = 0;i<mdeadline;i++){
        //     result[i] = -1;
        // }
        
        // //Step4 finding profit
        // int countjobs = 0;
        // int totalprofit = 0;
        // for(int i =0;i<n;i++){
        //     for(int j = jobs[i].deadline;j>0;j--){
        //         if(result[j]==-1){
        //             result[j] = i;
        //             countjobs++;
        //             totalprofit = totalprofit+jobs[i].profit;
        //             break;
        //         }
        //     }
        // }
        // int ans[] = new int [2];
        // ans[0] = countjobs;
        // ans[1] = totalprofit;
        // return ans;
        Arrays.sort(jobs,(x,y)->y.profit-x.profit);
        int maxDeadline=0;
        for(Job j:jobs) maxDeadline=Math.max(maxDeadline,j.deadline);
        int deadlines[]=new int[maxDeadline+1];
        Arrays.fill(deadlines,-1);
        int maxProfit=0,totalJobs=0;
        for(Job j:jobs){
            for(int i=j.deadline;i>0;i--){
                if(deadlines[i]==-1){
                    deadlines[i]=j.profit;
                    maxProfit+=j.profit;
                    totalJobs++;
                    break;
                }
            }
        }
        return new int[]{totalJobs,maxProfit};
    }
}
