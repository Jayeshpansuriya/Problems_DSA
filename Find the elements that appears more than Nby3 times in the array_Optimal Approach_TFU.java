/*
Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.


*/Example 1:
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
Optimal Approach (Extended Boyer Moore’s Voting Algorithm): 
Approach: 
Initialize 4 variables:
cnt1 & cnt2 –  for tracking the counts of elements
el1 & el2 – for storing the majority of elements.
Traverse through the given array.
If cnt1 is 0 and the current element is not el2 then store the current element of the array as el1 along with increasing the cnt1 value by 1.
If cnt2 is 0 and the current element is not el1 then store the current element of the array as el2 along with increasing the cnt2 value by 1.
If the current element and el1 are the same increase the cnt1 by 1.
If the current element and el2 are the same increase the cnt2 by 1.
Other than all the above cases: decrease cnt1 and cnt2 by 1.
The integers present in el1 & el2 should be the result we are expecting. So, using another loop, we will manually check their counts if they are greater than the floor(N/3).
Intuition: If the array contains the majority of elements, their occurrence must be greater than the floor(N/3). Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the array. So when we traverse through the array we try to keep track of the counts of elements and the elements themselves for which we are tracking the counts. 

After traversing the whole array, we will check the elements stored in the variables. Then we need to check if the stored elements are the majority elements or not by manually checking their counts.

Note: This intuition is simply the logic of cancellation i.e. a variation of Moore’s Voting Algorithm that we used in the problem Majority Element (> N/2).

The projection will be the following:


Edge Case: Why we are adding extra checks like el2 != v[i] and el1 != v[i] in the first if statements? Let’s understand it using an example:
Assume the given array is: {2, 1, 1, 3, 1, 4, 5, 6}. Now apply the algorithm without the checks:


We can clearly notice that in iteration 5, el1 and el2 both are set to 1 as cnt1 becomes 0 in iteration 4. But this is incorrect. So, to avoid this edge case, we are checking if the current element is already included in our elements, and if it is, we will not again include it in another variable.
  */

  


import java.util.*;

public class tUf {
    public static List<Integer> majorityElement(int []v) {
        int n = v.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1) cnt1++;
            else if (v[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

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
Time Complexity: O(N) + O(N), where N = size of the given array.
Reason: The first O(N) is to calculate the counts and find the expected majority elements. The second one is to check if the calculated elements are the majority ones or not.

Space Complexity: O(1) as we are only using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constant.
*/
