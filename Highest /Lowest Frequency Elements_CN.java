/*
Problem statement
Given an array 'v' of 'n' numbers.



Your task is to find and return the highest and lowest frequency elements.


If there are multiple elements that have the highest frequency or lowest frequency, pick the smallest element.



Example:
Input: ‘n' = 6, 'v' = [1, 2, 3, 1, 1, 4]

Output: 1 2

Explanation: The element having the highest frequency is '1', and the frequency is 3. The elements with the lowest frequencies are '2', '3', and '4'. Since we need to pick the smallest element, we pick '2'. Hence we return [1, 2].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
1 2 3 1 1 4
Sample Output 1 :
1 2
Sample Explanation 1:
Input: ‘n' = 6, 'v' = [1, 2, 3, 1, 1, 4]

Output: 1 2

Explanation: The element having the highest frequency is '1', and the frequency is 3. The elements with the lowest frequencies are '2', '3', and '4'. Since we need to pick the smallest element, we pick '2'. Hence we return [1, 2].
Sample Input 2 :
6
10 10 10 3 3 3
Sample Output 2 :
3 3
Sample Explanation 2:
Input: ‘n' = 6, 'v' = [10, 10, 10, 3, 3, 3]

Output: 3 3

Explanation: Since the frequency of '3' and '10' is 3. Therefore, the element with the maximum and minimum frequency is '3'.
Expected Time Complexity :
The expected time complexity is O(n), where n is the size of the array.
Expected Space Complexity :
The expected time complexity is O(n), where n is the size of the array.
Constraints :
2 <=  n <= 10^4
1 <= v[i] <= 10^9
There are at least two distinct elements in the array.
Time Limit: 1 sec 
*/

===================================================================================================================================
======================================================================================================================================
  import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] getFrequencies(int[] v) {
        // HashMap to store the frequencies of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : v) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Variables to keep track of the highest and lowest frequency elements
        int maxFreqElement = -1;
        int minFreqElement = Integer.MAX_VALUE;
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;

        // Iterate through the map to find the highest and lowest frequency elements
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();

            // Update the highest frequency element
            if (freq > maxFreq || (freq == maxFreq && key < maxFreqElement)) {
                maxFreq = freq;
                maxFreqElement = key;
            }

            // Update the lowest frequency element
            if (freq < minFreq || (freq == minFreq && key < minFreqElement)) {
                minFreq = freq;
                minFreqElement = key;
            }
        }

        // Return the highest and lowest frequency elements
        return new int[]{maxFreqElement, minFreqElement};
    }
}
