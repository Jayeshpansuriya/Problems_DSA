/*
Given an array arr. The task is to find and return the maximum product possible with the subset of elements present in the array.

Note:

The maximum product can be a single element also.
Since the product can be large, return it modulo 109 + 7.
Examples:

Input: arr[] = [-1, 0, -2, 4, 3]
Output: 24
Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24
Input: arr[] = [-1, 0]
Output: 0
Explanation: Maximum product will be ( -1 * 0) = 0
Input: arr[] = [5]
Output: 5
Explanation: Maximum product will be 5.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 2 * 104
-10 <= arr[i] <= 10
*/

class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        long result = 1;
        int n = arr.size();
        int zeroes = 0;
        int maxi = Integer.MIN_VALUE;
        int mod = 1000000007;
        if(n == 1) return arr.get(0)%mod;
        if(n == 2){
            if(arr.get(0) == 0 && arr.get(1) < 0) return 0;
            else if(arr.get(0) < 0 && arr.get(1) == 0) return 0;
        }
        for(int i =0; i<n; i++){
            if(arr.get(i) != 0){
                result = (result * arr.get(i))%mod;
                if(arr.get(i) < 0) maxi = Math.max(maxi, arr.get(i));
            }
            else zeroes++;
            
        }
        if(zeroes == n) return 0;
        if(result < 0) result = result/maxi;
        return result % mod;
    }
}
