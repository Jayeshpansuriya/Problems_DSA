/*
Given a binary matrix contains 0s and 1s only, we need to find the sum of coverage of all zeros of the matrix where coverage for a particular 0 is defined as a total number of ones around a zero in left, right, up and bottom directions.

Note: The ones considered to be anywhere till the corner point in a direction. 

Examples:

Input: 
matrix = [[0, 0, 0, 0],
          [1, 0, 0, 1], 
          [0, 1, 1, 0]]
Output: 14
Explanation:
1st Row: Four 0's are there, since every 0 has coverrage(down) till bottom of the matrix so 1+1+1+1 = 4
2nd Row: Both 0's has three coverage(left, right, down) each, so 3 + 3 = 6
3rd Row: Both 0's has two coverage each so 2 + 2 = 4.
Total = 4 + 6 + 4 = 14.
Input: 
matrix = [[0, 1]]
Output: 1
Explanation: There are only 1 coverage for that 0.
Expected Time Complexity: O(n * m)
Expected Space Complexity: O(1)

Constraints:
1 <= matrix.size, matrix[0].size <= 100


*/

class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int sum =0;
        int []x={1,-1,0,0};
        int []y={0,0,1,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    for(int z=0;z<4;z++){
                        int xx=i+x[z];
                        int yy=j+y[z];
                        
                        if(xx>=0 && xx<n&& yy>=0 && yy<m && mat[xx][yy]==1){
                            sum++;
                        }
                    }
                }
            }
        }
        

                    return sum;

    }
}
