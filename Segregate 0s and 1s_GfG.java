/*
Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

Examples :

Input: arr[] = [0, 0, 1, 1, 0]
Output: [0, 0, 0, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 1, 1].
Input: arr[] = [1, 1, 1, 1]
Output: [1, 1, 1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1, 1, 1]
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 1
*/

/*
Step-by-Step Explanation:
Initialization:

low is initialized to 0. It will be used to keep track of the leftmost position where a 1 can be placed.
high is initialized to arr.length - 1. It will be used to keep track of the rightmost position where a 0 can be placed.
Iteration:

The algorithm uses a while loop to iterate as long as low is less than high.
Condition Check:

If arr[low] is 0:
It means the element is already in the correct position, so we increment low to check the next element.
If arr[low] is 1:
We need to move this 1 to the right side. To do this, we swap the element at low with the element at high.
After swapping, we decrement high because we have placed a 1 at the end, so the position high is no longer valid for future swaps.
Example Execution:
Let's go through an example to see how this works:

Initial Array:
0,1,0,1,1,0

Initial Pointers:
low = 0
high = 5
Iteration 1:
arr[low] is 0.
Increment low.
low = 1, high = 5.
Iteration 2:
arr[low] is 1.
Swap arr[low] with arr[high].
Array becomes: 0,0,0,1,1,1
Decrement high.
low = 1, high = 4.
Iteration 3:
arr[low] is 0.
Increment low.
low = 2, high = 4.
Iteration 4:
arr[low] is 0.
Increment low.
low = 3, high = 4.
Iteration 5:
arr[low] is 1.
Swap arr[low] with arr[high].
Array becomes: 0,0,0,1,1,1
Decrement high.
low = 3, high = 3.
Termination:
Now low is no longer less than high (low = high), so the loop terminates.
The final array is: 0,0,0,1,1,1

Summary:
The algorithm effectively partitions the array into two segments by swapping elements to ensure all 0s are on the left and all 1s are on the right, using a two-pointer technique. This approach ensures an in-place solution with a time complexity of O(n).

 */

JAVA SOLUTION CODE:

class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int low = 0;
        int high = arr.length-1;
        
        while(low<high){
            if(arr[low]==0){
                low++;
            }
           else {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
