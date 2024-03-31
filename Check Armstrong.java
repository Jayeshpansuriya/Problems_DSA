/* 
Problem statement
You are given an integer 'n'.



Return 'true' if 'n' is an Armstrong number, and 'false' otherwise.



Note:
An Armstrong number is a number (with 'k' digits) such that the sum of its digits raised to 'kth' power is equal to the number itself. For example, 371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371.
Example:
Input: 'n' = 1634

Output: true

Explanation:
1634 is an Armstrong number, as 1^4 + 6^4 + 3^4 + 4^4 = 1634


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1


Sample Output 1 :
true


Explanation of Sample Input 1 :
1 is an Armstrong number as, 1^1 = 1.


Sample Input 2 :
103


Sample Output 2 :
false


Expected Time Complexity:
Try to solve this in O(log(n)). 


Constraints:
1 <= ‘n’ <= 10^9

Time Limit: 1 sec

*/

===============================================================================================================================================================================================================================
===============================================================================================================================================================================================================================

import java.util.*;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here
int sum=0;
Scanner sc= new Scanner(System.in);
int n=sc.nextInt();
int dup=n;
while( n!=0){
		int lastDigit=n%10;
		sum=sum+(lastDigit*lastDigit*lastDigit);
		n=n/10;
		
}
if(sum==dup){
	System.out.println("true");
}else{
	System.out.println("false");
}
	}
}
==================================================================================================================================================================
======================================================================================================================================================================
import java.util.*;
class TUF{
static boolean ArmstrongNumber(int n)
{
    int originalno = n;
    int count = 0;
    int temp = n;
    while (temp != 0)
    {
        count++;
        temp = temp / 10;
    }
    int sumofpower = 0;
    while (n != 0)
    {
        int digit = n % 10;
        sumofpower += Math.pow(digit,count);
        n /= 10;
    }
    return (sumofpower == originalno);
}
public static void main(String args[])
{
    int n1 = 153;
    if (ArmstrongNumber(n1))
    {
        System.out.println("Yes, it is an Armstrong Number\n");
    }
    else
    {
        System.out.println("No, it is not an Armstrong Number\n");
    }
    
}
}

