class Solution {
    public static int largest(int[] arr) {
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > num) {
                num = arr[i];
            }
        }
        return num;
    }
}

