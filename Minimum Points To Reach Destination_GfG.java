/*
Given a m*n grid with each cell consisting of positive, negative, or zero point. We can move across a cell only if we have positive points. Whenever we pass through a cell, points in that cell are added to our overall points, the task is to find minimum initial points to reach cell (m-1, n-1) from (0, 0) by following these certain set of rules :
1. From a cell (i, j) we can move to (i + 1, j) or (i, j + 1).
2. We cannot move from (i, j) if your overall points at (i, j) are <= 0.
3. We have to reach at (n-1, m-1) with minimum positive points i.e., > 0.

Example 1:

Input: 
m = 3, n = 3 
points = {{-2,-3,3}, 
          {-5,-10,1},
          {10,30,-5}} 
Output: 
7 
Explanation: 7 is the minimum value to reach the destination with positive throughout the path. Below is the path. (0,0) -> (0,1) -> (0,2) -> (1, 2) -> (2, 2) We start from (0, 0) with 7, we reach (0, 1) with 5, (0, 2) with 2, (1, 2) with 5, (2, 2) with and finally we have 1 point (we needed greater than 0 points at the end).
Example 2:
Input:
m = 3, n = 2
points = {{2,3},  
          {5,10},  
          {10,30}} 
Output: 
1 
Explanation: Take any path, all of them are positive. So, required one point at the start
Your Task:  
You don't need to read input or print anything. Complete the function minPoints() which takes m,n and 2-d vector points as input parameters and returns the minimum initial points to reach cell (m-1, n-1) from (0, 0).

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)

Constraints:
1 ≤ m ≤ 103  
1 ≤ n ≤ 103
-103 ≤ points[i][j] ≤ 103
*/

=================================================================================================================================================
====================================================================================================================================================
  class Solution {
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
    //   if(a[m-1][n-1]>0)
    //      a[m-1][n-1]=0;
      
    //   for(int i=n-2;i>=0;i--){
    //       a[m-1][i]+=a[m-1][i+1];
    //       if(a[m-1][i]>0){
    //           a[m-1][i]=0;
    //       }
    //   }
       
    //   for(int i=m-2;i>=0;i--){
    //       a[i][n-1]+=a[i+1][n-1];
    //       if(a[i][n-1]>0){
    //           a[i][n-1]=0;
    //       }
    //   }
       
    //   for(int i=m-2;i>0;i--){
    //       for(int j=n-2;j>=0;j--){
    //           a[i][j]+=Math.max(a[i+1],a[i][j+1]);
    //           if(a[i][j]>0)
    //           a[i][j]=0;
    //       }
    //   }
    //   return Math.abs(a[0][0]+1);
     int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - points[m - 1][n - 1]);
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - points[i][n - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - points[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - points[i][j]);
            }
        }
        return dp[0][0];
    }
}
