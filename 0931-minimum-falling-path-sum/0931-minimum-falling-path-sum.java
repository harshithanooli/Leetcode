class Solution {
    public int f(int[][] grid, int i, int j, int[][] dp) {
        if (j < 0 || j >= grid[0].length) {
            return 1_000_000_007;
        }
        if (i == 0) {
            return dp[i][j] = grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = grid[i][j] + f(grid, i - 1, j, dp);
        int leftUp = grid[i][j] + f(grid, i - 1, j - 1, dp);
        int rightUp = grid[i][j] + f(grid, i - 1, j + 1, dp);
        return dp[i][j] = Math.min(up, Math.min(leftUp, rightUp));
    }

    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int res = Integer.MAX_VALUE;
       
            for (int j = 0; j < grid[0].length; j++)
                dp[0][j] = grid[0][j];
        
        for(int i=1;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                        int up = grid[i][j] + dp[i - 1][j];

                int leftUp = grid[i][j];
                if(j>0) leftUp+=dp[i-1][j-1];
                else
                leftUp=1_000_000_007;
                int rightUp = grid[i][j];
                if(j<grid[0].length-1)
                rightUp+=dp[i-1][j+1];
                else
                rightUp=1_000_000_007;
                dp[i][j]=Math.min(up, Math.min(leftUp, rightUp));
            }
        }
        for (int j = 0; j < grid[0].length; j++)
               res=Math.min(res,  dp[grid.length-1][j]);
        return res;
    }
}