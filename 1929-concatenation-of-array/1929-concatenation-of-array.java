class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[2*nums.length];
        int index = 0;
        for(int i=0; i<2; i++){
            for(int n : nums){
                answer[index++] = n;
            }    
        }
        return answer;
    }
}

// TC:O(n)
// SC:O(n)