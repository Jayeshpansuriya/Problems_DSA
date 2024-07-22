/*
Given a binary tree. Find the size of its largest subtree which is a Binary Search Tree.
Note: Here Size equals the number of nodes in the subtree.

Examples :

Input:   1
        /  \
        4   4              
       / \ 
      6   8
Output: 1 
Explanation: There's no sub-tree with size greater than 1 which forms a BST. All the leaf Nodes are the BSTs with size equal to 1.

Input:    6
        /   \
      6      2              
       \    / \
        2  1   3
Output: 3
Explanation: The following sub-tree is a BST of size 3:  2
                                                       /   \
                                                      1     3
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106
*/

class Solution {

    static int largestBst(Node root) {

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {

            return countNodes(root);

        }

        int left = largestBst(root.left);

        int right = largestBst(root.right);

        return Math.max(left, right);

    }

 

    static boolean isBST(Node node, int min, int max) {

        if (node == null) {

            return true;

        }

        if (node.data < min || node.data > max) {

            return false;

        }

        return isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max);

    }

 

    static int countNodes(Node node) {

        if (node == null) {

            return 0;

        }

        return 1 + countNodes(node.left) + countNodes(node.right);

    }

}

 
