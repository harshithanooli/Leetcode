class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[triangle.size()][triangle.size()];
        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }


        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int straight=triangle.get(i).get(j)+dp[i+1][j];
                int diagonal=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(straight, diagonal);
            }
        }
        return dp[0][0];
    }
}