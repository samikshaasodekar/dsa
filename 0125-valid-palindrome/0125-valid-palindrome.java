class Solution {
    public boolean isPalindrome(String s) {
        /*int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters in a case-insensitive manner
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))             {
                return false;
            }
            left++;
            right--;
        }
        return true; // If no mismatches are found, the string is a palindrome
    }*/
        


        // StringBuilder to store only alphanumeric(a-z,0-9,@,&,*) characters in lowercase
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch)); // After processing, sb contains                                                                 "amanaplanacanalpanama".
                //toString --> converts the StringBuilder object into a String
            }
        }        
        StringBuilder rev = new StringBuilder(sb).reverse();
        return sb.toString().equals(rev.toString());
        
        //TC:O(n) SC:O(n)
    }
}


