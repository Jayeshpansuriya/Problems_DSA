/*
Problem statement
There is an integer array ‘A’ of size ‘N’.

A sequence is successive when the adjacent elements of the sequence have a difference of 1.

You must return the length of the longest successive sequence.

Note:

You can reorder the array to form a sequence. 
For example,

Input:
A = [5, 8, 3, 2, 1, 4], N = 6
Output:
5
Explanation: 
The resultant sequence can be 1, 2, 3, 4, 5.    
The length of the sequence is 5.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
1 <= A[i] <= 10^9
Time Limit: 1 sec
*/
import java.util.*;
public class Solution {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        int n = a.length;
Set<Integer> set = new HashSet<>();

        for(int num : a){
            set.add(num);
        }

        int maxLen=0;

        

        for(int num :a){
            if(!set.contains(num-1)){
                int currNum=num;
                int currLen=1;

                while(set.contains(currNum+1)){
                    currNum++;
                    currLen++;

                }

                maxLen=Math.max(maxLen,currLen);

            }
            
        }
                    return maxLen;

    }
}
