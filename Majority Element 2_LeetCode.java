/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {

     int n=nums.length;
     List<Integer> ls =new ArrayList<>();
     HashMap<Integer,Integer> mpp=new HashMap<>();
     int  mini =(int)(n/3)+1;

     for(int i=0;i<n;i++){
        int value=mpp.getOrDefault(nums[i],0);
        mpp.put(nums[i], value+1);
        if(mpp.get(nums[i])==mini){
            ls.add(nums[i]);

        }
        if(ls.size()==2)break;


     }  
     return ls; 
    }
}
