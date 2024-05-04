

/*
Rotate Image by 90 degree


20

1
Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.

Note: Rotate matrix 90 degrees anticlockwise

Examples
Example 1:
Input:
 [[1,2,3],[4,5,6],[7,8,9]]

Output
: [[7,4,1],[8,5,2],[9,6,3]]

Explanation:
 Rotate the matrix simply by 90 degree clockwise and return the matrix.

Example 2:
Input:
 [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

Output:
[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Explanation:
 Rotate the matrix simply by 90 degree clockwise and return the matrix
*/
=======================================================================================================================================================
/*
Intuition: By observation, we see that the first column of the original matrix is the reverse of the first row of the rotated matrix, so that’s why we transpose the matrix and then reverse each row, and since we are making changes in the matrix itself space complexity gets reduced to O(1).

Approach:

Step 1: Transpose the matrix. (transposing means changing columns to rows and rows to columns)

Step 2: Reverse each row of the matrix.
*/

=====================================================================================================================================================

  
import java.util.*;
class TUF {
    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*
Time Complexity: O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix.

Space Complexity: O(1).
*/
  
