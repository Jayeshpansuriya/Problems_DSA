/*
Given the root of a binary search tree and a number n, find the greatest number in the binary search tree that is less than or equal to n. 
*/
====================================================================================================================================
========================================================================================================================================
  class Solution {
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        if(root==null)
        return -1;
        if(root.key<=n){
            return Math.max(root.key,findMaxForN(root.right,n));
        }else{
            return findMaxForN(root.left,n);
        }
    }
}
