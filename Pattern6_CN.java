/*Problem statement
Aryan and his friends are very fond of the pattern. For a given integer ‘N’, they want to make the Reverse N-Number Triangle.

Example:
Input: ‘N’ = 3

Output: 

1 2 3
1 2
1
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1  <= N <= 20
Time Limit: 1 sec
Sample Input 1:
3
Sample Output 1:
1 2 3
1 2
1
Sample Input 2 :
4
Sample Output 2 :
1 2 3 4
1 2 3
1 2
1
Sample Input 3 :
7
Sample Output 3 :
1 2 3 4 5 6 7
1 2 3 4 5 6
1 2 3 4 5 
1 2 3 4
1 2 3
1 2
1


  */

===================================================================================================================================================================
  public class Solution {
    public static void nNumberTriangle(int n) {
        // Write your code here
         for (int i = 0; i < n; i++)
    {
        // This is the inner loop which loops for the columns
        // no. of columns = (N - row index) for each line here
        // as we have to print an inverted pyramid.
        // (N-j) will give us the numbers in a row starting from 1 to N-i.
        for (int j = n; j > i; j--)
        {
            System.out.print(n-j+1+" ");
        }

         // As soon as numbers for each iteration are printed, we move to the
        // next row and give a line break otherwise all numbers
        // would get printed in 1 line.
        System.out.println();
    }
    }
}
  
