/*
Given an integer array a[] of size n, find the length of the longest subsequence such that the absolute difference between adjacent elements is 1.

Example 1:

Input:
n = 7
a[] = {10, 9, 4, 5, 4, 8, 6}
Output: 
3
Explaination: 
The three possible subsequences of length 3 are {10, 9, 8}, {4, 5, 4}, and {4, 5, 6}, where adjacent elements have a absolute difference of 1. No valid subsequence of greater length could be formed.
Example 2:

Input: 
n = 5
a[] = {1, 2, 3, 4, 5}
Output: 
5
Explaination: 
All the elements can be included in the valid subsequence.
Your Task:
You do not need to read input. Your task is to complete the function longestSubseq() which takes integer n and array a[] as input parameters and returns the length of the longest subsequence where the absolute difference of adjacent elements is 1.

Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 103
1 ≤ a[i] ≤ 103
*/

============================================================================================================================================================================================
  /*
Intuition
The problem is asking for the longest subsequence in an array where the absolute difference between adjacent elements is 1. A straightforward approach might involve checking all subsequences, but that would be inefficient. Instead, we can use dynamic programming with a hashmap to keep track of the longest subsequence ending with each number.

Approach
Initialization:

Use a hashmap to store the length of the longest subsequence that ends with each integer in the array.
Initialize the maximum subsequence length (ans) to 1 since the smallest possible subsequence length is 1.
Iteration:

For each element in the array, determine the longest subsequence length ending with that element.
Check if the element minus one (i-1) or the element plus one (i+1) exists in the hashmap. If they do, update the current subsequence length accordingly.
Update the hashmap with the current element and its subsequence length.
Update the maximum subsequence length if the current one is longer.
Final Output:

Return the maximum subsequence length after processing all elements.
Complexity
Time complexity: 𝑂(𝑛)O(n)
We iterate through the array once, and each operation within the loop (hashmap operations) is 𝑂(1)O(1) on average.
Space complexity: 𝑂(𝑛)O(n)
We use a hashmap to store the lengths of subsequences for each unique element, which in the worst case can be the same size as the input array.
  */
  class Solution {

    /**
     * Finds the length of the longest subsequence such that the absolute difference 
     * between adjacent elements is 1.
     *
     * @param n the size of the array
     * @param a the array of integers
     * @return the length of the longest subsequence with the specified property
     */
    public static int longestSubseq(int n, int[] a) {
        // Map to store the length of the longest subsequence ending with a specific number
        Map<Integer, Integer> map = new HashMap<>();
        // Variable to keep track of the maximum length of any subsequence found
        int ans = 1;

        // Iterate through each number in the array
        for (int i : a) {
            // Start with a subsequence length of 1 for the current number
            int len = 1;

            // Check if there is a subsequence ending with the current number - 1
            if (map.containsKey(i - 1)) {
                // Update the length to be the maximum of the current length or the length of 
                // the subsequence ending with i-1 plus 1
                len = Math.max(len, map.get(i - 1) + 1);
            }

            // Check if there is a subsequence ending with the current number + 1
            if (map.containsKey(i + 1)) {
                // Update the length to be the maximum of the current length or the length of 
                // the subsequence ending with i+1 plus 1
                len = Math.max(len, map.get(i + 1) + 1);
            }

            // Store the updated length for the current number in the map
            map.put(i, len);
            // Update the overall maximum length of any subsequence found so far
            ans = Math.max(ans, len);
        }

        return ans;
    }
}

===============================================================================================================================================================================================================================

/*
Detailed Explanation
Imports:

import java.util.HashMap;
import java.util.Map; These import statements are necessary for using the HashMap class.
Class and Method Definition:

The Solution class contains a static method longestSubseq which takes an integer n (the size of the array) and an array of integers a.
Map Initialization:

Map<Integer, Integer> map = new HashMap<>();
This map will store the lengths of the longest subsequences ending with each integer.
Initial Answer Variable:

int ans = 1;
This variable keeps track of the maximum length of any valid subsequence found during the iteration.
Iterating Through the Array:

A for-each loop iterates through each element i in the array a.
Initial Subsequence Length:

int len = 1;
Each number initially starts with a subsequence length of 1.
Checking for Previous and Next Elements:

The code checks if the map contains the keys i - 1 or i + 1.
If map.containsKey(i - 1), it updates len to be the maximum of the current length or the length of the subsequence ending with i - 1 plus 1.
Similarly, if map.containsKey(i + 1), it updates len to be the maximum of the current length or the length of the subsequence ending with i + 1 plus 1.
Updating the Map and Answer:

map.put(i, len);
The map is updated with the current number and its respective subsequence length.
ans = Math.max(ans, len);
The answer is updated to be the maximum length found so far.
Returning the Result:

return ans;
Finally, the method returns the length of the longest subsequence where the absolute difference between adjacent elements is 1.
*/
