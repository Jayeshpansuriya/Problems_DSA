/*
Given two integers s and d. The task is to find the smallest number such that the sum of its digits is s and the number of digits in the number are d. Return a string that is the smallest possible number. If it is not possible then return -1.

Examples:

Input: s = 9, d = 2
Output: 18 
Explanation: 18 is the smallest number possible with the sum of digits = 9 and total digits = 2.
Input: s = 20, d = 3 
Output: 299 
Explanation: 299 is the smallest number possible with the sum of digits = 20 and total digits = 3.
Expected Time Complexity: O(d)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ s ≤ 100
1 ≤ d ≤ 6
*/

class Solution {
    
    public int helper(int s,int d,int dig){
        if(d==0 && s==0) return dig;
        
        if(d==0 || s<0) return (int )1e8;
        
        int take=(int)1e8;
        
        for(int i=0;i<=9;i++){
            if(dig==0 && i==0 && d!=1) continue;
            take = Math.min(take,helper(s-i,d-1,dig*10+i));
            
        }
        
        return take;
    }
    
    public String smallestNumber(int s, int d) {
        // code here
        
        int result=helper(s,d,0);
        
        if(result>=(int)1e8){
            return "-1";
        }
        
        return String.valueOf(result);
    }
}
