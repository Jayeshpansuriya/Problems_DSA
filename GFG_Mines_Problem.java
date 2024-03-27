/*Given a matrix mat[][] with r rows and c columns, where some cells are landmines (marked as 0) and others are safe to traverse. Your task is to find the shortest safe route from any cell in the leftmost column to any cell in the rightmost column of the mat. You cannot move diagonally, and you must avoid both the landmines and their adjacent cells (up, down, left, right), as they are also unsafe.*/
============================================================================================================================================
class Solution {
    public static int findShortestPath(int[][] mat) {
           int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    if(i-1>=0)mat[i-1][j]=-1;
                    if(i+1<n)mat[i+1][j]=-1;
                    if(j-1>=0)mat[i][j-1]=-1;
                    if(j+1<m)mat[i][j+1]=-1;
                    
                }
            }
        }
        int d[][]=new int[n][m];
        for(int t[]:d){
            Arrays.fill(t,Integer.MAX_VALUE);
        }
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(mat[i][0]==1)q.add(new pair(1,i,0));
        }
        int delr[]={-1,0,1};
            int delc[]={0,1,0};
        while(!q.isEmpty()){
            pair p=q.poll();
            int s=p.st;
            int r=p.ro;
            int c=p.co;
            if(c==m-1)return s;
            for(int i=0;i<3;i++){
                int nr=r+delr[i];
                int nc=c+delc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]==1 && d[nr][nc]>s+1){
                    q.add(new pair(s+1,nr,nc));
                    d[nr][nc]=s+1;
                }
            }
            
    }
    return -1;
    }
}
class pair{
    int st,ro,co;
    pair(int st,int ro,int co){
        this.st=st;
        this.ro=ro;
        this.co=co;
    }
}
