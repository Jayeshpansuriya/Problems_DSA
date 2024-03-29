/*Problem statement
Aryan and his friends are very fond of patterns. For a given integer ‘N’, they want to make the Reverse Letter Triangle.

You must print a matrix corresponding to the given Reverse Letter Triangle.

Example:
Input: ‘N’ = 3

Output: 

A B C
A B
A
*/ 
================================================================================================================================================================
  ================================================================================================================================================================
  public class Solution {
    public static void nLetterTriangle(int n) {
        // Write your code here
       for(int i=0;i<n;i++){
          
          // Inner loop will loop for i times and
          // print alphabets from A to A + (N-i-1).
          for(char ch = 'A'; ch<='A'+(n-i-1);ch++){
              System.out.print(ch + " ");
              
          }
          // As soon as the letters for each iteration are printed, we move to the
          // next row and give a line break otherwise all letters
          // would get printed in 1 line.
          System.out.println();
        }
    }
}
