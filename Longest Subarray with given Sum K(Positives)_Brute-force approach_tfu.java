/*
Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.

Examples
Example 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
Result: 3
Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
*/

======================================================================================================================
  /*
   Solution 1:
Naive Approach (Brute-force approach): 
Here, in this approach, we are going to generate all possible subarrays to solve this problem.

How to generate all possible subarrays?

We will select all possible starting indices(say i) and all possible ending indices(say j) to generate all possible subarrays. The possible starting indices i.e. i can vary from index 0 to index n-1(i.e. The last index). For every index i, the possible ending index j can vary from i to n-1. So, the nested loops to generate all possible subarrays will be like the following:


Approach:
The steps are as follows:

First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = size of the array).
Inside the loop, we will run another loop(say j) that will signify the ending index of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
After that for each subarray starting from index i and ending at index j (i.e. arr[i….j]), we will run another loop to calculate the sum of all the elements(of that particular subarray).
If the sum is equal to k, we will consider its length i.e. (j-i+1). Among all such subarrays, we will consider the maximum length by comparing all the lengths.
Intuition:
We will check the sum of every possible subarray and consider the one with the sum k and the maximum length among them. To get every possible subarray sum, we will be using three nested loops. The first loops(say i and j) will iterate over every possible starting index and ending index of a subarray. Basically, in each iteration, the subarray range will be from index i to index j. Using another loop we will get the sum of the elements of the subarray [i…..j]. Among all the subarrays with sum k, we will consider the one with the maximum length.

Note: We are selecting every possible subarray using two nested loops and for each of them, we add all its elements using another loop.

Note: For a better understanding of intuition, please watch the video at the bottom of the page.


Time Complexity: O(N3) approx., where N = size of the array.
Reason: We are using three nested loops, each running approximately N times.

Space Complexity: O(1) as we are not using any extra space.
  */

  


import java.util.*;

public class jd {
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            for (int j = i; j < n; j++) { // ending index
                // add all the elements of
                // subarray = a[i...j]:
                long s = 0;
                for (int K = i; K <= j; K++) {
                    s += a[K];
                }

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}


