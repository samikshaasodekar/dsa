class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Voting
        int candidate=0, count=0;
        for(int n:nums){
            if(count==0){
                candidate = n;
            }
            if(n==candidate){
                count = count+1;
            }else{
                count = count-1;
            }
            //count = count + ((n == candidate) ? 1 : -1);
        }
        return candidate;
    }
}

// TC:O(n)
// SC:O(1)