/*
Given an array arr of n integers, count all pairs (arr[i], arr[j]) in it such that i*arr[i] > j*arr[j] and 0 ≤ i < j < n.

Note: 0-based Indexing is followed.

Example 1:

Input :
n = 4
arr[] = {8, 4, 2, 1}
Output :
2
Explanation:
If we see the array after operations
[0*8, 1*4, 2*2, 3*1] => [0, 4, 4, 3]
Pairs which hold the condition i*arr[i] > j*arr[j] are (4,1) and (2,1), so in total 2 pairs are available.
Example 2:

Input :
n = 7
arr[] = {5, 0, 10, 2, 4, 1, 6}
Output:
5
Explanation :
Pairs which hold the condition i*arr[i] > j*arr[j] are (10,2), (10,4), (10,1), (2,1) and (4,1), so in total 5 pairs are there.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function countPairs() which takes the array arr[] and its size n as inputs and returns the required result.

Expected Time Complexity: O(n*log(n))
Expected Auxiliary Space: O(n*log(n))

Constraints:
1 ≤ n ≤ 104
1 ≤ arr[i] ≤ 104
*/

=============================================================================================================================================================================================
  class Solution {
    static int mergeAndCount(int arr[], int low, int mid, int high) {
        int swapCount = 0;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int temp1[] = new int[n1], temp2[] = new int[n2];
        for(int m=0;m<n1;++m) {
            temp1[m] = arr[low + m];
        }
        for(int m=0;m<n2;++m) {
            temp2[m] = arr[mid + 1 + m];
        }
        int i = 0, j = 0, k = low;
        while(i < n1 && j < n2) {
            if(temp1[i] <= temp2[j]) {
                arr[k] = temp1[i];
                ++i;
            }
            else {
                swapCount += (n1 - i);
                arr[k] = temp2[j];
                ++j;
            }
            ++k;
        }
        while(i < n1) {
            arr[k] = temp1[i];
            ++i;
            ++k;
        }
        while(j < n2) {
            arr[k] = temp2[j];
            ++j;
            ++k;
        }
        return swapCount;
    }
    static int mergeSortAndCount(int arr[], int low, int high) {
        int pairCount = 0;
        if(low < high) {
            int mid = low + (high - low) / 2;
            pairCount += mergeSortAndCount(arr, low, mid);
            pairCount += mergeSortAndCount(arr, mid + 1, high);
            pairCount += mergeAndCount(arr, low, mid, high);
        }
        return pairCount;
    }
    static int countPairs(int arr[], int n) 
    {
         // Your code goes here
         for(int i=0;i<n;++i) {
             arr[i] = i * arr[i];
         }
         return mergeSortAndCount(arr, 0, n - 1);
         
    }
}
