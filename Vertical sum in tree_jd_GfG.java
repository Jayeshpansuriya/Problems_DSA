/*
Given a binary tree having n nodes, find the vertical sum of the nodes that are in the same vertical line. Return all sums through different vertical lines starting from the left-most vertical line to the right-most vertical line.

Example 1:

Input:
       1
    /    \
  2      3
 /  \    /  \
4   5  6   7
Output: 
4 2 12 3 7
Explanation:
The tree has 5 vertical lines
Line 1 has only one node 4 => vertical sum is 4.
Line 2 has only one node 2 => vertical sum is 2.
Line-3 has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12.
Line-4 has only one node 3 => vertical sum is 3.
Line-5 has only one node 7 => vertical sum is 7.
Example 2:

Input:
          1
         /
        2
       /
      3
     /
    4
   /
  6
 /
7
Output: 
7 6 5 4 3 2 1
Explanation:
There are seven vertical lines each having one node.
Your Task:
You don't need to take input. Just complete the function verticalSum() that takes root node of the tree as parameter and returns an array containing the vertical sum of tree from left to right.

Expected Time Complexity: O(nlogn).
Expected Auxiliary Space: O(n).

Constraints:
1<=n<=104
1<= Node value <= 105


*/

=============================================================================================================================================
  /*
  Algorithm:
1.Create a tree map to get sorted values
2.Create a util method and pass root, 0 as a current index, and map
3.Create a util method as parameters root node, index, and map
4.First, check if the root is null, then return from it.
5.Then, check if the current index is present or not on the map. If yes, then get the corresponding value and add root data, put it into the map
6.Else, directly put into the map
7.Call for the left subtree with the root.left, index-1, and map
8.Call for the right subtree with the root.right, index+1, and map.
9.Add all values in the answer array, and return it.
  */

  */
class Solution{
   void vSumUtil(Node root, int ind, Map<Integer, Integer> mp) {
        if (root == null)
            return;
            
        mp.put(ind, mp.getOrDefault(ind, 0) + root.data);
        // call for left subtree
        vSumUtil(root.left, ind-1, mp);
        // call for right subtree
        vSumUtil(root.right, ind+1, mp);
    }
    
    public ArrayList <Integer> verticalSum(Node root) {
        Map<Integer, Integer> mp = new TreeMap<>();
        vSumUtil(root, 0, mp);
        return new ArrayList<>(mp.values());
    }
}
