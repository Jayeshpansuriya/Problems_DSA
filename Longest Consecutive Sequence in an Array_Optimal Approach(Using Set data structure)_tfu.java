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





***************************************************************************************************************************************************************************************
/*
Optimal Approach(Using Set data structure): 
We will adopt a similar approach to the brute-force method but with optimizations in the search process. Instead of searching sequences for every array element as in the brute-force approach, we will focus solely on finding sequences only for those numbers that can be the starting numbers of the sequences. This targeted approach narrows down our search and improves efficiency.

We will do this with the help of the Set data structure.

How to identify if a number can be the starting number for a sequence:

First, we will put all the array elements into the set data structure.
If a number, num, is a starting number, ideally, num-1 should not exist. So, for every element, x, in the set, we will check if x-1 exists inside the set. :
If x-1 exists: This means x cannot be a starting number and we will move on to the next element in the set.
If x-1 does not exist: This means x is a starting number of a sequence. So, for number, x, we will start finding the consecutive elements.
How to search for consecutive elements for a number, x:

Instead of using linear search, we will use the set data structure itself to search for the elements x+1, x+2, x+3, and so on.
Thus, using this method we can narrow down the search and optimize the approach.

Algorithm:
We will declare 2 variables, 

‘cnt’ → (to store the length of the current sequence), 
‘longest’ → (to store the maximum length).
First, we will put all the array elements into the set data structure.
For every element, x, that can be a starting number(i.e. x-1 does not exist in the set) we will do the following:
We will set the length of the current sequence(cnt) to 1.
Then, again using the set, we will search for the consecutive elements such as x+1, x+2, and so on, and find the maximum possible length of the current sequence. This length will be stored in the variable ‘cnt’.
After that, we will compare ‘cnt’ and ‘longest’ and update the variable ‘longest’ with the maximum value (i.e. longest = max(longest, cnt)).
Finally, we will have the answer i.e. ‘longest’.
*/

  


import java.util.*;

public class jd {
    public static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
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
Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
Reason: O(N) for putting all the elements into the set data structure. After that for every starting element, we are finding the consecutive elements. Though we are using nested loops, the set will be traversed at most twice in the worst case. So, the time complexity is O(2*N) instead of O(N2).

Space Complexity: O(N), as we are using the set data structure to solve this problem.

Note: The time complexity is computed under the assumption that we are using unordered_set and it is taking O(1) for the set operations. 

If we consider the worst case the set operations will take O(N) in that case and the total time complexity will be approximately O(N2). 
And if we use the set instead of unordered_set, the time complexity for the set operations will be O(logN) and the total time complexity will be O(NlogN).
*/
