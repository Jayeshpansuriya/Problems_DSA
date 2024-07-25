/*
Given a sorted array. Convert it into a Height Balanced Binary Search Tree (BST). Return the root of the BST.

Height-balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every node never differ by more than 1.

Note: The driver code will check the BST, if it is a Height-balanced BST, the output will be true otherwise the output will be false.

Examples :

Input: nums = [1, 2, 3, 4]
Output: true
Explanation: The preorder traversal of the following BST formed is [2, 1, 3, 4]:
           2
         /   \
        1     3
               \
                4
Input: nums = [1, 2, 3, 4, 5, 6, 7]
Ouput: true
Explanation: The preorder traversal of the following BST formed is [4, 2, 1, 3, 6, 5, 7]:
        4
       / \
      2   6
     / \   / \
    1 3  5 7
Expected Time Complexity: O(n)
Expected Auxillary Space: O(n)

Constraints:
1 ≤ nums.size() ≤ 105
1 ≤ nums[i] ≤ 105
*/

/*

Intuition and Visualization

Intuition:

The key to converting a sorted array into a balanced BST is choosing the middle element as the root node. This ensures that the nodes are evenly distributed, maintaining the height balance.

 

Visualizing the Approach:

 

Select the Middle Element:

 

Choose the middle element of the array as the root node. This choice naturally divides the array into two halves, ensuring balance.

Recursive Division:

 

Recursively apply the same logic to the left and right subarrays.

The middle of each subarray becomes the root of the left or right subtree, respectively.

Base Case:

 

When the left index exceeds the right index, it indicates there are no elements left for subtree construction, so we return null.

Visual Example:

Consider the sorted array: [1, 2, 3, 4, 5, 6, 7]

 

Step-by-step Construction:

 

1.Initial Call: Entire array [1, 2, 3, 4, 5, 6, 7]

 

Middle element: 4 becomes the root.

Left subarray: [1, 2, 3]

Right subarray: [5, 6, 7]

 

      4

    /   \

  ?       ?

2. Left Subtree: Array [1, 2, 3]

 

Middle element: 2 becomes the left child of 4.

Left subarray: [1]

Right subarray: [3]

 

      4

    /    \

   2      ?

  /  \

 ?    ?

 

3. Right Subtree: Array [5, 6, 7]

 

Middle element: 6 becomes the right child of 4.

Left subarray: [5]

Right subarray: [7]

      4

    /   \

   2      6

  / \     / \

 ?   ?   ?   ?

 

4. Left Subtree of 2: Array [1]

 

Middle element: 1 becomes the left child of 2.

      4

    /  \

   2      6

  / \     / \

 1   ?  ?    ?

 

5. Right Subtree of 2: Array [3]

 

Middle element: 3 becomes the right child of 2.

 

      4

    / \

   2 6

  / \ / \

 1 3 ? ?

6. Left Subtree of 6: Array [5]

 

Middle element: 5 becomes the left child of 6.

markdown

Copy code

      4

    / \

   2 6

  / \ / \

 1 3 5 ?

7. Right Subtree of 6: Array [7]

 

Middle element: 7 becomes the right child of 6.

markdown

Copy code

      4

    / \

   2 6

  / \ / \

 1 3 5 7

The recursive nature of the algorithm ensures that each subarray is similarly split until the entire array is converted into a balanced BST.

 

Approach in Detail

Recursive Strategy:

Select Middle Element:

Calculate the middle index: mid = left + (right - left) / 2.

Use this middle element as the current node's value.

Recursive Subtree Construction:

Recursively call the function for the left subarray (left to mid - 1) to form the left subtree.

Recursively call the function for the right subarray (mid + 1 to right) to form the right subtree.

Base Case:

When left > right, return null, indicating there are no more elements to include in this subtree.

 

Complexity Analysis

Time Complexity: 

𝑂(𝑛)

O(n) because each element in the array is processed exactly once to build the tree node.

Space Complexity: 

𝑂(logn)

O(logn) due to the recursion stack, which is the height of the tree. In a balanced tree, this is 

O(logn).

 

 

# Additional Visualization

To better understand the tree structure, let's use a step-by-step diagram:

 

Initial Array: [1, 2, 3, 4, 5, 6, 7]

Step 1: Middle element 4 becomes the root.

Left Subarray: [1, 2, 3]

Right Subarray: [5, 6, 7]

 

       4

Step 2: Recursively apply the process to subarrays:

Left Subarray [1, 2, 3]:

Middle is 2, which becomes left child of 4.

Left child of 2 is 1.

Right child of 2 is 3.

Right Subarray [5, 6, 7]:

Middle is 6, which becomes right child of 4.

Left child of 6 is 5.

Right child of 6 is 7.

 

       4

     / \

    2    6

   / \    / \

  1   3 5  7

By selecting the middle element at each step, the tree maintains balance, ensuring that search operations remain efficient. Each level of recursion refines the tree's structure, embodying the divide-and-conquer strategy that underlies many efficient algorithms.
*/

class Solution {
    public Node sortedArrayToBST(int[] nums) {
        // Code here
        
        return solve(0,nums.length-1,nums);
    }
    public Node solve(int l,int r,int[] nums){
        if(l>r)
        return null;
        int mid=l+(r-l)/2;
        Node root = new Node(nums[mid]);
        root.left=solve(l,mid-1,nums);
        root.right=solve(mid+1,r,nums);
        
        return root;
    }
}
