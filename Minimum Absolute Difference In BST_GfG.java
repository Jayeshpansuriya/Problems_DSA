/* 
Given a binary search tree having n (n>1) nodes, the task is to find the minimum absolute difference between any two nodes.

Example 1:

Input:
Input tree

Output:
10
Explanation:
There are no two nodes whose absolute difference is smaller than 10.
Example 2:

Input:
Input tree

Output:
20
Explanation:
There are no two nodes whose absolute difference is smaller than 20.
Your Task:
You don't have to take any input. Just complete the function absolute_diff() , that takes root as input and return minimum absolute difference between any two nodes.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(Height of tree)

Constraints:
2 <= n <= 105
1 <= Node->data <= 109
*/
============================================================================================================================================
============================================================================================================================================
class Solution
{
    static Node prev;
    static int min;
    Solution(){
        this.prev=null;
        this.min=Integer.MAX_VALUE;
    }
    int absolute_diff(Node root)
    {
        //Your code here
        inorder(root);
        return min;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
            
        }
        inorder(root.left);
        if(prev!=null){
            min=Math.min(Math.abs(root.data-prev.data),min);
        }
        prev=root;
        inorder(root.right);
    }
}
