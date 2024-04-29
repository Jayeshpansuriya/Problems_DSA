/*
Find the Majority Element that occurs more than N/2 times


27

0
Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

Examples
Example 1:
Input Format
: N = 3, nums[] = {3,2,3}
Result
: 3
Explanation
: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

Example 2:
Input Format:
  N = 7, nums[] = {2,2,1,1,1,2,2}

Result
: 2

Explanation
: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Example 3:
Input Format:
  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}

Result
: 4
*/
=======================================================================================================================================
  /*
cccc
Approach:
The steps are as follows:

We will run a loop that will select the elements of the array one by one.
Now, for each element, we will run another loop and count its occurrence in the given array.
If any element occurs more than the floor of (N/2), we will simply return it.

Time Complexity: O(N2), where N = size of the given array. Reason: For every element of the array the inner loop runs for N times. And there are N elements in the array. So, the total time complexity is O(N2). Space Complexity: O(1) as we use no extra space.
  */

  


import java.util.*;

public class jd {
    public static int majorityElement(int []v) {
        //size of the given array:
        int n = v.length;

        for (int i = 0; i < n; i++) {
            //selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (v[j] == v[i]) {
                    cnt++;
                }
            }

            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return v[i];
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);

    }

} 


