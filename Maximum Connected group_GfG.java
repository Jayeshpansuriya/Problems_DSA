/*
You are given a square binary grid. A grid is considered binary if every value in the grid is either 1 or 0. You can change at most one cell in the grid from 0 to 1. You need to find the largest group of connected  1's. Two cells are said to be connected if both are adjacent to each other and both have the same value.

Examples :

Input: grid = [1, 1]
             [0, 1]
Output: 4
Explanation: By changing cell (2,1), we can obtain a connected group of 4 1's
[1, 1]
[1, 1]
Input: grid = [1, 0, 1]
             [1, 0, 1]
             [1, 0, 1]
Output: 7
Explanation: By changing cell (3,2), we can obtain a connected group of 7 1's
[1, 0, 1]
[1, 0, 1]
[1, 1, 1]
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 <= size of the grid<= 500
0 <= grid[i][j] <= 1
*/

class Solution {
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};
    private void grouper(int[][] grid, int[][] vis, int i, int j, int n, int m, int group, int[] size) {
        if (i == n || i < 0 || j == m || j < 0 || vis[i][j] != -1 || grid[i][j] == 0) {
            return;
        }
        vis[i][j] = group;
        size[0]++;
        for (int k = 0; k < 4; ++k) {
            int new_i = i + x[k];
            int new_j = j + y[k];
            grouper(grid, vis, new_i, new_j, n, m, group, size);
        }
    }
    public int MaxConnection(int[][] grid) {
        int maxSize = 0, tempSize;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int[] row : vis) {
            Arrays.fill(row, -1);
        }
        int size;
        int group = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (vis[i][j] == -1 && grid[i][j] == 1) {
                    int[] sizeArray = {0};
                    grouper(grid, vis, i, j, n, m, group, sizeArray);
                    size = sizeArray[0];
                    mp.put(group, size);
                    maxSize = Math.max(maxSize, size);
                    group++;
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) {
                    tempSize = 0;
                    for (int k = 0; k < 4; ++k) {
                        int new_i = i + x[k];
                        int new_j = j + y[k];
                        if (new_i < n && new_i >= 0 && new_j < m && new_j >= 0 && vis[new_i][new_j] != -1 && !set.contains(vis[new_i][new_j])) {
                            tempSize += mp.get(vis[new_i][new_j]);
                            set.add(vis[new_i][new_j]);
                        }
                    }
                    maxSize = Math.max(maxSize, tempSize + 1);
                    set.clear();
                }
            }
        }
        return maxSize;
    }
}
