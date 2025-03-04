class Solution {

    public int f(int[][] grid, int i, int j, int[][] dp){
        if(i==0 && j==0){
            return dp[i][j]=grid[i][j];
        }
        
        if(i<0 || j<0){
            return 1_000_000_007;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int up=grid[i][j]+f(grid, i-1,j,dp);
        int left=grid[i][j]+f(grid, i, j-1,dp);

        return dp[i][j]=Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            dp[i][j]=-1;
        }
        return f(grid, grid.length-1, grid[0].length-1, dp);
    }
}