/*
Problem statement
Given an array 'arr' of 'n' non-negative integers, your task is to move all the zeros to the end of the array while keeping the non-zero elements at the start of the array in their original order. Return the modified array.



Example :
Input: ‘n’ = 5, ‘arr’ = [1, 2, 0, 0, 2, 3]
Output: [1, 2, 2, 3, 0, 0]

Explanation: Moved all the 0’s to the end of an array, and the rest of the elements retain the order at the start.
Detailed explanation ( Input/output format, Notes, Images )
Sample input 1:
4
0 0 0 1 
Sample output 1:
1 0 0 0 
Explanation of sample input 1:
Output: [1, 0, 0, 0]

We move all the 0’s to the end of an array, and the rest of the elements retained the order at the start.
Sample input 2:
5
4 0 3 2 5 
Sample output 2:
4 3 2 5 0 
Explanation of sample input 2:
Output: [4, 3, 2, 5, 0]

we move all the 0’s to the end of an array, and the rest of the elements retained the order at the start.
Expected time complexity:
 The expected time complexity is O(n).
Constraints:
1 ≤ n ≤ 10^6
0 ≤ arr[i] ≤ 10^9

Time limit: 1 sec
*/
===============================================================================================================================

  import java.util.ArrayList;

public class Solution {
    public static int[] moveZeros(int n, int[] arr) {
        ArrayList<Integer> nonZeroElements = new ArrayList<>();

        // Collect non-zero elements
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                nonZeroElements.add(arr[i]);
            }
        }

        // Fill the array with non-zero elements
        for (int i = 0; i < nonZeroElements.size(); i++) {
            arr[i] = nonZeroElements.get(i);
        }

        // Fill the remaining positions with zeros
        for (int i = nonZeroElements.size(); i < n; i++) {
            arr[i] = 0;
        }

        return arr;
    }
}
