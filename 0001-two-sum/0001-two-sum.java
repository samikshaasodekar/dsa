class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            int difference = target - n;
            if(map.containsKey(difference)){
                return new int[]{
                    map.get(difference),i
                };
            }
            map.put(n,i);
        }
        return new int[]{};
    }
}

// TC:O(n).
// SC:O(n).