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
          int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark i-th row:
                    matrix.get(i).set(0, 0);

                    // mark j-th column:
                    if (j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    // check for col & row:
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }
}
