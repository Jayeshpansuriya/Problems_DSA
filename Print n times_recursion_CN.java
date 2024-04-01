/*
Problem statement
You are given an integer ‘n’.



Print “Coding Ninjas ” ‘n’ times, without using a loop.



Example:
Input: ‘n’  = 4

Output:
Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas 

Explanation: “Coding Ninjas” is printed 4 times. 


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3


Sample Output 1:
Coding Ninjas Coding Ninjas Coding Ninjas 


Explanation of sample output 1:
“Coding Ninjas” is printed 3 times. 

Sample Input 2:
5


Sample Output 2:
Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas 


Expected Time Complexity:
Try to solve this in O(n).


Expected Space Complexity:
Try to solve this in O(n).


Constraints:
1 <= 'n' <= 10^4

Time Limit: 1 sec
*/

===========================================================================================================================
 ===========================================================================================================================
  import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Recursive method to add "Coding Ninjas" n times to a list
    public static List<String> printNtimes(int n) {
        List<String> result = new ArrayList<>();
        addNtimes(result, n); // Start the recursion with initial value of n
        return result;
    }

    // Helper method for recursion
    private static void addNtimes(List<String> list, int n) {
        if (n == 0) {
            return; // Base case: when n is 0, stop the recursion
        }
        list.add("Coding Ninjas "); // Add "Coding Ninjas" to the list
        addNtimes(list, n - 1); // Recursive call with decremented n
    }

    // Main method to test the code
    public static void main(String[] args) {
        int n = 4; // Example input
        List<String> output = printNtimes(n);
        // Print the result
        output.forEach(System.out::print);
    }
}
