/*
Given a two-dimensional integer array arr of dimensions n x n, consisting solely of zeros and ones, identify the row or column (using 0-based indexing) where all elements form a palindrome. If multiple palindromes are identified, prioritize the palindromes found in rows over those in columns. Within rows or columns, the palindrome with the smaller index takes precedence. The result should be represented by the index followed by either 'R' or 'C', indicating whether the palindrome was located in a row or column. The output should be space-separated. If no palindrome is found, return the string -1.

Examples:

Input: 
arr[][] =  [[1, 0, 0], 
           [0, 1, 0],
           [1, 1, 0]]
Output: 1 R
Explanation: In the first test case, 0-1-0 is a palindrome 
occuring in a row having index 1.
Input: 
arr[][] =   [[1, 0],
           [1, 0]]
Output: 0 C
Explanation: 1-1 occurs before 0-0 in the 0th column. And there is no palindrome in the two rows.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
1<= arr.size <= 50
0 <= arr[i][j] <= 1
*/

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        if(arr.length<=1){
            return "0 R";
        }
        for(int i = 0; i < arr.length; i++) {
            if(isRowPalindrome(arr[i])) {
                return ""+ i+ " R";
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(isColumnPalindrome(arr, i)) {
                return ""+ i+ " C";
            }
        }
        
        return "-1";
        
    }
    
    public Boolean isRowPalindrome(int [] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            if(arr[i] != arr[(arr.length - 1) - i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public Boolean isColumnPalindrome(int[][] arr, int col) {
        for(int i = 0; i < arr.length / 2; i++) {
            if(arr[i][col] != arr[(arr.length  - 1) - i][col]) {
                return false;
            }
        }
        
        return true;
    }
}
