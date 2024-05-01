/*
Given a singly linked list having n nodes containing english alphabets ('a'-'z'). Rearrange the linked list in such a way that all the vowels come before the consonants while maintaining the order of their arrival. 

Example 1:

Input:
n = 9
linked list: a -> b -> c -> d -> e -> f -> g -> h -> i 
Output: 
a -> e -> i -> b -> c -> d -> f -> g -> h
Explanation: 
After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.
Example 2:

Input:
n = 8
linked list: a -> b -> a -> b -> d -> e -> e -> d 
Output: 
a -> a -> e -> e -> b -> b -> d -> d
Explanation: 
After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.
Your Task:
Your task is to complete the function arrangeCV(), which takes head of linked list and arranges the list in such a way that all the vowels come before the consonants while maintaining the order of their arrival and returns the head of the updated linked list.

Expected Time Complexity :  O(n)
Expected Auxiliary Space :  O(1)

Constraints:
1 <= n <= 104
'a' <= elements of linked list <= 'z'
*/
/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node dum = new Node('#'), tmp = dum, prev = null, curr = head, con = null; 
        while(curr != null) {
            char c = curr.data;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {  
                tmp.next = curr;
                tmp = tmp.next;
                if(prev == null) {
                    Node p = curr.next;
                    curr.next = null;
                    curr = p;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                if(con == null)
                    con = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        tmp.next = con;
        return dum.next;
    
    }
}



