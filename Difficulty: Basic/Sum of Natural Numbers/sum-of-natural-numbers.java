class Solution {
    public static int findSum(int n) {
        // code here
        if(n==1){
            return 1;
        }
        int s1 = findSum(n-1);
        int sn = n + s1;
        return sn;
    }
}
