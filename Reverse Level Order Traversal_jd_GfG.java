/*
Given a binary tree of size n, find its reverse level order traversal. ie- the traversal must begin from the last level.

Example 1:

Input :
        1
      /   \
     3     2

Output: 
3 2 1
Explanation:
Traversing level 1 : 3 2
Traversing level 0 : 1
Example 2:

Input :
       10
      /  \
     20   30
    / \ 
   40  60

Output: 
40 60 20 30 10
Explanation:
Traversing level 2 : 40 60
Traversing level 1 : 20 30
Traversing level 0 : 10
Your Task: 
You don't need to read input or print anything. Complete the function reverseLevelOrder() which takes the root of the tree as input parameter and returns a list containing the reverse level order traversal of the given tree.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 104
*/

   Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree

{
    
    ArrayList<Integer> al= new ArrayList<>();
    Queue<Node> q=new LinkedList<Node>();
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
         al.clear();
        q.clear();
        levelOrder(node);
        Collections.reverse(al);
        return al;
    }
    void levelOrder(Node root){
        if(root==null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            al.add(curr.data);
            if(curr.right!=null){
                q.add(curr.right);
            }
            if(curr.left!=null){
                q.add(curr.left);
            }
        }
    }
}      
