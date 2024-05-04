/*

Problem statement
You are given a matrix 'MATRIX' of dimension 'N' x 'M'. Your task is to make all the elements of row 'i' and column 'j' equal to 0 if any element in the ith row or jth column of the matrix is 0.

Note:

1) The number of rows should be at least 1.

2) The number of columns should be at least 1.

3) For example, refer to the below matrix illustration: 

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 100
1 <= M <= 100
-10^9 <= MATRIX[i][j] <= 10^9

Where 'MATRIX[i][j]' denotes the matrix element.
Follow Up:

Can you solve it with the space complexity of O(1)?

Time limit: 1 sec


Sample Input 1:
2 3
2 4 3
1 0 0
Sample Output 1:
2 0 0 
0 0 0 
Sample Input 2:
1 1 
5
Sample Output 2:
5 


Hints:
1. Think about how to identify the rows and columns containing a '0' element and then modify the matrix accordingly to make all elements in those rows and columns equal to 0.
2. You can use the first row and first column of the matrix itself as indicators to mark whether a particular row or column needs to be zeroed
*/


import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
    	// Write your code here.
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }
}
