/*
Problem statement
You are given an integer array 'arr' of size 'N' and an integer 'K'.

Your task is to find the total number of subarrays of the given array whose sum of elements is equal to k.

A subarray is defined as a contiguous block of elements in the array.

Example:
Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6

Output: 2

Explanation: The subarrays that sum up to '6' are: [3, 1, 2], and [2, 4].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2
4 6
3 1 2 4

3 3
1 2 3
Sample output 1:
2
2
Explanation:
Test Case 1:

Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6

Output: 2

Explanation: The subarrays that sum up to '6' are: [3, 1, 2], and [2, 4].

Test Case 2:

Input: ‘N’ = 3, ‘arr’ = [1, 2, 3], 'K' = 3

Output: 2

Explanation: The subarrays that sum up to '7' are: [1, 2], and [3].
Sample Input 2:
2
3 7
1 2 3

4 9
6 3 5 2
Sample output 2:
0
1

*/

import java.util.*;

public class Solution {
    public static int findAllSubarraysWithGivenSum(int[] arr, int s) {
        int n = arr.length;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        // Initialize prefix sum with 0
        prefixSumCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // Check if (prefixSum - s) exists in the map
            if (prefixSumCount.containsKey(prefixSum - s)) {
                count += prefixSumCount.get(prefixSum - s);
            }

            // Update prefix sum count
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

  
}
