/*
Problem statement
You are given an array 'a' of size 'n' and an integer 'k'.



Find the length of the longest subarray of 'a' whose sum is equal to 'k'.



Example :
Input: ‘n’ = 7 ‘k’ = 3
‘a’ = [1, 2, 3, 1, 1, 1, 1]

Output: 3

Explanation: Subarrays whose sum = ‘3’ are:

[1, 2], [3], [1, 1, 1] and [1, 1, 1]

Here, the length of the longest subarray is 3, which is our final answer.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
7 3
1 2 3 1 1 1 1


Sample Output 1 :
3


Explanation Of Sample Input 1 :
Subarrays whose sum = ‘3’ are:
[1, 2], [3], [1, 1, 1] and [1, 1, 1]
Here, the length of the longest subarray is 3, which is our final answer.


Sample Input 2 :
4 2
1 2 1 3


Sample Output 2 :
1


Sample Input 3 :
5 2
2 2 4 1 2 


Sample Output 3 :
1


Expected time complexity :
The expected time complexity is O(n).


Constraints :
1 <= 'n' <= 5 * 10 ^ 6
1 <= 'k' <= 10^18
0 <= 'a[i]' <= 10 ^ 9

Time Limit: 1-second
*/

import java.util.*;

public class Solution {
    public static int longestSubarrayWithSumK(int[] a, long k) {
        int n = a.length;
        int maxLength = 0; // Initialize the maximum length
        long currentSum = 0; // Initialize the current sum
        HashMap<Long, Integer> prefixSumMap = new HashMap<>(); // Store prefix sums

        for (int i = 0; i < n; i++) {
            currentSum += a[i]; // Update the current sum

            if (currentSum == k) {
                // If the current sum equals k, update the maximum length
                maxLength = i + 1;
            }

            if (prefixSumMap.containsKey(currentSum - k)) {
                // If (currentSum - k) exists in the prefix sum map, update the maximum length
                maxLength = Math.max(maxLength, i - prefixSumMap.get(currentSum - k));
            }

            if (!prefixSumMap.containsKey(currentSum)) {
                // Store the current sum in the prefix sum map (only if not already present)
                prefixSumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 1, 1, 1, 1};
        System.out.println(longestSubarrayWithSumK(a1, 3)); // Output: 3

        int[] a2 = {1, 2, 1, 3};
        System.out.println(longestSubarrayWithSumK(a2, 2)); // Output: 1

        int[] a3 = {2, 2, 4, 1, 2};
        System.out.println(longestSubarrayWithSumK(a3, 2)); // Output: 1
    }
}
