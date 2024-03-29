/*Problem statement
Ninja was very fond of patterns. For a given integer ‘N’, he wants to make the Reverse N-Star Triangle.

Example:
Input: ‘N’ = 3

Output: 

*****
 ***
  *

  */
=======================================================================================================================================================================================================================================
=======================================================================================================================================================================================================================================
  public class Solution {
    public static void nStarTriangle(int n) {
        // Write your code here
        for( int i=0;i<n;i++){

            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<2*n-(2*i+1);j++){
               System.out.print("*");
            }

            for(int j=0; j<i; j++){
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
