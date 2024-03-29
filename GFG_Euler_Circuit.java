/* 
Eulerian Path is a path in a graph that visits every edge exactly once. Eulerian Circuit is an Eulerian Path that starts and ends on the same vertex. Given the number of vertices v and adjacency list adj denoting the graph. Find that there exists the Euler circuit or not. Return 1 if there exist  alteast one eulerian path else 0.*/
==================================================================================================================================
  ==============================================================================================================================
  class Solution {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         for(ArrayList<Integer> al: adj){
            if(al.size()%2!=0) return  false;
        }
        return true;
    }
}
