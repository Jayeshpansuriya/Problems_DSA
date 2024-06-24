/*

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        Arrays.sort(nums); // Sort the array
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates for the first number
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates for the second number
                
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates for the third number
                        while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates for the fourth number
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();
        
    //     int[] nums1 = {1, 0, -1, 0, -2, 2};
    //     int target1 = 0;
    //     System.out.println(sol.fourSum(nums1, target1)); // Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        
    //     int[] nums2 = {2, 2, 2, 2, 2};
    //     int target2 = 8;
    //     System.out.println(sol.fourSum(nums2, target2)); // Output: [[2, 2, 2, 2]]
        
    //     int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
    //     int target3 = -294967296;
    //     System.out.println(sol.fourSum(nums3, target3)); // Output: []
    // }
}
