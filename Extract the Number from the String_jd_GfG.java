/*
Given a sentence containing several words and numbers. Find the largest number among them which does not contain 9. If no such number exists, return -1.

Examples :

Input: sentence="This is alpha 5057 and 97"
Output: 5057
Explanation: 5057 is the only number that does
not have a 9.
Input: sentence="Another input 9007"
Output: -1
Explanation: Since there is no number that
does not contain a 9,output is -1.
Expected Time Complexity: O(n)
Expected Auxillary Space: O(n)

Constraints:
1<=n<=106
1<=answer<=1018

n is the length of a given sentence.
*/


class Solution {
    long ExtractNumber(String sentence) {
        // code here
        // String sentence="jayeshPansuriya2003";
        // System.out.println(sentence);
        // System.out.println(sentence.replaceAll(regex:"[0-9]",replacement:""));
        
        long max=-1;
        int n=sentence.length();
        long temp=0;
        for(int i=0;i<n;i++){
            if(sentence.charAt(i)>=48 && sentence.charAt(i)<=57){
                temp= temp*10 + (sentence.charAt(i)-48);
                
            }else {
                if(temp!=0 && !Long.toString(temp).contains("9")){
                    max=Math.max(temp,max);
                }
                temp=0;
            }
        }
        
        if(temp!=0){
            if(temp!=0 && !Long.toString(temp).contains("9")){
                max=Math.max(temp,max);
            }
        }
        
        return max;
        
    }
}
