/* //Problem Statement: Given a number N reverse the number and print it.
Example 1:
Input: N = 123
Output: 321
Explanation: The reverse of 123 is 321

*/
================================================================================
================================================================================
  #include<stdio.h>

int main()
{
    int N = 123;
    int num = N;
    int reverse = 0;
    while(N!=0)
    {
        int digit = N%10;
        reverse = reverse*10+digit;
        N = N/10;
    }
    printf("The reverse of the %d is %d",num,reverse);
}
==========================================================================================
=========================================================================================
Approach:
Run a while loop until the given number N is equal to zero while(N!=0)
Initialize a variable reverse = 0;
now in each step take the remainder of the given number N and store it as a variable digit, digit = N % 10
Also, Divide the number by 10. N= N / 10
in each step, the variable reverse get updated as reverse = reverse*10+digit.
