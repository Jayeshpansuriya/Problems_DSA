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
======================================================================================================================================================
  /*




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

Brute Force Approach

Algorithm / Intuition

The steps are as follows:

First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = size of the array).
Inside the loop, we will run another loop(say j) that will signify the ending index of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
After that for each subarray starting from index i and ending at index j (i.e. arr[i….j]), we will run another loop to calculate the sum of all the elements(of that particular subarray).
After calculating the sum, we will check if the sum is equal to the given k. If it is, we will increase the value of the count.
Intuition: We will check the sum of every possible subarray and count how many of them are equal to k. To get every possible subarray sum, we will be using three nested loops. The first two loops(say i and j) will iterate over every possible starting index and ending index of a subarray. Basically, in each iteration, the subarray range will be from index i to index j. Using another loop we will get the sum of the elements of the subarray [i…..j]. Among all values of the sum calculated, we will only consider those that are equal to k.
  */
  
import java.util.*;

public class jd {
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            for (int j = i; j < n; j++) { // ending index j

                // calculate the sum of subarray [i...j]
                int sum = 0;
                for (int K = i; K <= j; K++)
                    sum += arr[K];

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
Time Complexity: O(N3), where N = size of the array.
Reason: We are using three nested loops here. Though all are not running for exactly N times, the time complexity will be approximately O(N3).

Space Complexity: O(1) as we are not using any extra space.
*/
