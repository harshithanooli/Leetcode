class Solution {

    
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
           {
            if(i==0 && j==0){
                dp[i][j]=grid[i][j];
            }

            else{
                int up=grid[i][j];
                if(i>0){
                    up+=dp[i-1][j];
                }else{
                    up=up+1_000_000_007;
                }
                int left=grid[i][j];
                if(j>0){
                    left+=dp[i][j-1];
                }else{
                    left=left+1_000_000_007;
                }

                dp[i][j]=Math.min(up, left);
            }
           }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}