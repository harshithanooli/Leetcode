class Solution {
    public int dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited){
        visited[i][j]=true;
        int[] dirRow = {0, -1, 0, 1};
        int[] dirCol = {-1, 0, 1, 0};
        int count=1;
        for(int k=0;k<dirRow.length;k++){
            int a = i+dirRow[k], b = dirCol[k]+j;
           
            if(a>=0 && a<m && b>=0 && b<n && grid[a][b]==1 && !visited[a][b]){
               count += dfs(a, b, m, n, grid, visited);
            }
        }

        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
         int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    
                    res = Math.max(res,dfs(i, j, m, n, grid, visited));
                }
            }
        }

        return res;
    }
}