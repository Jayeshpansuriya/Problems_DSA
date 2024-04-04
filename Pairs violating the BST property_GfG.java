/*
Given a binary tree with n nodes, find the number of pairs violating the BST property.
BST has the following properties:-

Every node is greater than its left child and less than its right child.
Every node is greater than the maximum value of in its left subtree and less than the minimum value in its right subtree.
The maximum in the left sub-tree must be less than the minimum in the right subtree.
Example 1:

Input : 
n = 5
Input tree
    
Output :
5
Explanation : 
Pairs violating BST property are:-
(10,50), 10 should be greater than its left child value.
(40,30), 40 should be less than its right child value.
(50,20), (50,30) and (50,40), maximum of left subtree of 10 is 50 greater than 20, 30 and 40 of its right subtree.
Example 2:

Input : 
n = 6
Input tree

Output :
8
Explanation :
There are total 8 Pairs which violation the BST properties.
Your task :
You don't have to read input or print anything. Your task is to complete the function pairsViolatingBST() that takes the root of the tree and n as input and returns number of pairs violating BST property.
 
Expected Time Complexity: O(n*logn)
Expected Space Complexity: O(n)
 
Your Task :
1 <= n <= 2*104
-109 <= node->data <= 109
*/

==============================================================================================================================
==============================================================================================================================
class Solution {
    public static int pairsViolatingBST(int n, Node root) {
        // code here
        List<Integer> list = new ArrayList<>();
        createList(root,list);
        return mergeSort(list,0,list.size()-1);
    
    }
    public static void createList(Node root,List<Integer> list){
        if(root!=null){
            createList(root.left,list);
            list.add(root.data);
            createList(root.right,list);
        }
    }
    
    public static int merge(List<Integer> list,int low,int mid,int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int c = 0;
        
        while(left<=mid && right<=high){
            if(list.get(left)<=list.get(right)){
                temp.add(list.get(left));
                left++;
            }
            else{
                temp.add(list.get(right));
                c += mid-left+1;
                right++;
            }
        }
        
        while(left<=mid){
            temp.add(list.get(left));
                left++;
        }
        
        while(right<=high){
            temp.add(list.get(right));
                right++;
        }
        for(int i=low;i<=high;i++){
            list.set(i,temp.get(i-low));
        }
        return c;
    }
    
    public static int mergeSort(List<Integer> list,int low,int high){
        int c = 0;
        if(low>=high)
            return 0;
        int mid = low+(high-low)/2;
        c += mergeSort(list,low,mid);
        c += mergeSort(list,mid+1,high);
        c += merge(list,low,mid,high);
        return c;
    
    }
}
