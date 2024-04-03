/* 
Given a BST with n (n>=2) nodes, find the kth common ancestor of nodes x and y in the given tree. Return -1 if kth ancestor does not exists.

Nodes x and y will always be present in input BST, and x != y.

Your task :
You don't have to read input or print anything. Your task is to complete the function kthCommonAncestor() that takes the root of the tree, k, x and y as input and returns the kth common ancestor of x and y.
 
Expected Time Complexity: O(Height of the BST)
Expected Space Complexity: O(Height of the BST)
 
Your Task :
1 <= n, k <= 105
1 <= node->data, x, y <= 109
*/

================================================================================================================================================================
 ====================================================================================================================================================================
  class Solution {
    int LCA(Node root,int x,int y){
        
        if(root==null){
            return -1;
        }
        
        //We search for a mid value as
        //it will be always the first LCA of BST.
        if(x<root.data && y<root.data){
            return LCA(root.left,x,y);
        }
        else if(x>root.data && y>root.data){
            return LCA(root.right,x,y);
        }
        
        return root.data;
        
    }
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        if(k==0){
            return 0;
        }
        
        int lca=LCA(root,x,y);
        
        ArrayList<Integer> arr=new ArrayList<>();
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node curr=q.poll();
            arr.add(curr.data);
            if(curr.data==lca){
                break;
            }
            
            if(curr.left!=null){
                q.add(curr.left);
            }
            else {
                q.add(new Node(-1));
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
            else {
                q.add(new Node(-1));
            }
            
        }
        
        int p=arr.size()-1;
        while(p!=0 && k>1){
            if(p%2==0){
                p=p/2-1;
            }
            else{
                p=p/2;
            }
            
            k--;
            
        }
        
        if(k>1){
            return -1;
        }
        
        return arr.get(p);
        
    
    }
}
