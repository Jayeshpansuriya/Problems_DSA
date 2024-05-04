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


============================================================================================================================================

  /*
Solution 1: Brute force

Intuition & Approach: Take one temporary matrix of size n*n and replace the elements accordingly.

For example:

Let's consider matrix [1,2,3] , [4,5,6],[7,8,9] and its output is  

  [3 ,6 ,9] ,[2 ,5 ,8],  [1, 4, 7 ],         

So by observing it is clear that:

Element at index 0,0 is replaced by the element at index 0,2
Element at index 0,1 is replaced by the element at index 1,2
Element at index 0,2 is replaced by the element at index 2,2
Element at index 1,0 is replaced by the element at index 0,1
Element at index 1,1 is replaced by the element at index 1,1
Element at index 1,2 is replaced by the element at index 2,1
Element at index 2,0 is replaced by the element at index 0,0
Element at index 2,1 is replaced by the element at index 1,0
Element at index 2,2 is replaced by the element at index 2,0
  */

  public class jd {
  private static void rotate(int[][] matrix) {
    int n = matrix.length;

    //Creating new matrix to store rotated values
    int temp[][] = new int[n][n];

    int ind = n - 1;
    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n; j++) {
        temp[i][j] = matrix[j][ind];
      }
      ind--;
    }
    //Printing array after rotation
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(temp[i][j] + " ");
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
Time complexity: O(n*n) for traversing in matrix

Space complexity: O(n*n) for temporary matrix
*/
