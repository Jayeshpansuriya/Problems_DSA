/*
Problem Statement: Given an array of integers arr[] and an integer target.

1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.

2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.

Examples:

Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.

Example 2:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
Result: NO (for 1st variant)
	[-1, -1] (for 2nd variant)
Explanation: There exist no such two numbers whose sum is equal to the target.
*/
===============================================================================================================================================
  /*
Naive Approach(Brute-force approach): 

Intuition: For each element of the given array, we will try to search for another element such that its sum is equal to the target. If such two numbers exist, we will return the indices or “YES” accordingly.

Approach:

First, we will use a loop(say i) to select the indices of the array one by one.
For every index i, we will traverse through the remaining array using another loop(say j) to find the other number such that the sum is equal to the target (i.e. arr[i] + arr[j] = target).
Observation: In every iteration, if the inner loop starts from index 0, we will be checking the same pair of numbers multiple times. For example, in iteration 1, for i = 0, we will check for the pair arr[0] and arr[1]. Again in iteration 2, for i = 1, we will check arr[1] and arr[0]. So, to eliminate these same pairs, we will start the inner loop from i+1.

Dry Run: Given array, nums = [2,1,3,4], target = 4

Using the naive approach, we first select one number and then find the second one.

For index 0, element= 2,
Then, we iterate through indices 1 to 3 to check if target – x, i.e. 4 – 2 = 2 exists. 2 does not exist from index 1 to 3, we move to the next index.

For index 1, element=1,
Then, we iterate through indices 2 to 3 to find if target – x, i.e. 4 – 1 = 3 exists. 3 exists at index 2, so we store the indices 1 and 2, break the loop, and return the indices.


Time Complexity: O(N2), where N = size of the array.
Reason: There are two loops(i.e. nested) each running for approximately N times.

Space Complexity: O(1) as we are not using any extra space.


  */
  import java.util.*;

public class jd {
    public static String twoSum(int n, int []arr, int target) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return "YES";
            }
        }
        return "NO";
    }

    public static void main(String args[]) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        String ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 1: " + ans);
    }

}
