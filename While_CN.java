/*Problem statement
Write a program to input an integer 'n' and print the sum of all its even digits and the sum of all its odd digits separately.
Digits mean numbers, not places! That is, if the given integer is "132456", even digits are 2, 4, and 6, and odd digits are 1, 3, and 5.

Constraints
0<= 'n' <=10000


Example :
Input: 'n' = 132456

Output: 12 9

Explanation:
The sum of even digits = 2 + 4 + 6 = 12
The sum of odd digits = 1 + 3 + 5 = 9
Constraints
0<= 'n' <=10000


Example :
Input: 'n' = 132456

Output: 12 9

Explanation:
The sum of even digits = 2 + 4 + 6 = 12
The sum of odd digits = 1 + 3 + 5 = 9
Input format :
 The first line contains an integer 'n'.
Output format :
In a single line, print two space-separated integers, first the sum of even digits and then the sum of odd digits.*/


\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here
Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int evenSum = 0;
        int oddSum = 0;

      
        while (n > 0) {
            int rem = n % 10; // get the last digit
            if (rem % 2 == 0) {
                evenSum += rem; // add to even sum if the digit is even
            } else {
                oddSum += rem; // add to odd sum if the digit is odd
            }
            n /= 10; // remove the last digit to process the next digit
        }

        // print the sum of even and odd digits
        System.out.println(evenSum + " " + oddSum);
	}
}
