class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        for(int i=0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(String s:strs){
                if(i == s.length() || s.charAt(i) != ch){
                    return strs[0].substring(0,i); //not including i
                }
            }
        }
        return strs[0];
    }
}

// TC:O(n*m)
// ->n = length of the shortest string
// ->m = number of strings
// SC:O(1)