class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        /*
        //Horizontal Scaling (Comparing Prefix with Each String)
        
        Horizontal Scanning	O(N * M)	O(1)
        
        if (strs == null || strs.length == 0) return ""; 
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
        */
        
        
        
        
        
        
        
        //Vertical Scanning (Character by Character Comparison)
        
        //Vertical Scanning	O(N * M)	O(1)
        
        //StringBuilder sb = new StringBuilder(); //to store prefix        
/*If strs[0] is "flower":
When i = 0, c becomes 'f'.
When i = 1, c becomes 'l'.
And so on until all characters in "flower" are checked.
The goal is to use ch for comparison with characters at the same position in the other strings*/
        //for(int i=0; i<=strs[0].length()-1; i++){
            //char ch = strs[0].charAt(i);
/* Iteration 1 (i = 0):
ch = 'f' (character at index 0 of "flower").
We compare 'f' with the character at index 0 of "flow" (which is also 'f') and "flight" (which is also 'f').
Since all characters match, we append 'f' to prefix, making prefix = "f".*/
            //for(String str : strs){
/*Example: If c is 'f' (from "flower") and str is "flight", when i = 2, c will be 'o' (from "flower"), and str.charAt(i) will be 'i' (from "flight"). Since 'o' and 'i' do not match, this condition becomes true.*/
                //if(i==str.length() || str.charAt(i) != ch){
                    //return sb.toString();
                //}
            //}
       //sb.append(ch);
        //}
    //return sb.toString(); 
            
        
        
        
        
        
        
        
        /*
        //Divide and Conquer Approach(Split the array and find the prefix recursively)
        
        Divide and Conquer	O(N * M)	O(log N)
        
        return divideAndConquer(strs, 0, strs.length-1);
    }
        
        private String divideAndConquer(String[] strs, int left, int right){
            if(left == right){ //Base case: if there is only one string, return it
                 return strs[left];
            }else{
                int mid = (left+right)/2;
                // Split the array into two halves
                // Example: For ["flower", "flow", "flight"], the array is split into
                // ["flower", "flow"] and ["flight"] at the midpoint
                String leftPrefix = divideAndConquer(strs, left, mid);  // Get prefix from the left half
                String rightPrefix = divideAndConquer(strs, mid+1, right);  // Get prefix from the right half
                // Example: The left half returns "flow" and the right half returns "flight"
                return commonPrefix(leftPrefix, rightPrefix);  // Merge the two prefixes
            }
        }
        
        // Naming the parameters left and right makes it more flexible and applicable to any two strings passed to it and leftPrefix , rightPrefix this are implicit so we aren't using it.
        private String commonPrefix(String left, String right){
            int minLength = Math.min(left.length(),right.length());// Find the shortest length
            for(int i = 0; i < minLength; i++){
                if(left.charAt(i) != right.charAt(i)){  // Compare characters
                    // Example: Comparing "flow" and "flight", characters match until 'i'
                    return left.substring(0,i);  //// Return prefix up to the mismatch
                }
            }
            return left.substring(0, minLength);
            */
        
        
        
        
        
        
        
        //Binary Search Approach(Use binary search to minimize the number of comparisons in sorted)
        
        //Binary Search	O(N * log M)	O(1)
        //N is the total items you have and M is the possible number of values those items could take.
        
/*example: strs = {"flower", "flow", "flight"}.

Initial Setup:

minLen = 4 (the length of the shortest string, "flow").
low = 1, high = 4.
First Iteration:

mid = (1 + 4) / 2 = 2.
isCommonPrefix(strs, 2) checks if the first two characters ("fl") are common in all strings:
"flower" starts with "fl" -> true.
"flow" starts with "fl" -> true.
"flight" starts with "fl" -> true.
Since all strings share the prefix "fl", prefix = "fl" and low = 3.
Second Iteration:

mid = (3 + 4) / 2 = 3.
isCommonPrefix(strs, 3) checks if the first three characters ("flo") are common in all strings:
"flower" starts with "flo" -> true.
"flow" starts with "flo" -> true.
"flight" starts with "flo" -> false.
Since "flight" does not start with "flo", the prefix is too long, so high = 2.
Termination:

The loop exits as low > high, and the longest common prefix found is "fl".*/
        
        int minLen = Integer.MAX_VALUE;  // Find the shortest string length in the array
        for(String str : strs){
            minLen = Math.min(minLen, str.length());
        }
        
        int low=1,high=minLen;
        String prefix = "";
        
        while(low<=high){
            int mid = low + (high - low) / 2;  // Avoid overflow
            if (isCommonPrefix(strs, mid)){
                prefix = strs[0].substring(0, mid);
                low = mid + 1;  // Try a longer prefix
            } else {
                high = mid -1;  // Try a shorter prefix
            }
        }
        return prefix;
        }
    
    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0, len);
        for(String str : strs){
            if(!str.startsWith(str1)){
                return false;
            }
        }
        return true;
    } 
        
    }
