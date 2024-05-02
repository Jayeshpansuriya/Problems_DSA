/*
Problem statement
You are given an array ‘a’ of ‘n’ integers.



You have to return the lexicographically next to greater permutation.



Note:

If such a sequence is impossible, it must be rearranged in the lowest possible order.


Example:

Input: 'a' = [1, 3, 2]

Output: 2 1 3

Explanation: All the permutations of [1, 2, 3] are [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1], ]. Hence the next greater permutation of [1, 3, 2] is [2, 1, 3].


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3
3 1 2


Sample Output 1:
3 2 1


Explanation Of Sample Input 1:
Input:
A = [3, 1, 2]
Output:
3 2 1

Explanation: All the permutations of [1, 2, 3] are [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1], ]. Hence the next greater permutation of [3, 1, 2] is [3, 2, 1].


Sample Input 2:
3
3 2 1


Sample Output 2:
1 2 3


Constraints:
1 <= n <= 100
1 <= a[ i ] <= 100
Time Limit: 1 sec
*/

import java.util.*;
public class Solution {
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        // Write your code here.
     //   public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int n = A.size(); // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }

        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        // Step 3: reverse the right half:
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
    
    }
}
