/*
You are given an array arr. Your task is to find the longest length of a good sequence. A good sequence {x1, x2, .. xn} is an alternating sequence if its elements satisfy one of the following relations :

1.  x1 < x2 > x3 < x4 > x5. . . . . and so on
2.  x1 >x2 < x3 > x4 < x5. . . . . and so on

Examples:

Input: arr= [1, 5, 4]
Output: 3
Explanation: The entire sequenece is a good sequence.
Input: arr= [1, 17, 5, 10, 13, 15, 10, 5, 16, 8]
Output: 7
Explanation: There are several subsequences that achieve this length. 
One maximum length good subsequences is [1, 17, 10, 13, 10, 16, 8].
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1 <= nums.size() <= 105 
1 <= nums[i] <= 104 
*/

class Solution {
    public int alternatingMaxLength(int[] arr) {
        // code here
        
        int n= arr.length;
        if(n==1) return 1;
        
        int inc=1,dec=1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]) inc=dec+1;
            else if(arr[i]<arr[i-1] )dec=inc+1;
            
        }
        return Math.max(inc,dec);
    }
}
