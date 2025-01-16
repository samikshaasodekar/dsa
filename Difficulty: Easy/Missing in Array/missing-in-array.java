//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().missingNumber(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length + 1;  
        int xorArray = 0; //will store the XOR of all the values in the input array
        int xorFull = 0; //will store the XOR of all numbers from 1 to n
        for (int num : arr) {
            xorArray ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xorFull ^= i;
        }
        return xorArray ^ xorFull; // The missing number is the XOR of xorFull and xorArray
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)