/*
Given the two singly Linked Lists respectively. The task is to check whether two linked lists are identical or not. 
Two Linked Lists are identical when they have the same data and with the same arrangement too. If both Linked Lists are identical then return true otherwise return false. 

Examples:

Input:
LinkedList1: 1->2->3->4->5->6
LinkedList2: 99->59->42->20
Output: false
Explanation:

As shown in figure linkedlists are not identical.
Input:
LinkedList1: 1->2->3->4->5
LinkedList2: 1->2->3->4->5
Output: true
Explanation: 
 
As shown in figure both are identical.
Expected Time Complexity: O(n)
Expected Auxilliary Space: O(1)

Constraints:
1 <= length of lists <= 103
*/


/*
Identical Linked Lists
Overview

As we given two linked list head and we have to check if they are identical or not. Two linked list are identical if they have same data and same number of nodes.

so approach is very simple as traverse at both linked list till the one of them not become null and check for their node value if values are same then go to next node or if not same then return false. One additional condition we need to add for checking if anyone of list is short and become null early before other at that case also we need to return false as list are not identical.



Alogrithm

1. Traverse the both linked list till either of them not become null.

2. check for the data of nodes if they are equal then increment the nodes else return false.

3. when traversing is completed then check for a additional condition that:either of them still not null.

  */
JAVA CODE 

class Solution {
    // Function to check whether two linked lists are identical or not.
    public boolean areIdentical(Node head1, Node head2) {
        //traverse the lists till either of them not become null
        while(head1!=null && head2!=null){
            //checks for same data
            if(head1.data==head2.data){
                head1=head1.next;
                head2=head2.next;
            }
            //if not having the same data
            else{
                return false;
            }
        }
        //checks for additional condition of unequal list.
        if((head1==null && head2!=null)||(head1!=null && head2==null)){
            return false;
        }
    
       return true; 
    }
}
