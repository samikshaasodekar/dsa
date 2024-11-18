import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;  
        
        
        
        
        //By sorting
        /*
        char[] sArray = s.toCharArray();  // String to char store in char[]
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);  // sorted in lexicographical order
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
//after sorting the arrays, you're comparing them directly with Arrays.equals(). You do not need to convert them back to strings because Arrays.equals() compares the arrays directly, which is enough for checking equality.
//String sortedS = new String(sArray);
//String sortedT = new String(tArray);  
        */
        
        
        
        
        
        
        
        
        //Using HashMap
        HashMap<Character, Integer> count = new HashMap<>();  //count is empty HashMap
        for(char ch: s.toCharArray()){
            
/*First Loop: Counting Frequencies in s = "anagram"

The count.getOrDefault(ch, 0) method ensures we don’t get a NullPointerException when accessing a key that isn't in the map.

Character 'a':

count.getOrDefault('a', 0) returns 0 (since 'a' is not in the map yet).
count.put('a', 0 + 1) updates the map: {'a': 1}.
Character 'n':

count.getOrDefault('n', 0) returns 0.
count.put('n', 0 + 1) updates the map: {'a': 1, 'n': 1}.
Character 'a':

count.getOrDefault('a', 0) returns 1 (since 'a' is already in the map).
count.put('a', 1 + 1) updates the map: {'a': 2, 'n': 1}.
Character 'g':

count.getOrDefault('g', 0) returns 0.
count.put('g', 0 + 1) updates the map: {'a': 2, 'n': 1, 'g': 1}.
Character 'r':

count.getOrDefault('r', 0) returns 0.
count.put('r', 0 + 1) updates the map: {'a': 2, 'n': 1, 'g': 1, 'r': 1}.
Character 'a':

count.getOrDefault('a', 0) returns 2.
count.put('a', 2 + 1) updates the map: {'a': 3, 'n': 1, 'g': 1, 'r': 1}.
Character 'm':

count.getOrDefault('m', 0) returns 0.
count.put('m', 0 + 1) updates the map: {'a': 3, 'n': 1, 'g': 1, 'r': 1, 'm': 1}.
After the First Loop
*/
            
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        for(char ch : t.toCharArray()){
            if(!count.containsKey(ch)){
                return false;
            }
            
/*Second Loop: Subtracting Frequencies from t = "nagaram"
Character 'n':

count.get('n') returns 1.
count.put('n', 1 - 1) updates the map: {'a': 3, 'n': 0, 'g': 1, 'r': 1, 'm': 1}.
Character 'a':

count.get('a') returns 3.
count.put('a', 3 - 1) updates the map: {'a': 2, 'n': 0, 'g': 1, 'r': 1, 'm': 1}.
Character 'g':

count.get('g') returns 1.
count.put('g', 1 - 1) updates the map: {'a': 2, 'n': 0, 'g': 0, 'r': 1, 'm': 1}.
Character 'a':

count.get('a') returns 2.
count.put('a', 2 - 1) updates the map: {'a': 1, 'n': 0, 'g': 0, 'r': 1, 'm': 1}.
Character 'r':

count.get('r') returns 1.
count.put('r', 1 - 1) updates the map: {'a': 1, 'n': 0, 'g': 0, 'r': 0, 'm': 1}.
Character 'a':

count.get('a') returns 1.
count.put('a', 1 - 1) updates the map: {'a': 0, 'n': 0, 'g': 0, 'r': 0, 'm': 1}.
Character 'm':

count.get('m') returns 1.
count.put('m', 1 - 1) updates the map: {'a': 0, 'n': 0, 'g': 0, 'r': 0, 'm': 0}.
*/
            
            count.put(ch, count.get(ch)-1);
        }
        
        for(int ct : count.values()){
            if(ct != 0){
                return false;  // If any value is not 0, they are not anagrams
            }
        }
    return true;
    }
}
                

/*HashMap Approach: O(n) time and O(1) space (since space used is limited to character set size).
We use a HashMap to store the character frequencies. In the worst case, if all characters are unique, the HashMap could have k entries, where k is the number of unique characters in the string.
Since there are only a limited number of characters (e.g., 26 lowercase letters or 52 uppercase and lowercase combined), the space complexity is O(k), which is O(1) in practical terms for English characters.
Sorting Approach: O(n log n) time and O(n) space.
Arrays.sort, have a time complexity of O(n log n).
Comparing the sorted arrays takes another O(n).
Which Approach is Better?
The HashMap approach is generally faster for large inputs because it has linear time complexity.
The sorting approach is easier to implement and may be preferable for simpler or smaller problems, but it is less efficient for very large strings due to the O(n log n) complexity.*/