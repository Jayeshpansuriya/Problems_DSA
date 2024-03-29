/*
Problem statement
Sam is curious about Alpha-Ramp, so he decided to create Alpha-Ramp of different sizes.

An Alpha-Ramp is represented by a triangle, where alphabets are filled from the top in order.

For every value of ‘N’, help sam to return the corresponding Alpha-Ramp.

Example:
Input: ‘N’ = 3

Output: 
A
B B
C C C
*/
====================================================================================================================
  =================================================================================================================
  public class Solution {
    public static void alphaRamp(int n) {
        // Write your code here
         for(int i=0;i<n;i++){
          
          
          for(int j=0;j<=i;j++){
              
              // same char which is defined 
              // is to be printed i times in that row.
              System.out.print((char)((int)('A'+i)) + " ");
              
          }
          // As soon as the letters for each iteration are printed, we move to the
          // next row and give a line break otherwise all letters
          // would get printed in 1 line.
          System.out.println();
         } 
    }
}
