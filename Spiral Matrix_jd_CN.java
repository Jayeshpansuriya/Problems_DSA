/*
Problem statement
You are given a 2D matrix ‘MATRIX’ of ‘N’*’M’ dimension. You have to return the spiral traversal of the matrix.

Example:

Input:
MATRIX = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60] ]
Output:
1 3 5 7 20 60 34 30 23 10 11 16

Explanation: Starting from the element in the first row and the first column, traverse from left to right (1 3 5 7), then top to bottom (20 60), then right to left (34 30 23), then bottom to up (10) and then left to right (11 16).
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N, M <= 10^5
1 <= MATRIX [ i ] [ j ] <= 10^9
The sum of N*M over all test cases is less than 2*10^5.
Time Limit: 1 sec
Sample Input 1:
3 3
1 3 7
10 12 15
19 20 21
Sample Output 1:
1 3 7 15 21 20 19 10 12
Explanation Of Sample Input 1:
Input:
MATRIX = [ [1, 3, 7], [10, 12, 15], [19, 20, 21] ], 
Output:
1 3 7 15 21 20 19 10 12

Explanation: Starting from the element in the first row and the first column, traverse from left to right (1 3 7), then top to bottom (15 21), then right to the left (20 19), then bottom to up (10) and then left to right (12).
Sample Input 2:
4 4
1 5 9 13
14 15 16 17
19 20 21 50
59 60 71 80
Sample Output 2:
1 5 9 13 17 50 80 71 60 59 19 14 15 16 21 20
*/

=====================================================================================================================================
  import java.util.*;

public class Solution {
    public static int[] spiralMatrix(int[][] MATRIX) {
        int rows = MATRIX.length;
        int cols = MATRIX[0].length;
        int[] result = new int[rows * cols];

        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int idx = 0;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                result[idx++] = MATRIX[top][i];
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result[idx++] = MATRIX[i][right];
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[idx++] = MATRIX[bottom][i];
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[idx++] = MATRIX[i][left];
                }
                left++;
            }
        }

        return result;
    }

    // public static void main(String[] args) {
    //     int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    //     int[] result1 = spiralMatrix(matrix1);
    //     System.out.println(Arrays.toString(result1)); // Output: [1, 3, 5, 7, 20, 60, 34, 30, 23, 10, 11, 16]

    //     int[][] matrix2 = {{1, 5, 9, 13}, {14, 15, 16, 17}, {19, 20, 21, 50}, {59, 60, 71, 80}};
    //     int[] result2 = spiralMatrix(matrix2);
    //     System.out.println(Arrays.toString(result2)); // Output: [1, 5, 9, 13, 17, 50, 80, 71, 60, 59, 19, 14, 15, 16, 21, 20]
    // }
}
