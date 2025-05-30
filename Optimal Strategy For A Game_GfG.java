/*
You are given an array arr of size n. The elements of the array represent n coin of values v1, v2, ....vn. You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
You need to determine the maximum possible amount of money you can win if you go first.
Note: Both the players are playing optimally.

Example 1:

Input:
n = 4
arr[] = {5, 3, 7, 10}
Output: 
15
Explanation: The user collects maximum
value as 15(10 + 5). It is guarantee that we cannot get more than 15 by any possible moves.
Example 2:

Input:
n = 4
arr[] = {8, 15, 3, 7}
Output: 
22
Explanation: The user collects maximum
value as 22(7 + 15). It is guarantee that we cannot get more than 22 by any possible moves.
Your Task:
Complete the function maximumAmount() which takes an array arr[] (represent values of n coins) and n as a number of coins as a parameter and returns the maximum possible amount of money you can win if you go first.

Expected Time Complexity : O(n*n)
Expected Auxiliary Space: O(n*n)

Constraints:
2 <= n <= 103
1 <= arr[i] <= 106
*/

===========================================================================================================================================================================================================================
===========================================================================================================================================================================================================================
  class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
         int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i=0; i<n; i++){
            sum[i+1] = arr[i] + sum[i];
        }
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = arr[i];
        }
        for(int d=1; d<n; d++){
            for(int r=0; r<n-d; r++){
                int c = d+r;
                //option 1
                //take arr[c]
                //sum from r to c-1 inclusive = sum till c-1 - sum till r-1
                // = sum[c] - sum[r]
                dp[r][c] = arr[c] + (sum[c] - sum[r]) - dp[r][c-1];
                //option 2
                //take arr[r]
                //sum from r+1 to c inclusive = sum till c - sum till r
                // = sum[c+1] - sum[r+1];
                dp[r][c] = Math.max(dp[r][c], arr[r] + (sum[c+1] - sum[r+1]) - dp[r+1][c]);
            }
        }
        return dp[0][n-1];
    }
}
