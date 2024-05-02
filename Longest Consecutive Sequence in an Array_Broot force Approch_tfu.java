/*
Longest Consecutive Sequence in an Array


23

2
Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Examples
Example 1:
Input:
 [100, 200, 1, 3, 2, 4]

Output:
 4

Explanation:
 The longest consecutive subsequence is 1, 2, 3, and 4.

Input:
 [3, 8, 5, 7, 6]

Output:
 4

Explanation:
 The longest consecutive subsequence is 5, 6, 7, and 8.
*/
****************************************************************************************************************************************
  /*
Brute-force Approach: 
A straightforward but basic solution is to examine consecutive sequences for each element in the given array. For every element x, we will try to find the consecutive elements, x+1, x+2, x+3, and so on using the linear search algorithm. Thus, we will check the length of the longest consecutive subsequence we can build for every element x. Among all the lengths we will consider the maximum one.

Algorithm:
To begin, we will utilize a loop to iterate through each element one by one.
Next, for every element x, we will try to find the consecutive elements like x+1, x+2, x+3, and so on using the linear search algorithm in the given array.
Within a loop, our objective is to locate the next consecutive element x+1. 
If this element is found, we increment x by 1 and continue the search for x+2. 
Furthermore, we increment the length of the current sequence (cnt) by 1. 
This process repeats until step 2.2 occurs.

If a specific consecutive element, for example, x+i, is not found, we will halt the search for subsequent consecutive elements such as x+i+1, x+i+2, and so on. Instead, we will take into account the length of the current sequence (cnt).
Among all the lengths we get for all the given array elements, the maximum one will be the answer.
  */

  


import java.util.*;

public class jd {
    public static boolean linearSearch(int []a, int num) {
        int n = a.length; //size of array
        for (int i = 0; i < n; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }
    public static int longestSuccessiveElements(int []a) {
        int n = a.length; //size of array
        int longest = 1;
        //pick a element and search for its
        //consecutive numbers:
        for (int i = 0; i < n; i++) {
            int x = a[i];
            int cnt = 1;
            //search for consecutive numbers
            //using linear search:
            while (linearSearch(a, x + 1) == true) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}

/*

Time Complexity: O(N2), N = size of the given array.
Reason: We are using nested loops each running for approximately N times.

Space Complexity: O(1), as we are not using any extra space to solve this problem.
*/
