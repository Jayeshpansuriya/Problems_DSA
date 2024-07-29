/*
Given a boolean 2D array, consisting of only 1's and 0's, where each row is sorted. Return the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.

Examples:

Input: arr[][] = [[0, 1, 1, 1],
               [0, 0, 1, 1],
               [1, 1, 1, 1],
               [0, 0, 0, 0]]
Output: 2
Explanation: Row 2 contains 4 1's (0-based indexing).
Input: arr[][] = [[0, 0], 
               [1, 1]]
Output: 1
Explanation: Row 1 contains 2 1's (0-based indexing).
Expected Time Complexity: O(n+m)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ number of rows, number of columns ≤ 103
0 ≤ arr[i][j] ≤ 1 


*/

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j][i]==1)
                return j;
            }
        }
        return -1;
    }
}
/*Explanation:
This code attempts to find the first row in a 2D binary matrix that contains the maximum number of 1s. The approach involves checking each column for a 1 and returning the row index of the first 1 encountered.

Outer Loop:

Iterate over each column (i from 0 to the number of columns).
Inner Loop:

For each column, iterate over each row (j from 0 to the number of rows).
Check if the current element (arr[j][i]) is 1.
If a 1 is found, return the row index j.
Return:

If no 1 is found in any column, return -1.
This approach ensures that the first row with a 1 is returned, but it may not always return the row with the maximum number of 1s. It has a time complexity of O(n * m) where n is the number of rows and m is the number of columns.
*/
