/* Problem statement
Aryan and his friends are very fond of the pattern. They want to make the Reverse N-Number Crown for a given integer' N'.

Given 'N', print the corresponding pattern.

Example:
Input: ‘N’ = 3

Output: 

1         1
1 2     2 1
1 2 3 3 2 1   */
==================================================================================================================================
  ================================================================================================================================
  public class Solution {
    public static void numberCrown(int n) {
        // Write your code here.
         int spaces = 2*(n-1);
     
      // Outer loop for the number of rows.
      for(int i=1;i<=n;i++){
          
          // for printing numbers in each row
          for(int j=1;j<=i;j++){
          System.out.print(j+" ");
          }
          
          // for printing spaces in each row
          for(int j = 1;j<=spaces;j++){
          System.out.print(" ");
          }
          
          // for printing numbers in each row
          for(int j=i;j>=1;j--){
           System.out.print(j+ " ");
          }
          
          // As soon as the numbers for each iteration are printed, we move to the
          // next row and give a line break otherwise all numbers
          // would get printed in 1 line.
          System.out.println();
          
          // After each iteration nos. increase by 2, thus
          // spaces will decrement by 2.
          spaces-=2;
      }
    }
    
}
