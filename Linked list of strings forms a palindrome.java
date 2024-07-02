/*
Given a linked list with string data, check whether the combined string formed is palindrome. If the combined string is palindrome then return true otherwise return false.

Example:

Input:
a>bc>d>cb>a

Output : true
Explanation: As string "abcddcba" is palindrome the function should return true.
Input:
a>b>cd>b>a

Output : false
Explanation: As string "abcdba" is not palindrome the function should return false.
Expected Time Complexity:  O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Node.data.length<= 103
1<=list.length<=103


*/

class Solution {
    
    static boolean palindrome(char[]ch,int st,int end){
        while(st<end){
            if(ch[st]!=ch[end])
            {
                return false;
                
            }
            st++;
            end--;
            
            
        }
        return true;
        
    }
    public boolean compute(Node root) {
        
        StringBuilder sb = new StringBuilder();
        
        Node cur = root;
        
        while(cur!=null){
            
            sb.append(cur.data);
            cur=cur.next;
            
        }
        
        
        char[] ch = sb.toString().toCharArray();
        
        return palindrome(ch,0,ch.length-1);
        
        
    }
}
