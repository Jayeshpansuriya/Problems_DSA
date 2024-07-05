/*
Given a Binary Tree. You need to find and return the vertical width of the tree.

Examples :

Input:
         1
       /    \
      2      3
     / \    /  \
    4   5  6   7
            \   \
             8   9
Output: 6
Explanation: The width of a binary tree is
the number of vertical paths in that tree.



The above tree contains 6 vertical lines.
Input:
     1
    /  \
   2    3
Output: 3
Explanation: The above tree has 3 vertical lines, hence the answer is 3.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(height of the tree).

Constraints:
0 <= number of nodes <= 104
*/

***************************************************************************************************************************

  class Solution {
    // Function to find the vertical width of a Binary Tree.
   HashSet<Integer>list = new HashSet<>();
   
    public int verticalWidth(Node root) {
        // code here.
        
        if(root==null)
        return 0;
        
        ans(root,0);
        
        return list.size();
        
        
    }
    
    void ans(Node root, int ht){
        if(root==null)
        return;
        
        ans(root.left,ht-1);
        list.add(ht);
        ans(root.right,ht+1);
    }
}
