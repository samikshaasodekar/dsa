//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            List<Integer> result = new Solution().leaders(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();    // Ensure new line after each test case output
                System.out.println("~"); // Ensure new line after each test case output
            }
        }
    }
}

// } Driver Code Ends

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
       ArrayList<Integer> res = new ArrayList<>();
       int n = arr.length;
       //As we can see, last element is always a leader
       int le = arr[n-1];
       res.add(le);
       
       for(int i=n-2; i>=0; i--){
           if(arr[i] >= le){
               le = arr[i];
               res.add(le);
           }
       }
       
       Collections.reverse(res);
       return res;
    }
}

//TC : O(n)  Single traversal of the array and one reversal of the result list.
//SC : O(k)  Space for the result list, where k is the number of leaders.