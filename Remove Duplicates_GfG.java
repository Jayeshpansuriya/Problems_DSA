/*
Given a string str without spaces, the task is to remove all duplicate characters from it, keeping only the first occurrence.

Note: The original order of characters must be kept the same. 

Examples :

Input: str = "zvvo"
Output: "zvo"
Explanation: Only keep the first occurrence
Input: str = "gfg"
Output: "gf"
Explanation: Only keep the first occurrence
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= |str| <= 105
str contains lowercase English alphabets
*/

class Solution {
    String removeDups(String str) {
        // code here
        String result="";
        ArrayList<Character> list= new ArrayList<>();
        int len=str.length();
        for(int i=0;i<len;i++){
            if(!list.contains(str.charAt(i))){
                result+=str.charAt(i);
                list.add(str.charAt(i));
                
            }
        }
        
        return result;
        
        
    }
}
