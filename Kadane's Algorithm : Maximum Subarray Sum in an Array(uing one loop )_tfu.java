/*
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Examples
Example 1:
Input:
 arr = [-2,1,-3,4,-1,2,1,-5,4] 

Output:
 6 

Explanation:
 [4,-1,2,1] has the largest sum = 6. 

Examples 2:
Input:
 arr = [1] 

Output:
 1 

Explanation:
 Array has only one element and which is giving positive sum of 1. 
*/
========================================================================================================
  /*
Intuition: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].

Assume previous subarray = arr[i……j-1]
current subarray = arr[i…..j]
Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]

This is how we can remove the third loop and while moving j pointer, we can calculate the sum.

Approach:
The steps are as follows:

First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = array size).
Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element of the subarray. For every subarray starting from index i, the possible ending index can vary from index i to n-1(n = size of the array).
Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j]. Among all the sums the maximum one will be the answer.
  */
  
import java.util.*;

public class jd {
    public static int maxSubarraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // current subarray = arr[i.....j]

                //add the current element arr[j]
                // to the sum i.e. sum of arr[i...j-1]
                sum += arr[j];

                maxi = Math.max(maxi, sum); // getting the maximum
            }
        }

        return maxi;
    }

    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);

    }

}
/*
Time Complexity: O(N2), where N = size of the array.
Reason: We are using two nested loops, each running approximately N times.

Space Complexity: O(1) as we are not using any extra space.
*/
