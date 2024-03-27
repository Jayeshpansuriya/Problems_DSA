/*Problem statement
Functions - Take this coding challenge to test your coding skills to



-define a function

-pass arguments by value to a function

-pass arguments by reference to a function



This coding challenge is organized in the following way:



First line of input reads an integer to select the coding challenge:



-Reading value '1' selects the coding-challenge 1 ( tests the ability to define a function and pass arguments by value.)



-Reading value '2' selects the coding challenge 2 (tests the ability to pass arguments by reference to a function)



Coding Challenge -1

Define a function named "Maximum" that accepts two integers (pass by value) as arguments and returns the greatest of the two arguments.



Coding Challenge -2

Define a function named "Swap" that accepts two integers (pass by reference) as arguments and swaps their value.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
1
2 3


Sample Output 1:
3


Explanation of sample input 1 :
The maximum of 2 and 3 is 3.


Sample Input 2:
2
4 5


Sample Output 2:
5 4


Explanation of sample input 2 :
The values 4 and 5 are swapped.


Expected time complexity :
The expected time complexity is O(1).


Constraints :
1 <= 'test' <= 2
0 <= 'a', 'b' <= 10^9

Time limit: 1 second*/
=============================================================================================================================================
  #include <iostream>
using namespace std;
int Maximum(int x, int y)
{
	// Write your code here.
	return (x > y) ? x : y;
}
void Swap(int &x, int &y)
{
	// Write your code here.
	int temp = x;
	x = y;
	y = temp;

}
int main()
{
	int test, a, b, r;
	cin >> test;
	cin >> a >> b;
	switch (test)
	{
	case 1:
		r = Maximum(a, b);
		cout << r;
		break;
	case 2:
		Swap(a, b);
		cout << a << " " << b;
		break;
	default:
		cout << "Invalid test option";
	}
	return 0;
}
