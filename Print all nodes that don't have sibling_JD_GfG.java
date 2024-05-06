/*
Given a Binary Tree of n nodes, find all the nodes that don't have any siblings. You need to return a list of integers containing all the nodes that don't have a sibling in sorted order (Increasing).

Two nodes are said to be siblings if they are present at the same level, and their parents are the same.

Note: The root node can not have a sibling so it cannot be included in our answer.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 
20 113
Explanation: 
Nodes 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: 
-1
Explanation: 
Every node has a sibling.
Your Task:  
You don't need to read input or print anything. Complete the function noSibling() which takes the root of the tree as input parameter and returns a list of integers containing all the nodes that don't have a sibling in sorted order. If all nodes have a sibling, then the returning list should contain only one element -1.

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(Height of the tree)

Constraints:
1 ≤ n ≤ 104
*/

//User function Template for Java

/*  A Binary Tree nodea
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
       ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> toReturn = helper(list,node);
        if(toReturn.size()==0){
            toReturn.add(-1);
            return toReturn;
        }
        Collections.sort(toReturn);
        return toReturn;
    }
    private static ArrayList<Integer> helper(ArrayList<Integer> list, Node root){
        if(root==null){
            return list;
        }
        if(root.left!=null && root.right==null){
            list.add(root.left.data);
        }
        if(root.left==null && root.right!=null){
            list.add(root.right.data);
        }
        helper(list,root.left);
        helper(list,root.right);
        
        return list;
    }
}
