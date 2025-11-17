class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int n : nums){
            if(seen.contains(n)){
                return true;
            }
            seen.add(n);
        }
        return false;
    }
}

// TC:O(n)
// SC:O(n)

//return Arrays.stream(n).distinct().count() < nums.length;

