/*
Given a binary tree having n nodes and an integer k. Print all nodes that are at distance k from the root (root is considered at distance 0 from itself). Nodes should be printed from left to right.

Example 1:

Input:
k = 0
      1
    /   \
   3     2
Output: 
1
Explanation: 
1 is the only node which is 0 distance from the root 1.
Example 2:

Input:
k = 3
        1
       /
      2
       \
        1
      /  \
     5    3
Output: 
5 3
Explanation:  
5 and 3 are the nodes which are at distance 3 from the root 3.
Here, returning 3 5 will be incorrect.
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root node and k as parameters and returns the value of the nodes that are at a distance k from the root.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 104
0 <= k <= 30
*/


//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */


class Tree
{
     ArrayList<Integer> Kdistance(Node root, int k)
     {
         ArrayList<Integer>ans = new ArrayList<>();
         int dist = 0;
         findH(root,k,dist,ans);
         return ans;
         
     }
     public void findH(Node root, int k, int dist,ArrayList<Integer> ans){
         if(root==null)return;
         if(k==dist){
             ans.add(root.data);
             return;
         }
         dist++;
         findH(root.left,k,dist,ans);
         findH(root.right,k,dist,ans);
     }
}
