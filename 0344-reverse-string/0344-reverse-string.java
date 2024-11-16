class Solution {
    public void reverseString(char[] s) {
        //1st

        /*int left = 0;
        int right = s.length - 1; 
        char temp; 

        while (left < right) {
            temp = s[left]; 
            s[left] = s[right]; 
            s[right] = temp; 
            left++;
            right--;
        }
        
        
Time Complexity
O(n): The algorithm iterates over half of the array, making swaps. Since each element is processed once, the complexity is linear with respect to the size of the array.
Space Complexity
O(1): The algorithm uses a constant amount of space (a few variables), regardless of the size of the input. The reversal is done in place, meaning no additional data structures are used.*/



        //2nd

        String original = new String(s); //char to String
        StringBuilder sb = new StringBuilder(original); //String to SB
        sb.reverse(); //only 1st char reversed with last.
        // Update the original char array with the reversed characters
        for(int i=0; i<s.length; i++){
            s[i] = sb.charAt(i); //put in sb
        }




        //3rd
        
        /*StringBuilder sb = new StringBuilder(s);
        sb.reverse();     
        return sb.toString();

Time Complexity
O(n): The reverse() method iterates through the characters of the string once. Therefore, the time complexity is linear with respect to the number of characters in the string.
Space Complexity
O(n): The StringBuilder object requires additional space proportional to the length of the string, as it creates a new string to store the reversed characters.
        */
    }
}
