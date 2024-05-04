/*
Rotate Matrix anti-clockwise by 90 degree


0

0
Problem statement: Given a matrix, your task is to rotate matrix anti-clockwise by 90 degrees.

Examples:

Example 1:
Input:   {{1,2,3},
          {4,5,6},
          {7,8,9}}
Output:
        3 6 9 
        2 5 8 
        1 4 7 
Explanation: Rotate the matrix anti-clockwise by 90 degrees and return it.

Example 2:
Input:    {{1,2,3,4},   
           {5,6,7,8},   
           {9,10,11,12},  
           {13,14,15,16}}
Output:
        4 8 12 16 
        3 7 11 15 
        2 6 10 14 
        1 5 9 13 
Explanation: Rotate the matrix anti-clockwise by 90 degrees and return it.
*/


================================================================================================

  /*
Solution 2: Optimized approach
Intuition:
We can see that the first column is the reverse of the first row, so that’s why we can find the transpose of the matrix and reverse each column.

Approach:
Find the transpose of the matrix.
Reverse every column of the matrix.
  */

  public class jd {
    private static void rotate(int[][] matrix) {
         int n = matrix.length;
 
        /* Finding transpose*/
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
 
        /* Reverse every column */
        int ind = n-1;
        for (int i=0;i<n;i++){
            for (int j=0;j<n/2;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[ind][i];
                matrix[ind][i] = temp;
                ind--;
            }
            ind = n-1;
        }

         //Printing array after rotation
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
 
 
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int n = matrix.length;
 
        rotate(matrix);
 
    }
}


/*
Time complexity: O(n*n) +O(n*n), for transpose and reversing.

Space complexity: O(1) as we are not using any extra space.
*/
