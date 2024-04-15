/*
Problem statement
You are given a sorted integer array 'arr' of size 'n'.



You need to remove the duplicates from the array such that each element appears only once.



Return the length of this new array.



Note:
Do not allocate extra space for another array. You need to do this by modifying the given input array in place with O(1) extra memory. 


For example:
'n' = 5, 'arr' = [1 2 2 2 3].
The new array will be [1 2 3].
So our answer is 3.
Detailed explanation ( Input/output format, Notes, Images )
Sample input 1:
10
1 2 2 3 3 3 4 4 5 5 
Sample output 1:
5
Explanation of sample input 1:
The new array will be [1 2 3 4 5].
So our answer is 5.
Sample input 2:
9
1 1 2 3 3 4 5 5 5 
Sample output 2:
5
Expected time complexity:
The expected time complexity is O(n).
Constraints :
1 <= 'n' <= 10^6
-10^9 <= 'arr[i]' <=10^9

Where ‘arr[i]’ is the value of elements of the array.

Time limit: 1 sec
*/

===========================================================================================================================
===========================================================================================================================
   class Solution {
    public static int removeDuplicates(int[] arr, int n) {
        if (n == 0) {
            return 0; // Empty array
        }

        int i = 0; // Pointer for unique elements

        for (int j = 1; j < n; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j]; // Update the next unique element
            }
        }

        // The length of the new array is (i+1)
        return i + 1;
    }
}
