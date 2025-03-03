class Solution {

    public int paths(int[][] dp,int i, int j){
        if(i==0 && j==0){
            return dp[0][0]=1;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up=paths(dp, i-1, j);
        int left=paths(dp, i, j-1);

        return dp[i][j]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }



        return paths(dp,m-1,n-1);
    }
}