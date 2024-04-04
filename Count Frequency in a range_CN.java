/*
Problem statement
You are given an array 'arr' of length 'n' containing integers within the range '1' to 'x'.



Your task is to count the frequency of all elements from 1 to n.

Note:
You do not need to print anything. Return a frequency array as an array in the function such that index 0 represents the frequency of 1, index 1 represents the frequency of 2, and so on.
Example:
Input: ‘n’ = 6 ‘x’ = 9 ‘arr’ = [1, 3, 1, 9, 2, 7]    
Output: [2, 1, 1, 0, 0, 0]
Explanation: Below Table shows the number and their counts, respectively, in the array
Number         Count 
 1                2
 2              1
 3                1
 4                0
 5                0
 6                0
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6 4
1 3 4 3 4 1
Sample Output 1:
2 0 2 2 0 0
Explanation Of Sample Input 1 :
Frequency table:
Number         Count 
 1                2
 2              0
 3                2
 4                2
 5                0
 6                0
Sample Input 2 :
5 5
1 2 3 4 5
Sample Output 2 :
1 1 1 1 1
Explanation Of Sample Input 2 :
Frequency table:
Number         Count 
 1                1
 2              1
 3                1
 4                1
 5                1
Constraints:
1  <= n <= 10^5
1  <= x <= 10^5
1 <= arr[i] <= x


Hints:
1. Since the range of the elements is known, we can iterate over the range.
2. Since the bounds of the elements are known, a frequency array can be maintained.
3. Try to use the input array as the answer array itself.
*/

==========================================================================================================================
==========================================================================================================================
  public class Solution {
    public static int[] countFrequency(int n, int x, int []nums){
        // Write your code here.
        int[] frequency = new int[n];
        
        // Iterate over the array and increment the frequency count
        for (int num : nums) {
            if (num <= n) {
                frequency[num - 1]++;
            }
        }
        
        return frequency;  
    
    }
}
