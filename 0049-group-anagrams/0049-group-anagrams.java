class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<>();  //res = {}
        for(String s:strs){
            int[] count = new int[26];  //"eat": [0,0,0,...]
            for(char ch : s.toCharArray()){
                count[ch - 'a']++;
                // "eat" → 'e','a','t'.
                // 'e' → count[4] = 1
                // 'a' → count[0] = 1
                // 't' → count[19] = 1
                // Result: [1,0,0,0,1,...,1,...]
            }
                String key = Arrays.toString(count);
                //"eat" = "[1,0,0,0,1,...,1,...]"
                result.putIfAbsent(key, new ArrayList<>());
                ;
                // { 
                //     "[eat signature]": [] 
                // }
                result.get(key).add(s);
                // "eat" → { 
                //     "[eat signature]": ["eat"] 
                // }

                // "tea" → same signature as "eat" → group becomes ["eat","tea"].
                // "tan" → new signature → group ["tan"].
                // "ate" → same as "eat" → group ["eat","tea","ate"].
                // "nat" → same as "tan" → group ["tan","nat"].
                // "bat" → new signature → group ["bat"].
            }
            return new ArrayList<>(result.values());
            //[ ["eat","tea","ate"], ["tan","nat"], ["bat"] ]
    }
}

// TC: O(N * L) 
// SC: O(N * L)
// N = number of words in the input array strs. Example: ["eat","tea","tan","ate","nat","bat"] → here N = 6.
// L = average length of each word. Example: "eat" has length 3, "tea" length 3, "tan" length 3… so here L ≈ 3.