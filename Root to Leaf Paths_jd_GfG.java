/*
Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 
10 20 40 
10 20 60 
10 30 
Your Task:
Your task is to complete the function Paths() which takes the root node as an argument and returns all the possible paths. (All the paths are printed in new lines by the driver's code.)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1<=n<=104
*/


class Solution {
    
    
    public static void solve (Node root , ArrayList<ArrayList<Integer>> res , ArrayList<Integer> temp){
        if(root == null ){
            return ; 
            
        }
        temp.add(root.data);
        if(root.left==null && root.right==null){
            res.add(new ArrayList<>(temp));
            
        }
        solve (root.left,res,temp);
        solve(root.right,res,temp);
        temp.remove(temp.size()-1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(root,res,temp);
        return res;
        
        
        
        
    }
}
     
