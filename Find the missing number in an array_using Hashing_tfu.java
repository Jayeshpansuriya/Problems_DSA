/*


Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

Examples
Example 1:
Input Format:
 N = 5, array[] = {1,2,4,5}
Result:
 3
Explanation: 
In the given array, number 3 is missing. So, 3 is the answer.

Example 2:
Input Format:
 N = 3, array[] = {1,3}
Result:
 2
Explanation: 
In the given array, number 2 is missing. So, 2 is the answer.

*/
==========================================================================================================================================================================================
  /*Better Approach (using Hashing):
Intuition:
Using the hashing technique, we will store the frequency of each element of the given array. Now, the number( i.e. between 1 to N) for which the frequency will be 0, will be returned

Approach:
The algorithm steps are as follows:

The range of the number is 1 to N. So, we need a hash array of size N+1 (as we want to store the frequency of N as well).
Now, for each element in the given array, we will store the frequency in the hash array.
After that, for each number between 1 to N, we will check the frequencies. And for any number, if the frequency is 0, we will return it.
Dry run:

Assume the given array = {1,3} and N = 3. The hash array will look like the following:


We can clearly see that for index 2 the frequency is 0 and so 2 is our answer.


Time Complexity: O(N) + O(N) ~ O(2*N),  where N = size of the array+1.
Reason: For storing the frequencies in the hash array, the program takes O(N) time complexity and for checking the frequencies in the second step again O(N) is required. So, the total time complexity is O(N) + O(N).

Space Complexity: O(N), where N = size of the array+1. Here we are using an extra hash array of size N+1.
  */

  


import java.util.*;

public class jd {
    public static int missingNumber(int []a, int N) {

        int hash[] = new int[N + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i < N - 1; i++)
            hash[a[i]]++;

        //checking the freqencies for numbers 1 to N:
        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        // The following line will never execute.
        // It is just to avoid warnings.
        return -1;
    }

    public static void main(String args[]) {
        int N = 5;
        int a[] = {1, 2, 4, 5};

        int ans = missingNumber(a, N);
        System.out.println("The missing number is: " + ans);
    }

}

