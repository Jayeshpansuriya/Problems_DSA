/*
Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.


Example 1:
Input Format
: N = 5, array[] = {1,2,2,3,2}
Result
: 2
Explanation:
 Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format
:  N = 6, array[] = {11,33,33,11,33,11}
Result:
 11 33
Explanation:
 Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
*/

/*
Better Approach (Using Hashing): 
Intuition:
Use a better data structure to reduce the number of look-up operations and hence the time complexity. Moreover, we have been calculating the count of the same element again and again – so we have to reduce that also.

Approach: 
The steps are as follows:

Use a hashmap and store the elements as <key, value> pairs. (Can also use frequency array based on the size of nums).
Here the key will be the element of the array and the value will be the number of times it occurs. 
Traverse the whole array and update the occurrence of each element. 
After that, check the map if the value for any element is greater than the floor of N/3. 
If yes, include it in the list. 
Else iterate forward.
Finally, return the list.
Dry Run: 
Let’s take the example of arr[] = {10,20,40,40,40}, n=5.

First, we create an unordered map to store the count of each element.

Now traverse through the array 

Found 10 at index 0, increase the value of key 10 in the map by 1.

Found 20 at index 1, increase the value of key 20 in the map by 1.

Found 40 at index 2, increase the value of key 40 in the map by 1.

Found 40 at index 3, increase the value of key 40 in the map by 1.

Found 40 at index 4, increase the value of key 40 in the map by 1.

Now, Our map will look like this:

10 -> 1 
20 -> 1
40 -> 3
Now traverse through the map, 

We found that the value of key 40 is greater than the floor(N/3). So, 40 is the answer.

Note: For a better understanding of intuition, please watch the video at the bottom of the page.
*/




import java.util.*;

public class tUf {
    public static List<Integer> majorityElement(int []v) {
        int n = v.length; //size of the array
        List<Integer> ls = new ArrayList<>(); // list of answers

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // least occurrence of the majority element:
        int mini = (int)(n / 3) + 1;

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);

            //checking if v[i] is
            // the majority element:
            if (mpp.get(v[i]) == mini) {
                ls.add(v[i]);
            }
            if (ls.size() == 2) break;
        }

        return ls;
    }

    public static void main(String args[]) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

/*
Complexity Analysis
Time Complexity: O(N*logN), where N = size of the given array.
Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN).
If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

Space Complexity: O(N) as we are using a map data structure. We are also using a list that stores a maximum of 2 elements. That space used is so small that it can be considered constant.
*/
