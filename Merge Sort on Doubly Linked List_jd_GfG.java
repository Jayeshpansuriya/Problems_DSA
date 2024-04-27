/*
Given Pointer/Reference to the head of a doubly linked list of n nodes, the task is to Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.

Example 1:

Input:
n = 8
value[] = {7,3,5,2,6,4,1,8}
Output:
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
Explanation: After sorting the given
linked list in both ways, resultant
matrix will be as given in the first
two line of output, where first line
is the output for non-decreasing
order and next line is for non-
increasing order.
Example 2:

Input:
n = 5
value[] = {9,15,0,-1,0}
Output:
-1 0 0 9 15
15 9 0 0 -1
Explanation: After sorting the given
linked list in both ways, the
resultant list will be -1 0 0 9 15
in non-decreasing order and 
15 9 0 0 -1 in non-increasing order.
Your Task:
The task is to complete the function sortDoubly() which takes reference to the head of the doubly linked and Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing. The printing is done automatically by the driver code.

Expected Time Complexity: O(nlogn)
Expected Space Complexity: O(logn)

Constraints:
1 <= n <= 104
0 <= values[i] <= 105
*/

******************************************************************************************************************************************************************************

// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // add your code here
          if(head==null || head.next==null){
            return head;
        }
        
        //storing middle by calliing split function
        
        
        Node left=head;
        Node right=splitList(head);
        
        
        
        //recursion fro further spliting the list 
        left=sortDoubly(left);
        right= sortDoubly(right);
        
        //calling merge functin to sort and merge
        Node result=merge(left, right);
        return result;
        
    }
    
    
    // split function to find middle
    static Node splitList(Node head){
        
        Node slow=head;
        Node fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        Node temp=slow.next;
        slow.next=null;
        temp.prev=null;
        
        return temp;
    }
    
    
    // merge functin to perform sort and merge
    static Node merge(Node left, Node right){
        
        
        
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        

        
        Node head=new Node(0);
        Node tail=head;
        Node temp=null;
        
    
            while(left!=null && right!=null){
                if(left.data<=right.data){
                    tail.next=left;
                    temp=tail;
                    tail=tail.next;
                    tail.prev=temp;
            
                    left=left.next;
                }else{
                    tail.next=right;
                    temp=tail;
                    tail=tail.next;
                    tail.prev=temp;
                   
                    right=right.next;
                }
            }
            
            if(left==null){
                tail.next=right;
                temp=tail;
                tail=tail.next;
                tail.prev=temp;
            }
            
            if(right==null){
                tail.next=left;
                temp=tail;
                tail=tail.next;
                tail.prev=temp;
            }
            
            // tail.next=null;
            
            head=head.next;
            head.prev=null;
            
            return head;
        
    }
}
