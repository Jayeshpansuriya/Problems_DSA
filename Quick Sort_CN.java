/*
Problem statement
Given the 'start' and the 'end'' positions of the array 'input'. Your task is to sort the elements between 'start' and 'end' using quick sort.



Note :
Make changes in the input array itself.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
1 2 3 5 7
Sample Output 2 :
1 2 3 5 7 
Constraints :
1 <= N <= 10^3
0 <= input[i] <= 10^9
*/

======================================================================================================================================================================
=========================================================================================================================================================================
  public class Solution {
    public static void quickSort(int[] input, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(input, startIndex, endIndex);
            quickSort(input, startIndex, pivotIndex - 1); // Sort left subarray
            quickSort(input, pivotIndex + 1, endIndex); // Sort right subarray
        }
    }

    private static int partition(int[] input, int startIndex, int endIndex) {
        int pivot = input[endIndex];
        int i = startIndex - 1; // Index of smaller element

        for (int j = startIndex; j < endIndex; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }

        swap(input, i + 1, endIndex); // Place pivot in correct position
        return i + 1;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 5, 4, 3};
        quickSort(arr1, 0, arr1.length - 1);
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] arr2 = {1, 2, 3, 5, 7};
        quickSort(arr2, 0, arr2.length - 1);
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
}
