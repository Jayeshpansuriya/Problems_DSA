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

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

  /*
Solution 1: Brute force
Intuition:

By observing the question it is clear that the elements at 1st row are interchanged with 1st column, and the elements at 2nd row are interchanged with the 2nd column and so on…which means the element at index 0,1 is interchanging with the elements at the index 1,0 and 0,2  is interchanging with 2,0 and so on…, So to achieve this we can use another matrix to store its corresponding values.

Approach:

Create a new matrix(say temp) to store new values.
Transverse through the entire matrix and while traversing interchange the rows and columns.


  */
  public class TransposeOfMatrix {
    public static void main(String[] args) {

        // matrix initialization
        int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        int m = matrix.length;
        int n = matrix[0].length;

        int temp[][] = transpose(matrix,m,n);

        // printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transpose(int[][] matrix,int m,int n) {

        // creating new matrix to store transpose
        /* Creating temp matrix of size [n][m] so 
           that it will work for rectangle matrix also*/
        int temp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = matrix[j][i];
            }
        }

        return temp;
    }
}


/*
Time complexity: O(n*m) for traversing

Space complexity: O(n*m) for new matrix
*/
