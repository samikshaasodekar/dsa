class Solution {
    public int getSecondLargest(int[] arr) {
        //Arrays.sort(arr);
        //return arr[arr.length - 2];
        
        int largest = arr[0];
        int secLargest = -1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > largest){
                secLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secLargest && arr[i] != largest){
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
}