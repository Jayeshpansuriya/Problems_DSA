/*Problem statement
Sam is making a forest visualizer. An N-dimensional forest is represented by the pattern of size NxN filled with ‘*’.

For every value of ‘N’, help sam to print the corresponding N-dimensional forest.

Example:
Input: ‘N’ = 3

Output: 
* * *
* * *
* * *
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1  <= N <= 25
Time Limit: 1 sec
Sample Input 1:
3
Sample Output 1:
* * *
* * *
* * *
Explanation Of Sample Input 1 :
For N = 3, fill all the rows and columns in 3x3 matrix with ‘*’.
Sample Input 2 :
1
Sample Output 2 :
*
Sample Input 3 :
4
Sample Output 3 :
* * * *
* * * *
* * * *
* * * *


*/



=======================================================================================================================================================
================================================================================================================================================================================
====================================================================================================================================================================================
public class Solution {
    public static void nForest(int n) {
        // Write your code 
     for (int i = 0; i < n; i++)
    {
        
        for (int j = 0; j < n; j++)
        {
            System.out.print("* ");
        }

        
        System.out.println();

    }

    }
}
