/*Sam is researching on Alpha-Triangles. So, he needs to create them for different integers ‘N’.

An Alpha-Triangle is represented by the triangular pattern of alphabets in reverse order.

For every value of ‘N’, help sam to print the corresponding Alpha-Triangle.

Example:
Input: ‘N’ = 3

Output: 
C
C B 
C B A */

=====================================================================================================================================================
=====================================================================================================================================================
  public class Solution {
    public static void alphaTriangle(int n) {
        // Write your code here
       for (int i = 0; i < n; i++) {
            // Start from the last character 'C' and move backwards in the alphabet
            char startChar = (char) ('A' + n - 1);
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (startChar - j) + " ");
            }
            System.out.println();
        }
    }
}
