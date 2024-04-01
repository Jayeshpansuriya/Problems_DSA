/* 
Problem statement
You are given an integer ‘n’.



Your task is to return an array containing integers from 1 to ‘n’ (in increasing order) without using loops.



Example:
Input: ‘n’ = 5

Output: 1 2 3 4 5

Explanation: An array containing integers from ‘1’ to ‘n’ is [1, 2, 3, 4, 5].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
Sample Output 1 :
1 2 3 4 5
Explanation Of Sample Input 1:
The array contains all integers from 1 to 5 in ascending order.
Sample Input 2:
2
Sample Output 2:
1 2
Explanation Of Sample Input 2:
The array contains all integers from 1 to 2 in ascending order.
Expected Time Complexity:
The expected time complexity is O(n), where 'n' is the given integer.
Constraints:
1 <= n <= 10^6

Time Limit: 1-sec
*/


====================================================================================================================================================
====================================================================================================================================================
  import java.util.Scanner;
public class Solution {
   private static void fillArray(int[] arr, int index) {
        if (index == 0) return; // Base case
        fillArray(arr, index - 1); // Recursive call
        arr[index - 1] = index; // Set the value at the current index
    }

    public static int[] printNos(int n) {
        int[] arr = new int[n]; // Create an array of size n
        fillArray(arr, n); // Fill the array with numbers from 1 to n
        return arr; // Return the filled array
    }

    // Main method to test the code
    public static void main(String[] args) {
        int n = 5; // Example input
        int[] result = printNos(n);
        // Print the result (This will print the array in a single line)
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
