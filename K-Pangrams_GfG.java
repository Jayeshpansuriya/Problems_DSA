/*
Given a string str and an integer k, return true if the string can be changed into a pangram after at most k operations, else return false.

A single operation consists of swapping an existing alphabetic character with any other alphabetic character.

Note - A pangram is a sentence containing every letter in the english alphabet.

Examples :

Input: str = "the quick brown fox jumps over the lazy dog", k = 0
Output: true
Explanation: the sentence contains all 26 characters and is already a pangram.
Input: str = "aaaaaaaaaaaaaaaaaaaaaaaaaa", k = 25 
Output: true
Explanation: The word contains 26 instances of 'a'. Since only 25 operations are allowed. We can keep 1 instance and change all others to make str a pangram.
Input: str = "a b c d e f g h i j k l m", k = 20
Output: false
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)  

Constraints:
1<= str.size() <= 105
0<= k <= 50
str may contain duplicate characters.
str contains only lowercase alphabets or spaces.
*/
class Solution {
    boolean kPangram(String str, int k) {
        // code here
        int alp[]=new int[26];
        int extras=0, notExist=0;
        
        
        for(char c:str.toCharArray()){
            if(c!=' ') alp[c-'a']++;
            
            
        }
        for(int i=0;i<26;i++){
            if(alp[i]>1) extras+=alp[i]-1;
            if(alp[i]==0) notExist++;
            
        }
        
        if(notExist>k) return false;
        if(extras<notExist) return false;
        return true;
    }
}
