/* 
Problem statement
You are given an integer ’n’.



Your task is to return a sorted array (in increasing order) containing all the factorial numbers which are less than or equal to ‘n’.



The factorial number is a factorial of a positive integer, like 24 is a factorial number, as it is a factorial of 4.



Note:
In the output, you will see the array returned by you.
Example:
Input: ‘n’ = 7

Output: 1 2 6

Explanation: Factorial numbers less than or equal to ‘7’ are ‘1’, ‘2’, and ‘6’.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7
Sample Output 1 :
1 2 6
Explanation Of Sample Input 1:
Input: ‘n’ = 7

Output: 1 2 6

Explanation: Factorial numbers less than or equal to ‘7’ are ‘1’, ‘2’, and ‘6’.
Sample Input 2:
2
Sample Output 2:
1 2
Explanation Of Sample Input 2:
Input: ‘n’ = 2

Output: 1 2

Explanation: Factorial numbers less than or equal to ‘2’ are ‘1’ and ‘2’.
Expected Time Complexity:
The expected time complexity is O(m), where ‘m’ is the number of factorial numbers which are less than or equal to ‘n’.
Expected Space Complexity:
The expected space complexity is O(m), where ‘m’ is the number of factorial numbers which are less than or equal to ‘n’.
Constraints:
1 <= n <= 10^18

Time Limit: 1-sec

*/
==========================================================================================================================
=============================================================================================================================
  import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Long> factorialNumbers(long n) {
        List<Long> factorials = new ArrayList<>();
        long factorial = 1;
        int i = 1;

        // Add the first factorial number, which is 1
        factorials.add(factorial);

        // Calculate factorials and add them to the list until they exceed 'n'
        while (factorial <= n) {
            i++;
            factorial *= i;
            if (factorial <= n) {
                factorials.add(factorial);
            }
        }

        return factorials;
    }
}
