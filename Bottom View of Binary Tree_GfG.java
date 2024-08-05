/*
Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree, the output should be 5 10 4 14 25.

Examples :

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.

Thus bottom view of the binary tree will be 3 1 2.
Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
*/


class Solution
{
   public class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        //jaise top view mein kia tha
        //level order kro
        Node ptr = root;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ptr, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node nd = p.node;
            int h = p.hd;

            map.put(h, nd.data);

            if(nd.left != null){
                q.add(new Pair(nd.left, h-1));
            }
            if(nd.right != null){
                q.add(new Pair(nd.right, h+1));
            }

        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> hm : map.entrySet()){
            int a = hm.getValue();
            ans.add(a);
        }

        return ans;
        
    }
}
