//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Item{
    int value;
    int weight;
    Item(int value,int weight){
        this.value = value;
        this.weight = weight;
        
    }
}
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        int n = val.size();
        int w = capacity;
        Item arr[] = new Item [n];
        for(int i =0;i<n;i++){
         arr[i] =new Item(val.get(i),wt.get(i));
        }
        
    // Arrays.sort(arr, (a, b) -> {
    // double ratioA = (double) a.value / a.weight;
    // double ratioB = (double) b.value / b.weight;
    // if (ratioA > ratioB) {
    //     return -1; // Sort in descending order
    // } else if (ratioA < ratioB) {
    //     return 1;
    // } else {
    //     return 0;
    // }
    //  });
    // double totalvalue = 0;
    // for(int i =0;i<n;i++){
    //     if(arr[i].weight<=capacity){
    //         totalvalue = totalvalue+arr[i].value;
    //         capacity =capacity-arr[i].weight; 
    //     }else{
    //         totalvalue = totalvalue+(double)((arr[i].value/arr[i].weight)*capacity);
    //         break;
    //     }
    // }
    // return totalvalue;
      double profit = 0;
        Arrays.sort(arr,(a,b)->(a.value*b.weight)-(b.value*a.weight));
        for(int i =n-1;i>=0;i--){
            if(arr[i].weight<=w){
                profit = profit+arr[i].value;
                w =w-arr[i].weight;
            }else{
                profit = profit+arr[i].value*((double)w/(double)arr[i].weight);
                break;
            }
        }
        return profit;
    }
}