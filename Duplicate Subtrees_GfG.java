/*
Given a binary tree, your task is to find all duplicate subtrees from the given binary tree.

Note:  Return the root of each tree in the form of a list array & the driver code will print the tree in pre-order tree traversal in lexicographically increasing order.

Examples:

Input : 
 
Output: 2 4   
        4
Explanation: The above tree have two duplicate subtrees.i.e 
  2
 /
4  and 4. Therefore, you need to return the above tree root in the form of a list.
Input:     5
          / \
         4   6
        / \
       3   4
          / \
         3   6
Output: 4 3
        6
Explanation: In the above tree, there are two duplicate subtrees.i.e
  4
 /
3   and 6. Therefore, you need to return the above subtrees root in the form of a list.
Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1<= size of binary tree <=100


*/


***************************************************************************
  
class Solution {
    
    Map<String,Integer> map = new HashMap<>();
    List<Node> res = new ArrayList<>();
    
    public List<Node> printAllDups(Node root){
        traverse(root);
        return res;
        
    }
    
    
    
    
    
    private String traverse(Node node) {
        if(node==null) return "";
        String str = node.data + "," + traverse(node.left)+ ","+traverse(node.right);
        
        map.put(str,map.getOrDefault(str,0)+1);
        
        if(map.get(str)==2) res.add(node);
        
        return str;
        // code here
    }
}
