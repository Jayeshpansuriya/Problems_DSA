/*
Problem statement
You are given an integer array 'arr' of size 'N'.



You must sort this array using 'Insertion Sort' recursively.



 Note:
Change in the input array itself. You don't need to return or print the elements.
Example:
Input: ‘N’ = 7
'arr' = [2, 13, 4, 1, 3, 6, 28]

Output: [1 2 3 4 6 13 28]

Explanation: After applying insertion sort on the input array, the output is [1 2 3 4 6 13 28].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
9 3 6 2 0
Sample Output 1:
0 2 3 6 9
Sample Input 2:
4
4 3 2 1
Sample Output 2:
1 2 3 4 
Constraints :
0 <= N <= 10^3
0 <= arr[i] <= 10^5
Time Limit: 1 sec
*/

=============================================================================================================================
================================================================================================================================
  public class Solution {
    public static void insertionSort(int[] arr, int size) {
        //Your code goes here
        if (size<=1){
            return;
        }

        insertionSort(arr,size-1);
        int key = arr[size-1];
        int j=size-2;
        while(j>=0 && arr[j]>key){
            arr[j+1]=arr[j];
            j--;

        }
        arr[j+1]=key;
    }
}
