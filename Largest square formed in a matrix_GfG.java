Given a binary matrix mat of size n * m, find out the maximum length of a side of a square sub-matrix with all 1s.

Examples:

Input: n = 6, m = 5
mat = [[0, 1, 1, 0, 1], 
       [1, 1, 0, 1, 0],
       [0, 1, 1, 1, 0],
       [1, 1, 1, 1, 0],
       [1, 1, 1, 1, 1],
       [0, 0, 0, 0, 0]]
Output: 3
Explanation: 

The maximum length of a side of the square sub-matrix is 3 where every element is 1.
Input: n = 2, m = 2
mat = [[1, 1], 
       [1, 1]]
Output: 2
Explanation: The maximum length of a side of the square sub-matrix is 2. The matrix itself is the maximum sized sub-matrix in this case.
Input: n = 2, m = 2
mat = [[0, 0], 
       [0, 0]]
Output: 0
Explanation: There is no 1 in the matrix.
Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
0 ≤ mat[i][j] ≤ 1 






Scene: The Quest for the Largest Power-Up Square
Imagine a world where the characters are on a quest to find the largest power-up square in a grid. Each cell in the grid has either a power-up (represented by a 1) or is empty (represented by a 0). The goal is to find the largest square area filled entirely with power-ups.

Characters and Setting:
- Grid (mat[][]): This is the battlefield where our characters are searching for power-ups.
- Characters (i, j): These are our heroes, moving through the battlefield, checking each cell for power-ups.
- Power Level (ans): This represents the size of the largest square filled with power-ups found so far.

Plot Summary:
1. Initialization:
   - Our heroes start their journey with a power level of 0 (int ans = 0).

2. First Row and First Column:
   - As they explore the battlefield, they check the first row and first column. Since there are no previous rows or columns to compare, they simply take note of any power-ups they find (if(i == 0 || j == 0)).

3. Exploring the Grid:
   - As they move further into the grid, they start comparing the current cell with its neighbors:
     - The cell above (mat[i-1][j])
     - The cell to the left (mat[i][j-1])
     - The diagonal cell above-left (mat[i-1][j-1])
   - If the current cell has a power-up (mat[i][j] != 0), they calculate the minimum value of the three neighbors and add it to the current cell. This helps in determining the size of the square ending at the current cell (mat[i][j] += Math.min(mat[i-1][j], Math.min(mat[i-1][j-1], mat[i][j-1]))).
   - They then update their power level if the current square is larger than any they have found so far (ans = Math.max(ans, mat[i][j])).

4. Final Power Level:
   - After exploring the entire battlefield, the heroes return their final power level (`return ans`), which represents the size of the largest square of power-ups they found.

 

Code Explanation:

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int ans = 0;  // Initialize the maximum size of the square

        // Traverse the entire matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    // If we are at the first row or first column, take the value as it is
                    ans = Math.max(ans, mat[i][j]);
                } else if (mat[i][j] != 0) {
                    // If the current cell is not zero, update it with the size of the square it can form
                    mat[i][j] += Math.min(mat[i-1][j], Math.min(mat[i-1][j-1], mat[i][j-1]));
                    ans = Math.max(ans, mat[i][j]);  // Update the answer with the maximum size found
                }
            }
        }
        return ans;  // Return the maximum size of the square
    }
}
