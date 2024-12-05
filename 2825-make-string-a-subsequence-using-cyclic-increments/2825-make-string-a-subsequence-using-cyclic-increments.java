class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();        
        int j = 0;
        for (int i = 0; i < n1 && j < n2; i++) {
            if (c1[i] == c2[j] || c1[i] + 1 == c2[j] || (c1[i] == 'z' && c2[j] == 'a')) {
                j++;
            }
        }
        return j == n2;
    }
}

/*
Time Complexity: O(n1) - outer loop.Inner loop takes constant time
Space Complexity: O(n1 + n2) - 2 char[]
*/