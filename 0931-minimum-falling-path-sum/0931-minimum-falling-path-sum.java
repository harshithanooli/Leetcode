class Solution {
    public int f(int[][] grid, int i, int j, int[][] dp){
        if(j<0 || j>=grid[0].length){
            return 1_000_000_007;
        }
        if(i==0){
            return dp[i][j]=grid[i][j];
        }
        
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int up=grid[i][j]+f(grid, i-1,j,dp);
        int leftUp=grid[i][j]+f(grid, i-1, j-1,dp);
        int rightUp=grid[i][j]+f(grid,i-1, j+1, dp);
        return dp[i][j]=Math.min(up, Math.min(leftUp, rightUp));
    }
    public int minFallingPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        int res=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
            dp[i][j]=-1;
        }
        for(int j=0;j<grid[0].length;j++){
            res=Math.min(res, f(grid, grid.length-1, j, dp));
            
        }
        return res;
    }
}