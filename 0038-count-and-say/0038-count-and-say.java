class Solution {
    public String countAndSay(int n) {
/*
The 1st term is "1" (This is given). ie, we have to write frequency,number
The 2nd term describes the 1st term as "one 1" → "11". take full as answer
The 3rd term describes the 2nd term as "two 1s" → "21".
The 4th term describes the 3rd term as "one 2, one 1" → "1211".
The 5th term describes the 4th term as "one 1, one 2, two 1s" → "111221".
*/
        String res = "1";
        
        //generate loop from 2 to n
        for(int i = 1; i<n; i++){ //we are already done with 1st term so Iteration 1: Generate the 2nd term → "11", Iteration 2: Generate the 3rd term → "21", Iteration 3: Generate the 4th term → "1211", Iteration 4: Generate the 5th term → "111221"
            StringBuilder next = new StringBuilder();
            char curr = res.charAt(0);  //At the beginning: result = "1".
            int count = 1; //Count of the current character
            
            // Iterate over the current term
            for(int j=1; j<=res.length()-1; j++){
                if(res.charAt(j) == curr){
                    count++; 
                }else{
                    // Append the count and character to the next term
                    next.append(count).append(curr);
                    curr = res.charAt(j);
                    count = 1;
                }
/*
First Iteration (i = 1)
Input: result = "1"
Loop: No inner loop iterations are needed (since length = 1).
Append: nextTerm = "11" (Describes: "one 1")
Update: result = "11"

Second Iteration (i = 2)
Input: result = "11"
Inner Loop:
j = 1: result.charAt(1) == '1' → count = 2
Append: nextTerm = "21" (Describes: "two 1s")
Update: result = "21"

Third Iteration (i = 3)
Input: result = "21"
Inner Loop:
j = 1: result.charAt(1) != '2'
Append: nextTerm = "12" (Describes: "one 2")
Update: currentChar = '1', count = 1
Final Append: nextTerm = "1211" (Describes: "one 1")
Update: result = "1211"

Fourth Iteration (i = 4)
Input: result = "1211"
Inner Loop:
j = 1: result.charAt(1) != '1'
Append: nextTerm = "11" (Describes: "one 1")
Update: currentChar = '2', count = 1
j = 2: result.charAt(2) != '2'
Append: nextTerm = "1112" (Describes: "one 2")
Update: currentChar = '1', count = 1
j = 3: result.charAt(3) == '1' → count = 2
Final Append: nextTerm = "111221" (Describes: "two 1s")
Update: result = "111221"
*/
         
            }
            // Append the last character and its count
            next.append(count).append(curr);
            res = next.toString();  // Update the result for the next iteration
        }
      return res;           
    }    
}


/*Time Complexity:
O(n * m), where n is the number of terms, and m is the length of each term. The length of each term roughly doubles with each iteration, so this complexity can grow quickly.
Space Complexity:
O(m) space is needed for each term in the sequence.*/