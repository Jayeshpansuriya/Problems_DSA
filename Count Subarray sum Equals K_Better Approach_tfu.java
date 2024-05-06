/*
Count Subarray sum Equals K


25

0
Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.

A subarray is a contiguous non-empty sequence of elements within an array.

Pre-requisite: Longest subarray with given sum

Examples
Example 1:
Input Format:
 N = 4, array[] = {3, 1, 2, 4}, k = 6
Result:
 2
Explanation:
 The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].

Example 2:
Input Format:
 N = 3, array[] = {1,2,3}, k = 3
Result:
 2
Explanation:
 The subarrays that sum up to 3 are [1, 2], and [3].

*/

=========================================================================================================================

  /*
Algorithm / Intuition
The steps are as follows:

First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = array size).
Inside the loop, we will run another loop(say j) that will signify the ending index as well as the current element of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
Inside loop j, we will add the current element to the sum of the previous subarray i.e. sum = sum + arr[j]. 
After calculating the sum, we will check if the sum is equal to the given k. If it is, we will increase the value of the count.
Intuition: If we carefully observe, we can notice that to get the sum of the current subarray we just need to add the current element(i.e. arr[j]) to the sum of the previous subarray i.e. arr[i….j-1].

Assume previous subarray = arr[i……j-1]
current subarray = arr[i…..j]
Sum of arr[i….j] = (sum of arr[i….j-1]) + arr[j]

This is how we can remove the third loop and while moving j pointer, we can calculate the sum.
  */

  
import java.util.*;

public class jd {
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subarray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += arr[j];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = findAllSubarraysWithGivenSum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}  


/*
Time Complexity: O(N2), where N = size of the array.
Reason: We are using two nested loops here. As each of them is running for exactly N times, the time complexity will be approximately O(N2).

Space Complexity: O(1) as we are not using any extra space.
*/
