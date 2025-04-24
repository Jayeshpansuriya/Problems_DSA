/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
*/

*********************************************************************************

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int n= nums.length;
        for(int i=0 ; i<n ;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);

            }else{
                map.put(nums[i],1);
            }
        }

        for(int key:map.keySet()){
            if(map.get(key)>n/2){
                // System.out.println(key);
                return key;
            }
        }
     return -1;   
    }
 
}

********************************************************************************
 import java.util.*;
public class Classroom{
public static void majorityelement(int nums[]){
    HashMap<Integer,Integer> map = new HashMap<>();
    int n= nums.length;
    for(int i=0; i<n;i++){
        if(map.containsKey(nums[i])){
            map.put(nums[i], map.get(nums[i])+1);
        }else{
            map.put(nums[i],1);
        }
    }

    for(int key : map.keySet()){
        if(map.get(key)>n/3){
            System.out.println(key);
        }
    }

}

public static void main(String args[]){
    int nums[] = {1,3,2,5,1,3,1,5,1};
    majorityelement(nums);
}
}
