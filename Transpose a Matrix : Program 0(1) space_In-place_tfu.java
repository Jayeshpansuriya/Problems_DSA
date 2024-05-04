/*
Transpose a Matrix : Program 0(1) space


1

0
Problem statement: Transpose a Matrix.

Given a matrix, your task is to find its transpose of the given matrix.

Transpose: The transpose of a matrix means, interchanging its rows into columns or columns into rows.

Examples:

Example 1:
Input:      {{4,5,6},
             {7,8,9},
             {10,11,12}}
Output: 
              4 7 10 
              5 8 11 
              6 9 12 

Explanation: The 1st row i.e 4,5,6 and 1st column i.e 4,7,10 
are interchanged in the same way other rows and columns 
will also interchange their values.

Example 2:
Input:   {{1,2,3}
          {4,5,6},
          {7,8,9},
          {10,11,12}}
Output:
        1 4 7 10 
        2 5 8 11 
        3 6 9 12 
*/

=======================================================================================================================================================
/*  Solution 2: In-place
Intuition:

From the definition of transpose it is known that transposing of a matrix is interchanging the rows and columns, so to achieve this, we can directly interchange elements without using extra space.

Approach:

Traverse through the entire matrix
Swap row and corresponding column elements



  */


  public class TransposeOfMatrix {
    public static void main(String[] args) {

        //matrix initialization
        int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        int m = matrix.length;
        int n = matrix[0].length;

      transpose(matrix,m,n);

        //printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void transpose(int[][] matrix,int m,int n) {

                for (int i=0;i<n;i++){
                    for (int j=i+1;j<m;j++){
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                    }
                }

    }
}



/*
Time complexity: O(n*m) for traversing

Space complexity: O(1)
*/
