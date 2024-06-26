/*
Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero

Examples
Example 1:
Input Format
: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result
: 5
Explanation
: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!

Example 2:
Input Format:
 N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
Result
: 8
Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
Length of longest subarray = 8

Example 3:
Input Format:
 N = 3, array[] = {1, 0, -5}
Result
: 1
Subarray : {0}
Length of longest subarray = 1

Example 4:
Input Format:
 N = 5, array[] = {1, 3, -5, 6, -2}
Result
: 0
Subarray: There is no subarray that sums to zero

*/

===================================================================================================================================================================================
  /*
lgorithm / Intuition
Solution 1 (Naive approach) :
Intuition:
We are required to find the longest subarray that sums to zero. So our initial approach could be to consider all possible subarrays of the given array and check for the subarrays that sum to zero. Among these valid subarrays (a sum equal to zero) we’ll return the length of the largest subarray by maintaining a variable, say max.   

Approach :  
Initialize a variable max = 0, which stores the length of the longest subarray with a sum of 0.
Traverse the array from the start and initialize a variable sum = 0 which stores the sum of the subarray starting with the current index
Traverse from the next element of current_index up to the end of the array, each time add the element to the sum and check if it is equal to 0.
If sum = 0, check if the length of the subarray so far is > max and if yes update max
Now keep adding elements and repeat step 3 a.
After the outer loop traverses all elements return max
  */

  


import java.util.*;

public class Solution {
static int solve(int[] a){
	int  max = 0;
	for(int i = 0; i < a.length; ++i){
		int sum = 0;
		for(int j = i; j < a.length; ++j){
			sum += a[j];
			if(sum == 0){
				max = Math.max(max, j-i+1);
			}
		}
	}
	return max;
   }

    public static void main(String args[]) 
    { 
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(solve(a));
    } 
}

/*
Time Complexity: O(N^2) as we have two loops for traversal

Space Complexity: O(1) as we aren’t using any extra space.
*/
